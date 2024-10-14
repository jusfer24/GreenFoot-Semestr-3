import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy4 extends Enemy
{
    /**
     * Act - do whatever the Enemy4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     private GreenfootImage[] images = {
        new GreenfootImage("Enemy4.png"),
        new GreenfootImage("Enemy4.1.png"),
        new GreenfootImage("Enemy4.2.png")
    };
    
    // Constructor de la clase Enemy
    public Enemy4()
    {
        int randomIndex = Greenfoot.getRandomNumber(images.length); // Seleccionar una imagen al azar
        setImage(images[randomIndex]);  // Cambiar la imagen del enemigo
    }
    
    public void act()
    {
        ZigZag();
        
        EliminatePlayer();
        removeFromWorld();
    }
}
