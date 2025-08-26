package Frame;

import GamePlay.*;
import player.player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class playerTurn{
    JFrame frame  = new JFrame();
    JPanel panel = new JPanel();
    JLabel act ;
    JButton exchange;
    JButton ambassador;
    JButton assassin;
    JButton duke;
    JButton general;
    JButton princess;
    JButton coup;
    JButton coin;
    JButton coins;
    //if we attack on some one
    JButton player1;
    JButton player2;
    JButton player3;
    //if we use ambassador card
    JButton card1;
    JButton card2;
    JButton card3;
    JButton card4;
    player defender;
    static JLabel warning;
    static JButton exchange1;
    static JButton exchange2;
    static JButton ambassador1;
    static JButton ambassador2;
    static JButton ambassador3;
    static JButton ambassador4;
    int m = 0;
    public  playerTurn(board board){
        frame.setSize(300,520);
        frame.setTitle("Coup Game");
        warning = new JLabel("Error !");
        warning.setBounds(100,500,100,20);
        warning.setVisible(false);
        panel.add(warning);
        act = new JLabel("Choose an action");
        act.setBounds(100,0,92,16);
        panel.add(act);
        actions.setBoard(board);
        player1 = new JButton(new AbstractAction("P1") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                defender = board.getPlayer2();
            }
        });
        player1.setBounds(10,50,72,22);
        panel.add(player1);

        player2 = new JButton(new AbstractAction("P2") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                defender = board.getPlayer3();
            }
        });
        player2.setBounds(110,50,72,22);
        panel.add(player2);

        player3 = new JButton(new AbstractAction("P3") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                defender = board.getPlayer4();
            }
        });
        player3.setBounds(210,50,72,22);
        panel.add(player3);

        exchange = new JButton(new AbstractAction("Exchange") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (board.getPlayer1().getCard().size() == 1) {
                    exchange1 = new JButton(new AbstractAction(String.valueOf(board.getPlayer1().getCard().get(0).getType())) {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            actions.exchange(board.getPlayer1(),board,board.getPlayer1().getCard().get(0));
                            frame.dispose();
                        }
                    });
                    exchange1.setBounds(194,390,94,22);
                    panel.add(exchange1);
                } else if(board.getPlayer1().getCard().size() == 2) {
                    exchange1 = new JButton(new AbstractAction(String.valueOf(board.getPlayer1().getCard().get(0).getType())) {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            actions.exchange(board.getPlayer1(),board,board.getPlayer1().getCard().get(0));
                            frame.dispose();
                        }
                    });
                    exchange1.setBounds(194,390,94,22);
                    panel.add(exchange1);
                    exchange2 = new JButton(new AbstractAction(String.valueOf(board.getPlayer1().getCard().get(1).getType())) {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            actions.exchange(board.getPlayer1(),board,board.getPlayer1().getCard().get(1));
                            frame.dispose();
                        }
                    });
                    exchange2.setBounds(6,390,94,22);
                    panel.add(exchange2);

                }
            }
        });
        exchange.setBounds(100,390,94,22);
        panel.add(exchange);

        general = new JButton(new AbstractAction("General") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                actions.setBoard(board);
                board.getPlayer1().setChooseCard(true);
                actions.general(board.getPlayer1(),defender);
                frame.dispose();
            }
        });
        general.setBounds(100,340,94,22);
        panel.add(general);

        duke = new JButton(new AbstractAction("Duke") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                actions.setBoard(board);
                board.getPlayer1().setChooseCard(true);
                actions.duke(board.getPlayer1());
                frame.dispose();
            }
        });
        duke.setBounds(100,290,94,22);
        panel.add(duke);

        ambassador1 = new JButton(new AbstractAction(String.valueOf(actions.ambassador(board.getPlayer1(),board)[0].getType())) {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                board.getPlayer1().getCard().add(actions.ambassador(board.getPlayer1(),board)[0]);
                ambassador1.setVisible(false);
                m++;
            }
        });
        ambassador1.setVisible(false);
        ambassador1.setBounds(194,250,100,11);
        panel.add(ambassador1);
        ambassador2 = new JButton(new AbstractAction(String.valueOf(actions.ambassador(board.getPlayer1(),board)[1].getType())) {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                board.getPlayer1().getCard().add(actions.ambassador(board.getPlayer1(),board)[1]);
                ambassador2.setVisible(false);
                m++;
            }
        });
        ambassador2.setVisible(false);
        ambassador2.setBounds(194,261,100,11);
        panel.add(ambassador2);
       ambassador3 = new JButton(new AbstractAction(String.valueOf(board.getPlayer1().getCard().get(0).getType())) {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                board.getPlayer1().getCard().add(board.getPlayer1().getCard().get(0));
                ambassador3.setVisible(false);
                m++;
            }
        });
        ambassador3.setVisible(false);
        ambassador3.setBounds(0,250,100,11);
        panel.add(ambassador3);
        ambassador4 = new JButton(new AbstractAction(String.valueOf(board.getPlayer1().getCard().get(1).getType())) {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                board.getPlayer1().getCard().add(board.getPlayer1().getCard().get(1));
                ambassador4.setVisible(false);
                m++;
            }
        });
        ambassador4.setVisible(false);
        ambassador4.setBounds(0,261,100,11);
        panel.add(ambassador4);
        ambassador = new JButton(new AbstractAction("Ambassador") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                actions.setBoard(board);
                board.getPlayer1().setChooseCard(true);
                actions.ambassador(board.getPlayer1(),board);
                ambassador1.setVisible(true);
                ambassador2.setVisible(true);
                ambassador3.setVisible(true);
                ambassador4.setVisible(true);
            }
        });
        ambassador.setBounds(100,250,94,22);
        panel.add(ambassador);
        if (m==2){
            ambassador1.setVisible(false);
            ambassador2.setVisible(false);
            ambassador3.setVisible(false);
            ambassador4.setVisible(false);
            board.getPlayer1().getCard().remove(0);
            board.getPlayer1().getCard().remove(1);
            gameFrame.cards4.get(0).setIcon(board.getPlayer1().getCard().get(0).getImage());
            gameFrame.cards4.get(1).setIcon(board.getPlayer1().getCard().get(1).getImage());
            frame.dispose();
            m=0;
        }


        assassin = new JButton(new AbstractAction("Assassin") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                actions.setBoard(board);
                board.getPlayer1().setChooseCard(true);
                actions.assassin(board.getPlayer1(),defender);
                frame.dispose();
            }
        });
        assassin.setBounds(100,210,94,22);
        panel.add(assassin);

        coup = new JButton(new AbstractAction("Coup") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                actions.coup(defender,board.getPlayer1());
                frame.dispose();
            }
        });
        coup.setBounds(100,170,94,22);
        panel.add(coup);

        coins= new JButton(new AbstractAction("Take 2 coins") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                actions.setBoard(board);
                actions.take2Coins(board.getPlayer1());
                frame.dispose();
            }
        });
        coins.setBounds(100,130,94,22);
        panel.add(coins);

        coin = new JButton(new AbstractAction("Take 1 coin") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                actions.setBoard(board);

                actions.takeCoin(board.getPlayer1());
                frame.dispose();
            }
        });
        coin.setBounds(100,90,94,22);
        panel.add(coin);

        panel.setLayout(null);
        frame.setResizable(false);
        frame.add(panel,BorderLayout.CENTER);
        frame.setVisible(true);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

}
