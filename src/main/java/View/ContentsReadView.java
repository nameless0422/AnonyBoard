package View;

import Classes.DBConnecter;
import Controler.MainProcess;
import Model.BoardModel;
import Model.ContentsModel;
import Model.ReplyModel;

import javax.swing.*;
import java.util.ArrayList;

public class ContentsReadView {

    private ContentsModel model;

    private MainProcess mainProcess;
    private JTextArea textArea1;
    private JPanel MainPanel;
    private JButton addCommentButton;
    private JTextField textField1;
    private JButton xButton;
    private JButton editButton;
    private JLabel TitleLabel;
    private JButton RecommandButton;
    private JScrollPane ScrollReply;
    private int idx;
    private JFrame frame;
    private JTable table1;

    public ContentsReadView(MainProcess p){
        mainProcess = p;
        frame = new JFrame();
        frame.setContentPane(MainPanel);
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();

        editButton.setIcon(new ImageIcon("/resources/092-edit 1.png"));
    }

    public ContentsModel getModel() {
        return model;
    }

    public void setModel(ContentsModel model) {
        this.model = model;
    }

    public void update(){
        TitleLabel.setText(this.model.Title);
        textArea1.setText(this.model.Content);
        table1 = createTable();
        ScrollReply.setViewportView(table1);
    }

    public void update_model(){
        this.model = DBConnecter.getContetent(idx);
        this.model.replys = (ArrayList<ReplyModel>) DBConnecter.getReplyList(idx);
        update();
    }

    public JTable createTable(){
        Object[][] listdata = new Object[model.replys.size()][2];
        Object columnNames[] = {"content","time"};
        for(int i = 0;i< model.replys.size();i++) {
            ReplyModel replymodel = model.replys.get(i);
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    listdata[i][j] = replymodel.Content;
                } else if (j == 1) {
                    listdata[i][j] = replymodel.Time;
                }
            }
        }
            JTable table1 = new JTable(listdata,columnNames);
            table1.setTableHeader(null);
            return table1;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
        update_model();
    }

    public void Visivle(){
        frame.setVisible(true);
    }
}
