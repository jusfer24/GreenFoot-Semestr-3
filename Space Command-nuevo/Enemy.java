import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 4;  // Velocidad de movimiento
    private int direction = 1; 
    private int jaque = 0; 
    private int timer = 0; 
    private int rango = 50; // Amplitud del zigzag
    private int abajo = 2; 
    //// Temporizador para la espera
    public void act()
    {
        
    }
    public void moveEnemy()
    {
        setLocation(getX(),getY()+2);
    }
    public void moveEnemy3()
    {
        setLocation(getX(),getY()+3);
    }
    public void moveDeviant()
    {
        setLocation(getX(), getY() + speed);

        if (getY() >= getWorld().getHeight() -485) { // Ajusta el número para el punto donde quieres que se detenga
            jaque = 1;
            speed = 0; 
        }
        if (jaque == 0) {
            moveEnemy(); 
        } else {
            timer++; 
            if (timer >= 680) {
                getWorld().removeObject(this); 
            }
        }
    }
    public void ZigZag()
    {
        // Moverse hacia abajo
        setLocation(getX() + (direction * 2), getY() + abajo);

        // Cambiar dirección si alcanza los límites del zigzag
        if (getX() <= rango || getX() >= getWorld().getWidth() - rango) {
            direction *= -1;  // Invertir la dirección
        }
    }
    public void removeFromWorld()
    {
        if (getY()==599)
        {
            getWorld().removeObject(this);
        }
    }
     public void EliminatePlayer()
    {
        // Verificamos si este enemigo está tocando al jugador (Liberty)
        Liberty player = (Liberty) getOneIntersectingObject(Liberty.class);
        
        if (player != null)  // Si está tocando al jugador
        {
            // Eliminar al jugador
            getWorld().removeObject(player);
            Gameover gameOverImage = new Gameover();
            getWorld().addObject(gameOverImage, getWorld().getWidth() / 2, getWorld().getHeight() / 3);
            getWorld().showText("You DIED press (PLAY) to Restart", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            Greenfoot.stop();

        }
     
    }

}
