import excel
import eletric
import bmiplus
import os
while(True):
    print("欢迎使用TRSTool Python版 Beta1")
    print("请输入你要使用的功能：1、bmi计算 2.万能表 3.excel小提示")
    a = input()
    if a == "1":
        bmiplus.bmicalculator()
    elif a == "2":
        eletric.electric()
    elif a == "3":
        excel.excel()
    else:
        print("正在施工或您选择有误")
        os.system('cls' if os.name == 'nt' else 'clear')
