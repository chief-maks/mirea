package Pr_7W;

import java.util.Stack;

public class Game {
    private Stack<Card> deck1 = new Stack<>();
    private Stack<Card> deck2 = new Stack<>();
    private Stack<Card> deck3 = new Stack<>();

    public void cardUpStack(Card card) {       // положить 1 карту сверху
        if(card.getPlayer() == 0) deck1.push(card);
        else deck2.push(card);
    }

    public void cardDownStack(Card card1, Card card2, int player) {    // положить 2 карты вниз колоды
        if(player == 0) {
            card2.setPlayer(0);   // теперь владелец этой карты 1 игрок

            int sizeDeck = deck1.size();
            for(int i = 0; i < sizeDeck; i++) {   // перекладываем карты во вспомогательную колоду в обратном порядке
                deck3.push(deck1.pop());
            }
                // кладем в самый низ основной колоды 2 карты со стола
            deck1.push(card2);  // по правилам карта 2-го игрока всегда ложится в самый низ
            deck1.push(card1);

            sizeDeck = deck3.size();
            for(int i = 0; i < sizeDeck; i++) {   // перекладываем карты в основную колоду(№1) также в обратном порядке
                deck1.push(deck3.pop());
            }
        }
        else {
            card1.setPlayer(1);   // теперь владелец этой карты 2 игрок

            int sizeDeck = deck2.size();
            for(int i = 0; i < sizeDeck; i++) {   // перекладываем карты во вспомогательную колоду в обратном порядке
                deck3.push(deck2.pop());
            }
                // кладем в самый низ основной колоды 2 карты со стола
            deck2.push(card2);  // по правилам карта 2-го игрока всегда ложится в самый низ
            deck2.push(card1);

            sizeDeck = deck3.size();
            for(int i = 0; i < sizeDeck; i++) {   // перекладываем карты в основную колоду(№2) также в обратном порядке
                deck2.push(deck3.pop());
            }
        }
    }

    public void Play() {
        Card card1, card2;
        int z = 0;
        for (; z < 106 && !deck1.empty() && !deck2.empty(); z++) {
            card1 = deck1.pop();
            card2 = deck2.pop();

            if(card1.getNum() == 0 || card2.getNum() != 0 && card1.getNum() > card2.getNum())
                cardDownStack(card1, card2, 0);
            else
                cardDownStack(card1, card2, 1);

        }
        if (deck1.empty()) System.out.println("Победил 2 игрок. Кол-во шагов - " + z);
        else if (deck2.empty()) System.out.println("Победил 1 игрок. Кол-во шагов - " + z);
        else if (z == 106) System.out.println("ботва!");
    }
}
