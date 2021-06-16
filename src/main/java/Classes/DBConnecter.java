package Classes;

import Model.BoardModel;
import Model.ContentsModel;
import Model.ReplyModel;
import Model.UserModel;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import javax.management.modelmbean.ModelMBean;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnecter {

    public static List<BoardModel> getBoardList(){
        ArrayList<BoardModel> list = new ArrayList<BoardModel>();
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
            String sql = "SELECT * FROM board";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                BoardModel model = new BoardModel(
                        rs.getString("CLASS_NAME"),
                        rs.getInt("CLASS"),
                        rs.getString("PROF_NAME"));
                model.setIdx(rs.getInt("idx"));
                list.add(model);
            }
            stmt.close();
            rs.close();
            con.close();
            session.disconnect();
        }catch (Exception ex){
            System.out.println("오류 내역\n"+ex);
        }

        return list;
    }

    public static BoardModel AddNewBoard(BoardModel model){
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
            String sql = "INSERT into board(CLASS_NAME,CLASS,PROF_NAME) values (?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,model.ClassName);
            pstmt.setString(2,Integer.toString(model.Class));
            pstmt.setString(3, model.Prof_Name);

            int r = pstmt.executeUpdate();
            System.out.println("변경된 row : " + r);

            sql = "SELECT * FROM board WHERE CLASS_NAME='" + model.ClassName + "' AND CLASS=" + model.Class + " AND PROF_NAME='" + model.Prof_Name + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                model.setIdx(rs.getInt("idx"));
            }
            stmt.close();
            pstmt.close();
            con.close();
            session.disconnect();
        }catch (Exception ex){
            System.out.println("오류 내역\n"+ex);
        }
        return model;
    }

    public static List<ContentsModel> getContentList(int boardIDX){
        ArrayList<ContentsModel> list = new ArrayList<ContentsModel>();
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
            String sql = "SELECT * FROM post WHERE BOARD_IDX=" + boardIDX;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                ContentsModel model = new ContentsModel(
                        rs.getInt("USER_ID"),
                        rs.getInt("BOARD_IDX"),
                        rs.getString("PASSWORD"),
                        rs.getString("TITLE"),
                        rs.getString("CONTENT"),
                        rs.getString("TIME"),
                        rs.getInt("VIEWS"),
                        rs.getInt("LIKES"));
                model.setIdx(rs.getInt("idx"));
                list.add(model);
            }
            stmt.close();
            rs.close();
            con.close();
            session.disconnect();
        }catch (Exception ex){
            System.out.println("오류 내역\n"+ex);
        }
        return list;
    }

    public static ContentsModel AddNewContent(ContentsModel model){

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
            String sql = "INSERT into post(BOARD_IDX,USER_ID,PASSWORD,TITLE,CONTENT,TIME,VIEWS,LIKES) values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, Integer.toString(model.Board_ID) );
            pstmt.setString(2, Integer.toString(model.User_ID));
            pstmt.setString(3, model.Password);
            pstmt.setString(4, model.Title);
            pstmt.setString(5, model.Content);
            pstmt.setString(6, model.Time);
            pstmt.setString(7, Integer.toString(model.Views));
            pstmt.setString(8, Integer.toString(model.Likes));

            int r = pstmt.executeUpdate();
            System.out.println("변경된 row : " + r);
            pstmt.close();

            sql = "SELECT * FROM post WHERE USER_ID="
                    + model.User_ID
                    +" AND PASSWORD='"
                    + model.Password
                    + "' AND TITLE='"
                    + model.Title
                    +"' AND TIME='"
                    + model.Time
                    + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                model.setIdx(rs.getInt("idx"));
            }
            stmt.close();
            rs.close();
            con.close();
            session.disconnect();
        }catch (Exception ex){
            System.out.println("오류 내역\n"+ex);
        }

        return model;
    }

    public static void DeleteContent(int conIDX, UserModel U){
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
            String sql = "DELETE TABLE post WHERE idx=" + conIDX +" AND USER_ID=" + U.USER_ID + " AND PASSWORD='" + U.PASSWORD + "'";
            PreparedStatement pstmt = con.prepareStatement(sql);
            int r = pstmt.executeUpdate();
            System.out.println("변경된 row : " + r);
            pstmt.close();

            con.close();
            session.disconnect();
        }catch (Exception ex){
            System.out.println("오류 내역\n"+ex);
        }
    }

    public static ContentsModel UpdateContent(ContentsModel model){
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
            String sql = "UPDATE post SET TITLE=?, CONTENT=?, TIME=?, VIEWS=?, LIKES=? WHERE idx=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, model.Title);
            pstmt.setString(2, model.Content);
            pstmt.setString(3, model.Time);
            pstmt.setString(4, Integer.toString(model.Views));
            pstmt.setString(5, Integer.toString(model.Likes));
            pstmt.setString(6, Integer.toString(model.getIdx()));

            int r = pstmt.executeUpdate();
            System.out.println("변경된 row : " + r);
            pstmt.close();
            con.close();
            session.disconnect();
        }catch (Exception ex){
            System.out.println("오류 내역\n"+ex);
        }

        return model;
    }

    public static ContentsModel getContetent(int idx){
        ContentsModel model = new ContentsModel();
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
            String sql = "SELECT * FROM post WHERE BOARD_IDX=" + idx;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                model.setIdx(rs.getInt("idx"));
                model.Time = rs.getString("TIME");
                model.Title = rs.getString("TITLE");
                model.Password = rs.getString("PASSWORD");
                model.User_ID = rs.getInt("USER_ID");
                model.Likes = rs.getInt("LIKES");
                model.Content = rs.getString("CONTENT");
                model.Views = rs.getInt("VIEWS");
            }
            rs.close();
            con.close();
            session.disconnect();
        }catch (Exception ex){
            System.out.println("오류 내역\n"+ex);
        }

        return model;
    }

    public static void AddViews(int conIDX){
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
            int View = 0;
            // db에 쿼리 쏘기
            String sql = "SELECT * FROM post WHERE idx=" + conIDX;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                View = rs.getInt("VIEWS");
            }
            View = View + 1;
            stmt.close();
            sql = "UPDATE post SET VIEWS=? WHERE idx=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, Integer.toString(View));
            pstmt.setString(2, Integer.toString(conIDX));
            int r = pstmt.executeUpdate();
            System.out.println("변경된 row : " + r);
            pstmt.close();
            con.close();
            session.disconnect();
        }catch (Exception ex){
            System.out.println("오류 내역\n"+ex);
        }
    }

    public static void AddLikes(int conIDX){
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
            int Like = 0;
            // db에 쿼리 쏘기
            String sql = "SELECT * FROM post WHERE idx=" + conIDX;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Like = rs.getInt("VIEWS");
            }
            Like = Like + 1;
            stmt.close();
            sql = "UPDATE post SET LIKES=? WHERE idx=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, Integer.toString(Like));
            pstmt.setString(2, Integer.toString(conIDX));
            int r = pstmt.executeUpdate();
            System.out.println("변경된 row : " + r);
            pstmt.close();
            con.close();

            session.disconnect();
        }catch (Exception ex){
            System.out.println("오류 내역\n"+ex);
        }
    }

    public static List<ReplyModel> getReplyList(int conIDX){
        ArrayList<ReplyModel> list = new ArrayList<ReplyModel>();
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
            String sql = "SELECT *  FROM reply WHERE CON_NUM=" + conIDX;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                ReplyModel model = new ReplyModel(
                        rs.getInt("CON_NUM"),
                        rs.getInt("USER_ID"),
                        rs.getString("PASSWORD"),
                        rs.getString("CONTENT"),
                        rs.getString("TIME")
                );
                model.setIdx(rs.getInt("idx"));
                list.add(model);
            }
            stmt.close();
            rs.close();
            con.close();
            session.disconnect();
        }catch (Exception ex){
            System.out.println("오류 내역\n"+ex);
        }
        return list;
    }

    public static ReplyModel AddNewReply(ReplyModel model){
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
            String sql = "INSERT into reply(CON_NUM,USER_ID,PASSWORD,CONTENT,TIME) values (?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, Integer.toString(model.Con_Num));
            pstmt.setString(2, Integer.toString(model.User_ID));
            pstmt.setString(3, model.Password);
            pstmt.setString(4, model.Content);
            pstmt.setString(5, model.Time);

            int r = pstmt.executeUpdate();
            System.out.println("변경된 row : " + r);
            pstmt.close();

            sql = "SELECT * FROM reply WHERE CON_NUM="
                    + model.Con_Num
                    + " AND USER_ID="
                    + model.User_ID
                    + " AND TIME='"
                    + model.Time
                    + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                model.setIdx(rs.getInt("idx"));
            }
            stmt.close();
            rs.close();
            con.close();
            session.disconnect();
        }catch (Exception ex){
            System.out.println("오류 내역\n"+ex);
        }

        return model;
    }

    public static void DeleteReply(int reIDX, UserModel U){
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
            String sql = "DELETE TABLE reply WHERE idx=" + reIDX +" AND USER_ID=" + U.USER_ID + " AND PASSWORD='" + U.PASSWORD + "'";
            PreparedStatement pstmt = con.prepareStatement(sql);
            int r = pstmt.executeUpdate();
            System.out.println("변경된 row : " + r);
            pstmt.close();

            con.close();
            session.disconnect();
        }catch (Exception ex){
            System.out.println("오류 내역\n"+ex);
        }
    }
}
