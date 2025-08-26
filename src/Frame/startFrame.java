package Frame;

import GamePlay.board;
import player.player;
import player.botType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class startFrame  {
    JLabel name;
    JLabel background;
    JButton game1;
    JButton game2;
    JButton game3;
    JButton game4;
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    public startFrame(){
        frame.setSize(550,420);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        name = new JLabel("Coup Game");
        name.setFont(new Font("Serif",Font.BOLD,24));
        name.setForeground(Color.WHITE);
        name.setIcon(new ImageIcon("D:/coup/Image/sword.png"));
        name.setBounds(0,0,400,40);
        panel.add(name);

        game1 = new JButton(new AbstractAction("1") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                board myBoard = new board(new player(),new player() ,new player(),new player());
                myBoard.getPlayer2().setType(botType.coupMaker);
                myBoard.getPlayer3().setType(botType.killer);
                myBoard.getPlayer4().setType(botType.paranoid);
                gameFrame.startGame(myBoard);

                frame.dispose();
                gameFrame gameFrame = new gameFrame();
                gameFrame.setBoard(myBoard);

            }
        });
        game1.setBackground(new Color(255,255,100));
        game1.setBounds(221,166,75,22);
        panel.add(game1);
        game2 = new JButton(new AbstractAction("2") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                board myBoard = new board(new player(),new player() ,new player(),new player());
                myBoard.getPlayer2().setType(botType.coupMaker);
                myBoard.getPlayer3().setType(botType.killer);
                myBoard.getPlayer4().setType(botType.custom);
                gameFrame.startGame(myBoard);
                frame.dispose();
                gameFrame gameFrame = new gameFrame();
                gameFrame.setBoard(myBoard);
            }
        });
        game2.setBackground(new Color(250,200,100));
        game2.setBounds(221,200,75,22);
        panel.add(game2);
        game3 = new JButton(new AbstractAction("3") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                board myBoard = new board(new player(),new player() ,new player(),new player());
                myBoard.getPlayer2().setType(botType.coupMaker);
                myBoard.getPlayer3().setType(botType.custom);
                myBoard.getPlayer4().setType(botType.paranoid);
                gameFrame.startGame(myBoard);
                frame.dispose();
                gameFrame gameFrame = new gameFrame();
                gameFrame.setBoard(myBoard);
            }
        });
        game3.setBackground(new Color(250,140,50));
        game3.setBounds(221,234,75,22);
        panel.add(game3);
        game4 = new JButton(new AbstractAction("4") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                board myBoard = new board(new player(),new player() ,new player(),new player());
                myBoard.getPlayer2().setType(botType.custom);
                myBoard.getPlayer3().setType(botType.killer);
                myBoard.getPlayer4().setType(botType.paranoid);
                gameFrame.startGame(myBoard);
                frame.dispose();
                gameFrame gameFrame = new gameFrame();
                gameFrame.setBoard(myBoard);
            }
        });
        game4.setBackground(new Color(250,20,50));
        game4.setBounds(221,268,75,22);
        panel.add(game4);

        background = new JLabel();
        background.setBounds(0,0,550,420);
        background.setIcon(new ImageIcon("D:/coup/Image/background.jpg"));
        panel.add(background);
        frame.setTitle("Coup Game");
        panel.setLayout(null);
        frame.setResizable(false);
        frame.add(panel,BorderLayout.CENTER);
        frame.setVisible(true);
    }


}