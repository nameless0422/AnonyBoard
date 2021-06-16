package Controler;
import Model.UserModel;
import View.*;

import com.formdev.flatlaf.FlatIntelliJLaf;

public class MainProcess {
    public static LoginView loginView;
    public static ContentsWriteView contentsWriteView;
    public static produceView ProduceView;
    public static boardlistView BoardlistView;
    public static InBoardListView InBoardlistView;
    public static UserModel User;
    public static ContentsReadView contentsReadView;
    public boolean isEdit = false;

    public static void main(String[] args) {
        FlatIntelliJLaf.install();
        MainProcess mainProcess = new MainProcess();
        loginView = new LoginView(mainProcess);
        BoardlistView = new boardlistView(mainProcess);
        ProduceView = new produceView(mainProcess);
        loginView.Visible();
    }
}