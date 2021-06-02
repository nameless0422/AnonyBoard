package Controler;
import Model.UserModel;
import View.LoginView;

import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.*;

public class MainProcess {
    public static LoginView loginView;
    public static UserModel User;
    public static void main(String[] args) {
        FlatIntelliJLaf.install();
        MainProcess mainProcess = new MainProcess();
        loginView = new LoginView(mainProcess);
        loginView.Visivle();
    }
}
