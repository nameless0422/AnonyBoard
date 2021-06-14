package Model;

public class ReplyModel {

    private int idx;
    public int Con_Num;
    public int User_ID;
    public String Password;
    public String Content;
    public String Time;

    public ReplyModel(int CN, int UID, String P, String C, String T){
        Con_Num = CN;
        User_ID = UID;
        Password = P;
        Content = C;
        Time = T;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getIdx() {
        return idx;
    }
}
