import java.util.Scanner;

class Bmi {

    public static void cal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入您的体重（公斤）：");
        double weight = scanner.nextDouble();

        System.out.println("请输入您的身高（米）：");
        double height = scanner.nextDouble();

        double bmi = calculateBMI(weight, height);

        System.out.println("您的BMI指数为：" + bmi);
        interpretBMI(bmi);
    }

    // 计算BMI的函数
    public static double calculateBMI(double weight, double height) {
        if (height <= 0) {
            System.out.println("身高必须大于零！");
            return 0.0;
        }

        return weight / (height * height);
    }

    // 解释BMI的函数
    public static void interpretBMI(double bmi) {
        System.out.print("BMI指数的解释：");

        if (bmi < 18.5) {
            System.out.println("偏瘦");
        } else if (bmi < 24.9) {
            System.out.println("正常");
        } else if (bmi < 29.9) {
            System.out.println("超重");
        } else {
            System.out.println("肥胖");
        }
    }
}