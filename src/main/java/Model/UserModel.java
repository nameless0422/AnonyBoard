package Model;

public class UserModel {
    public int USER_ID;
    public String ID;
    public String PASSWORD;
    public UserModel(String id, String password){
        ID = id;
        PASSWORD = password;
    }
    public void setUSER_ID(int idx){
        USER_ID = idx;
    }

}
