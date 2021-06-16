package Model;

import java.util.ArrayList;

public class ContentsModel {
    private int idx;
    public int User_ID;
    public int Board_ID;
    public String Password;
    public String Title;
    public String Content;
    public String Time;
    public int Views;
    public int Likes;
    public ArrayList<ReplyModel> replys;

    public ContentsModel(int UID, int BID, String PW, String TT, String C, String TM, int V, int L){
        User_ID = UID;
        Board_ID = BID;
        Password = PW;
        Title = TT;
        Content = C;
        Time = TM;
        Views = V;
        Likes = L;
    }

    public ContentsModel(){
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getIdx() {
        return idx;
    }
}
