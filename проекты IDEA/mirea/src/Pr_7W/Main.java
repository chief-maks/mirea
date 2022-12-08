package Pr_7W;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.cardUpStack(new Card(9,0));
        game.cardUpStack(new Card(7,0));
        game.cardUpStack(new Card(5,0));
        game.cardUpStack(new Card(3,0));
        game.cardUpStack(new Card(1,0));

        game.cardUpStack(new Card(0,1));
        game.cardUpStack(new Card(8,1));
        game.cardUpStack(new Card(6,1));
        game.cardUpStack(new Card(4,1));
        game.cardUpStack(new Card(2,1));

        game.Play();
    }
}
