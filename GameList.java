import java.util.Random;

public class GameList {
  private GameNode list; // reference to the first GameNode in this list

  /**
   * This initializes the game list to null
   */
  public GameList() {
    this.list = null;
  } // initializes list to start out empty

  /**
   * 
   * @param newNode: refers to the new node being added to the list. Checks if the list is empty, or
   *        has nodes in it already, then adds a node after the last node.
   */
  public void addNode(GameNode newNode) {
    if (this.list == null) {
      this.list = newNode;
      return;
    } else if (this.list.getNext() == null) {
      list.setNext(newNode);
      return;
    } else {
      GameNode iter = this.list;
      do {
        iter = iter.getNext();
      } while (iter.getNext() != null);
      iter.setNext(newNode);
      return;
    }
  } // adds the new node to the end of this list


  /**
   * 
   * @param number: The number which the user is checking the list for.
   * @return: Returns true if the list contains the number, false if it does not.
   */
  public boolean contains(int number) {
    if (this.list == null) {
      return false;
    } else {
      GameNode iter = this.list;
      // int test = 99; // Dummy value just to ensure loop is entered
      while (iter != null) {
        if (iter.getNumber() == number) {
          return true;
        } else {
          iter = iter.getNext();
        }
      }
      return false;
    }
  } // only returns true when this list contains a node with the specified number

  /**
   * Converts the string into an output that indicates the instructions for the user.
   */
  public String toString() {
    if (this.list == null)
      return "";
    String output = "";
    GameNode iter = this.list;
    output += iter.getNumber();
    output += " -> ";
    while (iter.getNext() != null) {
      iter = iter.getNext();
      output += iter.getNumber() + " -> ";
      // System.out.println("45");
    }
    output += "END";
    return output;
  } // returns a string with each number in the list separated by " -> "s, and ending with " -> END"

  /**
   * 
   * @param number: The user's input for which number they want to apply the operator on
   * @param operator: The user's input for which operation they want to perform on the specified
   *        number. This method iterated through the list looking for the specified number. Once it
   *        is found, it performs the mathematical operation specified by the user, then creates a
   *        new random node at the end of the list.
   */
  public void applyOperatorToNumber(int number, GameOperator operator) {
    if (!this.contains(number)) {
      return;
    } else {
      GameNode iter = this.list;
      int test;
      iterLoop: do {
        test = iter.getNumber();
        if (test == number) {
          break iterLoop;
        }
        System.out.println(test);

        iter = iter.getNext();
      } while (iter.getNext() != null && test != number);
      iter.applyOperator(operator);
      this.addNode(new GameNode(new Random()));
    }
  }
}
