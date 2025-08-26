package Frame;

import GamePlay.board;
import GamePlay.card;
import player.player;
import player.status;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import static player.status.Alive;

public class gameFrame {
     static JFrame frame = new JFrame();
    static board board = new board(new player(),new player(),new player(),new player());
    static JLabel name;
    static JPanel panel = new JPanel();
    static JLabel bot1 = new JLabel("Player1");
    static JLabel bot2 = new JLabel("Player2");
    static JLabel bot3 = new JLabel("Player3");
    static JLabel player = new JLabel("Me");
    static JButton card = new JButton();
    static JLabel card1 = new JLabel();
    static JLabel coin1N;
    static JLabel coin2N;
    static JLabel coin3N;
    static JLabel coins4N;
    static JLabel coinsNum;

    static  int coinAmount = 42;
    static ArrayList<JLabel> cards1 = new ArrayList<>();
    static ArrayList<JLabel> cards2 = new ArrayList<>();
    static ArrayList<JLabel> cards3 = new ArrayList<>();
    static ArrayList<JLabel> cards4 = new ArrayList<>();
    ImageIcon cardIcon = new ImageIcon("D:/coup/Image/Webp.net-resizeimage (2).jpg");
    ImageIcon coinIcon = new ImageIcon("D:/coup/Image/coin.png");
    static JButton challenge;
    static JButton duke;
    public gameFrame(){
        if (playGame.turn==0) {
            startGame(board);
        }
        frame.setSize(700,420);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        name = new JLabel("Coup Game");
        name.setFont(new Font("Serif",Font.BOLD,24));
        name.setForeground(Color.WHITE);
        name.setIcon(new ImageIcon("D:/coup/Image/sword.png"));
        name.setBounds(0,0,400,40);
        panel.add(name);
        bot1.setBounds(250,70 ,50,16);
        panel.add(bot1);


        int x = 0;
        for(card c : board.getPlayer2().getCard()){
            cards1.add(new JLabel(cardIcon,JLabel.CENTER));
            cards1.get(cards1.size()-1).setBounds(190-39*x,40,39,30);
            panel.add(cards1.get(cards1.size()-1));
            x++;
        }

        JLabel coins1  = new JLabel(coinIcon,JLabel.CENTER);
        coins1.setBounds(310,40,20,20);
        panel.add(coins1);
        coin1N = new JLabel(String.valueOf(board.getPlayer2().getCoin()));
        coin1N.setBounds(310,30,40,10);
        panel.add(coin1N);

        bot2.setBounds(440,200 ,50,16);
        panel.add(bot2);

        x = 0;
        for(card c : board.getPlayer3().getCard()){
            cards2.add(new JLabel(cardIcon,JLabel.CENTER));
            cards2.get(cards2.size()-1).setBounds(480-39*x,160,39,30);
            panel.add(cards2.get(cards2.size()-1));
            x++;
        }

        JLabel coins2  = new JLabel(coinIcon,JLabel.CENTER);
        coins2.setBounds(480,240,20,20);
        panel.add(coins2);
        coin2N = new JLabel(String.valueOf(board.getPlayer3().getCoin()));
        coin2N.setBounds(500,240,40,20);
        panel.add(coin2N);

        bot3.setBounds(70,200 ,50,16);
        panel.add(bot3);

        x = 0;
        for(card c : board.getPlayer4().getCard()){
            cards3.add(new JLabel(cardIcon,JLabel.CENTER));
            cards3.get(cards3.size()-1).setBounds(30+39*x,140,39,30);
            panel.add(cards3.get(cards3.size()-1));
            x++;
        }

        JLabel coins3  = new JLabel(coinIcon,JLabel.CENTER);
        coins3.setBounds(30,240,30,20);
        panel.add(coins3);
        coin3N = new JLabel(String.valueOf(board.getPlayer4().getCoin()));
        coin3N.setBounds(20,240,10,20);
        panel.add(coin3N);

        player.setBounds(250,320 ,41,16);
        panel.add(player);

        x = 0;
        for(card c : board.getPlayer1().getCard()){
            cards4.add(new JLabel(c.getImage(),JLabel.CENTER));
            cards4.get(cards4.size()-1).setBounds(310+39*x,340,39,30);
            panel.add(cards4.get(cards4.size()-1));
            x++;
        }

        JLabel coins4  = new JLabel(coinIcon,JLabel.CENTER);
        coins4.setBounds(190,340,30,20);
        panel.add(coins4);
        duke = new JButton(new AbstractAction("Duke") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                actions.duke(playGame.playerPlaying);
            }
        });
        duke.setBounds(110,340,70,20);
        duke.setVisible(false);
        panel.add(duke);
        challenge = new JButton(new AbstractAction("Challenge") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        challenge.setBounds(110,320,70,20);
        challenge.setVisible(false);
        panel.add(challenge);

        coins4N = new JLabel(String.valueOf(board.getPlayer1().getCoin()));
        coins4N.setBounds(190,320,39,20);
        panel.add(coins4N);

        JButton exit = new JButton(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                new startFrame();

            }
        });
        exit.setBounds(480,360,70,22);
        panel.add(exit);
        if(playGame.turn==0){
            new playerTurn(board);
        }
        ArrayList<JLabel> events = new ArrayList<>();

        JButton continueGame = new JButton(new AbstractAction("Continue") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                playGame.turn ++;
                playGame.play(board);
                events.add(new JLabel(actions.event.get(actions.event.size()-1)));
                events.get(events.size()-1).setBounds(550,actions.event.size()*10,200,10);
                panel.add(events.get(events.size()-1));


            }
        });
        continueGame .setBounds(480,0,70,22);
        panel.add(continueGame );

        JButton allCards = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        JButton explain = new JButton(new AbstractAction("Guide") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new guide();
            }
        });
        explain.setBounds(0,420,20,10);
        panel.add(explain);
        allCards.setBounds(180,180,39,30);
        allCards.setIcon(new ImageIcon("D:/coup/Image/Webp.net-resizeimage (2).jpg"));
        panel.add(allCards);

        JLabel cardsNum = new JLabel(String.valueOf(board.getCards().size()));
        cardsNum.setBounds(190,150,39,30);
        panel.add(cardsNum);

        JButton allCoins = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        allCoins.setBounds(300,190,32,20);
        allCoins.setIcon(new ImageIcon("D:/coup/Image/Webp.net-resizeimage (1).jpg"));
        panel.add(allCoins);

        coinsNum = new JLabel(String.valueOf(coinAmount));
        coinsNum.setBounds(310,180,39,10);
        panel.add(coinsNum);


  
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("D:/coup/Image/photo_۲۰۲۲-۰۵-۰۶_۰۱-۰۶-۰۲.jpg"));
        background.setBounds(0,0,550,420);
        panel.add(background);


        frame.setTitle("Coup Game");
        panel.setLayout(null);
        frame.setResizable(false);
        frame.add(panel,BorderLayout.CENTER);
        frame.setVisible(true);


    }

    public void removeCoins(player player){

    }

    public void addCards(ArrayList<JLabel> c){
        for(JLabel l : c){
            panel.add(l);
        }
    }
    public void play(){
        new playerTurn(board);
        if (board.getPlayer2().getStatus()== Alive){

        }
    }
    public static void startGame(board board){
        int upperRand = 0;
        int i = 0;
            upperRand = board.getCards().size();
            i = new Random().nextInt(upperRand);
            board.getPlayer1().getCard().add(board.getCards().get(i));
            board.getPlayer1().setCoin(2);
        upperRand = board.getCards().size();
        i = new Random().nextInt(upperRand);
        board.getPlayer1().getCard().add(board.getCards().get(i));
        board.getPlayer1().setCoin(2);
        upperRand = board.getCards().size();
        i = new Random().nextInt(upperRand);
        board.getPlayer2().getCard().add(board.getCards().get(i));
        board.getPlayer2().setCoin(2);
        upperRand = board.getCards().size();
        i = new Random().nextInt(upperRand);
        board.getPlayer2().getCard().add(board.getCards().get(i));
        board.getPlayer2().setCoin(2);
        upperRand = board.getCards().size();
        i = new Random().nextInt(upperRand);
        board.getPlayer3().getCard().add(board.getCards().get(i));
        board.getPlayer3().setCoin(2);
        upperRand = board.getCards().size();
        i = new Random().nextInt(upperRand);
        board.getPlayer3().getCard().add(board.getCards().get(i));
        board.getPlayer3().setCoin(2);
        upperRand = board.getCards().size();
        i = new Random().nextInt(upperRand);
        board.getPlayer4().getCard().add(board.getCards().get(i));
        board.getPlayer4().setCoin(2);
        upperRand = board.getCards().size();
        i = new Random().nextInt(upperRand);
        board.getPlayer4().getCard().add(board.getCards().get(i));
        board.getPlayer4().setCoin(2);

    }

    public int getAlive(board b){
        int result = 0;
        ArrayList<player> players = new ArrayList<player>();
        players.add(board.getPlayer2());
        players.add(board.getPlayer3());
        players.add(board.getPlayer4());
        players.add(board.getPlayer1());
        for (player p : players){
            if(p.getStatus()==Alive){
                result++;
            }
        }
        return result;
    }

    public static void setAlive(ArrayList<player> players) {
        for (player p : players) {
            if (p.getCard().size()==0) {
                p.setStatus(status.Dead);
            }
        }
    }
    public static int getAlive(ArrayList<player> players){
        int result = 0;
        for (player p : players) {
            if (p.getCard().size()>=1) {
                result++;
            }
        }

        return result;
    }


    //getters and setters


    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public board getBoard() {
        return board;
    }

    public void setBoard(board board) {
        this.board = board;
    }
}
