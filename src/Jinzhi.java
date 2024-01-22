import java.util.Scanner;

public class Jinzhi {

    public static int convertBinaryToDecimal(long n) {
        int decimalNumber = 0, i = 0, remainder;
        while (n != 0) {
            remainder = (int) (n % 10);
            n /= 10;
            decimalNumber += remainder * Math.pow(2, i);
            ++i;
        }
        return decimalNumber;
    }

    public static long convertDecimalToBinary(int n) {
        long binaryNumber = 0;
        int remainder, i = 1, step = 1;

        while (n != 0) {
            remainder = n % 2;
            System.out.printf("Step %d: %d/2, 余数 = %d, 商 = %d\n", step++, n, remainder, n / 2);
            n /= 2;
            binaryNumber += remainder * i;
            i *= 10;
        }

        return binaryNumber;
    }

    public static void ertoshi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎使用十进制，二进制互转程序");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int choice;
        System.out.println("请输入您要使用的功能：1.二进制转十进制 2.十进制转二进制");
        choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("输入一个二进制数: ");
            long n = scanner.nextLong();
            System.out.printf("二进制数 %d 转换为十进制为 %d", n, convertBinaryToDecimal(n));
        } else if (choice == 2) {
            System.out.print("输入一个十进制数: ");
            int n = scanner.nextInt();
            System.out.printf("十进制数 %d 转换为二进制为 %d", n, convertDecimalToBinary(n));
        }
    }
}
