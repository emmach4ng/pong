import java.awt.*;

public class Paddle {
    
    //positions
    int x; //class scope
    int y;
    int length;
    int width;

    public Paddle(int x, int y) { //local scope
        this.x = x;
        this.y = y;
        this.width = 10;
        this.length = 50;
    }

    void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(this.x, this.y, this.width, this.length);
    }

}
