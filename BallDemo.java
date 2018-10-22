import java.awt.Color;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 * 
 * @author Darnell Stovall
 * @version 2018.10.22
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulates 5 bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BoxBall ball = new BoxBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BoxBall ball2 = new BoxBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();
        BoxBall ball3 = new BoxBall(45, 30, 10, Color.GREEN, ground, myCanvas);
        ball3.draw();
        BoxBall ball4 = new BoxBall(30, 25, 15, Color.BLACK, ground, myCanvas);
        ball4.draw();
        BoxBall ball5 = new BoxBall(60, 20, 25, Color.GREEN, ground, myCanvas);
        ball5.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
