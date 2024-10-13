import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tierra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tierra extends Actor
{
    /**
     * Act - do whatever the Tierra wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     private int speed = 4;
     private int timer = 0; 
    public void act()
    {
        movetierra();
        remover();
    }
    public void movetierra()
    {
        setLocation(getX(),getY()+speed);
    }
    public void remover()
    {
        if(getY() >= getWorld().getHeight()){
            getWorld().removeObject(this);
        }
    }
}

