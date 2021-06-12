package View;

import javax.swing.*;

public class boardlistView {

    private JButton 가나다Button;
    private JScrollBar scrollBar1;
    private JPanel ClassList;
    private JTable t;
    private JFrame frame;

   public boardlistView(){
       frame = new JFrame();
       frame.setContentPane(ClassList);
       frame.setSize(800,600);
       frame.setResizable(false);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.pack();
   }

    public void Visivle(){
        frame.setVisible(true);
    }
    public void createUIComponents(){

    }
}
