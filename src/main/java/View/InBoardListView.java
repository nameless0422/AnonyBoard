package View;

import Controler.MainProcess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class InBoardListView {
    DefaultTableModel model;
    private MainProcess mainProcess;
    private JScrollPane scrollPane;
    private JPanel IBL;
    private JLabel infor;
    private JFrame frame;
    private JPanel panel1;
    private JPanel panel;
    private JButton Button1;
    private JLabel subLabel;
    private JLabel makeLabel;
    private JTable table1;

    public InBoardListView(MainProcess p) {
        mainProcess = p;
        frame = new JFrame();
        frame.setSize(585, 415);
        frame.setContentPane(panel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scrollPane = new JScrollPane(table1);
        frame.pack();
        final JTable[] table1 = {new JTable(model)};
        table1[0].setModel(model);
        scrollPane = new JScrollPane(table1[0]);

        frame.setVisible(true);
    }

    public static JTable createTable(){
        String[] columnNames = {"제목", "시간", "조회수", "추천수"};
        Object[][] data = {{}};
        JTable table1 = new JTable(data, columnNames);
        table1.setFillsViewportHeight(true);

        return table1;
    }

    public void Visible() {
        frame.setVisible(true);
    }
}