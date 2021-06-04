package View;

import Controler.MainProcess;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ContentsWriteView {
    private JPanel MainPanel;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton saveButton;
    private JList list1;
    private JButton addFileButton;
    private MainProcess mainProcess;
    private JFrame frame;
    public ContentsWriteView(MainProcess p){
        mainProcess = p;

        frame = new JFrame();
        frame.setContentPane(MainPanel);
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        addFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                try {
                    // ssh 터널링
                    JSch jsch = new JSch();
                    Session session = jsch.getSession("root", "106.10.57.242", 5000);
                    session.setPassword("qawzsx351");
                    session.setConfig("StrictHostKeyChecking","no");
                    session.connect();

                    // 포트포워딩
                    int assinged_port = session.setPortForwardingL(8001,"localhost",3306);
                    System.out.println("localhost:"+assinged_port+" -> "+3306+":"+8001);
                    Connection con = null;
                    String driver = "org.mariadb.jdbc.Driver";
                    Class.forName(driver);
                    con = DriverManager.getConnection("jdbc:mariadb://localhost:8001/anonyBoard",
                            "root",
                            "qawzsx351");
                    System.out.println("db접속 성공");
                    if(con != null){
                    }

                    // db에 쿼리 쏘기
                    String sql = "";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);

                    while(rs.next()) {
                    }

                    stmt.close();
                    con.close();
                }catch (Exception ex){
                    System.out.println("오류 내역\n"+ex);
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // ssh 터널링
                    JSch jsch = new JSch();
                    Session session = jsch.getSession("root", "106.10.57.242", 5000);
                    session.setPassword("qawzsx351");
                    session.setConfig("StrictHostKeyChecking","no");
                    session.connect();

                    // 포트포워딩
                    int assinged_port = session.setPortForwardingL(8001,"localhost",3306);
                    System.out.println("localhost:"+assinged_port+" -> "+3306+":"+8001);
                    Connection con = null;
                    String driver = "org.mariadb.jdbc.Driver";
                    Class.forName(driver);
                    con = DriverManager.getConnection("jdbc:mariadb://localhost:8001/anonyBoard",
                                                     "root",
                                                  "qawzsx351");
                    System.out.println("db접속 성공");
                    if(con != null){
                    }

                    // db에 쿼리 쏘기
                    String sql = "";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);

                    while(rs.next()) {
                    }

                    stmt.close();
                    con.close();
                }catch (Exception ex){
                    System.out.println("오류 내역\n"+ex);
                }
            }
        });
    }
    public void Visivle(){
        frame.setVisible(true);
    }
}
