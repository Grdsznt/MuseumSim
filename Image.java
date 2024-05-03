import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * this class is to make images into actors so images can move, like setLocation()
 * 
 * @author Nick
 * @version Apr 31 2024
 */
public class Image extends SuperSmoothMover
{
    private String text;
    private boolean randomizeText;
    private int fontSize;
    private int actNum;
    private GreenfootImage image;
    private boolean firework;
    private double xVel, yVel;
    public Image(GreenfootImage image){
        this.image = image;
        setImage(image);
        actNum = 0;
        firework = false;
    }
    public Image(GreenfootImage image, String text){
        this.image = image;
        int a = Greenfoot.getRandomNumber(20) + 20;
        image.scale(a, a);
        setImage(image);
        actNum = 0;
        firework = true; xVel = 0; yVel = 0;
    }
    public Image(String text){
        fontSize = 40;
        randomizeText = true;
        this.text = text;
        GreenfootImage image = new GreenfootImage(text, fontSize, Color.BLACK, null);
        this.image = image;
        setImage(image);
        actNum = 0;
        firework = false;
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
        if(firework){
            if(isAtEdge()){
            getWorld().removeObject(this);
        }
        else{
            setLocation(getX() + xVel, getY() - yVel);
            int rate = 90;//decay rate
            if(xVel > 0){
                xVel -= xVel/rate;
            }
            else if(xVel < 0){
                xVel += xVel/rate;
            }
            yVel -= 0.5;//change in velocity applied
            
        }
        }
        actNum++;
    }
    public void followActor(Actor a, int offsetX, int offsetY){
        setLocation(a.getX() + offsetX, a.getY() + offsetY);
    }
    public void setVel(double xVel, double yVel){
        this.xVel = xVel; this.yVel = yVel;
    }
}
