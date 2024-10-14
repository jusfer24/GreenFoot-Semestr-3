import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stars here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stars extends Actor
{
    /**
     * Act - do whatever the Stars wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 4;
    public void act()
    {
        moveStars();
        removeIfOutOfBounds();
    }
    public void moveStars()
    {
        setLocation(getX(),getY()+speed);
    }
    public void removeIfOutOfBounds()
    {
        if(getY() >= getWorld().getHeight()){
            getWorld().removeObject(this);
        }
    }
}
