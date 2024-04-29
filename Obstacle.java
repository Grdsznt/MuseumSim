sxcimport greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Valuable Objects found in each room 
 */
public class Obstacle extends Actor 
{
    private int hitBoxTop, hitBoxBot, hitBoxLeft, hitBoxRight, width, height;
    public Obstacle(int width, int height){
        // setHitBox(width, height);
        this.width = width; this.height = height;
        this.setImage(new GreenfootImage(width, height));
        
        // GreenfootImage img = new GreenfootImage(width, height);
        // img.setColor(new Color(0, 0, 0, 255));
        // img.fill();
        // this.setImage(img);
    }
    /**
     * Act - do whatever the Object wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
    public void setHitBox(int width, int height){
        if(this != null){
            hitBoxTop = getY() - (int)(height/2);
            hitBoxBot = getY() + (int)(height/2);
            hitBoxLeft = getX() - (int)(width/2);
            hitBoxRight = getX() + (int)(width/2);
        }
    }
    public void checkHitBox(int x, int y){
        
    }
}
