import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


 /**

  * Write a description of class Liberty here.
  * 
  * @author (your name)
  * @version (a version number or a date)
*/
public class Liberty extends Actor
{

     private GreenfootSound shoot;
     private int fireCooldown;
     public Liberty() {
         GreenfootImage image = getImage();
        
        // Establecer el nuevo tamaño (por ejemplo, reducir al 50%)
        int newWidth = image.getWidth() * 2 / 3;   // Reduce el ancho al 50%
        int newHeight = image.getHeight() * 2 / 3; // Reduce la altura al 50%
        
        // Escalar la imagen
        image.scale(newWidth, newHeight);
        
        // Asignar la imagen escalada de nuevo al actor
        setImage(image);
        //
        shoot = new GreenfootSound("disparar.mp3"); 
        // Cambia "shootSound.mp3" por el nombre de tu archivo de sonido
        fireCooldown = 0;
    }
    
 /**    
  * Act - do whatever the Liberty wants to do. This method is called whenever
  * the 'Act' or 'Run' button gets pressed in the environment.
    */
public void act()
{
    moveAround();
    fireProjectile();
    if(fireCooldown > 0){
        fireCooldown--;
    }
}
public void moveAround()
{
    if(Greenfoot.isKeyDown("right")){
      move(4);
    }
    if(Greenfoot.isKeyDown("left")){
      move(-4);
    }
}
public void fireProjectile(){
    if(Greenfoot.isKeyDown("space")&& fireCooldown ==0 ){
      shoot.play();
      getWorld().addObject(new Bala(),getX(),getY()-40);
      fireCooldown = 80;
    }}
}
