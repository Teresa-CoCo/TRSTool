import javax.swing.*;
import java.awt.event.*;//Need add this module
import java.io.IOException;
import java.util.Random;

public class TRSTool{
    public static void GUI(){
        JFrame frame = new JFrame("TRSTool Java GUI  全部功能正常运行！");
        JPanel panel1 = new JPanel();
        JButton button2 = new JButton("1.长度转换工具");
        JButton button3 = new JButton("2.鞋码转换工具");
        JButton button4 = new JButton("3.BMI计算工具");
        JButton button5 = new JButton("4.多功能电表");
        JButton button6 = new JButton("5.幸运数");
        JButton button7 = new JButton("6.二进制转十进制");
        JButton button8 = new JButton("7.玩扫雷");
        JButton button9 = new JButton("8.打开记事本");
        JButton button10 = new JButton("9.十进制转二进制");
        JButton button11 = new JButton("10.二阶矩阵计算");
        //Add button listener
        button2.addActionListener(new ActionListener(){
            //add int in here can exit a=0 cycle
            public void actionPerformed(ActionEvent e){
                //Here e means event but you can change that
                TransLong();
            }
        });
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                shoeSize();
            }
        });
        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                BMI();
            }
        });
        button5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Electric();
            }
        });
        button6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                lucky();
            }
        });
        button7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                erToShi();
            }
        });
        button10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                shiToEr();
            }
        });
        button8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                GUIMinesweeper.start();
            }
        });button9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ef){
                try {
                // 创建并启动ProcessBuilder实例以运行记事本
                ProcessBuilder pb = new ProcessBuilder("notepad.exe");
                pb.start();
                } catch (IOException e) {
                // 处理异常
                e.printStackTrace();
        }
            }
        });
        button11.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                erjie();
            }
        });
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(button6);
        panel1.add(button7);
        panel1.add(button10);
        panel1.add(button8);
        panel1.add(button9);
        panel1.add(button11);
        frame.add(panel1);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    
    //TransLong Function
    public static void TransLong() {
        //init
        
        JFrame frame = new JFrame("TransLong Tools");
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        JLabel lableOne = new JLabel("请选择您输入的单位：");
        JComboBox<String> unitSelector = new JComboBox<>(new String[]{"米", "英尺", "英寸", "码", "英里"});
        JButton processButton = new JButton("启动！");
        JTextField input = new JTextField("在这里输入");
        JTextField meter = new JTextField();
        JTextField yingChi = new JTextField();
        JTextField yingCun = new JTextField();
        JTextField yingLi = new JTextField();
        JTextField yard = new JTextField();

        //process
        processButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent whenClick){
                float inputValue = Float.parseFloat(input.getText());
                String selected = (String)unitSelector.getSelectedItem();
                convertUnits(inputValue, selected, meter, yingChi, yingCun,yingLi, yard);
            }
        });

        //display\
        panel1.add(lableOne);
        panel1.add(unitSelector);
        panel1.add(processButton);
        panel1.add(input);
        panel1.add(meter);
        panel1.add(yingChi);
        panel1.add(yingCun);
        panel1.add(yingLi);
        panel1.add(yard);
        frame.add(panel1);
        frame.setBounds(300,200,400,300);
        frame.setVisible(true);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exited All

    }


    //choose process unit

    public static void convertUnits(float value, String unit, JTextField meter, JTextField yingChi, JTextField yingCun, JTextField yingLi, JTextField yard) {
        // Conversion factors
        final float METER_TO_FOOT = 3.28084f;
        final float METER_TO_INCH = 39.3701f;
        final float METER_TO_MILE = 0.000621371f;
        final float METER_TO_YARD = 1.09361f;

        float meters = 0, feet = 0, inches = 0, miles = 0, yards = 0;

        // Convert based on input unit
        switch (unit) {
            case "米":
                meters = value;
                feet = value * METER_TO_FOOT;
                inches = value * METER_TO_INCH;
                miles = value * METER_TO_MILE;
                yards = value * METER_TO_YARD;
                break;
            case "英尺":
                meters = value / METER_TO_FOOT;
                feet = value;
                inches = value * 12;
                miles = value / (METER_TO_FOOT / METER_TO_MILE);
                yards = value / 3;
                break;
            case "英寸":
                meters = value / METER_TO_INCH;
                feet = value / 12;
                inches = value;
                miles = value / (METER_TO_INCH / METER_TO_MILE);
                yards = value / 36;
                break;
            case "码":
                meters = value / METER_TO_YARD;
                feet = value * 3;
                inches = value * 36;
                miles = value / (METER_TO_YARD / METER_TO_MILE);
                yards = value;
                break;
            case "英里":
                meters = value / METER_TO_MILE;
                feet = value * (METER_TO_FOOT / METER_TO_MILE);
                inches = value * (METER_TO_INCH / METER_TO_MILE);
                miles = value;
                yards = value * (METER_TO_YARD / METER_TO_MILE);
                break;
        }

        // Update text fields
        meter.setText(String.format("%.2f 米", meters));
        yingChi.setText(String.format("%.2f 英尺", feet));
        yingCun.setText(String.format("%.2f 英寸", inches));
        yingLi.setText(String.format("%.2f 英里", miles));
        yard.setText(String.format("%.2f 码", yards));
    }


    //Shoesize Function


    public static void shoeSize(){
        // init
        JFrame frame = new JFrame("鞋子尺码计算器");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel lableOne = new JLabel("请选择您输入的单位：");
        JComboBox<String> unitSelector = new JComboBox<>(new String[]{"欧洲尺码", "中国尺码", "美国尺码", "英式尺码"});
        JButton processButton = new JButton("启动！");
        JTextField input = new JTextField("在这里输入");
        JTextField ouZhou = new JTextField("");
        JTextField zhongGuo = new JTextField("");
        JTextField meiGuo = new JTextField("");
        JTextField yingShi = new JTextField("");

        //process
        processButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent whenClick){
                float inputValue = Float.parseFloat(input.getText());
                String selected = (String)unitSelector.getSelectedItem();
                transform(selected,inputValue,ouZhou,zhongGuo,meiGuo,yingShi);
            }
        });

        //display
       panel.add(lableOne);
       panel.add(unitSelector);
       panel.add(processButton);
       panel.add(input);
       panel.add(ouZhou);
       panel.add(zhongGuo);
       panel.add(meiGuo);
        panel.add(yingShi);
        frame.add(panel);
        frame.setBounds(300, 200, 400, 300);
        frame.setVisible(true);
        
    }


    //Shoesize calculate


    public static void transform(String unit,float value,JTextField ouZhou,JTextField zhongGuo,JTextField meiGuo,JTextField yingShi){
        float ouzhou=0,zhonguo=0,meiguo=0,yingshi=0;
        if (unit == "欧洲尺码") {
            zhonguo = (float)(value+10)/2;
            ouzhou = value;
            meiguo = (float)(zhonguo-18+0.5);
            yingshi = (float)zhonguo-18;
        }
        if(unit == "中国尺码"){
            if(value > 100){
                value = value/10;
                zhonguo = value;
            }else{
                zhonguo=value;
            }
            ouzhou = zhonguo * 2-10;
            meiguo = (float)(zhonguo-18+0.5);
            yingshi = zhonguo-18;
        }
        if (unit == "美国尺码") {
            zhonguo = (float)(value +18-0.5);
            ouzhou = zhonguo * 2 -10;
            meiguo = value;
            yingshi = zhonguo-18;
        }
        if (unit == "英式尺码"){
            zhonguo = value +18;
            ouzhou = zhonguo * 2 -10;
            meiguo = (float)(zhonguo-18+0.5);
            yingshi = value;
        }
        //Update textField
        ouZhou.setText(String.format("%.2f 码", ouzhou));
        zhongGuo.setText(String.format("%.2f 厘米", zhonguo));
        meiGuo.setText(String.format("%.2f 码", meiguo));
        yingShi.setText(String.format("%.2f 码", yingshi));
    }

    //BMI Function
    public static void BMI(){
        JFrame frame = new JFrame("BMI计算器");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel lableOne = new JLabel("请输入您的体重（KG）：");
        JTextField Weight = new JTextField();
        JLabel lableTwo = new JLabel("请输入您的身高（m）：");
        JTextField Height = new JTextField("");
        JButton processButton = new JButton("启动！");
        JLabel textBMI = new JLabel();
        JLabel evaluate = new JLabel();

        processButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent whenClick){
                float tiZhong = Float.parseFloat(Weight.getText());
                float shenGao = Float.parseFloat(Height.getText());
                calculateBMI(tiZhong, shenGao,textBMI,evaluate);
                
                
                
            }
        });

        //display
        panel.add(lableOne);
        panel.add(Weight);
        panel.add(lableTwo);
        panel.add(Height);
        panel.add(processButton);
        panel.add(textBMI);
        panel.add(evaluate);
        frame.add(panel);
        frame.setBounds(300,200,400,300);
        frame.setVisible(true);
    }

    //计算BMI函数
    public static void calculateBMI(double weight, double height, JLabel textBMI, JLabel evaluate) {
        if (height >= 5) {
            height = height/100;
        }

        if (height <= 0 || weight <=0) {
            textBMI.setText(String.format("输入有误"));
        }else{
            double bmi =weight / (height * height);
            textBMI.setText(String.format("您的BMI是 %.2f", bmi));

            String out =  new String();
            if (bmi < 18.5) {
                out = "偏瘦";
            } else if (bmi < 24.9) {
                out = "正常";
            } else if (bmi < 29.9) {
                out ="超重";
            } else {
                out = "肥胖";
            }
            evaluate.setText(String.format(out));
            }
        
    }

    //lucky Function
    public static void lucky(){
        JFrame frame = new JFrame("看看你今天幸运吗");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("快来看看今天您的幸运数字是几！");
        JLabel context = new JLabel("正在准备...");
        JProgressBar progressBar = new JProgressBar(0, 10);

        panel.add(title);
        panel.add(context);
        panel.add(progressBar);
        frame.add(panel);
        frame.setBounds(300, 200, 400, 300);
        frame.setVisible(true);

        Timer timer = new Timer(100, new ActionListener() {
            private int count = 0;
            private int phase = 1;
            public void actionPerformed(ActionEvent e) {
                if (phase == 1) {
                    context.setText("正在初始化中......");
                    if (count >= 10) {
                        count = 0;
                        phase = 2;
                    }
                } else if (phase == 2) {
                    context.setText("生成随机种子中......");
                    if (count >= 10) {
                        ((Timer)e.getSource()).stop(); // 停止计时器
                        long seed = System.currentTimeMillis();
                        Random random = new Random(seed);
                        int randomnumber = random.nextInt(9) + 1;
                        context.setText(String.format("您今天的幸运数字是 %d 快分享给您的好友吧！", randomnumber));
                        return;
                    }
                }
                progressBar.setValue(count);
                count++;
            }
        });
        timer.setInitialDelay(0); // 立即开始
        timer.start();
    }

    //erToShi
    public static void erToShi(){
        JFrame frame = new JFrame("二进制转十进制");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel label0 = new JLabel("请输入您要转换的二进制数字：");
        JTextField input = new JTextField();
        JLabel label1 = new JLabel("转换后的十进制数字为：");
        JTextField output = new JTextField();
        JButton start = new JButton("启动！");
        output.setEditable(false);

        //process
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent whenClick){
                int shuru = Integer.parseInt(input.getText());
                convertBinaryToDecimal(shuru, output);
            }
        });

        panel.add(label0);
        panel.add(input);
        panel.add(label1);
        panel.add(output);
        panel.add(start);
        frame.add(panel);
        frame.setBounds(300,200,400,300);
        frame.setVisible(true);
    }

    public static void shiToEr(){
        JFrame frame = new JFrame("十进制转二进制");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel label0 = new JLabel("请输入您要转换的十进制数字：");
        JTextField input = new JTextField();
        JLabel label1 = new JLabel("转换后的二进制数字为：");
        JTextField output = new JTextField();
        JButton start = new JButton("启动！");
        output.setEditable(false);

        //process
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent whenClick){
                int shuru = Integer.parseInt(input.getText());
                convertDecimalToBinary(shuru, output);
            }
        });

        panel.add(label0);
        panel.add(input);
        panel.add(label1);
        panel.add(output);
        panel.add(start);
        frame.add(panel);
        frame.setBounds(300,200,400,300);
        frame.setVisible(true);
    }

    public static void convertBinaryToDecimal(long n,JTextField output) {
        int decimalNumber = 0, i = 0, remainder;
        while (n != 0) {
            remainder = (int) (n % 10);
            n /= 10;
            decimalNumber += remainder * Math.pow(2, i);
            ++i;
        }
        output.setText(String.format("%d", decimalNumber));
    }

    public static void convertDecimalToBinary(int n,JTextField output) {
        long binaryNumber = 0;
        int remainder, i = 1;

        while (n != 0) {
            remainder = n % 2;
            n /= 2;
            binaryNumber += remainder * i;
            i *= 10;
        }

        output.setText(String.format("%d", binaryNumber));
    }
    public static void Electric(){
        JFrame frame = new JFrame("多功能电表");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel label0 = new JLabel("请选择档位（即要求的项目）");
        JComboBox<String> selector = new JComboBox<>(new String[]{"安培档","电压档","欧姆档"});
        JButton start = new JButton("启动！");
        JLabel label1 = new JLabel("电流：");
        JTextField anPei = new JTextField();
        JLabel label2 = new JLabel("电压：");
        JTextField dianYa = new JTextField();
        JLabel label3 = new JLabel("电阻：");
        JTextField ouMu =new JTextField();

        //process
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent whenClick){
                float input_anpei = 0,input_dianya =0,input_oumu=0;
                String selected = (String)selector.getSelectedItem();
            if (selected == "安培档") {
                input_dianya=Float.parseFloat(dianYa.getText());
                input_oumu=Float.parseFloat(ouMu.getText());
                input_anpei = input_dianya/input_oumu;
            }
            if (selected == "电压档") {
                input_oumu=Float.parseFloat(ouMu.getText());
                input_anpei=Float.parseFloat(anPei.getText());
                input_dianya = input_anpei * input_oumu;
            }
            if (selected == "欧姆档") {
                input_anpei=Float.parseFloat(anPei.getText());
                input_dianya=Float.parseFloat(dianYa.getText());
                input_oumu = input_dianya / input_anpei;
            }
            anPei.setText(String.format("%.2f 安培（A）", input_anpei));
            dianYa.setText(String.format("%.2f 伏特（V）", input_dianya));
            ouMu.setText(String.format("%.2f 欧姆（Ω）", input_oumu));
            
            }
        });


        panel.add(label0);
        panel.add(selector);
        panel.add(start);
        panel.add(label1);
        panel.add(anPei);
        panel.add(label2);
        panel.add(dianYa);
        panel.add(label3);
        panel.add(ouMu);
        frame.add(panel);
        frame.setBounds(300,200,400,300);
        frame.setVisible(true);
    }

    //Still Working......

    public static void erjie(){
        JFrame frame = new JFrame("二阶矩阵计算器");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel label0 = new JLabel("1,1的位置");
        JTextField oneone = new JTextField();
        JLabel label1 = new JLabel("1,2的位置");
        JTextField onetwo = new JTextField();
        JLabel label2 = new JLabel("2,1的位置");
        JTextField twoone = new JTextField();
        JLabel label3 = new JLabel("2,2的位置");
        JTextField twotwo = new JTextField();
        JButton start = new JButton("启动");
        JTextField result = new JTextField();
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int resultt = (Integer.parseInt(oneone.getText()) * Integer.parseInt(twotwo.getText()))-(Integer.parseInt(onetwo.getText()) * Integer.parseInt(twoone.getText()));
                result.setText(String.format(String.valueOf(resultt)));
            }
        });

        panel.add(label0);
        panel.add(oneone);
        panel.add(label1);
        panel.add(onetwo);
        panel.add(label2);
        panel.add(twoone);
        panel.add(label3);
        panel.add(twotwo);
        panel.add(start);
        panel.add(result);
        frame.add(panel);
        frame.setBounds(300,200,400,300);
        frame.setVisible(true);
    }
    public static void building(){
        JFrame frame = new JFrame("正在施工。。。。。。");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel alarm = new JLabel("Still Working......");
        panel.add(alarm);
        frame.add(panel);
        frame.setBounds(300,200,400,300);
        frame.setVisible(true);
    }


}
