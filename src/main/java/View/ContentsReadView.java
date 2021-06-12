package View;

import Controler.MainProcess;
import Model.ContentsModel;

import javax.swing.*;

public class ContentsReadView {

    private ContentsModel model;

    private MainProcess mainProcess;
    private JTextArea textArea1;
    private JPanel MainPanel;
    private JButton addCommentButton;
    private JTextField textField1;
    private JButton xButton;
    private JButton editButton;
    private JTable table1;
    private JLabel TitleLabel;
    private JFrame frame;

    public void ContentsReadView(MainProcess p){
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

    public void Visivle(){
        frame.setVisible(true);
    }
}
