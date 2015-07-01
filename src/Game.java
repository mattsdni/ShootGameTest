import processing.core.PApplet;

/**
 * Created by Matt on 6/27/2015.
 */
public class Game extends PApplet
{
    public static void main(String args[])
    {
        PApplet.main(new String[]{"Game"});
    }

    Player player1;
    boolean[] downKeys = new boolean[256];
    ProjectileHandler projectileHandler;

    public void setup()
    {
        size(800,800);
        projectileHandler = new ProjectileHandler();
        player1 = new Player(this, projectileHandler);
    }

    public void draw()
    {
        background(50);
        player1.display();
        checkKeys();
        projectileHandler.update();
        projectileHandler.display();
    }

    public void mouseReleased()
    {
        player1.shoot();
    }

    public void checkKeys()
    {
        for (int i = 0; i < downKeys.length; i++)
        {
            if (downKeys[i])
            {
                if((char)i == 'w')
                {
                    if (player1.y-player1.size/2 > 0)
                        player1.y-=5;
                }
                if ((char)i == 'a')
                {
                    if (player1.x-player1.size/2 > 0)
                        player1.x-=5;
                }
                if ((char)i == 's')
                {
                    if (player1.y+player1.size/2 < height)
                        player1.y+=5;
                }
                if ((char)i == 'd')
                {
                    if (player1.x+player1.size/2 < width)
                        player1.x+=5;
                }

            }
        }

    }

    public void keyPressed()
    {
        if (key<256)
        {
            downKeys[key] = true;
        }
    }

    public void keyReleased()
    {
        if (key<256)
        {
            downKeys[key] = false;
        }
    }
}
