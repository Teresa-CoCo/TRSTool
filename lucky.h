#include<stdio.h>
#include<windows.h>
#include<time.h>
void lucky() {
    SetConsoleOutputCP(65001);
    int randomnumber,luckynumber;
    printf("欢迎使用幸运数程序\n快来看看你今天的幸运数字是几！\n");
    Sleep(1000);
    printf("请稍等，正在初始化程序。\n");
    Sleep(3000);
    printf("生成随机种子中\n");
    Sleep(4000);

    srand(time(NULL)); // 使用当前时间作为随机数种子
    randomnumber = rand() % 9 + 1; // 生成 1 和 9 之间的随机数

    printf("生成好了，您今天的幸运数字为 %d\n快分享给你的朋友吧！", randomnumber);
    
//升级：判断吉利、不吉利

    printf("您需要继续系统判断今天的运气吗？\n输入1继续，其他数字退出");
    int lucky;
    scanf("%d",&lucky);
    if (lucky == 1)
    {
        printf("感谢您对本系统的认可\n");/* code */
        Sleep(1000);
        printf("正在为您观察星象，请稍后\n");
        Sleep(2000);
        printf("可能需要一些额外时间，请耐心等待一下\n");
        Sleep(3000);
        printf("经系统夜以继日的判断，您今天的运势为：\n");
        Sleep(2000);
        luckynumber = rand() % 10 + 1;//生成1-10的随机数
        if (luckynumber == 1)
        {
            printf("大吉");/* code */
        }
        if (luckynumber == 2)
        {
            printf("中吉");/* code */
        }
        if (luckynumber == 3)
        {
            printf("小吉");/* code */
        }
        if (luckynumber == 4)
        {
            printf("吉");/* code */
        }
        if (luckynumber == 5)
        {
            printf("半吉");/* code */
        }
        if (luckynumber == 6)
        {
            printf("末吉");/* code */
        }
        if (luckynumber == 7)
        {
            printf("凶");/* code */
        }
        if (luckynumber == 8)
        {
            printf("半凶");/* code */
        }
        if (luckynumber == 9)
        {
            printf("小凶");/* code */
        }
        if (luckynumber == 10)
        {
            printf("大凶");/* code */
        }
        
        printf("\n吉利程度从大到小为：\n大吉、中吉、小吉、吉、半吉、末吉、凶、半凶、小凶、大凶\n如果你是大吉快分享给你的朋友吧！");

        Sleep(5000);
        return 0;
        
        
        
        
        
        
        
        
        
    }
    
    return 0;
}