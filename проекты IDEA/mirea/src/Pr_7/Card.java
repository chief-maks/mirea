package Pr_7;

public class Card {
    private int num;
    private int player;

    public Card(int num, int player) {
        this.num = num;
        this.player = player;
    }

    public int getNum() {
        return num;
    }
    public int getPlayer() {
        return player;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public void setPlayer(int player) {
        this.player = player;
    }
}
