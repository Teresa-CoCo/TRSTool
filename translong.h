#include<stdio.h>
#include<windows.h>

void translong(void)
{
    SetConsoleOutputCP(65001);
    float chose,input,calculate,mile,foot,meter,inch,yard; //init things

    printf("欢迎使用长度换算系统工具\n");
    printf("请输入你要输入的单位：\n1.米  2.英尺  3.英寸  4.英里  5.码");

    //meter foot inch mile yard
    scanf("%f",&chose);

        printf("请输入你要换算的数字：\n");
        scanf("%f",&input);

    if (chose == 1)
    {
        meter = input;
        foot = meter * 3.2808;
        inch = meter * 39.370;
        mile =  meter / 1000 * 0.621;
        yard = meter * 1.0936;

        printf("%f米=%f英尺=%f英寸=%f英里=%f码\n",meter,foot,inch,mile,yard);


    }
    else if (chose == 2)
    {
        foot = input;
        meter = foot * 0.3048;
        inch = meter * 39.370;
        mile =  meter / 1000 * 0.621;
        yard = meter * 1.0936;

        printf("%f米=%f英尺=%f英寸=%f英里=%f码\n",meter,foot,inch,mile,yard);
    }
        else if (chose == 3)
    {
        inch = input;
        meter = inch * 0.0254;
        foot = meter * 3.2808;
        
        mile =  meter / 1000 * 0.621;
        yard = meter * 1.0936;

        printf("%f米=%f英尺=%f英寸=%f英里=%f码\n",meter,foot,inch,mile,yard);
    }
    else if (chose == 4)
    {
        mile = input;
        meter = mile * 1609.34 ;
        foot = meter * 3.2808;
        inch = meter * 39.370;
        
        yard = meter * 1.0936;
    }
    else if(chose == 5)
    {
        yard = input;
        meter = yard * 0.9144;
        foot = meter * 3.2808;
        inch = meter * 39.370;
        mile =  meter / 1000 * 0.621;
        

        printf("%f米=%f英尺=%f英寸=%f英里=%f码\n",meter,foot,inch,mile,yard);

    }

    return 0;


}
