import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rayo3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rayo3 extends Rayo2
{
   /**
     * Act - do whatever the Rayo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int speed = 2;  // Velocidad de movimiento
    private int jaque = 0; // verificar en aparicion 
    private int mate = 0; // verificar movimiento( por si acaso leen esto Justin y no le entiendes me preguntas) :)
    
    private int timer = 0;  // Timer para desaparecer el rayo después de un tiempo
    private int appearDelay = 470; // Tiempo para que el rayo aparezca (3 segundos)
    

    public Rayo3()
    {
        GreenfootImage initialImage = new GreenfootImage("rasho2.png");
        initialImage.setTransparency(100); 
        setImage(initialImage);
    }

    public void act()
    {
        if (jaque == 0) {  // Si aún no es visible, se maneja el temporizador de aparición
            appearDelay--;
            if (appearDelay <= 0) {
                GreenfootImage visibleImage = new GreenfootImage("rasho.png");
                visibleImage.setTransparency(255);
                setImage(visibleImage); // Hacer visible el rayo
                jaque = 1;
                EliminatePlayer();
            }
        } else {
            moveRayo3(); // Comienza a moverse una vez que es visible
        }
    }
    public void moveRayo3()
    {
        setLocation(getX(), getY() + speed);

        if (getY() >= getWorld().getHeight() -385) { // Ajusta el número para el punto donde quieres que se detenga
            mate = 1;
            speed = 0; 
        }
        if (mate == 0) {
            moveEnemy(); 
        } else {
            timer++; 
            if (timer >= 100) {
                getWorld().removeObject(this); 
            }
        }
    }
}
