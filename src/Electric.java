import java.util.Scanner;

public class Electric {
    public static void measure(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("欢迎使用万能表\n");
        //int volt,anpei;
        int dangwei;
        System.out.printf("请选择档位：1.安培档，2.电压档，3.欧姆档");
//        scanf("%d",&dangwei);
        dangwei=scanner.nextInt();

        if (dangwei == 1)

        {
            float volt,anpei,omega;
            System.out.printf("请输入电阻、电压\n");
            omega = scanner.nextInt();
            volt = scanner.nextInt();
//            scanf("%d %d",&omega,&volt);
            anpei = volt / omega;
            System.out.printf("经计算，电流为%f",anpei);
//            return 0;

        }
        if (dangwei == 2)
        {
            long volt,anpei,omega;
            System.out.printf("请输入电阻、电流\n");
            omega = scanner.nextInt();
            anpei = scanner.nextInt();
//            scanf("%d %d",&omega,&anpei);
            volt = anpei * omega;
            System.out.printf("经计算，电压为%ld",volt);
//            return 0;
        }
        if (dangwei == 3)
        {
            float volt,anpei,omega;
            System.out.printf("请输入电压、电流\n");
            volt = scanner.nextInt();
            anpei = scanner.nextInt();
//            scanf("%d %d",&volt,&anpei);
            omega =volt / anpei;
            System.out.printf("经计算，电阻为%f",omega);
//            return 0;
        }
    }


}
