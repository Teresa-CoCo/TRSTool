#include<stdio.h>

void bmicalculator(void)
{
    float height, weight, standardheight, standardweight;
    int panduan;
    float nuh, yuhu;

    printf("请输入您的身高（cm）:\n");
    scanf("%f", &height);

    standardheight = height / 100;

    printf("您的身高是Ϊ%f米\n", standardheight);

    printf("请输入您的体重：\n");
    scanf("%f", &weight);

    printf("请输入您刚才输入体重的单位：\n1.斤 2.千克（公斤）\n");
    scanf("%d", &panduan);

    if (panduan == 2)
    {
        standardweight = weight / 2;
    }
    else if (panduan == 1)
    {
        standardweight = weight;
    }
    else
    {
        printf("您输入有误，请重新执行本程序\n");
        //return 0;
    }

    printf("您的体重是%f kg\n", standardweight);

    yuhu = standardheight * standardheight;

    nuh = standardweight / yuhu;

    printf("yuhuΪ%.1f\n", yuhu);
    printf("bmiΪ%.1f\n", nuh);

    if (nuh < 18.5)
    {
        printf("营养不良\n");
    }
    else if (18.5 <= nuh && nuh < 24)
    {
        printf("有点瘦\n");
    }
    else if (24 <= nuh && nuh < 27)
    {
        printf("正常区间\n");
    }
    else if (nuh >= 27)
    {
        printf("有点胖\n");
    }

    //return 0;
}

//This maybe the last edition of this cmd version.

//Next Version 3 will incloud a simple gui.