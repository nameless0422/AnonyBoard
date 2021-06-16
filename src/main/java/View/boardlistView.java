package View;

import Classes.DBConnecter;
import Controler.MainProcess;
import Model.BoardModel;
import Model.ContentsModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;

public class boardlistView {
    private JFrame frame;
    private JButton Button1;
    private MainProcess mainProcess;
    private JPanel panel;
    private JLabel hiLabel;
    private JLabel makeLabel;
    private JScrollPane tablescroll;
    private static JTable table1;

    public boardlistView(MainProcess p) {
        mainProcess = p;
        frame = new JFrame();
        frame.setContentPane(panel);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        table1 = createTable();
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(InBoardListView.prname().equals("김노윤")){
                    JOptionPane.showMessageDialog(null, "김노윤은 교수가 아닙니다!", "오류!", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    InBoardListView.setBoardidx(classidx());
                    mainProcess.InBoardlistView = new InBoardListView(mainProcess);
                    mainProcess.InBoardlistView.Visible();
                }
            }
        });
        tablescroll.setViewportView(table1);
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainProcess.ProduceView.Visible();
            }
        });
    }
    public static int classidx(){
        JTable table = boardlistView.getTable1();
        List<BoardModel> list = DBConnecter.getBoardList();
        int i = table.getSelectedRow();
        BoardModel model = list.get(i);
        return model.getIdx();
    }
    public static JTable createTable() {
        String[] columnNames = {"강의명", "분반" , "교수명"};
        List<BoardModel> list = DBConnecter.getBoardList();
        Object[][] data = new Object[20][20];
        for(int i = 0;i< list.size();i++) {
            BoardModel model = list.get(i);
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    data[i][j] = model.ClassName;
                } else if (j == 1) {
                    data[i][j] = model.Class;
                } else {
                    data[i][j] = model.Prof_Name;
                }
            }
        }
        JTable table1 = new JTable(data,columnNames);
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public static JTable getTable1() {
        return table1;
    }

    public JScrollPane getTablescroll() {
        return tablescroll;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void Visible(){
        hiLabel.setText("반갑습니다! " + mainProcess.User.ID + "님.");
        frame.setVisible(true);
    }
}
