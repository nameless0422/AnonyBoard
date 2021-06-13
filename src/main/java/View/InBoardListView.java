package View;

import Controler.MainProcess;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InBoardListView {
    private JScrollPane scrollPane;
    private JPanel IBL;
    private JLabel infor;
    private MainProcess mainProcess;
    private JFrame frame;
    private JPanel panel;
    private JButton Button1;
    private JLabel hiLabel;
    private JLabel makeLabel;
    private JTable table1;

    public InBoardListView(MainProcess p){
        mainProcess = p;
        frame = new JFrame();
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[][] content = new String[20][4];
        String header[] = {"제목", "시간", "조회수", "추천수"};
//        frame.add(scrollPane);
//        frame.pack();
//        frame.setResizable(false);
//        frame.setVisible(true);

        //table = new JTable(content, header);
        //scrollPane = new JScrollBar(table);
        //add(scrollPane);
    }

    public void writeBtn(){
//        DefaultTableModel model = (DefaultTableModel)table.getModel();
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
    }

    public void Visible(){
        frame.setVisible(true);
    }
}