import View.LoginView;

import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.*;

public class MainProcess {
    static LoginView loginView;
    public static void main(String[] args) {
        FlatIntelliJLaf.install();
        loginView = new LoginView();
    }
}
