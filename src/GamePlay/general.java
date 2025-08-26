package GamePlay;

import player.player;

import javax.swing.*;

public class general extends card{
    cardType type = cardType.General;
    board board;
    ImageIcon image = new ImageIcon("D:/coup/Image/general1.png");
    public general(cardType type) {
        super(type);
    }

    @Override
    public void usePower(player player,player player1) {
        super.usePower(player, player1);
        if (player1.getCoin()>1){
            player1.setCoin(player1.getCoin()-2);
            player.setCoin(player.getCoin()+2);
        }else if(player1.getCoin()==1){
            player1.setCoin(0);
            player.setCoin(player.getCoin()+1);
        }
    }

}
