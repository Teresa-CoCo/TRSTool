//import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        int choice;
        System.out.println("Welcome Using TRSTool Java edition\\n");
        Thread.sleep(1000);
        //English version
        // System.out.println("Please input which funtion you want to use:\n0.GUI edition(BUIDING)    1.Length transform  \n2.Shoe Size Transform    3.BMI Calculator \n4.Muti-funtion Electric Calculator    5.Lucky Number \n6.0101 to normal number    7.(drive by chatgpt)Minesweeper(Run in powershell) \n8.Minesweeper(GUI edition)    9.Open Notepad(windows) \n10.Score Calculator    11.AHU Score Calculator(UNFINISHED)\n12.Space delete tool    13.Array tool");
        //Chinese version
        System.out.println("请输入你要使用的功能：\\n0.GUI版本(全新打造)(default)1.转换长度工具  2.转换鞋码工具 3.BMI健康指数计算工具 4.多功能电表 5.幸运数字与运势 6.二进制十进制互转 7.(chatgpt驱动)扫雷(命令行版本) 8.扫雷（GUI版本）9.打开记事本 10.成绩核算器 11.安带成绩核算器(未完成)12.空格消除器13.数组工具14.二阶矩阵计算");
        Scanner in = new Scanner(System.in);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("\n5秒倒计时结束，自动选择默认功能");
                TRSTool.GUI();
                
            }
        };
        timer.schedule(task, 5000);
        while (in.hasNext()) {
            if (in.hasNextInt()) {
                choice = in.nextInt();
                if (choice >= 0) {
                    // 用户已做出选择，取消倒计时任务
                    timer.cancel();
                    // break;
                }
        if (choice == 0)
        {
            TRSTool.GUI();
        }
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
        else if (choice == 13) {
            arrayUtils.start();
        }
        else if (choice == 14) {
            erjie.cal();
        }
    }


        }
    }
}
