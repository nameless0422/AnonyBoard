package View;

import Controler.MainProcess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class produceView {
    private JComboBox comboBox1;
    private JPanel panel1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton Button1;
    private MainProcess mainProcess;
    private JFrame frame;

    public produceView(MainProcess p) {
        mainProcess = p;
        frame = new JFrame();
        String menu1[] = {"자바","윈프","이산수학"};
        String menu2[] = {"양재동","박현주","이횽태"};
        String menu3[] = {"1","2","3"};
        comboBox1 = new JComboBox(menu1);
        comboBox2 = new JComboBox(menu2);
        comboBox3 = new JComboBox(menu3);
        frame.setContentPane(panel1);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainProcess.produceView.frame.setVisible(false);
            }
        });

    }
    public static JComboBox createBox(String a[]) {
        JComboBox Box1 = new JComboBox(a);
        Box1.setLightWeightPopupEnabled(true);

        return Box1;
    }
    public void Visible(){
        frame.setVisible(true);
    }
}
