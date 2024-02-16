package cocloud.teresacoco.life;

import java.util.Scanner;
import java.util.Arrays;

public class arrayUtils {
    public static void start() {
        System.out.println("Welcome use array utils\nPlease input your array size:");
        Scanner scanner = new Scanner(System.in);
        int size;
        size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Please input the array num(int)");
        int countOne=0;
        for(countOne=0;countOne<size;countOne++){
            array[countOne] = scanner.nextInt();
        }
        System.out.println("Your array is\n:");
        int countTwo;
        for(countTwo=0;countTwo<size;countTwo++){
            System.out.printf("%d ",array[countTwo]);
        }
        System.out.println("Which function do you want to use?\n1.reverse 2.sort(from big to small) 3.sort2(from small to big) 4.find number");
        int chose = scanner.nextInt();
        if (chose == 1) {
            reverse(array);
            
        }
        if (chose == 2) {
            Arrays.sort(array);
            System.out.println(Arrays.toString(array));//change to string
        }
        if (chose == 3) {
            Arrays.sort(array);
            reverse(array);
        }
        if (chose == 4) {
            //use binarySearch to find number
            int num=0;
            num = scanner.nextInt();
            Arrays.sort(array);
            int location = Arrays.binarySearch(array,num);
            if (location >= 0) {
                System.out.println("Found " + num + " at: " + location);
            } else {
                System.out.println("Number " + num  + " Not in array");
            }
        }
    }
    public static int[] reverse(int[] list) {
        int[] result = new int[list.length];
       
        for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
          result[j] = list[i];
        }
        //introduce a new method to read array
        for(int element :result){
            System.out.print(element+" ");
        }
        return result;
      }
}
