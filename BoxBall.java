import java.awt.*;
import java.awt.geom.*;
/**
 * Class BoxBall- a ball that moves within the constraints of a canvas
 *
 * @author Darnell Stovall
 * @version 2018.10.22
 */
public class BoxBall
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private int xBoundary;
    private int yBoundary;
    private int xspd = 7;
    private int yspd = 7;
    
    private Canvas canvas;
    
 /**
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int groundPos, Canvas drawingCanvas)
 {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        canvas = drawingCanvas;
 }
 
 /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

 /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }
    
 /**
  * Checks the x boundaries to keep the ball(s) inside
  */
    private void checkxBoundary()
    {
        if(xPosition < (xBoundary - diameter))
        {
          xspd = 7;  
        }
        if(xPosition >= (xBoundary - diameter))
        {
          xspd = -7;
        }
    }
    
 /**
  * Checks the y boundaries to keep the ball(s) inside
  */
    private void checkyBoundary()
    {
        if(yPosition < (yBoundary - diameter))
        {
          yspd = 7;  
        }
        if(yPosition >= (yBoundary - diameter))
        {
          yspd = -7;
        }
    }
    public void move()
    {
        xBoundary = 500-diameter;
        yBoundary = 300-diameter;
          erase(); //remove from canvas at the current position
            
            xPosition += xspd; //compute new position
            yPosition += yspd;
            
            if(xPosition >= xBoundary)
              checkxBoundary();
            if(xPosition <=0)   
              checkxBoundary();
              
            if(yPosition >= yBoundary)
              checkyBoundary();
            if(yPosition <=0)   
              checkyBoundary();
          
          draw();   
    }
   /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }  
}