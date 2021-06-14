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
    public static void main(String[] args) {
        FlatIntelliJLaf.install();
        MainProcess mainProcess = new MainProcess();
        loginView = new LoginView(mainProcess);
        contentsWriteView = new ContentsWriteView(mainProcess);
        BoardlistView = new boardlistView(mainProcess);
        InBoardlistView = new InBoardListView(mainProcess);
        ProduceView = new produceView(mainProcess);
        BoardlistView.Visible();
        InBoardlistView.Visible();
        loginView.Visivle();
        ProduceView.Visible();
    }
}
