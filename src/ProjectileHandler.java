import java.util.LinkedList;

/**
 * Created by Matt on 6/27/2015.
 */
public class ProjectileHandler
{
    private LinkedList<Projectile> projectiles;

    public ProjectileHandler()
    {
        projectiles = new LinkedList<Projectile>();
    }

    public void update()
    {
        for (int i = 0; i < projectiles.size(); i++)
        {
            if (projectiles.get(i).offscreen)
            {
                projectiles.remove(i);
            }
        }
    }
    public void display()
    {
        for (Projectile p : projectiles)
        {
            p.display();
        }
    }

    public void add(Projectile p)
    {
        projectiles.add(p);
    }

}
