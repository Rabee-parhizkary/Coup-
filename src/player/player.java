package player;

import Frame.actions;
import Frame.playerTurn;
import GamePlay.assassin;
import GamePlay.board;
import GamePlay.card;
import GamePlay.cardType;

import java.util.ArrayList;
import java.util.Random;

import static player.status.Alive;

public class player {
    // if paranoid mod 2 == 0; bluff
    int paranoid = 0;
    int coin;
    boolean chooseCard;
    botType type;
    boolean isTurn = true;
    board board;
    status status = Alive;
    ArrayList<GamePlay.card> card = new ArrayList<>();
    public player(){
        type = botType.player;
    }
    //this function will help this player ask given player if they have the inputted card
    public void challenge(player player,card card){
        boolean accepted = false;
        for(card c : player.getCard()){
            if(c.getType()==card.getType()){
                accepted = true;
            }
        }
        if (accepted){
            player.getCard().remove(card);
            //new board().getCard().add(card);
        }else{
            //layer.getCard().add(new board().getCards().get(0));

        }
    }
    public void turn(){
        switch (type){
            case paranoid:
                if (coin>=7){

                }else {
                    if (isTurn) {
                        actions.takeCoin(this);
                    } else {
                        if (paranoid % 2 == 0) {

                            paranoid++;
                        }
                    }
                }
                break;
            case custom:
                actions.setBoard(board);
                actions.takeCoin(this);
                break;
            case killer:
                boolean has = false;
                for (card c : card){
                    if (c.getType()== cardType.Assassin){
                        has = true;
                        break;
                    }
                }
                if (has){
                    int upperRand = board.getAlive();
                    int i = new Random().nextInt(upperRand);
                    ArrayList<player> alive = new ArrayList<player>();
                    ArrayList<player> players = new ArrayList<player>();
                    players.add(board.getPlayer2());
                    players.add(board.getPlayer3());
                    players.add(board.getPlayer4());
                    players.add(board.getPlayer1());
                    for (player p : players){
                        if (p.getStatus()==status.Alive){
                            alive.add(p);
                        }
                    }
                    actions.assassin(this,alive.get(i));
                }else {
                    for (card c : card){
                        if (c.getType()== cardType.Ambassador){
                            has = true;
                            break;
                        }
                    }
                    if (has){
                       boolean hasAssassin = false;
                       int j = 0;
                       card[] myCard = actions.ambassador(this,board);
                       for (card c : myCard){
                           if (c.getType()==cardType.Assassin){
                              hasAssassin = true;
                              break;
                           }
                           j++;
                       }
                       if(hasAssassin) {
                           ArrayList<card> choose = new ArrayList<>();
                           for (int i = 0; i < card.size(); i++) {
                               choose.add(card.get(i));
                           }
                           card.clear();
                           choose.add(myCard[(j+1)%2]);
                           int upperRand = choose.size();
                           int i = new Random().nextInt(upperRand);
                           card.add(new assassin(cardType.Assassin));
                           card.add(choose.get(i));
                           choose.clear();
                       }
                    }else {
                        if (coin==0){
                            actions.take2Coins(this);
                        }else {
                            actions.exchange(this,board,card.get(0));
                        }
                    }
                    break;
                }
            case coupMaker:
                if (coin>=7){
                    ArrayList<player> players = new ArrayList<player>();
                    players.add(board.getPlayer2());
                    players.add(board.getPlayer3());
                    players.add(board.getPlayer4());
                    players.add(board.getPlayer1());
                    ArrayList<player> alive = new ArrayList<player>();
                    for (player p : players){
                        if (p.getStatus()==status.Alive && p!=this){
                            alive.add(p);
                        }
                    }
                    int upperRand = alive.size();
                    int i = new Random().nextInt(upperRand);
                    actions.coup(alive.get(i),this);
                }else {
                    coin+=3;
                }
                break;

        }
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public botType getType() {
        return type;
    }

    public void setType(botType type) {
        this.type = type;
    }

    public ArrayList<GamePlay.card> getCard() {
        return card;
    }

    public void setCard(ArrayList<GamePlay.card> card) {
        this.card = card;
    }

    public status getStatus() {
        return status;
    }

    public void setStatus(status status) {
        this.status = status;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public board getBoard() {
        return board;
    }

    public void setBoard(board board) {
        this.board = board;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public boolean isChooseCard() {
        return chooseCard;
    }

    public void setChooseCard(boolean chooseCard) {
        this.chooseCard = chooseCard;
    }
}
