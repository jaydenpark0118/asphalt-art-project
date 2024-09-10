import org.code.neighborhood.*;

public class garyPainter extends backgroundPainter {

  //executes everything
  public void gary() {
    move("eyes");
    eyes();
    move("body");
    body();
    move("shell");
    shell();
  }
  /*
  Will move to a specific part on the grid
  Depends on what part of the body is inputted
  */
  public void move(String part) {
    if(part == "eyes") {
      turnRight();
      while(getY() != 2) {
        move();
      }
      turnLeft();
    } else if(part == "body") {
      turnRight();
      move();
      turnRight();
      while(getX() != 1) {
        if(getX() == 4) {
          paintLine("black", 1);
        }
        move();
      }
      turnLeft();
    } else if (part == "shell") {
      turnLeft();
      while(getX() != 9) {
        move();
      }
      turnLeft();
      while(getY() != 2) {
        move();
      }
    }
    
  }
  /*
  Paints just the eye area
  Makes the outline first and then paints the inside specific colors 
  depending on what space it is on
  */
  public void eyes() {
    //outline
    setPaint(19);
    for(var i = 0; i < 6; i++) {
      if(i == 2 || i == 3 || i == 5) {
        turnRight();
      }
      move();
      paintLine("black", 3);
  }
    //colors in the eyes
    turnRight();
    move();
    turnRight();
    move();
    turnLeft();
    setPaint(21);
    while(hasPaint()) {
      if(getX() == 7 || getX() == 3 || (getY() == 5 && getX() != 4)) {
        paint("darkkhaki");
      } else if(getX() == 4 || (getX() == 5 && getY() == 4) || (getX() == 1 && getY() == 4)) {
        paint("black");
      } else {
        paint("firebrick");
      }
      move();
      if(getX() == 7 && getY() == 3) {
        paint("darkkhaki");
        turnRight();
        move();
        turnRight();
      } else if(getX() == 1 && getY() == 4) {
        paint("black");
        turnLeft();
        move();
        turnLeft();
      }
    }
  }

  public void body() {
    /*
    Paints the detailed body
    will do neck first and then body
    */
    paintLine("black", 8);
    turnRight();
    move();
    paintLine("black", 1);
    turnAround();
    move();
    turnRight();
    move();
    turnLeft();
    paintLine("black", 15);
    turnLeft();
    move();
    paintLine("black", 1);
    turnLeft();
    move();
    paintLine("black", 7);
    turnRight();
    move();
    turnLeft();
    paintLine("black", 2);
    turnRight();
    paintLine("black", 2);
    turnRight();
    paintLine("black", 3);
    turnAround();
    move();
    move();
    turnRight();
    paintLine("black", 3);
    turnRight();
    move();
    paintLine("black", 1);
    turnAround();
    move();
    move();
    move();
    move();
    turnLeft();
    paintLine("black", 2);
    move();
    move();
    move();
    turnRight();
    move();
    paintLine("black", 2);
    turnAround();
    move();
    move();
    turnLeft();
    move();
    paintLine("black", 5);
    turnLeft();
    move();
    turnLeft();
    move();
    paintLine("skyblue", 5);
    move();
    turnLeft();
    paintLine("skyblue", 6);
    while(getX() != 15) {
      move();
    }
    turnRight();
    move();
    turnRight();
    move();
    //paints body a color pattern
    while(getX() != 2) {
      paintLine("turquoise", 2);
      paintLine("skyblue", 2);
    }
    paintLine("turquoise", 2);
    turnAround();
    move();
    move();
    move();
    move();
    turnLeft();
    move();
    move();
    paintLine("skyblue", 3);
    paintLine("turquoise", 1);
    turnAround();
    move();
    turnLeft();
    move();
    turnLeft();
    paintLine("skyblue", 2);
    paintLine("turquoise", 1);
    turnRight();
    move();
    turnRight();
    move();
    paintLine("skyblue", 1);
  }
//paints the shell
  public void shell() {
    turnRight();
    paintLine("black", 1);
    turnLeft();
    move();
    turnRight();
    paintLine("black", 4);
    turnRight();
    move();
    paintLine("black", 1);
    turnLeft();
    move();
    turnLeft();
    move();
    turnAround();
    move();
    paintLine("black", 8);
    turnRight();
    move();
    turnLeft();
    paintLine("black", 1);
    turnRight();
    move();
    paintLine("black", 1);
    setPaint(74);
    //depends on what colors the line of the shell needs
    /*
    Depending on part of shell, it will need certain colors and a variable to show where certain colors go
    */
    int end = 0;
    int dark = 0;
    int purp = 0;
    for(var j = 0; j < 11; j++) {
      if(j <= 5 || j == 7) {
        if(j == 0 || j == 2) {
          dark = 10;
          end = 7;
        } else if (j == 1) {
          dark = 10;
          end = 14;
        } else if (j == 3) {
          dark = 10;
          end = 15;
        } else if (j == 4) {
          move();
          dark = 10;
          end = 6;
        } else if (j == 5) {
          move();
          move();
          dark = 10;
          end = 15;
        } else if (j == 7) {
          move();
          move();
          dark = 12;
          end = 15;
        }
        while(getX() != end) {
          if(getX() != dark) {
            paint("salmon");
          } else {
            paint("darkred");
          }
          move();
        }
      } else if (j >= 6 && j <= 9) {
        if(j == 6) {
          move();
          end = 7;
          dark = 11;
          purp = 9;
        } else if (j == 8) {
          move();
          end = 8;
          dark = 0;
          purp = 10;
        } else if (j == 9) {
          move();
          end = 15;
          dark = 0;
          purp = 12;
        }
        
        while(getX() != end) {
          if(getX() != dark && getX() != purp) {
            paint("salmon");
          } else if (getX() == purp) {
            paint("mediumorchid");
          } else {
            paint("darkred");
          }
          move();
        }
      } else if (j == 10) {
        move();
        move();
        paintLine("salmon", 4);
      }
      if(j % 2 == 0 && j != 0) {
        turnRight();
        move();
        turnRight();
      } else if (j == 0) {
        move();
        turnRight();
        move();
        turnRight();
      } else {
        turnLeft();
        move();
        turnLeft();
      }
    }
    while(getX() != 13) {
    move();
    turnRight();
    move();
    turnLeft();
    }
    turnRight();
    paintLine("darkred", 4);
    turnRight();
    move();
    paintLine("darkred", 1);
  }
}