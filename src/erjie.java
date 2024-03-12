import java.util.Scanner;

public class erjie {
    public static void cal(){
        Scanner scanner = new Scanner(System.in);
        int r1l1;
        int r2l1;
        int r1l2;
        int r2l2;
        System.out.println("请输入第一行第一列的数字");
        r1l1 = scanner.nextInt();
        System.out.println("请输入第一行第2列的数字");
        r2l1 = scanner.nextInt();
        System.out.println("请输入第二行第一列的数字");
        r1l2 = scanner.nextInt();
        System.out.println("请输入第二行第二列的数字");
        r2l2 = scanner.nextInt();
        int result;
        result = (r1l1 * r2l2) - (r1l2 * r2l1);
        System.out.println("结果为"+result);
    }
}
