/**
   Client for the game of Bulgarian Solitaire.
*/
public class BulgarianSolitaireClient
{
   public static void main(String[] args)
   {
       Piles deck = new Piles();
       while(deck.getStatus() == false)
       {
           System.out.println(deck);
           deck.playRound();
       }
   }
}
