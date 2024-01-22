//import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        int choice;
        System.out.println("欢迎使用TRSTool Java edition(Beta)\\n");
        Thread.sleep(1000);
        System.out.println("请输入你要使用的功能：\\n1.转换长度工具  2.转换鞋码工具 (new)");
        Scanner in = new Scanner(System.in);
        choice = in.nextInt();
        if (choice == 1)
        {
            Translong.translong();
        }
        else if (choice == 2){
            Shoesize.transform();
        }
    }


}
