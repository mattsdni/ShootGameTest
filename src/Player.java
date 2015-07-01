import processing.core.PApplet;

import java.util.LinkedList;

/**
 * Created by Matt on 6/27/2015.
 */
public class Player
{
    PApplet p;
    float x,y;
    int size;
    float mid;
    ProjectileHandler projectileHandler;

    public Player(PApplet _p, ProjectileHandler _projectileHandler)
    {
        p = _p;
        x = p.width/2;
        y = p.height/2;
        size = 50;
        mid = 0;
        projectileHandler = _projectileHandler;
    }

    public void display()
    {
        p.fill(255);
        p.ellipse(x, y, size, size);
        p.noFill();
        p.stroke(255);

        p.pushMatrix();
        p.translate(x, y);
        float mid = p.atan2(p.mouseY - y, p.mouseX-x);
        p.popMatrix();

        p.arc(x, y, size * 1.5f, size * 1.5f, mid - .2f, mid + .2f);

    }

    public void shoot()
    {
        mid = p.atan2(p.mouseY - y, p.mouseX-x);
        projectileHandler.add(new Projectile(p, p.cos(mid), p.sin(mid), x, y));
    }
}
