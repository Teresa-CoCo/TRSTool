from PIL import ImageGrab
import tkinter as tk
from tkinter import messagebox


def take_screenshot():
    try:
        # 使用PIL的ImageGrab模块进行屏幕截图
        screenshot = ImageGrab.grab()

        # 保存截图为文件，这里可以根据需要修改保存路径和文件名
        screenshot.save("screenshot.png")

        messagebox.showinfo("截图成功", "截图已保存为 screenshot.png")
    except Exception as e:
        messagebox.showerror("截图失败", f"发生错误: {str(e)}")


# # 创建主窗口
# root = tk.Tk()
# root.title("屏幕截图程序")
#
# # 创建截图按钮
# button = tk.Button(root, text="截取屏幕", command=take_screenshot)
# button.pack(pady=20)
#
# # 运行主循环
# root.mainloop()
