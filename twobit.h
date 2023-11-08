#include<stdio.h>
#include<math.h>

int convertBinaryToDecimal(long long n) {
    int decimalNumber = 0, i = 0, remainder;
    while (n!=0) {
        remainder = n%10;
        n /= 10;
        decimalNumber += remainder*pow(2,i);
        ++i;
    }
    return decimalNumber;
}

long long convertDecimalToBinary(int n) {
    long long binaryNumber = 0;
    int i = 0, remainder;
    while (n!=0) {
        remainder = n%2;
        n /= 2;
        binaryNumber += remainder*pow(10,i);
        ++i;
    }
    return binaryNumber;
}
int twobit()
{
    printf("1.十进制转二进制 2.二进制转十进制\n");
    int grate;
    scanf("%d",&grate);
    if (grate == 1)
    {
        int n;
        printf("请输入一个十进制数：");
        scanf("%d", &n);
        printf("二进制数为：%lld", convertDecimalToBinary(n));
    }
    else if (grate == 2)
    {
        long long n;
        printf("请输入一个二进制数：");
        scanf("%lld", &n);
        printf("十进制数为：%d", convertBinaryToDecimal(n));
    }
    else
    {
        printf("请检查您输入的正确与否，本程序未能匹配到您想要运行的模块或者该模块暂未被修复\n");
    }
}