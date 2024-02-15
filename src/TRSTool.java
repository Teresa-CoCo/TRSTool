import javax.swing.*;
import java.awt.event.*;//Need add this module

public class TRSTool{
    public static void main(String[] arg){
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
        JLabel lableOne = new JLabel("目前仅支持米转其他");
        JButton processButton = new JButton("启动！");
        JTextField meter = new JTextField("在这里输入(单位：米)");
        JTextField yingChi = new JTextField("英尺");
        JTextField yingCun = new JTextField("英寸");
        JTextField yingLi = new JTextField("英里");
        JTextField yard = new JTextField("码");

        //process
        processButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent whenClick){
                final int meters =Integer.parseInt(meter.getText());//default is meter to else
                //calculate
                float foot = (float) (meters * 3.2808);
                float inch = (float) (meters * 39.370);
                float mile = (float) (meters / 1000 * 0.621);
                float yards = (float) (meters * 1.0936);
                //set numbers
                yingChi.setText(String.valueOf(foot));
                yingCun.setText(String.valueOf(inch));
                yingLi.setText(String.valueOf(mile));
                yard.setText(String.valueOf(yards));
            }
        });


        //display\
        panel1.add(lableOne);
        panel1.add(processButton);
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
}