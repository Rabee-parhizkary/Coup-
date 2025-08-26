package Frame;

import GamePlay.board;
import player.player;
import player.status;

import java.util.ArrayList;

public class playGame {
    static int turn= 0;

    static ArrayList<player> players ;
    static board board;
    static player playerPlaying;
    public playGame(){

    }

   public static void play(board board){
       ArrayList<player> players = new ArrayList<player>();
       players.add(board.getPlayer2());
       players.add(board.getPlayer3());
       players.add(board.getPlayer4());
       players.add(board.getPlayer1());
       int x = getAlive(players).size();
       setTurn(board);
       if (turn%x==0){
           playerPlaying = players.get(0);
           gameFrame.challenge.setVisible(false);
           gameFrame.duke.setVisible(false);
           if (getAlive(players).get(0).getCoin()<10) {
               getAlive(players).get(0).setBoard(board);
               new playerTurn(board);
           }else {
               mustCoup mustCoup = new mustCoup();
               mustCoup.setBoard(board);
               actions.coup(mustCoup.defender,getAlive(players).get(0));
           }
       }else{
           gameFrame.challenge.setVisible(true);
           gameFrame.duke.setVisible(true);
           if (getAlive(players).get(turn%x).getStatus()== status.Alive) {
               playerPlaying = getAlive(players).get(turn%x);
               if (getAlive(players).get(turn % x).getCoin() < 10) {
                   getAlive(players).get(turn % x).setBoard(board);
                   getAlive(players).get(turn % x).turn();
               } else {
                   getAlive(players).get(turn % x).setBoard(board);
                   playerTurn playerTurn = new playerTurn(board);
                   actions.coup(playerTurn.defender, getAlive(players).get(turn % 4));
               }
           }

       }
   }
   public static ArrayList<player> getAlive(ArrayList<player> players){
       ArrayList<player> result = new ArrayList<>();
        for (player p: players){
            if (p.getCard().size()!=0){
                result.add(p);
            }
        }
        return result;
   }
   public static void setTurn(board board){
        switch (turn%4){
            case 0:
                board.getPlayer1().setTurn(true);
                board.getPlayer2().setTurn(false);
                board.getPlayer3().setTurn(false);
                board.getPlayer4().setTurn(false);
                break;
            case 1:
                board.getPlayer2().setTurn(true);
                board.getPlayer1().setTurn(false);
                board.getPlayer3().setTurn(false);
                board.getPlayer4().setTurn(false);
                break;
            case 2:
                board.getPlayer3().setTurn(true);
                board.getPlayer2().setTurn(false);
                board.getPlayer1().setTurn(false);
                board.getPlayer4().setTurn(false);
                break;
            case 3:
                board.getPlayer4().setTurn(true);
                board.getPlayer2().setTurn(false);
                board.getPlayer3().setTurn(false);
                board.getPlayer1().setTurn(false);
                break;

        }
   }

    public static player getPlayerPlaying() {
        return playerPlaying;
    }

    public static void setPlayerPlaying(player playerPlaying) {
        playGame.playerPlaying = playerPlaying;
    }
}
