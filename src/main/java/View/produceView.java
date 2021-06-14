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
    public void Visible(){
        frame.setVisible(true);
    }
}
