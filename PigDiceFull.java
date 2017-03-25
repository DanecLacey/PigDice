import static java.lang.System.*;
import java.util.Scanner;
public class PigDiceFull {
  public static void main( String[] args ) {
    Scanner keyboard = new Scanner(System.in);
    int roll, ctot, ptot, turnTotal;
    String choice = "", init, init2;

    ptot = 0;
    ctot = 0;

    out.println("\n\nWelcome to PigDice! Enter INS for rules/instructions.");
    out.println("Or, \"roll\" the die to begin.\n\n");
    init = keyboard.next();

    while ( ! init.equals("roll") && ! init.equals("INS") ) {
      out.println("Please \"roll\" the die, or enter INS...");
      init = keyboard.next();
    }

      while (init.equals("INS") ) {
        out.println("\nPigDice is a game of chance VS. a computer.");
        out.println("\nThe starting player (human) rolls a six-sided die until they either roll a 1, or \"hold\".");
        out.println("\nIf the player rolls a 1, their points for the Round are not saved, and the die gets passed to the other player.");
        out.println("\nOn the other hand, if they do hold, their points are saved and added to the their total.");
        out.println("\nFirst player to 100 wins!\n\n");
        out.println("Please \"roll\" the die.\n");
        init = keyboard.next();
      }

        if ( init.equals("roll")) {


    do {
      // HUMAN turn start
      turnTotal = 0;
      out.println("--> You have " + ptot + " points.\n");

      do {
        roll = 1+(int)(Math.random()*6);
        out.println("\t\nYou rolled a " + roll + ".");
        if (roll == 1) {
          out.println("\tThat ends your turn.");
          turnTotal = 0;
        }
        else {
          turnTotal += roll;
          out.print("\t\n\nYou have " + turnTotal + " points");
          out.print( " so far this round. \n");
          out.print("\t\n--> Would you like to \"roll\" again?");
          out.print(" or \"hold\"?\t");
          choice = keyboard.next();
            while (!(choice.equals("roll") || choice.equals("hold"))) {
            out.println("\nI dont know what " + "\'" + choice + "\'" + " means.\n Please enter \"roll\" or \"hold\".");
            choice = keyboard.next();
          }
        }
      } while (roll != 1 && choice.equals("roll"));

      ptot += turnTotal;
      out.print("\t\nYou end the round with " + ptot + " points. ");

      if (ptot<100) {
        // CPU turn start
        turnTotal = 0;
        out.println("Computer has " + ctot + " points.\n");
        out.println("-------------------------------------------------------");

        do {
          roll = 1+(int)(Math.random()*6);
          out.println("Computer rolled a " + roll + ".");
          if (roll == 1) {
            out.println("That ends its turn.");
            turnTotal = 0;
          }
          else {
            turnTotal += roll;
            out.print("Computer has " + turnTotal);
            out.print(" points so far this round.");
            if (turnTotal < 20) {
              out.println("Computer will roll again.");
            }
            }
        } while (roll != 1 && turnTotal < 20);

          ctot += turnTotal;

        out.print("\n\nComputer ends the round with ");
        out.print( ctot + " points. \n");
        out.println("-------------------------------------------------------\n");
      }

  } while (ptot < 100 && ctot < 100);

  if (ptot > ctot) {
    out.println("Humanity wins!");
  }
  else {
    out.println("The computer wins.");
    }
    }
}
}
