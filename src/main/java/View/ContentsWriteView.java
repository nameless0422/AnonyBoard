package View;

import Controler.MainProcess;
import Model.BoardModel;
import Model.ContentsModel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;

public class ContentsWriteView {

    private ContentsModel model;

    private JPanel MainPanel;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton saveButton;
    private JList list1;
    private JButton addFileButton;
    private MainProcess mainProcess;
    private JFrame frame;
    private JFileChooser jfc;

    public ContentsWriteView(MainProcess p){
        mainProcess = p;

        frame = new JFrame();
        frame.setContentPane(MainPanel);
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        jfc = new JFileChooser();

        addFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG & GIF Images", // 파일 이름에 창에 출력될 문자열
                        "jpg", "gif"); // 파일 필터로 사용되는 확장자. *.jpg. *.gif만 나열됨
                jfc.setFileFilter(filter);

                int ret = jfc.showOpenDialog(null);
                if(ret != JFileChooser.APPROVE_OPTION) { // 사용자가  창을 강제로 닫았거나 취소 버튼을 누른 경우
                    JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다", "경고",

                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // 사용자가 파일을 선택하고 "열기" 버튼을 누른 경우
                String filePath = jfc.getSelectedFile().getPath(); // 파일 경로명을 알아온다.

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
                Date date_now = new Date(System.currentTimeMillis());
                SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

                    try {
                        // db에 쿼리 쏘기
                        String sql = "INSERT INTO post (USER_ID,PASSWORD,TITLE,CONTENT,TIME,VIEWS,LIKES) VALUES ("
                                + "'" + model.User_ID + "',"
                                + "'" + model.Password + "',"
                                + "'" + model.Title + "',"
                                + "'" + model.Content + "',"
                                + "'" + model.Time + "',"
                                + model.Views + ","
                                + model.Likes + ")";
                        PreparedStatement pstmt = con.prepareStatement(sql);
                        int r = pstmt.executeUpdate();
                        System.out.println("변경된 row : " + r);

                        pstmt.close();
                    }catch (Exception ex){
                        System.out.println("오류 내역\n"+ex);
                        con.close();
                        session.disconnect();
                    }
                    con.close();
                    session.disconnect();
                }catch (Exception ex){
                    System.out.println("오류 내역\n"+ex);
                }
                frame.setVisible(false);
            }
        });
    }

    public void setModel(ContentsModel model) {
        this.model = model;
    }

    public ContentsModel getModel() {
        return model;
    }

    public void Visivle(){
        frame.setVisible(true);
    }
}
