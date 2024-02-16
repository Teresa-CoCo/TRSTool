import java.util.Scanner;

public class Translong {
    public static void translong()
    {
        Scanner scanner = new Scanner(System.in);
        float chose, input, meter, foot, inch, mile, yard;
        System.out.println("欢迎使用长度换算系统工具");
        System.out.println("请输入你要输入的单位：\n1.米  2.英尺  3.英寸  4.英里  5.码");

        // meter foot inch mile yard
        chose = scanner.nextFloat();

        System.out.println("请输入你要换算的数字：");
        input = scanner.nextFloat();

        if (chose == 1) {
            meter = input;
            foot = (float) (meter * 3.2808);
            inch = (float) (meter * 39.370);
            mile = (float) (meter / 1000 * 0.621);
            yard = (float) (meter * 1.0936);

            System.out.printf("%f米=%f英尺=%f英寸=%f英里=%f码\n", meter, foot, inch, mile, yard);

        } else if (chose == 2) {
            foot = input;
            meter = (float) (foot * 0.3048);
            inch = (float) (meter * 39.370);
            mile = (float) (meter / 1000 * 0.621);
            yard = (float) (meter * 1.0936);

            System.out.printf("%f米=%f英尺=%f英寸=%f英里=%f码\n", meter, foot, inch, mile, yard);
        } else if (chose == 3) {
            inch = input;
            meter = (float) (inch * 0.0254);
            foot = (float) (meter * 3.2808);

            mile = (float) (meter / 1000 * 0.621);
            yard = (float) (meter * 1.0936);

            System.out.printf("%f米=%f英尺=%f英寸=%f英里=%f码\n", meter, foot, inch, mile, yard);
        } else if (chose == 4) {
            mile = input;
            meter = (float) (mile * 1609.34);
            foot = (float) (meter * 3.2808);
            inch = (float) (meter * 39.370);
            yard = (float) (meter * 1.0936);
            System.out.printf("%f米=%f英尺=%f英寸=%f英里=%f码\n", meter, foot, inch, mile, yard);
        } else if (chose == 5) {
            yard = input;
            meter = (float) (yard * 0.9144);
            foot = (float) (meter * 3.2808);
            inch = (float) (meter * 39.370);
            mile = (float) (meter / 1000 * 0.621);
            System.out.printf("%f米=%f英尺=%f英寸=%f英里=%f码\n", meter, foot, inch, mile, yard);
        }

    }



}
