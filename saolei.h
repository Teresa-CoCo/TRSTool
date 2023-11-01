#include "D:\Develop\CLanguageLearning-2\C_Primer_Plus\game\gameset.h"
#include "D:\Develop\CLanguageLearning-2\C_Primer_Plus\game\gamecode.h"
#include<stdio.h>

void game() {
	//��������
	char InnerBoard[ROWS][COLS] = { 0 };
	char OutBoard[ROWS][COLS] = { 0 };

	//��ʼ������
	char ichar = '0';
	char ochar = '#';
	IniBoard(InnerBoard, ichar);
	IniBoard(OutBoard, ochar);

	//��ӡ����
	DisplayBoard(OutBoard, ROW, COL);

	//����
	SetMine(InnerBoard, ROW, COL);
	//DisplayBoard(InnerBoard, ROW, COL);

	//����
	FindMine(InnerBoard, OutBoard, ROW, COL);
}

void menu() {
	printf("*****************************\n");
	printf("*******1.游玩 ******\n");
	printf("*******----------------******\n");
	printf("*******0.不玩 ******\n");
	printf("*****************************\n");
}

int wansaolei() {
	SetConsoleOutputCP(65001);
	int uipt;
	srand((unsigned int)time(NULL));
	do {
		menu();
		printf("你想选什么");
		scanf("%d", &uipt);
		switch (uipt) {
		case 0:
			printf("居然不玩~\n");
			break;
		case 1:
			game();
			break;
		default:
			printf("选错了\n");
			break;
		}
	} while (uipt);
	return 0;
}