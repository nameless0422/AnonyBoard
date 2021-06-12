package Model;

public class BoardModel {
    private int idx;
    public String ClassName;
    public int Class;
    public String Prof_Name;

    public BoardModel(String CN, int C, String PF){
        Class = C;
        ClassName = CN;
        Prof_Name = PF;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getIdx() {
        return idx;
    }
}
