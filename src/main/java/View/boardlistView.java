package View;

import Controler.MainProcess;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class boardlistView {


    private JButton Button1;
    private MainProcess mainProcess;
    private JPanel panel;
    private JLabel hiLabel;
    private JLabel makeLabel;
    private JScrollPane tablescroll;
    private JFrame frame;

    public boardlistView(MainProcess p) {
        mainProcess = p;
        frame = new JFrame();
        frame.setContentPane(panel);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        JTable table1 = createTable();
        tablescroll.setViewportView(table1);
        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                mainProcess.BoardlistView.frame.setVisible(false);
                mainProcess.InBoardlistView.Visible();
            }
        });
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainProcess.produceView.Visible();
            }
        });
    }
    public static JTable createTable() {
        String[] columnNames = {"강의명", "분반" ,"교수명"};
        Object[][] data = {{"자바", "3","양재동" },{"윈프", "2", "박현주"}};
        JTable table1 = new JTable(data, columnNames);
        table1.setFillsViewportHeight(true);

        return table1;
    }
    public void Visible(){
        hiLabel.setText("반갑습니다! " + mainProcess.User.ID + "님.");
        frame.setVisible(true);
    }
}
