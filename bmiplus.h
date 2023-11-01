// #include<stdio.h>

// int main(void)
// {
//     float height,weight,standardheight,standardweight;
//     int panduan;
//     float nuh,yuhu;

//     printf("�������������:\n");
//     scanf("%f",&height);

//     if (height>100)
//     {
//         standardheight = height / 100;
//     }
    


//     printf("��������Ϊ%f��",standardheight);

//     printf("���������أ�\n");
    
//     scanf("%f",&weight);

//     printf("��ѡ�������������صĵ�λ��1.���2.�н�");
//     scanf("%d",&panduan);



//     if (panduan == 2)
//     {
//         standardheight = (float)height / 2;
//     }
//     else if (panduan == 1)
//     {
//         standardheight = (float)weight;
//     }
//     else if (panduan != 1 && panduan !=0)
//     {
//         printf("������������,������ִ�С�");/* code */
//         return 0;
//     }
    
    

//     printf("��������Ϊ%f kg\n",standardweight);


//     yuhu = (float)height*height;

    

//     nuh = (float)weight / yuhu; 

    

    

//     printf("yuhuΪ%.1f\n",yuhu);

//     printf("bmiΪ%.1f\n",nuh);

//     if(nuh<18.5)
//     {
//         printf("���ع���\n");
//         return 0;
//     }
//     else if(18.5<=nuh && nuh<24)
//     {
//         printf("�������أ����������\n");
//         return 0;

//     }
//     else if(24<=nuh && nuh<27)
//     {
//         printf("���ع�����\n");
//         return 0;
//     }
//     else if (nuh>=27)
//     {
//         printf("���س�����\n");
//         return 0;
//     }
    

//     return 0;

// }




//Second edition

#include<stdio.h>

void bmicalculator(void)
{
    float height, weight, standardheight, standardweight;
    int panduan;
    float nuh, yuhu;

    printf("�������������:\n");
    scanf("%f", &height);

    standardheight = height / 100;

    printf("��������Ϊ%f��\n", standardheight);

    printf("���������أ�\n");
    scanf("%f", &weight);

    printf("��ѡ�������������صĵ�λ��1.���2.�н�\n");
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
        printf("������������������ִ�С�\n");
        //return 0;
    }

    printf("��������Ϊ%f kg\n", standardweight);

    yuhu = standardheight * standardheight;

    nuh = standardweight / yuhu;

    printf("yuhuΪ%.1f\n", yuhu);
    printf("bmiΪ%.1f\n", nuh);

    if (nuh < 18.5)
    {
        printf("���ع���\n");
    }
    else if (18.5 <= nuh && nuh < 24)
    {
        printf("�������أ����������\n");
    }
    else if (24 <= nuh && nuh < 27)
    {
        printf("���ع�����\n");
    }
    else if (nuh >= 27)
    {
        printf("���س�����\n");
    }

    //return 0;
}

//This maybe the last edition of this cmd version.

//Next Version 3 will incloud a simple gui.