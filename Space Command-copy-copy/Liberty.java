import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Liberty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Liberty extends Actor
{
    /**
     * Act - do whatever the Liberty wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveAround();
    }
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("right"))
        {
          move(4);  
        }
        if(Greenfoot.isKeyDown("left"))
        {
          move(-4);  
        }
    }
}
