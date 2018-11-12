import java.util.Random;
public class GameNode {
  private int number;
  private GameNode next;
  
  public GameNode(Random rng) {
    this.next = null;
    this.number = rng.nextInt(9) + 1;

  }
  
  public int getNumber() {
    return this.number;
  }
  
  public GameNode getNext() {
    return this.next;
  }
  
  public void setNext(GameNode next) {
    this.next = next;
  }
  
  public void applyOperator(GameOperator operator){
    switch(operator.toString()) {
      case "+":
        this.number += this.next.getNumber();
        break;
      case "-":
        this.number -= this.next.getNumber();
        break;
      case "x":
        this.number = this.number * this.next.getNumber();
        break;
      case "/":
        this.number = this.number / this.next.getNumber();
        break;
      case "&":
        this.number = Integer.parseInt("" + this.number + "" + this.next.getNumber());
        break;
    }
    this.next = this.next.getNext();
  }
}
