import javax.swing.*;
import java.awt.event.*;//Need add this module

public class TRSTool{
    public static void GUI(){
        System.out.printf("Test Button测试摁钮");
        JFrame frame = new JFrame("A Good example");
        JPanel panel1 = new JPanel();
        JButton button2 = new JButton("1.长度转换工具");
        JButton button3 = new JButton("2.鞋码转换工具");
        JButton button4 = new JButton("3.BMI计算工具");
        JButton button5 = new JButton("4.多功能电表");
        JButton button6 = new JButton("5.幸运数");
        JButton button7 = new JButton("6.二进制转十进制");
        JButton button8 = new JButton("7.玩扫雷");
        JButton button9 = new JButton("8.打开记事本");
        JButton button10 = new JButton("9.鞋码转换工具");
        //Add button listener
        button2.addActionListener(new ActionListener(){
            //add int in here can exit a=0 cycle
            public void actionPerformed(ActionEvent e){
                //Here e means event but you can change that
                TransLong();
            }
        });
        button3.addActionListener(new ActionListener(){
            //add int in here can exit a=0 cycle
            public void actionPerformed(ActionEvent e){
                //Here e means event but you can change that
                shoeSize();
            }
        });
        button4.addActionListener(new ActionListener(){
            //add int in here can exit a=0 cycle
            public void actionPerformed(ActionEvent e){
                //Here e means event but you can change that
                BMI();
            }
        });
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(button6);
        panel1.add(button7);
        panel1.add(button8);
        panel1.add(button9);
        panel1.add(button10);
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
        JLabel lableTwo = new JLabel("请输入您的身高（cm）：");
        JTextField Height = new JTextField("");
        JButton processButton = new JButton("启动！");
        JLabel textBMI = new JLabel();
        JLabel evaluate = new JLabel();

        processButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent whenClick){
                float tiZhong = Float.parseFloat(Weight.getText());
                float shenGao = Float.parseFloat(Height.getText());
                double bmi = calculateBMI(tiZhong, shenGao);
                interpretBMI(bmi,evaluate);
                textBMI.setText(String.format("您的BMI是 %.2f", bmi));
                
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
    public static double calculateBMI(double weight, double height) {
        if (height <= 0) {
            System.out.println("身高必须大于零！");
            return 0.0;
        }

        return weight / (height * height);
    }

    // 解释BMI的函数
    public static void interpretBMI(double bmi,JLabel evaluate) {
        String out =  new String();
        System.out.print("BMI指数的解释：");

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
