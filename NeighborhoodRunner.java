import org.code.neighborhood.*;

public class NeighborhoodRunner {
  public static void main(String[] args) {
    backgroundPainter bob = new backgroundPainter();

    //Paints background from backgroundPainter class
    bob.background("yellow", 16);

    //instantiates a gary painter
    garyPainter gary = new garyPainter();
    //runs gary method in gary class
    gary.gary();
  }
}