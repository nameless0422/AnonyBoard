package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import Controler.MainProcess;
import Model.UserModel;
import com.jcraft.jsch.*;
import com.sun.tools.javac.Main;


public class LoginView {

    private MainProcess mainProcess;
    private JPanel login;
    private JButton loginButton;
    private JButton regsterButton;
    private JTextField ID_TEXTFIELD;
    private JPasswordField PSWD_TEXTFIELD;
    private JLabel logoLabel;
    private JFrame frame;

    private ImageIcon icon;

    public LoginView(MainProcess p){
        mainProcess = p;
        frame = new JFrame();
        icon = new ImageIcon(this.getClass().getResource("/캡처.png"));
        Image img = icon.getImage();
        img = img.getScaledInstance(800,430,Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        logoLabel.setIcon(icon);
        frame.setContentPane(login);
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();


        // 회원가입 기능 구현
        regsterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String pw = "";
                char[] pw_ = PSWD_TEXTFIELD.getPassword();
                for(char cha: pw_){
                    Character.toString(cha);
                    pw+= (pw.equals("")) ? ""+cha+"" : ""+cha+"";
                }

                UserModel user = new UserModel(ID_TEXTFIELD.getText(),Integer.toString(pw.hashCode() & 0x7fffffff));
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
                    String sql = "SELECT COUNT(*) FROM user WHERE ID='" + user.ID +"';";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);

                    // 아이디 중복 체크
                    while(rs.next()) {
                        if(rs.getInt("COUNT(*)")>0) {
                            JOptionPane.showMessageDialog(null, "중복되는 아이디 입니다.", "오류!", JOptionPane.ERROR_MESSAGE);
                            session.disconnect();
                            return;
                        }
                    }

                    // 유저정보 db에 전송
                    sql = "INSERT into user(ID,PASSWORD) values (?,?);";
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, user.ID);
                    pstmt.setString(2, user.PASSWORD);
                    int r = pstmt.executeUpdate();
                    System.out.println("변경된 row : " + r);

                    sql = "SELECT * FROM user WHERE ID='" + user.ID + "';";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(sql);
                    while (rs.next()){
                        user.USER_ID = rs.getInt("USER_ID");
                    }
                    pstmt.close();
                    stmt.close();
                    con.close();
                    session.disconnect();
                mainProcess.User = user;
                mainProcess.loginView.frame.setVisible(false);
                mainProcess.BoardlistView.Visible();
                }catch (Exception ex){
                    System.out.println("오류 내역\n"+ex);
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pw = "";
                char[] pw_ = PSWD_TEXTFIELD.getPassword();
                for(char cha: pw_){
                    Character.toString(cha);
                    pw+= (pw.equals("")) ? ""+cha+"" : ""+cha+"";
                }


                UserModel user = new UserModel(ID_TEXTFIELD.getText(),Integer.toString(pw.hashCode() & 0x7fffffff));

                try
                {
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
                    if(con != null){
                        System.out.println("db접속 성공");
                    }

                    // db에 쿼리 쏘기
                    String sql = "SELECT COUNT(*) FROM user WHERE ID='" + user.ID +"' AND PASSWORD='"+user.PASSWORD+"';";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);

                    while (rs.next()){
                        if(rs.getInt("COUNT(*)")<1) {
                            System.out.println(rs.getInt("COUNT(*)"));
                            JOptionPane.showMessageDialog(null, "ID가 존재하지 않거나 비밀번호 오류입니다.", "오류!", JOptionPane.ERROR_MESSAGE);
                            session.disconnect();
                            return;
                        }
                    }
                    stmt.close();
                    sql = "SELECT * FROM user WHERE ID='" + user.ID +"';";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(sql);
                    while(rs.next()) {
                        user.USER_ID = rs.getInt("USER_ID");
                    }
                    stmt.close();
                    con.close();
                    session.disconnect();
                    mainProcess.User = user;
                    mainProcess.loginView.frame.setVisible(false);
                    mainProcess.BoardlistView.Visible();
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
