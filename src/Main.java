//import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        int choice;
        System.out.println("Welcome to use TRSTool Java edition");
        Thread.sleep(1000);
        System.out.println("Please input which function you want to use:");
        System.out.println("1.Transform long tool(beta)");
        Scanner in = new Scanner(System.in);
        choice = in.nextInt();
        if (choice == 1)
        {
            Translong.translong();
        }
    }


}