import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int enemyCount = 0; // Para controlar cuándo generar un nuevo enemigo
    int enemy1Counter1 = 0;
    int enemy1Counter2 = 0;
    int enemy1Counter3 = 0;// Contador para los Enemy1 generados
    int DeviantLimit = 45;
    int Enemy4Limit= 5;
    int Enemy3Limit= 2;

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(380, 600, 1);

        Tierra earth = new Tierra();
        addObject(earth, 320, 550);

        Titulo titio = new Titulo();
        addObject(titio, 190, 450);

        // Crear la nave
        Liberty ship = new Liberty();
        // Añadir la nave al último para que esté al frente
        addObject(ship, 242, 470);
        prepare();
    }

    public void act()
    {
        
        if (Greenfoot.isKeyDown("enter")) {
            reiniciar();
        }
        
        enemyCount++;

        
        if (enemyCount > 80)
        {
            //addStars();
            addEnemy1();
            enemyCount = 0; // Reiniciar el contador
            enemy1Counter1++; // Aumentar el contador de Enemy1
            enemy1Counter2++; 
            enemy1Counter3++; 
            
            // Si se han generado 15 Enemy1, generar los 3 Deviants
            if (enemy1Counter1 >= DeviantLimit)
            {
                addRayo();
                addDeviant();
                addRayo2();
                addDeviant2();
                addRayo3();
                addDeviant3();
                addEnemy4();
                addEnemy3();
                enemy1Counter1 = 0; // Reiniciar el contador de Enemy1 para el próximo ciclo
            }
            if (enemy1Counter2 >= Enemy4Limit)
            {
                addEnemy4();
                enemy1Counter2 = 0; // Reiniciar el contador de Enemy1 para el próximo ciclo
            }
            if (enemy1Counter3 >= Enemy3Limit)
            {
                addEnemy3();
                enemy1Counter3 = 0; // Reiniciar el contador de Enemy1 para el próximo ciclo
            }
        }
    }

    public void addEnemy1()
    {
        addObject(new Enemy1(), Greenfoot.getRandomNumber(380), 0); // Añadir enemigos en la parte superior
    }
    
    public void addEnemy3()
    {
        addObject(new Enemy3(), Greenfoot.getRandomNumber(380), 0); // Añadir enemigos en la parte superior
    }
    
      public void addRayo()
    {
        addObject(new Rayo(), 83, 380); // Posicionar Deviant
    }

    public void addDeviant()
    {
        addObject(new Deviant(), 80, 0); // Posicionar Deviant
    }
     
      public void addRayo2()
    {
        addObject(new Rayo2(), 193, 380); // Posicionar Deviant
    }
   
    public void addDeviant2()
    {
        addObject(new Deviant(), 190, 0); // Posicionar Deviant
    }
    
      public void addRayo3()
    {
        addObject(new Rayo3(), 303, 380); // Posicionar Deviant
    }
    
    public void addDeviant3()
    {
        addObject(new Deviant(), 300, 0); // Posicionar Deviant
    }
    
    public void Gameover()
    {
        addObject(new Gameover(), 300, 0); // Posicionar Deviant
    }
    
    public void addStars()
    {
        addObject(new Stars(), Greenfoot.getRandomNumber(380), 0); // Posicionar Deviant
    }
    
    public void addEnemy4()
    {
        addObject(new Enemy4(), 300, 0); 
        addObject(new Enemy4(), 100, 0);// Añadir enemigos en la parte superior
    }
    
      public void reiniciar() {
          Greenfoot.setWorld(new MyWorld());  // Reinicia el mundo creando una nueva instancia
     }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
    }
}

