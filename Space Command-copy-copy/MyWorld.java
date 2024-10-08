import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(380, 600, 1);
        
        // Añadir enemigos al mundo antes de la nave
        for (int i = 0; i < 5; i++) {  // Número de enemigos que quieres que aparezcan al inicio
            addEnemy1();  // Añadir enemigos al azar
        }
        
        // Crear la nave
        Liberty ship = new Liberty();
        // Añadir la nave al último para que esté al frente
        addObject(ship, 190, 450);
    
    }
    
    public void act()
    {
        //addStars(); // Generar estrellas constantemente
        if(Greenfoot.getRandomNumber(60) < 1)
        {
            addEnemy1(); // Añadir enemigos de manera aleatoria
        }
    }

    public void addStars()
    {
        addObject(new Stars(), Greenfoot.getRandomNumber(380), 0); // Añadir estrellas al azar en la parte superior
    }

    public void addEnemy1()
    {
        addObject(new Enemy1(), Greenfoot.getRandomNumber(380), 0); // Añadir enemigos en la parte superior
    }
}
