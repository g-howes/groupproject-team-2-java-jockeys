package starter;
import java.util.*;

class Dealer {
	private UnoCard[] deck;
	private int next;
	private Queue queue = new Queue(108);
	
	public Dealer(int num) {
		deck = new UnoCard[num];
		int start = 0;
		for(int i = 0; i < 4; i ++) {
			for(int j = 0; j < 13; j++) {
				if(j == 0) {	// there is only one 0 card value per color	
				deck[start] = new UnoCard(i,j);
				start++;
				}
				else {	//there are 2 of card values for each number except for wild cards
					deck[start] = new UnoCard(i,j);
					start++;
					deck[start] = new UnoCard(i,j);
					start++;
				}
			}
		}
		for(int i = 0; i < 4; i++) {	//there are 4 wild cards and 4 +4 wild cards in an UNO deck
			deck[start] = new UnoCard(4,13);
			start++;
			deck[start] = new UnoCard(4,14);
			start++;
		}
	}
	
	public static void main(String[] args) {
		Dealer dealerDeck = new Dealer(108);
		UnoCard c;
		dealerDeck.shuffle();
		for(int i = 0; i < 110; i++) {
			 c = dealerDeck.deal();
			 System.out.println((i+1) + "." + c.getCardValue().getValue() + 
					 " " + c.getColorType().getColor());
		}
	}
	
	public void shuffle() {
        Random randomNumber = new Random();
        //Randomise the deck
        for (int i = 0; i < 108; i++) {
             int rand = randomNumber.nextInt(107) + 1;
             queue.enqueue(deck[rand]);
        }
        next = 1;
   }
	
	 public UnoCard deal() { // Deals one card at a time
         if (Queue.isEmpty(queue)) { // If deck has no cards 
              shuffle();
         }
         return queue.dequeue();
    }
}