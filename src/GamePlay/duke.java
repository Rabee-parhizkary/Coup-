package GamePlay;

import player.player;

import javax.swing.*;

public class duke extends card{
    cardType type = cardType.Duke;
    board board;
    ImageIcon image = new ImageIcon("D:/coup/Image/duke1.jpg");
    public duke(cardType type) {
        super(type);
    }

    public void usePower(player player) {
       player.setCoin(player.getCoin()+3);
    }
    @Override
    public void usePower(player player,player player1) {
        super.usePower(player, player1);


    }
}
