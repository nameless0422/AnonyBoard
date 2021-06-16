package View;

import Classes.DBConnecter;
import Controler.MainProcess;
import Model.BoardModel;
import Model.ContentsModel;
import Model.ReplyModel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ContentsWriteView {

    private ContentsModel model;

    private JPanel MainPanel;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton saveButton;
    private JButton addFileButton;
    private MainProcess mainProcess;
    private JFrame frame;
    private JFileChooser jfc;
    private int idx;

    public ContentsWriteView(MainProcess p){
        mainProcess = p;

        frame = new JFrame();
        frame.setContentPane(MainPanel);
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.pack();

        jfc = new JFileChooser();

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    model = new ContentsModel();
                    if (textField1.getText().equals("") || textArea1.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "내용이 입력되지 않았습니다.", "오류!", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    model.Title = textField1.getText();
                    model.Content = textArea1.getText();
                    model.User_ID = mainProcess.User.USER_ID;
                    model.Password = mainProcess.User.PASSWORD;
                    model.Board_ID = mainProcess.InBoardlistView.getBoardidx();
                    model = DBConnecter.AddNewContent(model);
                    frame.setVisible(false);
                    mainProcess.InBoardlistView.InVisivle();
                    InBoardListView.setBoardidx(mainProcess.BoardlistView.classidx());
                    int a = mainProcess.InBoardlistView.conidx();
                    mainProcess.InBoardlistView = new InBoardListView(mainProcess);
                    mainProcess.contentsReadView = new ContentsReadView(mainProcess);
                    mainProcess.contentsReadView.setIdx(a);
                    mainProcess.InBoardlistView.Visible();
            }
        });
    }

    public void setModel(ContentsModel model) {
        this.model = model;
    }

    public ContentsModel getModel() {
        return model;
    }


    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void Visivle(){
        frame.setVisible(true);
    }
}
