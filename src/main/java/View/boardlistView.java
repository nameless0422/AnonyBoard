package View;

import Classes.DBConnecter;
import Controler.MainProcess;
import Model.BoardModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


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
        JTable table1 = createTable(0);
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
                mainProcess.ProduceView.Visible();
            }
        });
    }
    public static JTable createTable(int k) {
        String[] columnNames = {"강의명", "분반" ,"교수명"};
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

    public void Visible(){
        hiLabel.setText("반갑습니다! " + mainProcess.User.ID + "님.");
        frame.setVisible(true);
    }
}
