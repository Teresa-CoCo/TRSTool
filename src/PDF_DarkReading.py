import tkinter as tk
from tkinterdnd2 import TkinterDnD
from tkinter import filedialog, messagebox, simpledialog
from PIL import Image, ImageOps, ImageFilter, ImageTk
from pdf2image import convert_from_path
import numpy as np
import sys
import os
import threading


class ToolTip( object ):
	def __init__( self, widget, text = 'widget info' ):
		self.waittime = 500  # 出现延迟时间（毫秒）
		self.wraplength = 180  # 文本包装长度
		self.widget = widget
		self.text = text
		self.widget.bind( "<Enter>", self.enter )
		self.widget.bind( "<Leave>", self.leave )
		self.id = None
		self.tw = None
	
	def enter( self, event = None ):
		self.schedule( )
	
	def leave( self, event = None ):
		self.unschedule( )
		self.hidetip( )
	
	def schedule( self ):
		self.unschedule( )
		self.id = self.widget.after( self.waittime, self.showtip )
	
	def unschedule( self ):
		id = self.id
		self.id = None
		if id:
			self.widget.after_cancel( id )
	
	def showtip( self, event = None ):
		x, y, cx, cy = self.widget.bbox( "insert" )
		x += self.widget.winfo_rootx( ) + 25
		y += self.widget.winfo_rooty( ) + 20
		self.tw = tk.Toplevel( self.widget )
		self.tw.wm_overrideredirect( True )
		self.tw.wm_geometry( "+%d+%d" % (x, y) )
		label = tk.Label( self.tw, text = self.text, justify = 'left',
		                  background = "#ffffff", relief = 'solid', borderwidth = 1,
		                  wraplength = self.wraplength )
		label.pack( ipadx = 1 )
	
	def hidetip( self ):
		tw = self.tw
		self.tw = None
		if tw:
			tw.destroy( )
#用于创建悬浮提示窗


