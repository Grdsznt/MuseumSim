import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Object extends Actor
{
    private int hitBoxTop, hitBoxBot, hitBoxLeft, hitBoxRight;
    public Object(){
        
    }
    /**
     * Act - do whatever the Object wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
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
