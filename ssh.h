#include<stdio.h>
#include<windows.h>
#include<time.h>
void ssh()
{
    char username[100];
    int password = 0;
    printf("请输入你要连接目标计算机的ip地址:端口,用户名,密码（请使用英文逗号）\n");
    int ssh = 0;
    int port = 0;
    scanf("%d:%d,%s,%s",&ssh,&port,&username,&password);
    // printf("请输入你要链接目标计算机作为的用户名\n");
    // scanf("%s",&username);
    // printf("请输入你要链接目标计算机对应用户名的密码\n");
    // scanf("%d",&password);
    char code[100];
    sprintf(code,"ssh %s@%d:%d",username,ssh,port);//command function error need read ssh function api.doc
    Sleep(1000);


    system(code);
}