import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bala extends Actor
{
    /**
     * Act - do whatever the Bala wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        BalaMove();
        removeFromWorld();
    }
    public void BalaMove()
    {
        setLocation(getX(),getY()-5);
    }
    
   public void removeFromWorld()
    {
        Actor enemy1 = getOneIntersectingObject(Enemy1.class);
        Actor enemy2 = getOneIntersectingObject(Enemy2.class);
        Actor enemy3 = getOneIntersectingObject(Enemy3.class);
    if (enemy1 != null || enemy2 != null || enemy3 != null) {
        // Encontrar el contador en el mundo
        Counter counter = (Counter) getWorld().getObjects(Counter.class).get(0);
        
        // Incrementar el score en 10 puntos por cada enemigo
        counter.addPoints(10);  // Ajusta el número de puntos según sea necesario
        
        // Eliminar los enemigos si existen
        getWorld().removeObject(enemy1);
        getWorld().removeObject(enemy2);
        getWorld().removeObject(enemy3);
        
        // Eliminar el actor actual
        getWorld().removeObject(this);
    } else if (getY() == 0) {
        // Si el objeto ha llegado al borde de la pantalla
        getWorld().removeObject(this);
    }
    }
}
