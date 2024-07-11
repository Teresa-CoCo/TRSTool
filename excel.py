def excel():
    print("欢迎使用excel函数快速查询功能\n")
    print("请选择您要使用的功能：")
    print("1.如何使输入的数字不精确到小数点n位\n2.excel的几种基本函数写法\n")
    inputt1=input()
    if inputt1 == "1":
        print("选中需要处理的单元格或单元格区域 右键单击选中的单元格或单元格区域 选择“格式单元格” 在“数字”选项卡中，选择“常规”分类。在“小数位数”框中输入 0 然后单击“确定”按钮。\n")
        print("在另一个单元格中输入以下公式：=INT(A1)，其中 A1 是需要截断小数位数的单元格 按下“Enter”键 公式会返回 A1 单元格的整数部分 将公式应用到其他需要处理的单元格上。")
    elif inputt1 == "2":
        print("1.IF(logical_test,[value_if_true],[value_if_false])\n2.AND(logical1, logical2, ...)\n3.REPLACE(old_text, start_num, num_chars, new_text)\n")
        print("更多请打开此网站： https://cloud.tencent.com/developer/article/1838546\n")
    exit()