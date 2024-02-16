package cocloud.teresacoco.life;

import java.util.Scanner;

public class Shoesize {
    public static void transform(){
        int input;
        float test, europe, usa, eng, china, temp;

        System.out.println("欢迎使用鞋子尺码换算工具");

        System.out.println("请输入您要使用的模式：\n1.欧洲尺码换算为其他\n2.中国尺码换算为其他尺码\n3.美国尺码换算为其他尺码\n4.英式尺码换算为其他尺码\n（如果不输入默认为欧洲尺码）");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();

        System.out.println("请输入您要换算的尺码：");
        test = scanner.nextFloat();

        if (input == 1 || input == 0) { // input is europe
            china = (test + 10) / 2;
            europe = test;
            usa = (float) (china - 18 + 0.5);
            eng = china - 18;
            System.out.printf("经计算，您的中国尺码是%fcm\n您的欧洲尺码是%f码\n您的美国尺码是%f码\n您的英国尺码是%f码\n", china, europe, usa, eng);
        }

        if (input == 2) { // input is china
            temp = test;

            if (temp > 100) {
                china = temp / 10;
            } else {
                china = temp;
            }

            europe = test * 2 - 10;
            usa = (float) (test - 18 + 0.5);
            eng = test - 18;
            System.out.printf("经计算，您的中国尺码是%fcm\n您的欧洲尺码是%f码\n您的美国尺码是%f码\n您的英国尺码是%f码\n", china, europe, usa, eng);
        }

        if (input == 3) { // input is usa
            temp = (float) (test + 18 - 0.5);
            china = temp;
            europe = china * 2 - 10;
            usa = test;
            eng = china - 18;
            System.out.printf("经计算，您的中国尺码是%fcm\n您的欧洲尺码是%f码\n您的美国尺码是%f码\n您的英国尺码是%f码\n", china, europe, usa, eng);
        }

        if (input == 4) { // input is eng
            temp = test + 18;
//            new static fub(){
//
//            }
            china = temp;
            europe = china * 2 - 10;
            usa = (float) (china - 18 + 0.5);
            eng = test;
            System.out.printf("经计算，您的中国尺码是%fcm\n您的欧洲尺码是%f码\n您的美国尺码是%f码\n您的英国尺码是%f码\n", china, europe, usa, eng);
        }
    }
}
