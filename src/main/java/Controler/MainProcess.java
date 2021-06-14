package Controler;
import Model.UserModel;
import View.*;

import com.formdev.flatlaf.FlatIntelliJLaf;

public class MainProcess {
    public static LoginView loginView;
    public static ContentsWriteView contentsWriteView;
    public static produceView produceView;
    public static boardlistView BoardlistView;
    public static InBoardlistView InBoardlistView;
    public static UserModel User;

    public static void main(String[] args) {
        FlatIntelliJLaf.install();
        MainProcess mainProcess = new MainProcess();
        loginView = new LoginView(mainProcess);
        contentsWriteView = new ContentsWriteView(mainProcess);
        BoardlistView = new boardlistView(mainProcess);
        InBoardlistView = new InBoardlistView(mainProcess);
        produceView = new produceView(mainProcess);
        loginView.Visivle();
    }
}
