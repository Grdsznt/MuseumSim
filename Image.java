import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * the actor will only be a image and nothing else
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Image extends Actor
{
    private String text;
    private boolean randomizeText;
    private int fontSize;
    private int actNum;
    private GreenfootImage image;
    public Image(GreenfootImage image){
        this.image = image;
        setImage(image);
        actNum = 0;
    }
    public Image(String text){
        fontSize = 40;
        randomizeText = true;
        this.text = text;
        GreenfootImage image = new GreenfootImage(text, fontSize, Color.BLACK, null);
        this.image = image;
        setImage(image);
        actNum = 0;
    }
    /**
     * Act - do whatever the Image wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //change text to random textof same length
        if(randomizeText){
            Random random = new Random();
            String randomText = "";
            
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    char randomChar = (char) (random.nextInt(26) + 'a'); // Replace with a random lowercase letter
                    randomText = randomText + randomChar;
                }
            }
            if (!randomText.isEmpty()) {
                setImage(new GreenfootImage(randomText, fontSize, Color.BLACK, null));
            }
            if(actNum >= 90){
                randomizeText = false;
            }
        }
        else{
            if(text != null){
                setImage(new GreenfootImage(text, fontSize, Color.BLACK, null));
            }
            
        }
        actNum++;
    }
    public void followActor(Actor a, int offsetX, int offsetY){
        setLocation(a.getX() + offsetX, a.getY() + offsetY);
    }
}
