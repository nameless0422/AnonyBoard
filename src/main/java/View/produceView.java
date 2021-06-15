package View;

import Classes.DBConnecter;
import Controler.MainProcess;
import Model.BoardModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class produceView {
    private JPanel panel1;
    private JButton Button1;
    private JScrollPane s1;
    private JScrollPane s2;
    private JScrollPane s3;

    private MainProcess mainProcess;
    private JFrame frame;

    public produceView(MainProcess p) {
        mainProcess = p;
        frame = new JFrame();
        String menu1[] = {"자바","윈프","이산수학"};
        String menu3[] = {"양재동","박현주","이횽태"};
        String menu2[] = {"1","2","3"};
        frame.setContentPane(panel1);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        JComboBox comboBox1 = createBox(menu1);
        JComboBox comboBox2 = createBox(menu2);
        JComboBox comboBox3 = createBox(menu3);
        s1.setViewportView(comboBox1);
        s2.setViewportView(comboBox2);
        s3.setViewportView(comboBox3);
        Button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BoardModel bm = new BoardModel(comboBox1.getSelectedItem().toString(),comboBox2.getSelectedIndex()+1, comboBox3.getSelectedItem().toString());
                bm = DBConnecter.AddNewBoard(bm);
                mainProcess.ProduceView.frame.setVisible(false);
                mainProcess.BoardlistView.setTable1(boardlistView.createTable(0));
                mainProcess.BoardlistView.getTablescroll().setViewportView(mainProcess.BoardlistView.getTable1());
                mainProcess.BoardlistView.getTable1().getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                    public void valueChanged(ListSelectionEvent event) {
                        // do some actions here, for example
                        // print first column value from selected row
                        mainProcess.BoardlistView.getFrame().setVisible(false);
                        mainProcess.InBoardlistView.Visible();
                    }
                });
                mainProcess.BoardlistView.Visible();
            }
        });

    }
    public static JComboBox createBox(String a[]) {
        JComboBox Box1 = new JComboBox(a);
        return Box1;
    }
    public void Visible(){
        frame.setVisible(true);
    }
}
