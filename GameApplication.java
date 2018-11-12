import java.util.Random;
import java.util.Scanner;

public class GameApplication {
  public static final int LIST_SIZE = 7;
  public static int goal;
  public static int moves;
  public static String operators = "+x-/&";
  public static String numbers = "0123456789";
  /**
   * 
   * @param in: The user's input
   * @param gl: The goal that the user is trying to create in the list by manipulating the numbers in the list.
   * This method reads the input of the user.
   */
  public static void readInput(String in, GameList gl) {
    String numStr = "";
    for (int i = 0; i < in.length() - 1; i++) {
      numStr += in.charAt(i);
    }
    int num = Integer.parseInt(numStr);
    gl.applyOperatorToNumber(num, GameOperator.getFromChar(in.charAt(in.length()-1)));
    return;  
  }
  /**
   * 
   * @param in: The user's input
   * @return returns true if the input is vaild, or false if it is invalid.
   * This method checks whether the input is a valid input or not.
   */
  public static boolean inputValid(String in) {
    if (in.length() < 2) return false;
    for (int i = 0; i < in.length() - 1; i++) {
      if (numbers.indexOf(in.charAt(i)) == -1){
        return false;
      }
    }
    if (operators.indexOf(in.charAt(in.length()-1)) == -1) {
      return false;
    }
    return true;
  }
  
  /**
   * 
   * The main method activates the scanner, goal, and interface that the user faces.  It will end if the goal is reached.
   */
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    Random rand = new Random();
    goal = rand.nextInt(90) + 10;
    moves = 0;
    String input;
    GameList list = new GameList();
    for(int i = 0; i < LIST_SIZE; i++) {
      list.addNode(new GameNode(rand));
      

    }
    
    while(!list.contains(goal)) {
      System.out.println("Goal: " + goal + " Moves Taken: " + moves);
      System.out.println(list.toString());
      System.out.print("Number and Operation "+ GameOperator.ALL_OPERATORS +" to Apply: ");
      input = scnr.nextLine();
      input = input.trim();
      if (input.toLowerCase().equals("quit"))return;     
      if(inputValid(input)) {
        readInput(input, list);
        moves++;
      }else {
        System.out.println("Invalid input. Commands must be in number followed by operator format.");
        System.out.println("Example: 8x");
      }
      
    }
    System.out.println("Congratulations! You completed the game in " + (moves) + " moves");
    
  }
}