package Frame;

import javax.swing.*;
import java.awt.*;

public class guide {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel explain;
    public guide(){
        frame.setSize(500,378);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        explain = new JLabel(new ImageIcon("D:/coup/Image/guide.jpg"));
        explain.setBounds(0,0,500,378);
        panel.add(explain);
        frame.setTitle("Coup Game");
        panel.setLayout(null);
        frame.setResizable(false);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
