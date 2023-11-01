#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

void hyperv2()
{
    char downloadlink[100];
    char url[] = "https://alist.it7.buzz/d/C%3A/Users/Administrator/Desktop/APP/alist/folder/guest/tools/system-tools/Hyper-Vauto.bat";//URL of tool
    char commandone[100];
    strcpy(commandone, url);
    char commandtwo[10000];
    sprintf(commandtwo,"powershell cd ~;Invoke-WebRequest -Uri %s -Outfile hyperv.bat",commandone);
    system(commandtwo);
    system("powershell Start-Process -FilePath ~\\hyperv.bat");


}