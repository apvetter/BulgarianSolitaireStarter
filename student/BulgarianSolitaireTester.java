/**
   Tests the game of Bulgarian Solitaire.
*/
public class BulgarianSolitaireTester
{
   public static void main(String[] args)
   {
      Piles deck = new Piles(new int[]{ 20, 5, 1, 9, 10 });
 
        
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [19, 4, 8, 9, 5]");
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [18, 3, 7, 8, 4, 5]");
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [17, 2, 6, 7, 3, 4, 6]");
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [16, 1, 5, 6, 2, 3, 5, 7]");      
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [15, 4, 5, 1, 2, 4, 6, 8]");
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [14, 3, 4, 1, 3, 5, 7, 8]");

   }
}
