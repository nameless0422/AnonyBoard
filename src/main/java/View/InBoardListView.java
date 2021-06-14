package View;

import Controler.MainProcess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InBoardListView {
    public JComponent frame;
    private MainProcess mainProcess;
    private JButton Button1;
    private JPanel panel;
    private JLabel subLabel;
    private JLabel makeLabel;
    private JScrollPane scrollPane;
    private JFrame frame1;

    public InBoardListView(MainProcess p) {
        mainProcess = p;
        frame1 = new JFrame();
        frame1.setSize(585, 415);
        frame1.setContentPane(panel);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        JTable table1 = createTable();
        scrollPane.setViewportView(table1);

        Button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainProcess.contentsWriteView.Visivle();
                mainProcess.InBoardlistView.frame1.setVisible(false);
            }
        });
    }

    public static JTable createTable(){
        String[] columnNames = {"제목", "시간", "조회수", "추천수"};
        Object[][] data = {{"어쩌고","13:12","21","3"},{"저쩌고","15:23","5","1"}};
        JTable table1 = new JTable(data, columnNames);
        table1.setFillsViewportHeight(true);

        return table1;
    }

    public void Visible() {
//        subLabel.setText("" + mainProcess.User.ID + "님.");
        frame1.setVisible(true);
    }
}