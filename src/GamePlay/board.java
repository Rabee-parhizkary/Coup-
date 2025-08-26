package GamePlay;

import player.player;
import player.status;

import java.util.ArrayList;

public class board {
    player player1;
    player player2;
    player player3;
    player player4;
    //this shows the number of coins that no one owns
    private int coin;
    //this array list contains the card no one owns
    private ArrayList<card> cards = new ArrayList<>();

    public board(player player1,player player2,player player3,player player4) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;

        cards.add(new ambassador(cardType.Ambassador));
        cards.add(new ambassador(cardType.Ambassador));
        cards.add(new ambassador(cardType.Ambassador));
        cards.add(new assassin(cardType.Assassin));
        cards.add(new assassin(cardType.Assassin));
        cards.add(new assassin(cardType.Assassin));
        cards.add(new duke(cardType.Duke));
        cards.add(new duke(cardType.Duke));
        cards.add(new duke(cardType.Duke));
        cards.add(new general(cardType.General));
        cards.add(new general(cardType.General));
        cards.add(new general(cardType.General));
        cards.add(new princess(cardType.Princess));
        cards.add(new princess(cardType.Princess));
        cards.add(new princess(cardType.Princess));

    }

    public  int getAlive() {
        int result = 0;
        ArrayList<player> players = new ArrayList<player>();
        players.add(player2);
        players.add(player1);
        players.add(player3);
        players.add(player4);
        for (player p : players) {
            if (p.getStatus() == status.Alive) {
                result++;
            }
        }
        return result;
    }
    public void updatePlayers(){
        ArrayList<player> players = new ArrayList<player>();
        players.add(player2);
        players.add(player1);
        players.add(player3);
        players.add(player4);
        ArrayList<player> alive = new ArrayList<>();
        for (player p : players){
            if (p.getStatus() == status.Alive){
                alive.add(p);
            }
        }
        setPlayer1(alive.get(0));
        ArrayList<player> myPlayers = new ArrayList<>();
        myPlayers.add(player2);
        myPlayers.add(player3);
        myPlayers.add(player4);
        for (player p : myPlayers){
            for ( player l : alive){
                if (p.getType()==l.getType()){
                    p = l;
                }
            }
        }

    }

    //getters and setters
    public player getPlayer1() {
        return player1;
    }

    public void setPlayer1(player player1) {
        this.player1 = player1;
    }

    public player getPlayer4() {
        return player4;
    }



    public void setPlayer4(player player4) {
        this.player4 = player4;
    }

    public player getPlayer3() {
        return player3;
    }

    public void setPlayer3(player player3) {
        this.player3 = player3;
    }

    public player getPlayer2() {
        return player2;
    }

    public void setPlayer2(player player2) {
        this.player2 = player2;
    }
    public ArrayList<card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<card> cards) {
        this.cards = cards;
    }
}
