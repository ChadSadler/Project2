import java.util.ArrayList;
import java.util.Scanner;

public class Deck {

	public static void main(String args[]) {
		int[] deck = new int[52];
		ArrayList<String> hand = new ArrayList<>();
		int count = 0;
		int used = 0;
		int total = 0;
		int hit = 1; //1 for hit, 2 for stay
		
		Scanner keyboard = new Scanner(System.in);
		
		//creates new un-shuffled deck
		for (int suit = 0; suit <= 3; suit++) { //4 suits
			for (int value = 1; value <= 13; value++) { //13 face values
				deck[count] = value;
				count++;
			}
		}
		//shuffles deck
		for (int i = 51; i > 0; i--) {
			int rand = (int)(Math.random()*(i+1));
			int temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
		
		System.out.println("Welcome to Blackjack!\n");
		
		while(hit == 1) {
			switch (deck[used]) {
			case 1:
				hand.add("A");
				
				if (total <= 10) {
					total += 11;
				}
				else {
					total += 1;
				}
				break;
			case 11:
				hand.add("J");
				total += 10;
				break;
			case 12: 
				hand.add("Q");
				total += 10;
				break;
			case 13:
				hand.add("K");
				total += 10;
				break;
			default:
				hand.add("" + deck[used]);
				total += deck[used];
				break;
			}
			
			used++;
			
			if (used >= 2) {
				System.out.print("Your cards:");
				
				for (int i = 0; i < used; i++) {
					System.out.print(" " + hand.get(i));
				}
				System.out.print(" (Total: " + total + ")");
				
				if (total == 21) {
					System.out.println("\nBlackjack!");
					break;
				}
				else if (total > 21) {
					System.out.println("\nBust!");
					break;
				}
				
				System.out.println("\n\nPlease enter an option: 1 - Hit 2 - Stay");
				hit = keyboard.nextInt();
				System.out.println(" ");
			}
		}
		keyboard.close();
		return;
	}
}