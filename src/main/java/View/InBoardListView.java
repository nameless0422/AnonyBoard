package View;

import Classes.DBConnecter;
import Controler.MainProcess;
import Model.BoardModel;
import Model.ContentsModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private static int[] Boardidx = new int[1];
    private static ArrayList<ContentsModel> models;

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
                mainProcess.contentsReadView = new ContentsReadView(mainProcess);
                mainProcess.contentsReadView.setIdx(conidx());
                DBConnecter.AddViews(conidx());
                mainProcess.contentsReadView .Visible();

            }
        });
        scrollPane.setViewportView(table1);
        Button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainProcess.contentsWriteView = new ContentsWriteView(mainProcess);
                mainProcess.isEdit = true;
                mainProcess.contentsWriteView.Visible();
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
    public static int conidx(){
        JTable table = InBoardListView.getTable1();
        List<ContentsModel> list = DBConnecter.getContentList(Boardidx[0]);
        int i = table.getSelectedRow();
        ContentsModel model = list.get(i);
        return model.getIdx();
    }
    public static JTable createTable() {
        String[] columnNames = {"제목", "시간" ,"조회수","추천수"};
        List<ContentsModel> list = DBConnecter.getContentList(Boardidx[0]);
        Object[][] data = new Object[list.size()][5];
        for(int i = 0;i< list.size();i++) {
            ContentsModel model = list.get(i);
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    data[i][j] = model.Title;
                } else if (j == 1) {
                    data[i][j] = model.Time;
                } else if (j ==2 ){
                    data[i][j] =model.Views;
                }else{
                    data[i][j] = model.Likes;
                }

            }
        }
        JTable table1 = new JTable(data,columnNames);
        return table1;
    }
    public void Visible() {
        subLabel.setText(classname()+"   "+classnum()+"분반   "+prname()+"교수님");
        frame1.setVisible(true);
    }
    public void InVisivle(){
        frame1.setVisible(false);
    }

    public static JTable getTable1() {
        return table1;
    }

    public ArrayList<ContentsModel> getModel() {
        return models;
    }

    public void setModel(ArrayList<ContentsModel> models) {
        this.models = models;
    }

    public int getBoardidx() {
        return Boardidx[0];
    }

    public static void setBoardidx(int boardidx) {
        Boardidx[0] = boardidx;
    }
}