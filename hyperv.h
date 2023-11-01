#include<stdio.h>
#include<windows.h>
#include<time.h>
#include<stdlib.h>
#include<processthreadsapi.h>

void hyperv()
{
    int input = 0;
    printf("请提前将zip内的hypervauto.bat解压到C盘根目录\n解压完成请输入1回车");
    scanf("%d",&input);

    if (input = 1)
    {
        printf("正在准备启动，请稍后\n");
        Sleep(300);
        printf("由于Windows VAC政策，后面可能会向您请求管理员权限，请同意运行\n");
        system("C:\\hypervauto.bat");
    }
    else
    {
        printf("程序即将结束\n");
        return 0;
    }
}