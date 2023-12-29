#include<stdio.h>
#include<windows.h>
#include<time.h>
#include<D:\Develop\TRSTool\translong.h>
#include<D:\Develop\TRSTool\shoesize.h>
#include<D:\Develop\TRSTool\bmiplus.h>
#include<D:\Develop\TRSTool\eletric.h>
#include<D:\Develop\TRSTool\lucky.h>
#include<D:\Develop\TRSTool\excel.h>
#include<D:\Develop\TRSTool\twobit.h>
#include<D:\Develop\TRSTool\hyperv2.h>
#include<D:\Develop\TRSTool\saolei.h>
#include<D:\Develop\TRSTool\ssh.h>
void main(void)
{
    int grate;
    int i =0;
    SetConsoleOutputCP(65001);
    if ( i == 0)
    {
        printf("欢迎使用TRSToolV5.5 beta版\n");
        Sleep(1000);
        printf("请输入你要使用的功能：\n1.转换长度工具  2.转换鞋码工具  3.BMI健康指数计算工具 4.多功能电表 5.幸运数字与运势 6.excel快查7.二进制十进制互转8.运行hyperv开机bat（beta v2）(需联网)9.扫雷游戏（鸣谢@Hannnine）(新)10.链接ssh服务（新）");
        scanf("%d",&grate);
        if (grate == 1)
        {
            translong();
        }
        else if (grate == 2)
        {
            transshoe();
        }
        else if (grate == 3)
        {
            bmicalculator();
        }
        else if (grate == 4)
        {
            electric();
        }
        else if (grate == 5)
        {
            lucky();
        }
        else if (grate == 6)
        {
            excel();
        }
        else if(grate == 7)
        {
            twobit();
        }
        else if(grate == 8)
        {
            hyperv2();
        }
        else if(grate == 9)
        {
            wansaolei();
        }
        else if(grate == 10)
        {
            ssh();
        }
        
        else
        {
            printf("请检查您输入的正确与否，本程序未能匹配到您想要运行的模块\n");
            //break;
        }
    }
    

    
    
    
    
    
}
