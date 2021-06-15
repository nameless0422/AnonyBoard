package View;

import Classes.DBConnecter;
import Controler.MainProcess;
import Model.BoardModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
    public static String classname(){
        JTable table = boardlistView.getTable1();
        List<BoardModel> list = DBConnecter.getBoardList();
        int i = table.getSelectedColumn();
        BoardModel model = list.get(i);
        return model.ClassName;
    }
    public static int classnum(){
        JTable table = boardlistView.getTable1();
        List<BoardModel> list = DBConnecter.getBoardList();
        int i = table.getSelectedColumn();
        BoardModel model = list.get(i);
        return model.Class;
    }
    public static String prname(){
        JTable table = boardlistView.getTable1();
        List<BoardModel> list = DBConnecter.getBoardList();
        int i = table.getSelectedColumn();
        BoardModel model = list.get(i);
        return model.Prof_Name;
    }
    public static JTable createTable(){
        String[] columnNames = {"제목", "시간", "조회수", "추천수"};
        Object[][] data = {{"어쩌고","13:12","21","3"},{"저쩌고","15:23","5","1"}};
        JTable table1 = new JTable(data, columnNames);
        table1.setFillsViewportHeight(true);

        return table1;
    }

    public void Visible() {
        subLabel.setText(classname()+classnum()+prname());
        frame1.setVisible(true);
    }
}