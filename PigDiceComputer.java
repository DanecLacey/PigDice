import static java.lang.System.*;
//import java.util.Scanner;
//hold at 20 strategy
public class PigDiceComputer {
  public static void main( String[] args ) {
    int roll, total;
    total = 0;

    do {
      roll = 1+(int)(Math.random()*6);
      out.println("Computer rolled a " + roll + ".");
      if (roll == 1) {
        out.println("\tThat ends its turn.");
      }
      else {
        total += roll;
        out.print("\tComputer has " + total);
        out.print(" points so far this round.\n");
        if (total < 20) {
          out.println("\tComputer will roll again.");
        }
      }
    } while (roll != 1 && total < 20);

    out.println("Computer ends the round with " +total + " points.");
  }
}
