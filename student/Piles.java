import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
/**
 * A class that plays Bulgarian Solitare. 
 * Version 1: Implement the playRound and toString methods.
 */
public class Piles
{
   private ArrayList<Integer> piles;
   private ArrayList<Integer> sorted;
   private boolean complete = false;
   private int numOfPiles = 0;
   private ArrayList<Integer> solution = new ArrayList<Integer>();
   private int count = 0;
   private Random random = new Random();
   
   /**
      Create a set of piles with a known (non-random) configuration for testing.
      Also Creates Solution to be compared to
      @param pileSizes an array of numbers whose sum is 45
   */
   public Piles(int[] pileSizes)
   {
      piles = new ArrayList<>();
      for (int s : pileSizes)
         piles.add(s);
      for(int i = 1; i < 10; i++)
         solution.add(i);
   }

   /**
    * Creates a set of piles with an unknown configuration for application
    * Also Generates Solution to be compared with
    */
   public Piles()
   {
      for(int i = 1; i < 10; i++)
         solution.add(i);
      
      //Temp List
      ArrayList<Integer> pileSizes = new ArrayList<Integer>(); 
      //Several Sentry Variables
      boolean cont = true; 
      int update = 0;
      int randNum;
      boolean zero_cont;
      while (cont == true)
      {
           zero_cont = false;
           if (update < 45)//make sure sum is 45
              {
               while (zero_cont == false)
               {
                   randNum = random.nextInt(46-update);
                   if (randNum != 0)//Just to prevent number from being 0
                   {
                       pileSizes.add(randNum);
                       zero_cont = true;
                   }
                }
            }
           else
              cont = false;
           update = 0;
           for (int i = 0; i < pileSizes.size(); i++) //Updates sum sentry
              update += pileSizes.get(i);
      }
      //Sets temp list to main list
      piles = pileSizes;
      
   }
   
   /**
    * Return the string representation of the piles.
    * @return the string representation of the piles.
    */
   public String toString()
   {
       String keyphrase = "[";
       for (int i = 0; i < piles.size(); i++)
       {   
            if (i == piles.size() - 1)//Purely for formatting
                keyphrase += piles.get(i);
            else
                keyphrase += piles.get(i) + ", ";
       }
       keyphrase += "]";
       return keyphrase;
   }

   /**
    * Returns whether or not a solution has been found
    */
   public boolean getStatus()
   {
       return this.complete;
   }
   
   /**
      Play one round of the game.
   */
   public void playRound()
   {
        numOfPiles = piles.size();//Finds how many piles exist
        for (int i = 0; i < piles.size(); i++)//Runs the loop for amount of piles
        {
            piles.set(i, piles.get(i) - 1);
        }
        piles.add(numOfPiles); //taking 1 from amount of piles == add 1 for each pile
        for (int i = 0; i< piles.size(); i++)
        {                                  
            if (piles.get(i) == 0)//Sees if any piles = 0;
               {
                   piles.remove(i);  
                   i--;//Resets the counter back one not to skip an index
               }
        }
        count += 1;//Keeps track of amount of rounds ran
        if (numOfPiles == 9)
        {
            sorted = (ArrayList)piles.clone();//Creates a clone of base array
            Collections.sort(sorted);//Uses Collections class to sort
            if (sorted.equals(solution))
               this.complete = true;//Breaks loop when solution found
              
        }
        if (this.complete == true)//Prints text to find solution
        {
            System.out.println("The Solution has been found in " + count + " rounds!");
        }
   }
}
