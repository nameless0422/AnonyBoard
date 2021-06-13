package Controler;
import Model.UserModel;
import View.ContentsWriteView;
import View.LoginView;

import View.boardlistView;
import View.produceView;
import com.formdev.flatlaf.FlatIntelliJLaf;

public class MainProcess {
    public static LoginView loginView;
    public static ContentsWriteView contentsWriteView;
    public static produceView ProduceView;
    public static boardlistView BoardlistView;
    public static UserModel User;
    public static void main(String[] args) {
        FlatIntelliJLaf.install();
        MainProcess mainProcess = new MainProcess();
        loginView = new LoginView(mainProcess);
        contentsWriteView = new ContentsWriteView(mainProcess);
        BoardlistView = new boardlistView(mainProcess);
        ProduceView = new produceView(mainProcess);
        BoardlistView.Visible();
        loginView.Visivle();
        ProduceView.Visible();
    }
}
