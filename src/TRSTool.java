import javax.swing.*;
import java.awt.event.*;//Need add this module

public class TRSTool{
    public static void GUI(){
        System.out.printf("Test Button测试摁钮");
        JFrame frame = new JFrame("A Good example");
        JPanel panel1 = new JPanel();
        JButton button1 = new JButton("Test Button测试摁钮");
        JButton button2 = new JButton("1.长度转换工具");
        //Add button listener
        button1.addActionListener(new ActionListener(){
            int a=0;
            //add int in here can exit a=0 cycle
            public void actionPerformed(ActionEvent e){
                //Here e means event but you can change that
                button1.setText("计数："+String.valueOf(a++));
            }
        });
        button2.addActionListener(new ActionListener(){
            //add int in here can exit a=0 cycle
            public void actionPerformed(ActionEvent e){
                //Here e means event but you can change that
                TransLong();
            }
        });
        panel1.add(button1);
        panel1.add(button2);
        frame.add(panel1);
        frame.setBounds(300,200,400,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
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
}
