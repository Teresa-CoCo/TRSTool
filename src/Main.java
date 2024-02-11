//import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        int choice;
        System.out.println("欢迎使用TRSTool Java edition(Beta)\\n");
        Thread.sleep(1000);
        System.out.println("请输入你要使用的功能：\\n1.转换长度工具  2.转换鞋码工具 3.BMI健康指数计算工具 4.多功能电表 5.幸运数字与运势 6.二进制十进制互转 7.(chatgpt驱动)扫雷(命令行版本) 8.扫雷（GUI版本）9.打开记事本 10.成绩核算器 11.安带成绩核算器(未完成)12.空格消除器（建设中）");
        Scanner in = new Scanner(System.in);
        choice = in.nextInt();
        if (choice == 1)
        {
            Translong.translong();
        }
        else if (choice == 2){
            Shoesize.transform();
        }
        else if (choice == 3){
            Bmi.cal();
        }
        else if (choice == 4){
            Electric.measure();
        }
        else if (choice == 5){
            Lucky.cal();
        }
        else if (choice == 6){
            Jinzhi.ertoshi();
        }
        else if (choice == 7){
            Minesweeper.start();
        }
        else if (choice == 8){
            GUIMinesweeper.start();
        }
        else if (choice == 9){
            OpenNotePad.start();
        }
        else if(choice == 10){
            PerformanceAnalysis.ScoreAnalysis();
        }
        else if(choice == 11){
            ScoreCheck.start();
        }
        else if(choice == 12){
            delSpace.start();
        }
    }


}
