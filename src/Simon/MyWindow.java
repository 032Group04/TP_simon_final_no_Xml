package Simon;


import javax.swing.*;
import java.awt.*;


public class MyWindow extends JFrame {


    public MyWindow() {
        super("Simon");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(600, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
}
