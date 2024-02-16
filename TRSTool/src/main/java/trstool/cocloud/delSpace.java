package cocloud.teresacoco.life;

import java.util.Scanner;

public class delSpace {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Please input the sentence\n");
        String inpput = scanner.nextLine();
        System.out.printf("Your input is %s\n\n", inpput);
        char[] charArray = inpput.toCharArray();
        //No.1
        int i=0;
        for(i=0;i<inpput.length();i++){
            if (i%2==0&&i!=0) {
                System.out.printf(" ");
            }
            // System.out.printf("%c",charArray[i]);
        }
        System.out.println("\n");
        //No.2 Using buffer
        StringBuilder two = new StringBuilder(1000);
        // two.append(inpput);
        for(int j = 0; j < inpput.length(); j++) {
            two.append(inpput.charAt(j));
            // 在每个字符后添加空格，除了最后一个字符
            if (j%2==0&&j!=0) {
                two.append(" ");
            }
        }
        System.out.printf("%s",two);
    }
}
