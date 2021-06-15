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
    private JFrame frame1;
    private JButton Button1;
    private MainProcess mainProcess;
    private JPanel panel;
    private JLabel subLabel;
    private JLabel makeLabel;
    private JScrollPane scrollPane;
    private static JTable table1;

    public InBoardListView(MainProcess p) {
        mainProcess = p;
        frame1 = new JFrame();
        frame1.setContentPane(panel);
        frame1.setSize(585, 415);
        frame1.setResizable(false);
        frame1.pack();
        table1 = createTable();
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainProcess.contentsReadView.Visivle();
            }
        });
        scrollPane.setViewportView(table1);
        Button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainProcess.contentsWriteView.Visivle();
            }
        });
    }
    public static String classname(){
        JTable table = boardlistView.getTable1();
        List<BoardModel> list = DBConnecter.getBoardList();
        int i = table.getSelectedRow();
        BoardModel model = list.get(i);
        return model.ClassName;
    }
    public static int classnum(){
        JTable table = boardlistView.getTable1();
        List<BoardModel> list = DBConnecter.getBoardList();
        int i = table.getSelectedRow();
        BoardModel model = list.get(i);
        return model.Class;
    }
    public static String prname(){
        JTable table = boardlistView.getTable1();
        List<BoardModel> list = DBConnecter.getBoardList();
        int i = table.getSelectedRow();
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
        subLabel.setText(classname()+"   "+classnum()+"분반   "+prname()+"교수님");
        frame1.setVisible(true);
    }
}