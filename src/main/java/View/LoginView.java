package View;

import javax.swing.*;

public class LoginView {

    private JPanel login;
    public LoginView(){
        JFrame frame = new JFrame();
        frame.setContentPane(login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
