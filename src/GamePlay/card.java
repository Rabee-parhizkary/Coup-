package GamePlay;

import player.player;

import javax.swing.*;

public class card {
    private cardType type;
    private ImageIcon image;
    board board;
    public card(cardType type){
        this.type = type;
        switch (type){
            case Assassin:
              image  = new ImageIcon("D:/coup/Image/assassin1.png");
              break;
            case Princess:
               image = new ImageIcon("D:/coup/Image/princess1.jpg");
               break;
            case Duke:
                image = new ImageIcon("D:/coup/Image/duke1.jpg");
                break;
            case Ambassador:
                image = new ImageIcon("D:/coup/Image/ambassador1.png");
                break;
            case General:
                image = new ImageIcon("D:/coup/Image/general1.jpg");
                break;
        }
    }
    public void die(){}
    public void coup(card card){}
    public void move(){}

    public cardType getType() {
        return type;
    }

    public ImageIcon getImage() {

        return image;
    }

    public GamePlay.board getBoard() {
        return board;
    }

    public void setBoard(GamePlay.board board) {
        this.board = board;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
   //first player is the one who owns this card , second one is the one who we attack with this card
    public void usePower(player player,player player1){

    }
}
