package GamePlay;

import player.player;

import javax.swing.*;
import java.util.Random;

public class assassin extends card {
    cardType type = cardType.Assassin;
    board board;
    ImageIcon image = new ImageIcon("D:/coup/Image/assassin1.png");
    public assassin(cardType type) {
        super(type);
    }

    @Override
    public void usePower(player player, player player1) {
        super.usePower(player, player1);
        player.setCoin(player.getCoin()-3);
        int upperRand = player1.getCard().size();
        int i = new Random().nextInt(upperRand);
        board.getCards().add(player1.getCard().get(i));
        player1.getCard().remove(i);
    }
}
