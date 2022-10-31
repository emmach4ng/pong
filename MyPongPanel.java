import javax.swing.JPanel;
import java.awt.*;

public class MyPongPanel extends JPanel {
    /* Oh no! It seems like we have misplaced our Paddle class file! 
    Could you recreate it, so we can play a friendly game of pong?
    If you want to see how the code behaves,
    you can comment out any code regarding the Paddle class. 
    */
    Paddle one; 
    Paddle two;
    Ball b; 

    MyPongPanel() {
        one = new Paddle(40, 250);
        two = new Paddle(450, 250);
        b = new Ball(45);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // ignore this part 
        super.paintComponent(g);

        //draw paddles
        one.draw(g);
        two.draw(g);

        // draw ball
        b.draw(g);
    }

    public void play() throws InterruptedException
	{
		while(true)
		{
            //move the ball a little bit
            b.x += b.dx;
            b.y += b.dy;

            // hit vertical wall 

            // hit top or bottom
            if( b.y+b.diameter >= getHeight() || b.y < 0 )
            {
                b.dy = -1*b.dy;
            }

            //check for collision with paddles
            // I'm not sure what's happening with my code but the ball switches direction when it hits some area adjacent to
            // the left paddle and I can't find what's causing it. The balls also skids along the right paddle instead of bouncing
            boolean rightEdge = b.x + b.diameter >= getWidth();
            boolean inRightX = b.x + b.diameter >= two.x && b.x <= two.x + two.width;
            boolean inRightY = b.y + b.diameter >= two.y && b.y <= two.y + two.length;
            boolean inLeftX = b.x >= one.x && b.x <= one.x + one.width;
            boolean inLeftY = b.y >= one.y && b.y <= one.y + one.length;

            if((rightEdge || b.x < 0) || (inRightX && inRightY || inLeftY && inLeftX)) 
            {
                b.dx = -1*b.dx;
            }
        
            repaint();

            Thread.sleep(10);
        }
	}
    }