class PDFNightModeConverter:
	def __init__( self, root ):
		self.root = root
		self.root.title( 'PDF夜间阅读模式转化' )
		self.output_pdf_path = ""
		self.export_pdf_path = ""  # 用于存储导出路径
		self.poppler_path = self.get_poppler_path( )
		self.chosen_gray_value = 49  # 默认背景灰度值
		self.chosen_text_gray_value = 240  # 用于存储文字的灰度值，默认为240
		self.processing = False  # 文件是否正在处理
		self.preview_image = None  # 用于在Canvas上显示的PIL图像
		self.text_color = '#F0F0F0'  # 灰度值240
		self.global_font = ('Microsoft YaHei', 16)  # 适合中文阅读的字体
		self.center_window_on_screen( )  #窗口位置控制
		self.setup_ui( )
	
	def setup_ui( self ):
		# 全局字体设置
		global_font = ('Microsoft YaHei', 16)
		
		# 设置背景颜色和文字颜色
		text_color = '#F0F0F0'  # 灰度值240
		bg_color = self.gray_to_hex( self.chosen_gray_value )  # 灰度值49
		
		# 设置整体背景色
		self.root.configure( bg = bg_color )
		
		# 界面元素配置
		self.tips = tk.Label( self.root, text = "提示!!!\n灰度为0(纯黑)~255(纯白)之间的整数", bg = bg_color,
		                      fg = text_color, font = global_font )
		self.tips.pack( side = tk.TOP, padx = 10 )
		
		self.lbl_color_prompt = tk.Label( self.root, text = "请选择转换后的背景灰度", bg = bg_color, fg = text_color,
		                                  font = global_font )
		self.lbl_color_prompt.pack( pady = (50, 0) )
		
		self.color_frame = tk.Frame( self.root, bg = bg_color )
		self.color_frame.pack( pady = 5 )
		
		btn_color1 = tk.Button( self.color_frame, text = '  ', bg = '#20201f',\
		                        width = 6, height = 2, command = lambda:self.change_color( 31 ) )
		btn_color1.pack( side = tk.LEFT, padx = 10 )
		
		btn_color2 = tk.Button( self.color_frame, text = '  ', bg = '#313233',\
		                        width = 6, height = 2, command = lambda:self.change_color( 49 ) )
		btn_color2.pack( side = tk.LEFT, padx = 10 )
		
		self.lbl_color_choice = tk.Label( self.root, text = "(左偏暗,右偏亮,不选默认为右)", bg = bg_color,
		                                  fg = text_color, font = global_font )
		self.lbl_color_choice.pack( pady = (0, 20) )
		
		self.custom_gray_button = tk.Button( self.color_frame, text = '自定义', command = self.custom_gray_input,\
		                                     bg = bg_color, fg = text_color, font = global_font )
		self.custom_gray_button.pack( side = tk.LEFT, padx = 10 )
		
		self.top_frame = tk.Frame( self.root, bg = self.gray_to_hex( self.chosen_gray_value ) )
		self.top_frame.pack( side = tk.TOP, fill = tk.X, padx = 10, pady = 10 )
		
		self.btn_about = tk.Button( self.top_frame, text = "关于", bg = self.gray_to_hex( self.chosen_gray_value ),
		                            fg = "#F0F0F0", font = ('Microsoft YaHei', 16), command = self.show_about_window )
		self.btn_about.pack( side = tk.LEFT, padx = 10 )
		
		self.lbl_text_color_prompt = tk.Label( self.root, text = "请选择转换后的文字灰度", bg = bg_color,
		                                       fg = text_color,
		                                       font = global_font )
		self.lbl_text_color_prompt.pack( pady = (50, 0) )
		# 颜色选择框架
		self.text_color_frame = tk.Frame( self.root, bg = self.gray_to_hex( self.chosen_gray_value ) )
		self.text_color_frame.pack( pady = 5 )
		
		# 将第一个颜色块设置为灰度250，第二个设置为灰度240
		btn_color3 = tk.Button( self.text_color_frame, text = '  ', bg = self.gray_to_hex( 250 ),
		                        width = 6, height = 2, command = lambda:self.change_text_color( 250 ) )
		btn_color3.pack( side = tk.LEFT, padx = 10 )
		
		btn_color4 = tk.Button( self.text_color_frame, text = '  ', bg = self.gray_to_hex( 240 ),
		                        width = 6, height = 2, command = lambda:self.change_text_color( 240 ) )
		btn_color4.pack( side = tk.LEFT, padx = 10 )
		# 添加自定义文字灰度按钮
		self.btn_custom_text_color = tk.Button( self.text_color_frame, text = '自定义',
		                                        command = self.custom_text_gray_input,
		                                        bg = self.gray_to_hex( self.chosen_gray_value ), fg = self.text_color,
		                                        font = self.global_font )
		self.btn_custom_text_color.pack( side = tk.LEFT, padx = 10 )
		self.lbl_text_color_choice = tk.Label( self.root, text = "(左偏亮,右偏暗,不选默认为右)", bg = bg_color,
		                                       fg = text_color, font = global_font )
		self.lbl_text_color_choice.pack( pady = (0, 20) )
		
		# 文件选择框
		file_frame = tk.Frame( self.root, bg = bg_color )
		file_frame.pack( pady = 10 )
		
		self.entry_filename = tk.Entry( file_frame, width = 50, bg = bg_color, fg = text_color, font = global_font )
		self.entry_filename.pack( side = tk.LEFT, padx = (0, 10) )
		self.entry_filename.insert( 0, "选择文件路径" )
		
		btn_select = tk.Button( file_frame, text = "选择", command = self.select_file,\
		                        bg = bg_color, fg = text_color, font = global_font )
		btn_select.pack( side = tk.LEFT )
		
		# 导出路径选择框
		export_file_frame = tk.Frame( self.root, bg = bg_color )
		export_file_frame.pack( pady = 10 )
		
		self.entry_export_filename = tk.Entry( export_file_frame, width = 50,\
		                                       bg = bg_color, fg = text_color, font = global_font )
		self.entry_export_filename.pack( side = tk.LEFT, padx = (0, 10) )
		self.entry_export_filename.insert( 0, "导出文件路径(不选则与原文件处于同一目录)" )
		
		btn_export_select = tk.Button( export_file_frame, text = "选择",\
		                               command = self.select_export_path, bg = bg_color, fg = text_color,
		                               font = global_font )
		btn_export_select.pack( side = tk.LEFT )
		
		
		
		# 添加一个标签用于显示文字"预览"
		self.lbl_preview = tk.Label( self.root, text = "预览", bg = bg_color,
		                             fg = text_color, font = global_font )
		self.lbl_preview.pack( pady = (30, 0) )
		
		# 修改选择页数按钮位置
		self.btn_choose_page = tk.Button( self.root, text = "选择页数", command = self.choose_page,\
		                                  bg = bg_color, fg = text_color, font = global_font )
		self.btn_choose_page.pack( )
		
		# "开始处理"按钮
		processing_frame = tk.Frame( self.root, bg = bg_color )
		processing_frame.pack( pady = 20, fill = tk.X )
		self.btn_start = tk.Button( processing_frame, text = "开始处理", command = self.start_processing, bg = bg_color,
		                            fg = text_color, font = global_font )
		self.btn_start.pack( side = tk.LEFT, padx = (0, 10) )
		
		self.lbl_status = tk.Label( processing_frame, text = "", bg = bg_color, fg = text_color, font = global_font,
		                            anchor = 'center', justify = 'center' )
		self.lbl_status.pack( side = tk.LEFT, padx = 10, fill = tk.X, expand = True )
		
		self.btn_open_folder = tk.Button( self.root, text = "打开文件所在目录", command = self.open_output_directory,\
		                                  bg = bg_color, fg = text_color, font = global_font )  # 注意：这个按钮暂时还没有放入布局中
	#UI设计
	
	def show_about_window( self ):
		about_window = tk.Toplevel( self.root )
		about_window.title( "关于" )
		about_window.configure( bg = self.gray_to_hex( self.chosen_gray_value ) )
		
		# 设置窗口大小
		about_window_width = 800
		about_window_height = 1100
		about_window.geometry( f"{about_window_width}x{about_window_height}" )
		
		# 获取屏幕尺寸
		screen_width = self.root.winfo_screenwidth( )
		screen_height = self.root.winfo_screenheight( )
		
		# 计算x和y坐标使窗口出现在屏幕中央上方
		x = int( (screen_width - about_window_width) / 2 )
		y = int( (screen_height - about_window_height) / 2 )
		
		# 应用新的几何设置
		about_window.geometry( f'' )
		# 添加居中的文本
		label = tk.Label( about_window,\
		                  text = '\n\n\n\n你好\n这里是安大23级物联网工程一班\n高统军\n耗时一周自制的小软件\n\n\n'
		                         '本软件的创作目的:\n解决长时间对着白底黑字的PDF学习\n眼睛会瞎掉的问题\n(因为我有这样的需求)\n\n\n'
		                         '设计思路:\n开启多线程\nPDF转为图片\n灰度化\n反色\n转化为Numpy数组\n'
		                         '\t对低于用户选择的背景色的区域转为用户选择\t\n(不只针对反色后的纯黑)\n(是为了解决扫描文档常见的噪点问题)\n\n'
		                         '再对灰度值高于200的区域转为用户选择\n(反复调试之后设置的阈值)\n(过低、高或不设置都会导致可读性下降)\n\n\n'
		                         '有任何的想法\n(无论何种方面)\n(合作\\交流\\询问\\建议...)\n请联系:\nnatural_selection_@outlook.com\n\n\n\n'\
		                  , font = ('Microsoft YaHei', 14),
		                  bg = self.gray_to_hex( self.chosen_gray_value ),
		                  fg = "#F0F0F0" )
		label.pack( expand = True )
		
		# 使窗口出现在屏幕中间
		self.root.eval( 'tk::PlaceWindow %s center' % about_window.winfo_toplevel( ) )
	#按钮"关于"
	
	def custom_gray_input( self ):
		gray_value = simpledialog.askinteger( "自定义灰度", "请输入0~255之间的整数", minvalue = 0, maxvalue = 255,\
		                                      )
		if gray_value is not None:  # 确保用户输入了值
			self.change_color( gray_value )
	#获取自定义灰度(黑)
	
	def custom_text_gray_input( self ):
		# 获取用户自定义的文字灰度值
		gray_value = simpledialog.askinteger( "自定义文字灰度", "请输入0~255之间的整数", minvalue = 0, maxvalue = 255 )
		if gray_value is not None:  # 确保用户输入了值
			self.change_text_color( gray_value )
	#获取自定义灰度(白)
	
	def gray_to_hex( self, gray_value ):
		# 将灰度值转换为十六进制
		hex_value = '{:02x}'.format( gray_value )
		# 返回完整的十六进制颜色代码
		return f'#{hex_value}{hex_value}{hex_value}'
	#灰度值向HEX转化()
	
	def change_color( self, gray_value ):
		self.chosen_gray_value = gray_value
		self.lbl_status.config( text = f"选定灰度: {self.chosen_gray_value}" )
		bg_hex = self.gray_to_hex( self.chosen_gray_value )
		
		self.root.configure( bg = bg_hex )  # 更新相关组件的背景颜色
		self.tips.config( bg = bg_hex )
		self.lbl_color_prompt.config( bg = bg_hex )
		self.color_frame.config( bg = bg_hex )
		self.lbl_preview.config( bg = bg_hex )
		self.lbl_color_choice.config( bg = bg_hex )
		self.lbl_preview.config( bg = bg_hex )
		self.entry_filename.config( bg = bg_hex )
		self.entry_export_filename.config( bg = bg_hex )
		self.lbl_text_color_choice.config( bg = bg_hex )
		self.text_color_frame.config( bg = bg_hex )
		self.lbl_text_color_prompt.config( bg = bg_hex )
		self.top_frame.config( bg = bg_hex )
	#改变UI背景颜色
	
	def change_text_color( self, gray_value ):
		self.chosen_text_gray_value = gray_value
		self.lbl_status.config( text = f"选定文字灰度: {self.chosen_text_gray_value}" )
		text_hex = self.gray_to_hex( self.chosen_text_gray_value )
		
		# 更新相关组件的文字颜色
		self.tips.config( fg = text_hex )
		self.lbl_color_prompt.config( fg = text_hex )
		self.lbl_preview.config( fg = text_hex )
		self.lbl_text_color_choice.config( fg = text_hex )
		self.lbl_text_color_prompt.config( fg = text_hex )
		self.lbl_color_choice.config( fg = text_hex )
	#更改UI文字颜色
	
	def select_file( self ):
		file_path = filedialog.askopenfilename( )
		if file_path:
			self.entry_filename.delete( 0, tk.END )
			self.entry_filename.insert( 0, file_path )
			self.lbl_status.config( text = "" )
	#选择原文件路径
	
	def select_export_path( self ):
		original_file_path = self.entry_filename.get( )
		if original_file_path:
			# 提取原始文件的目录和文件名
			original_dir = os.path.dirname( original_file_path )
			original_file_name = os.path.splitext( os.path.basename( original_file_path ) )[0]
			
			# 创建新的文件名，附加 "_DarkReading"
			default_export_file_name = original_file_name + "_DarkReading.pdf"
			
			# 弹出文件保存对话框，并设置默认文件名
			export_path = filedialog.asksaveasfilename(
				defaultextension = ".pdf",
				initialdir = original_dir,
				initialfile = default_export_file_name
			)
			if export_path:
				self.entry_export_filename.delete( 0, tk.END )
				self.entry_export_filename.insert( 0, export_path )
				self.export_pdf_path = export_path
		else:
			messagebox.showinfo( "信息", "请先选择一个原始文件。" )
	#选择文件导出路径
	
	
	
	def start_processing( self ):
		file_path = self.entry_filename.get( )
		if file_path and not self.processing:
			self.lbl_status.config( text = "正在处理..." )
			self.processing = True
			self.btn_start.config( state = "disabled" )  # 禁用按钮
			threading.Thread( target = self.process_pdf_multithreaded, args = (file_path,), daemon = True ).start( )
			self.disable_buttons( )  # 禁用所有按钮
	#开始处理
	
	def open_output_directory( self ):
		if os.path.exists( self.output_pdf_path ):
			os.startfile( os.path.dirname( self.output_pdf_path ) )
		else:
			messagebox.showinfo( "信息", "文件不存在。" )
	#打开导出的文件
	
	
	'''
	预览相关
	'''
	def choose_page( self ):
		page_num = simpledialog.askinteger( "选择页数", "请输入想要预览的页数:", parent = self.root )
		if page_num is not None:
			if 1 <= page_num:  # 假设没有最大页数限制
				self.selected_page = page_num
				self.show_page_in_window( page_num )  # 在新窗口中显示所选页面
	#在弹窗中输入想预览的页面数
	
	def preview_page( self, page_num ):
		# 检查是否有可用的PDF页面图像
		if not hasattr( self, 'pdf_images' ) or not self.pdf_images:
			messagebox.showinfo( "错误", "没有可预览的文件。" )
			return
		if page_num - 1 < len( self.pdf_images ):
			img = self.pdf_images[page_num - 1]  # 获取正确的页面图像
			img_processed = self.process_page_for_preview( img )  # 处理图像以预览
			self.display_image_on_canvas( img_processed )  # 在 Canvas 上显示图像
	#对输入值进行修改(为了避免使用从0开始的列表索引)
	
	def process_page_for_preview( self, img ):
		img_gray = img.convert( "L" )
		img_inverted = ImageOps.invert( img_gray )
		data = np.array( img_inverted )
		
		low_gray_mask = data < self.chosen_gray_value
		data[low_gray_mask] = self.chosen_gray_value
		
		high_gray_mask = data >= 200
		data[high_gray_mask] = self.chosen_text_gray_value
		
		img_modified = Image.fromarray( data )
		img_tk = ImageTk.PhotoImage( image = img_modified )
		return img_tk
	#对那个页面进行处理
	
	def show_page_in_window( self, page_num ):
		try:
			pdf_path = self.entry_filename.get( )
			pdf_page = convert_from_path( pdf_path, first_page = page_num, last_page = page_num,
			                              poppler_path = self.poppler_path )[0]
			
			# 将PDF页面转换为灰度图像，然后反转颜色
			img_gray = pdf_page.convert( "L" )
			img_inverted = ImageOps.invert( img_gray )
			data = np.array( img_inverted )
			
			# 对图像应用灰度阈值
			low_gray_mask = data < self.chosen_gray_value
			data[low_gray_mask] = self.chosen_gray_value
			high_gray_mask = data >= 200
			data[high_gray_mask] = self.chosen_text_gray_value
			
			# 从数组创建修改后的图像
			img_modified = Image.fromarray( data )
			
			# 创建一个新窗口
			top = tk.Toplevel( )
			top.title( "Page Preview" )
			
			# 获取原始图像的尺寸
			width, height = img_modified.size
			
			# 在新窗口中添加滚动条
			scrollbar_vert = tk.Scrollbar( top, orient = "vertical" )
			scrollbar_hor = tk.Scrollbar( top, orient = "horizontal" )
			
			# 添加一个Canvas来显示图像，并配置滚动条
			canvas = tk.Canvas( top, width = width, height = height, yscrollcommand = scrollbar_vert.set,
			                    xscrollcommand = scrollbar_hor.set )
			scrollbar_vert.config( command = canvas.yview )
			scrollbar_hor.config( command = canvas.xview )
			
			# 打包Canvas和滚动条到窗口中
			canvas.pack( side = tk.LEFT, expand = True, fill = tk.BOTH )
			scrollbar_vert.pack( side = tk.RIGHT, fill = tk.Y )
			scrollbar_hor.pack( side = tk.BOTTOM, fill = tk.X )
			
			img_tk = ImageTk.PhotoImage( image = img_modified )
			canvas.create_image( 0, 0, anchor = "nw", image = img_tk )
			canvas.config( scrollregion = canvas.bbox( "all" ) )
			
			# 保存 img_tk 到类的属性，以防止它被垃圾回收
			self.img_tk = img_tk
			
			# 函数：用于Windows和MacOS鼠标滚轮事件处理
			def on_mousewheel( event ):
				canvas.yview_scroll( int( -1 * (event.delta / 120) ), "units" )
			
			# 函数：用于Linux鼠标滚轮向上滚动事件处理
			def on_linux_scroll_up( event ):
				canvas.yview_scroll( -1, "units" )
			
			# 函数：用于Linux鼠标滚轮向下滚动事件处理
			def on_linux_scroll_down( event ):
				canvas.yview_scroll( 1, "units" )
			
			# 绑定鼠标滚轮事件
			top.bind( "<MouseWheel>", on_mousewheel )  # 对于Windows和MacOS
			top.bind( "<Button-4>", on_linux_scroll_up )  # 对于Linux向上滚动
			top.bind( "<Button-5>", on_linux_scroll_down )  # 对于Linux向下滚动
		
		except Exception as e:
			messagebox.showerror( "错误", str( e ) )
	#在窗口的展示
	
	def display_image_on_canvas( self, img_tk ):
		self.preview_canvas.delete( "all" )  # 清除Canvas上的内容
		self.preview_canvas.create_image( 0, 0, anchor = "nw", image = img_tk )
		self.preview_canvas.image = img_tk  # 避免图像被垃圾收集器回收
	#关闭时清除要预览的图片
	
	def update_preview( self, page_num ):
		try:
			# 载入PDF的指定页码
			pdf_path = self.entry_filename.get( )
			pdf_page = convert_from_path( pdf_path, first_page = page_num, last_page = page_num,
			                              poppler_path = self.poppler_path )[0]
			
			# 处理页面
			img_gray = pdf_page.convert( "L" )
			img_inverted = ImageOps.invert( img_gray )
			data = np.array( img_inverted )
			
			low_gray_mask = data < self.chosen_gray_value  #低于选择值的像素变为选择值
			data[low_gray_mask] = self.chosen_gray_value
			
			high_gray_mask = data >= 220  #高于选择值的像素变为固定值
			data[high_gray_mask] = self.chosen_text_gray_value
			
			img_modified = Image.fromarray( data )
			
			# 将图像调整到Canvas的大小
			self.preview_image_full_size = img_modified  # 保存完整尺寸的图像副本
			img_modified.thumbnail( (self.preview_canvas.winfo_width( ), self.preview_canvas.winfo_height( )),
			                        Image.Resampling.LANCZOS )
			
			# 将处理后的图像转换为Tkinter兼容的图片
			self.preview_image = ImageTk.PhotoImage( image = img_modified )
			
			# 在Canvas上展示图片，并绑定点击事件
			self.preview_canvas.create_image(
				0,
				0,
				anchor = 'nw',
				image = self.preview_image
			)
			self.preview_canvas.config( scrollregion = self.preview_canvas.bbox( 'all' ) )
			self.preview_canvas.bind( "<Button-1>", self.popup_image )  # 点击图像时触发popup_image
		except Exception as e:
			messagebox.showerror( "错误", str( e ) )
	#当配置更新时更新要预览的图像


	'''
	禁用与启用按钮
	'''
	def disable_buttons( self ):
		self.btn_start.config( state = "disabled" )
		self.btn_choose_page.config( state = "disabled" )
	# 禁用其他所有按钮
	
	def enable_buttons( self ):
		self.btn_start.config( state = "normal" )
		self.btn_choose_page.config( state = "normal" )
	# 启用其他所有按钮
	
	def reset_processing_state( self ):
		self.processing = False
		self.enable_buttons( )
	# 启用所有按钮
	
	def update_ui_post_processing( self ):
		self.lbl_status.config( text = "文件处理已完成" )
		self.btn_open_folder.pack( pady = (5, 20) )
		self.reset_processing_state( )
	#文件处理已完成

	
	'''
	文件处理相关
	'''
	def process_page( self, img, output_images, index, lock ):
		img_gray = img.convert( "L" )
		img_inverted = ImageOps.invert( img_gray )
		data = np.array( img_inverted )
		
		low_gray_mask = data < self.chosen_gray_value  #低于选择值的像素变为选择值
		data[low_gray_mask] = self.chosen_gray_value
		
		high_gray_mask = data >= 200  #高于选择值的像素变为固定值
		data[high_gray_mask] = self.chosen_text_gray_value
		
		img_modified = Image.fromarray( data )
		with lock:
			output_images[index] = img_modified
	#文件处理函数
	
	def process_pdf_multithreaded( self, pdf_path ):
		try:
			images = convert_from_path( pdf_path, poppler_path = self.poppler_path )
			output_images = [None] * len( images )
			threads = []
			lock = threading.Lock( )
			
			for index, img in enumerate( images ):
				thread = threading.Thread( target = self.process_page, args = (img, output_images, index, lock) )
				threads.append( thread )
				thread.start( )
			
			for thread in threads:
				thread.join( )
			
			if self.export_pdf_path:
				self.output_pdf_path = self.export_pdf_path
			else:
				self.output_pdf_path = os.path.splitext( pdf_path )[0] + "_DarkReading.pdf"
			
			if output_images:
				output_images[0].save( self.output_pdf_path, "PDF", resolution = 100.0,\
				                       save_all = True, append_images = output_images[1:] )
			
			self.root.after( 0, self.update_ui_post_processing )
		except Exception as e:
			self.root.after( 0, messagebox.showerror, "错误", str( e ) )
			self.root.after( 0, self.lbl_status.config, { "text":"文件处理失败" } )
			self.root.after( 0, self.reset_processing_state )
	#多线程处理
	
	def get_poppler_path( self ):
		# 检查是否在打包后的环境中运行
		if getattr( sys, 'frozen', False ):
			# 如果是，则使用 _MEIPASS 中的路径和'bin'文件夹的相对路径
			base_path = os.path.join( sys._MEIPASS, 'bin' )
		else:
			# 如果不是，则使用原始的硬编码路径
			base_path = "D:/0000__Python项目/py_convert_exe/bin"
		return base_path
	#获取poppler路径

	
	'''
	窗口位置控制
	'''
	def center_window_on_screen( self ):
		window_width = 680  # 窗口宽度像素数
		window_height = 1000  # 窗口高度像素数
		
		# 获取屏幕尺寸
		screen_width = self.root.winfo_screenwidth( )
		screen_height = self.root.winfo_screenheight( )
		
		# 计算x和y坐标
		x = int( (screen_width - window_width) / 2 )
		y = int( (screen_height - window_height) / 4 )  # 将窗口定位到屏幕四分之一的高度处
		
		# 应用几何设置
		self.root.geometry( f'{window_width}x{window_height}+{x}+{y}' )


# 创建主窗口并运行应用
root = tk.Tk( )
app = PDFNightModeConverter( root )
root.mainloop( )
