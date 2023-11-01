#include<stdio.h>
#include<windows.h>
#include<math.h>
int convertBinaryToDecimal(long long n)
        {
            int decimalNumber = 0, i = 0, remainder;
            while (n!=0)
            {
                remainder = n%10;
             n /= 10;
                decimalNumber += remainder*pow(2,i);
                ++i;
            }
            return decimalNumber;
        }
    
long long convertDecimalToBinary(int n)
{
    long long binaryNumber = 0;
    int remainder, i = 1, step = 1;
 
    while (n!=0)
    {
        remainder = n%2;
        printf("Step %d: %d/2, 余数 = %d, 商 = %d\n", step++, n, remainder, n/2);
        n /= 2;
        binaryNumber += remainder*i;
        i *= 10;
    }    
}


void twobit()
{
    printf("欢迎使用十进制，二进制互转程序\n");
    Sleep(1000);
    int choice;
    printf("请输入您要使用的功能：1.二进制转十进制 2.十进制转二进制\n");
    scanf("%d",&choice);
    if (choice == 1)
    {
        long long n;
        printf("输入一个二进制数: ");
        scanf("%lld", &n);
        printf("二进制数 %lld 转换为十进制为 %d", n, convertBinaryToDecimal(n));
    }
    if(choice == 2)
    {
        long long n;
        printf("输入一个十进制数: ");
        scanf("%lld", &n);
        printf("十进制数 %lld 转换为二进制为 %d", n, convertDecimalToBinary(n));

    }
        
 
        
    

}