import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by Matt on 6/27/2015.
 */
public class Projectile
{
    PApplet p;
    PVector v;
    int size;
    float x,y;
    boolean offscreen;

    public Projectile(PApplet _p, float vx, float vy, float _x, float _y)
    {
        p = _p;
        size = 10;
        v = new PVector(vx,vy);
        x = _x+v.x*10;
        y = _y+v.y*10;
        offscreen = false;

    }

    public void display()
    {
        x += v.x*10;
        y += v.y*10;
        p.ellipse(x,y,size,size);
        if (x < 0 || x > p.width || y < 0 || y > p.height)
        {
            offscreen = true;
        }
    }

}
