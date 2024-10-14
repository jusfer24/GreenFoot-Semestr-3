import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color; // Importar el color de Greenfoot
import java.io.*;  // Importar clases para manejar archivos
/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int score = 0;  // Puntuación inicial
    private static int highScore = 0;
    private static final String FILE_NAME = "highscore.txt"; // Nombre del archivo para guardar el high score
 
    public Counter() {
        loadHighScore(); // Cargar el high score desde el archivo al iniciar
        updateImage();  // Actualizar la imagen del contador cuando se crea
    }

    // Método llamado para agregar puntos al score
    public void addPoints(int points) {
        score += points;
        if (score > highScore) {
            highScore = score;  // Actualizar high score
            saveHighScore();    // Guardar high score en el archivo
        }
        updateImage();  // Actualizar la imagen del contador
    }
    public int getHighScore() {
    return highScore;  // Cambia 'highScore' por la variable que estés usando para almacenar el mejor puntaje
    }

    // Guardar el high score en un archivo
    private void saveHighScore() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(Integer.toString(highScore));
        } catch (IOException e) {
            System.out.println("Error al guardar el high score: " + e.getMessage());
        }
    }
    // Cargar el high score desde un archivo
    private void loadHighScore() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            highScore = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("No se pudo cargar el high score, empezando desde 0.");
            highScore = 0;
        }
    }
    
    // Método que actualiza la imagen del contador
    private void updateImage() {
        setImage(new GreenfootImage("Score: " + score, 38, greenfoot.Color.RED, null));
    }

    // Método act() para comportamiento general
    public void act() {
        // Este es el comportamiento general que ocurre en cada frame, si es necesario.
    }
}
