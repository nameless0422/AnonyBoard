package View;

import Controler.MainProcess;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import Controler.MainProcess;
import Model.UserModel;
import com.jcraft.jsch.*;


public class boardlistView {


    private JButton Button1;
    private JTable table1;
    private MainProcess mainProcess;
    private JPanel panel;
    private JLabel hiLabel;
    private JLabel makeLabel;
    private JFrame frame;

    public boardlistView(MainProcess p) {
        mainProcess = p;
        frame = new JFrame();
        frame.setContentPane(panel);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        String header[] = {"강의명","분반","교수명"};
        String contents[][] = {{"Java프로그래밍","3","양재동"},{"윈도우즈프로그래밍","3","박현주"}};
        table1 = new JTable(contents, header);

        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void Visible(){
        frame.setVisible(true);
    }
}
