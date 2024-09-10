import org.code.neighborhood.*;
public class backgroundPainter extends PainterPlus{

  // paints the background in lines and turns at each end
  public void background(String color, int amt) {
  while(canMove("South")) {
    paintLine(color, amt);
    if(getY() % 2 == 0) {
      turnRight();
      move();
      turnRight();
    } else {
      turnLeft();
      move();
       turnLeft();
     }
   }
   paintLine(color, amt);
  }

  //paints one line depending on the color and amount inputted
  public void paintLine(String color, int amt) {
    setPaint(amt);
    while(hasPaint()) {
      paint(color);
      if(canMove()) {
        move();
      }
    }
  }
}