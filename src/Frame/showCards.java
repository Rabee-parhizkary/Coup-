package Frame;

import GamePlay.card;
import player.player;

import javax.swing.*;
import java.awt.*;

public class showCards {
    player player;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    public  showCards(player player){
        frame.setSize(610,330);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.player = player;
        int x  =0 ;
        for(card c : player.getCard()){
            JLabel card = new JLabel(c.getImage(),SwingConstants.CENTER);
            if(x==0){
                card.setBounds(0,0,100,200);
            }else if(x==3){
                card.setBounds(0,210,100,200);
            }
            else if(x>4){
                card.setBounds(x*100+10,210,100,200);
            }
            else{
                card.setBounds(x*100+10,0,100,200);
            }
            panel.add(card);
            x++;

        }
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("D:/coup/Image/photo_۲۰۲۲-۰۵-۰۶_۰۱-۰۶-۰۲.jpg"));
        background.setBounds(0,0,610,330);
        panel.add(background);
        frame.setTitle("Coup Game");
        panel.setLayout(null);
        frame.setResizable(false);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
