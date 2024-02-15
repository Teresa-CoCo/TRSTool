import javax.swing.*;
import java.awt.event.*;//Need add this module

public class TRSTool{
    public static void GUI(){
        System.out.printf("Hello");
        JFrame frame = new JFrame("A Good example");
        JPanel panel1 = new JPanel();
        JButton button1 = new JButton("Hello");
        //Add button listener
        button1.addActionListener(new ActionListener(){
            int a=0;//add int in here can exit a=0 cycle
            public void actionPerformed(ActionEvent e){
                //Here e means event but you can change that
                button1.setText(String.valueOf(a++));
            }
        });
        panel1.add(button1);
        frame.add(panel1);
        frame.setBounds(300,200,400,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}