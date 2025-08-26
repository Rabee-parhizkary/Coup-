package Frame;

import GamePlay.board;
import player.player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class mustCoup {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    board board;
    JButton player1;
    JButton player2;
    JButton player3;
    JLabel explain;
    static player defender;
    public mustCoup(){
        frame.setSize(150,100);
        frame.setTitle("Coup Game");
        player1 = new JButton(new AbstractAction("1") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                defender = board.getPlayer2();
                frame.dispose();
            }
        });
        player1.setBounds(0,30,50,70);
        panel.add(player1);

        player2 = new JButton(new AbstractAction("2") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                defender = board.getPlayer3();
                frame.dispose();
            }
        });
        player2.setBounds(50,30,50,70);
        panel.add(player2);

        player3 = new JButton(new AbstractAction("3") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                defender = board.getPlayer4();
                frame.dispose();
            }
        });
        player3.setBounds(100,30,50,70);
        panel.add(player3);

        explain = new JLabel("You must Coup!");
        explain.setBounds(30,0,120,30);
        panel.add(explain);


        panel.setLayout(null);
        frame.setResizable(false);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    public GamePlay.board getBoard() {
        return board;
    }

    public void setBoard(GamePlay.board board) {
        this.board = board;
    }
}
