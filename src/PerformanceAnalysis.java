import java.util.Scanner;

public class PerformanceAnalysis{

    public static double[] input(){
        int size;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要输入的成绩数组长度\n");
        size = in.nextInt();
        double[] score = new double[size];
        int i=0;
        for(i=0;i<size;i++){
            System.out.println("请输入下一个成绩：\n");
            score[i]= in.nextInt();
        }
        return score;

    }

    public static double average(double[] array){
        double pingjun;
        double total=0;
        int j;
        for(j=0;j<array.length;j++){
            total+=array[j];
        }
        pingjun = total/array.length;
        return pingjun;
    }

    public static int averageNum(double[] array,double average){
        int k=0;
        int avnum=0;
        for(k=0;k<array.length;k++){
            if(array[k]>average){
                avnum=avnum+1;
            }
        }
        return avnum;
    }

    public static double findMax(double[] array){
        int l=0;
        double max = array[0];
        for(l=0;l<array.length;l++){
            if(array[l]>max){
                max = array[l];
            }
        }
        return max;
    }


    public static double findMin(double[] array){
        int m=0;
        double min = array[0];
        for(m=0;m<array.length;m++){
            if(array[m]<min){
                min = array[m];
            }
        }
        return min;

    }

    public static int passNum(double[] array){
        int n=0;
        int pnum=0;
        for(n=0;n<array.length;n++){
            if(array[n]>=60){
                pnum=pnum+1;
            }
        }
        return pnum;
    }

    public static void ScoreAnalysis() {
        double[] score = input();
        passNum(score);
        average(score);
        double aver=average(score);
        averageNum(score,aver);
        findMax(score);
        findMin(score);
        // in.close;

    }
}