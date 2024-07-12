import excel
import eletric
import bmiplus
import ping
import translong
import twobit
import lucky
import os

while(True):
    print("欢迎使用TRSTool Python版 Beta1")
    print("请输入你要使用的功能：1、bmi计算 2.万能表 3.excel小提示 4.幸运与运势 5.ping网络工具 6.长度转换工具 7.十进制二进制互相转换工具 0.退出")
    a = input()
    if a == "1":
        bmiplus.bmicalculator()
    elif a == "2":
        eletric.electric()
    elif a == "3":
        excel.excel()
    elif a == "4":
        lucky.lucky()
    elif a == "5":
        ping.ping()
    elif a == "6":
        translong.translong()
    elif a == "7":
        twobit.twobit()
    elif a == "0":
        quit()
    else:
        print("正在施工或您选择有误")
        os.system('cls' if os.name == 'nt' else 'clear')
