import java.util.Scanner;
import java.util.Random;

class Lucky {

    public static void cal() {
        Scanner scanner = new Scanner(System.in);
        int randomnumber, luckynumber;

        System.out.println("欢迎使用幸运数程序");
        System.out.println("快来看看你今天的幸运数字是几！");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("请稍等，正在初始化程序。");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生成随机种子中");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 使用当前时间作为随机数种子
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        randomnumber = random.nextInt(9) + 1; // 生成 1 和 9 之间的随机数

        System.out.println("生成好了，您今天的幸运数字为 " + randomnumber + "，快分享给你的朋友吧！");

        // 判断吉利、不吉利
        System.out.println("您需要继续系统判断今天的运气吗？\n输入1继续，其他数字退出");
        int lucky = scanner.nextInt();
        if (lucky == 1) {
            System.out.println("感谢您对本系统的认可");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("正在为您观察星象，请稍后");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("可能需要一些额外时间，请耐心等待一下");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("经系统夜以继日的判断，您今天的运势为：");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            luckynumber = random.nextInt(10) + 1; // 生成1-10的随机数

            switch (luckynumber) {
                case 1:
                    System.out.println("大吉");
                    break;
                case 2:
                    System.out.println("中吉");
                    break;
                case 3:
                    System.out.println("小吉");
                    break;
                case 4:
                    System.out.println("吉");
                    break;
                case 5:
                    System.out.println("半吉");
                    break;
                case 6:
                    System.out.println("末吉");
                    break;
                case 7:
                    System.out.println("凶");
                    break;
                case 8:
                    System.out.println("半凶");
                    break;
                case 9:
                    System.out.println("小凶");
                    break;
                case 10:
                    System.out.println("大凶");
                    break;
            }

            System.out.println("吉利程度从大到小为：\n大吉、中吉、小吉、吉、半吉、末吉、凶、半凶、小凶、大凶");
            System.out.println("如果你是大吉快分享给你的朋友吧！");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
