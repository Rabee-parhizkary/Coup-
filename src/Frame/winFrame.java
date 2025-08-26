package Frame;

import javax.swing.*;
import java.awt.*;

public class winFrame {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    winStatus status;
    public winFrame(){
        frame.setSize(400,100);
        JLabel win = new JLabel("");
        frame.setTitle("Coup Game");
        panel.setLayout(null);
        frame.setResizable(false);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
