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
    private JLabel subLable;
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
//        model = new DefaultTableModel(data, columns);
        final JTable[] table1 = {new JTable(model)};
        table1[0].setModel(model);
        scrollPane = new JScrollPane(table1[0]);
//        add(scrollPane);

        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                String header[] = {"제목", "시간", "조회수", "추천수"};
                String contents[][] = {{"어쩌고", "13:24", "32", "3"}, {"윈도우즈프로그래밍", "3", "박현주"}};
                table1[0] = new JTable(contents, header);
            }
        });
        frame.setVisible(true);
    }



    public void Visible() {
//        subLable.setText("반갑습니다! " + mainProcess.User.ID + "님.");
        frame.setVisible(true);

//    ActionListener al = new ActionListener(){
//        public void actionPerformed(ActionEvent e){
//            model = (DefaultTableModel) table1.getModel();
//            Connection con = null;
//            PreparedStatement pstmt = null;
//            ResultSet rs = null;
//            //String[] row = ;
//
//        }
//    }

//    public static JTable createTable(){
//        String[] columnNames = {"제목", "시간", "조회수", "추천수"};
//        Object[][] data = {{}};
//        JTable table1 = new JTable(data, columnNames);
//        table1.setFillsViewportHeight(true);
//
//        return table1;
//    }

//    public void writeBtn(){
//        DefaultTableModel model = (DefaultTableModel)table1.getModel();
//        String []write = new String[4];
//        for(int i = 0; i < 4; i++){
//            if(isInvalidInput(fields[i].getText())){
//                System.out.println("Invalid Input");
//                return;
//            }
//            write[i]=fields[i].getText();
//        }
//        model.addRow(record);
//
//        //모든 TextField 비우기
//        for(int i = 0; i < 4; i++)
//            fields[i].setText("");
//
//        fields[0].requestFocus();
//    }
    }
}