package Frame;

import GamePlay.board;
import GamePlay.card;
import GamePlay.cardType;
import player.player;
import player.status;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class actions {
    static board board;
    static ArrayList<String> event = new ArrayList<>();

    public actions() {

    }

    public static void takeCoin(player player) {
        switch (actions.whichPlayer(player)) {
            case 1:
                event.add("player1 --> took a coin");
                int coin = player.getCoin();
                player.setCoin(coin + 1);
                Frame.gameFrame.coin1N.setText(String.valueOf(player.getCoin()));
                break;
            case 2:
                event.add("player2 --> took a coin");
                coin = player.getCoin();
                player.setCoin(coin + 1);
                Frame.gameFrame.coin2N.setText(String.valueOf(player.getCoin()));
                break;
            case 3:
                event.add("player3 --> took a coin");
                coin = player.getCoin();
                player.setCoin(coin + 1);
                Frame.gameFrame.coin3N.setText(String.valueOf(player.getCoin()));
                break;
            case 4:
                event.add("you --> took a coin");
                coin = player.getCoin();
                player.setCoin(coin + 1);
                Frame.gameFrame.coins4N.setText(String.valueOf(player.getCoin()));
                break;

        }
        gameFrame.coinAmount += -1;
        gameFrame.coinsNum.setText(String.valueOf(gameFrame.coinAmount));

    }

    public static void take2Coins(player player) {

        switch (actions.whichPlayer(player)) {
            case 1:
                event.add("player1 --> took 2 coins");
                int coin = player.getCoin();
                player.setCoin(coin + 2);
                Frame.gameFrame.coin1N.setText(String.valueOf(player.getCoin()));
                break;
            case 2:
                event.add("player2 --> took 2 coins");
                coin = player.getCoin();
                player.setCoin(coin + 2);
                Frame.gameFrame.coin2N.setText(String.valueOf(player.getCoin()));
                break;
            case 3:
                event.add("player3 --> took 2 coins");
                coin = player.getCoin();
                player.setCoin(coin + 2);
                Frame.gameFrame.coin3N.setText(String.valueOf(player.getCoin()));
                break;
            case 4:
                event.add("you --> took 2 coins");
                coin = player.getCoin();
                player.setCoin(coin + 2);
                Frame.gameFrame.coins4N.setText(String.valueOf(player.getCoin()));
                break;

        }
        gameFrame.coinAmount += -2;
        gameFrame.coinsNum.setText(String.valueOf(gameFrame.coinAmount));
    }

    public static void coup(player player, player player1) {
        if (player1.getCoin() >= 7) {
            String name1;
            String name2;
            if (whichPlayer(player)!=4){
                name1 = "player"+whichPlayer(player);
            }else {
                name1 = "you";
            }
            if (whichPlayer(player1)!=4){
                name2 = "player"+whichPlayer(player1);
            }else {
                name2 = "you";
            }
            event.add(name2+" --> coup "+name1);
            int x = player.getCard().size() - 1;
            card dead = player.getCard().get(0);
            player.getCard().remove(dead);
            switch (actions.whichPlayer(player)) {
                case 1:
                    gameFrame.cards1.get(x).setIcon(dead.getImage());
                    break;
                case 2:
                    gameFrame.cards2.get(x).setIcon(dead.getImage());
                    break;
                case 3:
                    gameFrame.cards3.get(x).setIcon(dead.getImage());
                    break;

            }
            switch (actions.whichPlayer(player1)) {
                case 1:
                    int coin = player1.getCoin();
                    player1.setCoin(coin - 7);
                    Frame.gameFrame.coin1N.setText(String.valueOf(player1.getCoin()));
                    break;
                case 2:
                    coin = player1.getCoin();
                    player1.setCoin(coin - 7);
                    Frame.gameFrame.coin2N.setText(String.valueOf(player1.getCoin()));
                    break;
                case 3:
                    coin = player1.getCoin();
                    player1.setCoin(coin - 7);
                    Frame.gameFrame.coin3N.setText(String.valueOf(player1.getCoin()));
                    break;
                case 4:
                    coin = player1.getCoin();
                    player1.setCoin(coin - 7);
                    Frame.gameFrame.coins4N.setText(String.valueOf(player1.getCoin()));
                    break;

            }
            gameFrame.coinAmount += 7;
            gameFrame.coinsNum.setText(String.valueOf(gameFrame.coinAmount));
        } else {
            playerTurn.warning.setVisible(true);
        }


    }

    public static void duke(player player) {

            String name1;
            if (whichPlayer(player) != 4) {
                name1 = "player" + whichPlayer(player);
            } else {
                name1 = "you";
            }

        event.add(name1+" --> duke");
        if (player.isTurn()) {
            switch (actions.whichPlayer(player)) {
                case 1:
                    int coin = player.getCoin();
                    player.setCoin(coin + 3);
                    Frame.gameFrame.coin1N.setText(String.valueOf(player.getCoin()));
                    break;
                case 2:
                    coin = player.getCoin();
                    player.setCoin(coin + 3);
                    Frame.gameFrame.coin2N.setText(String.valueOf(player.getCoin()));
                    break;
                case 3:
                    coin = player.getCoin();
                    player.setCoin(coin + 3);
                    Frame.gameFrame.coin3N.setText(String.valueOf(player.getCoin()));
                    break;
                case 4:
                    coin = player.getCoin();
                    player.setCoin(coin + 3);
                    Frame.gameFrame.coins4N.setText(String.valueOf(player.getCoin()));
                    break;

            }
            gameFrame.coinAmount += -3;
            gameFrame.coinsNum.setText(String.valueOf(gameFrame.coinAmount));
        } else {
            player = playGame.playerPlaying;
            switch (actions.whichPlayer(player)) {
                case 1:
                    int coin = player.getCoin();
                    player.setCoin(coin - 2);
                    Frame.gameFrame.coin1N.setText(String.valueOf(player.getCoin()));
                    break;
                case 2:
                    coin = player.getCoin();
                    player.setCoin(coin - 2);
                    Frame.gameFrame.coin2N.setText(String.valueOf(player.getCoin()));
                    break;
                case 3:
                    coin = player.getCoin();
                    player.setCoin(coin - 2);
                    Frame.gameFrame.coin3N.setText(String.valueOf(player.getCoin()));
                    break;
                case 4:
                    coin = player.getCoin();
                    player.setCoin(coin - 2);
                    Frame.gameFrame.coins4N.setText(String.valueOf(player.getCoin()));
                    break;

            }
            gameFrame.coinAmount += 2;
            gameFrame.coinsNum.setText(String.valueOf(gameFrame.coinAmount));
        }
    }

    public static void assassin(player player, player player1) {
        String name1;
        if (whichPlayer(player) != 4) {
            name1 = "player" + whichPlayer(player);
        } else {
            name1 = "you";
        }
        String name2;
        if (whichPlayer(player1) != 4) {
            name2 = "player" + whichPlayer(player1);
        } else {
            name2 = "you";
        }
        boolean enough = player.getCoin() >= 3;
        if (player1.getCard().size() == 1) {
            if (!(player1.getCard().get(0).getType() == cardType.Princess) && enough) {
                event.add(name1+" -->assassin "+name2);
                takeCoins(3, player);
                card dead = player1.getCard().get(0);
                player1.getCard().remove(dead);
                player1.setStatus(status.Dead);
                switch (actions.whichPlayer(player1)) {
                    case 1:
                        gameFrame.cards1.get(0).setIcon(dead.getImage());
                        gameFrame.cards1.get(0).setText("Dead");
                        break;
                    case 2:
                        gameFrame.cards2.get(0).setIcon(dead.getImage());
                        gameFrame.cards2.get(0).setText("Dead");
                        break;
                    case 3:
                        gameFrame.cards3.get(0).setIcon(dead.getImage());
                        gameFrame.cards3.get(0).setText("Dead");
                        break;
                    case 4:
                        gameFrame.cards4.get(0).setText("Dead");
                        break;
                }
            }
        } else if(enough){
            event.add(name1+" -->assassin "+name2);
            takeCoins(3,player);
            int x = player1.getCard().size();
            card dead = player1.getCard().get(x-1);
            player1.getCard().remove(dead);
            switch (actions.whichPlayer(player1)) {
                case 1:
                    gameFrame.cards1.get(x-1).setIcon(dead.getImage());
                    gameFrame.cards1.get(x-1).setText("Dead");
                    break;
                case 2:
                    gameFrame.cards2.get(x-1).setIcon(dead.getImage());
                    gameFrame.cards2.get(x-1).setText("Dead");
                    break;
                case 3:
                    gameFrame.cards3.get(x-1).setIcon(dead.getImage());
                    gameFrame.cards3.get(x-1).setText("Dead");
                    break;
                case 4:
                    gameFrame.cards4.get(x-1).setText("Dead");
                    break;

            }
        }else{
            playerTurn.warning.setVisible(true);
        }
    }

    public static void general(player player,player player1){
        String name1;
        if (whichPlayer(player) != 4) {
            name1 = "player" + whichPlayer(player);
        } else {
            name1 = "you";
        }
        String name2;
        if (whichPlayer(player1) != 4) {
            name2 = "player" + whichPlayer(player);
        } else {
            name2 = "you";
        }
        event.add(name1+" --> general "+name2);
       if(player1.getCoin()>1){

           switch (actions.whichPlayer(player1)) {
               case 1:
                   int coin = player1.getCoin();
                   player1.setCoin(coin - 2);
                   Frame.gameFrame.coin1N.setText(String.valueOf(player1.getCoin()));
                   break;
               case 2:
                   coin = player1.getCoin();
                   player1.setCoin(coin - 2);
                   Frame.gameFrame.coin2N.setText(String.valueOf(player1.getCoin()));
                   break;
               case 3:
                   coin = player1.getCoin();
                   player1.setCoin(coin - 2);
                   Frame.gameFrame.coin3N.setText(String.valueOf(player1.getCoin()));
                   break;
               case 4:
                   coin = player1.getCoin();
                   player1.setCoin(coin - 2);
                   Frame.gameFrame.coins4N.setText(String.valueOf(player1.getCoin()));
                   break;

           }

           switch (actions.whichPlayer(player)) {
               case 1:
                   int coin = player.getCoin();
                   player.setCoin(coin + 2);
                   Frame.gameFrame.coin1N.setText(String.valueOf(player.getCoin()));
                   break;
               case 2:
                   coin = player.getCoin();
                   player.setCoin(coin + 2);
                   Frame.gameFrame.coin2N.setText(String.valueOf(player.getCoin()));
                   break;
               case 3:
                   coin = player.getCoin();
                   player.setCoin(coin + 2);
                   Frame.gameFrame.coin3N.setText(String.valueOf(player.getCoin()));
                   break;
               case 4:
                   coin = player.getCoin();
                   player.setCoin(coin + 2);
                   Frame.gameFrame.coins4N.setText(String.valueOf(player.getCoin()));
                   break;

           }

       }else {
           switch (actions.whichPlayer(player1)) {
               case 1:
                   int coin = player1.getCoin();
                   player1.setCoin(coin - 1);
                   Frame.gameFrame.coin1N.setText(String.valueOf(player1.getCoin()));
                   break;
               case 2:
                   coin = player1.getCoin();
                   player1.setCoin(coin - 1);
                   Frame.gameFrame.coin2N.setText(String.valueOf(player1.getCoin()));
                   break;
               case 3:
                   coin = player1.getCoin();
                   player1.setCoin(coin - 1);
                   Frame.gameFrame.coin3N.setText(String.valueOf(player1.getCoin()));
                   break;
               case 4:
                   coin = player1.getCoin();
                   player1.setCoin(coin - 1);
                   Frame.gameFrame.coins4N.setText(String.valueOf(player1.getCoin()));
                   break;

           }

           switch (actions.whichPlayer(player)) {
               case 1:
                   int coin = player.getCoin();
                   player.setCoin(coin + 1);
                   Frame.gameFrame.coin1N.setText(String.valueOf(player.getCoin()));
                   break;
               case 2:
                   coin = player.getCoin();
                   player.setCoin(coin + 1);
                   Frame.gameFrame.coin2N.setText(String.valueOf(player.getCoin()));
                   break;
               case 3:
                   coin = player.getCoin();
                   player.setCoin(coin + 1);
                   Frame.gameFrame.coin3N.setText(String.valueOf(player.getCoin()));
                   break;
               case 4:
                   coin = player.getCoin();
                   player.setCoin(coin + 1);
                   Frame.gameFrame.coins4N.setText(String.valueOf(player.getCoin()));
                   break;

           }

       }
    }

    public static card[] ambassador(player player, board board){
        String name1;
        if (whichPlayer(player) != 4) {
            name1 = "player" + whichPlayer(player);
        } else {
            name1 = "you";
        }
        event.add(name1+" --> ambassador");
        card[] result = new card[2];
        int upperRand = board.getCards().size();
        int i = new Random().nextInt(upperRand);
        result[0] = board.getCards().get(i);
        upperRand = board.getCards().size();
        i = new Random().nextInt(upperRand);
        result[1] = board.getCards().get(i);
        return result;
    }

    public static void exchange(player player1,board board,card card){
        String name1;
        if (whichPlayer(player1) != 4) {
            name1 = "player" + whichPlayer(player1);
        } else {
            name1 = "you";
        }
        event.add(name1+" --> exchange");
        switch (actions.whichPlayer(player1)) {
            case 1:
                int coin = player1.getCoin();
                player1.setCoin(coin - 1);
                Frame.gameFrame.coin1N.setText(String.valueOf(player1.getCoin()));
                break;
            case 2:
                coin = player1.getCoin();
                player1.setCoin(coin - 1);
                Frame.gameFrame.coin2N.setText(String.valueOf(player1.getCoin()));
                break;
            case 3:
                coin = player1.getCoin();
                player1.setCoin(coin - 1);
                Frame.gameFrame.coin3N.setText(String.valueOf(player1.getCoin()));
                break;
            case 4:
                coin = player1.getCoin();
                player1.setCoin(coin - 1);
                Frame.gameFrame.coins4N.setText(String.valueOf(player1.getCoin()));
                break;

        }
        gameFrame.coinAmount += 1;
        gameFrame.coinsNum.setText(String.valueOf(gameFrame.coinAmount));

        int x  = board.getCards().size();
        int rand = new Random().nextInt(x);
        player1.getCard().remove(card);
        player1.getCard().add(board.getCards().get(rand));
        board.getCards().remove(rand);
        board.getCards().add(card);
        if (whichPlayer(player1)==4){
            x = 0;
            for(card c : board.getPlayer1().getCard()){
                gameFrame.cards4.get(x).setIcon(c.getImage());
            }
        }

    }
    public void challenge(player player,card card){
        String name1;
        if (whichPlayer(player) != 4) {
            name1 = "player" + whichPlayer(player);
        } else {
            name1 = "you";
        }
        String name2;
        if (whichPlayer( playGame.playerPlaying) != 4) {
            name2 = "player" + whichPlayer(player);
        } else {
            name2 = "you";
        }
        event.add(name1+" --> challenge"+name2);
        boolean win = true;
        player defender = playGame.playerPlaying;

        for(card c : defender.getCard()){
            if (c==card){
                card r  = c;
                win = false;
                break;
            }
        }
        if (win){

        }else {
            player.getCard().remove(0);
            int x  = board.getCards().size();
            int rand = new Random().nextInt(x);
            //defender.getCard().remove(r);
            defender.getCard().add(board.getCards().get(rand));
            if (whichPlayer(defender)==4){
                int y = defender.getCard().size();
                gameFrame.cards4.get(y-1).setIcon(board.getCards().get(rand).getImage());
            }

        }


    }



    public static int whichPlayer(player player){
        int result = 0;
        if(board.getPlayer1()==player){
            result  = 4;
        }else if(board.getPlayer2()==player){
            result = 1;
        }else if(board.getPlayer3()==player){
            result = 2;
        }else if(board.getPlayer4()==player){
            result = 3;
        }
        return  result;
    }
    public static void takeCoins(int x, player player) {
        switch (actions.whichPlayer(player)) {
            case 1:
                int coin = player.getCoin();
                player.setCoin(coin - x);
                Frame.gameFrame.coin1N.setText(String.valueOf(player.getCoin()));
                break;
            case 2:
                coin = player.getCoin();
                player.setCoin(coin - x);
                Frame.gameFrame.coin2N.setText(String.valueOf(player.getCoin()));
                break;
            case 3:
                coin = player.getCoin();
                player.setCoin(coin - x);
                Frame.gameFrame.coin3N.setText(String.valueOf(player.getCoin()));
                break;
            case 4:
                coin = player.getCoin();
                player.setCoin(coin - x);
                Frame.gameFrame.coins4N.setText(String.valueOf(player.getCoin()));
                break;

        }
        gameFrame.coinAmount += x;
        gameFrame.coinsNum.setText(String.valueOf(gameFrame.coinAmount));
    }

    public static GamePlay.board getBoard() {
        return board;
    }

    public static void setBoard(GamePlay.board board) {
        actions.board = board;
    }
}
