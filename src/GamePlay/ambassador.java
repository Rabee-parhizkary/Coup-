package GamePlay;

import player.player;

import javax.swing.*;
import java.util.Random;

public class ambassador extends card {
    cardType type = cardType.Ambassador;
    board board;
    ImageIcon image = new ImageIcon("D:/coup/Image/ambassador1.png");
    public ambassador(cardType type) {
        super(type);
    }

    @Override
    public void usePower(player player,player player1) {
        int upperRand = board.getCards().size();
        int i = new Random().nextInt(upperRand);
        player.getCard().add(board.getCards().get(i));
        board.getCards().remove(i);
        upperRand = board.getCards().size();
        i = new Random().nextInt(upperRand);
        player.getCard().add(board.getCards().get(i));
        board.getCards().remove(i);
    }
}
