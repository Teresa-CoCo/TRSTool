#include<stdio.h>
#include<windows.h>
#include<time.h>

// void Post();

// int main(void)
// {
//     Post();
//     return 0;
// }
// void Post()
// {
//     printf("114514\n");
//     printf("1919810\n");
//     Sleep(5000);
// }

void electric(void)
{
    SetConsoleOutputCP(65001);
    printf("欢迎使用万能表\n");
    //int volt,anpei;
    int dangwei;
    printf("请选择档位：1.安培档，2.电压档，3.欧姆档");
    scanf("%d",&dangwei);
    if (dangwei == 1)
    {
        anpei();
        
    }
    if (dangwei == 2)
    {
        volt();
    }
    if (dangwei == 3)
    {
        omegacal();
    }
    
    
    


    

}
void anpei(void)
{
    float volt,anpei,omega;
    printf("请输入电阻、电压\n");
    scanf("%d %d",&omega,&volt);
    anpei = volt / omega;
    printf("经计算，电流为%f",anpei);
    return 0;

}
void volt(void)
{
    long volt,anpei,omega;
    printf("请输入电阻、电流\n");
    scanf("%d %d",&omega,&anpei);
    volt = anpei * omega;
    printf("经计算，电压为%ld",volt);
    return 0;
}
void omegacal()
{
    float volt,anpei,omega;
    printf("请输入电压、电流\n");
    scanf("%d %d",&volt,&anpei);
    omega =volt / anpei;
    printf("经计算，电阻为%f",omega);
    return 0;



}
//根据此，可修改allinone程序。