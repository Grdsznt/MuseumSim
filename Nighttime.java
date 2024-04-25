import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 *
 */
public class Nighttime extends Effect
{
    /**
     * Creates an effect that lasts for 1200 acts, and targets 100 transparency.
     */
    public Nighttime(){
        super(600, 150);
    }
    public void addedToWorld(World w){
        if (!startAct) return;
        super.addedToWorld(w);
        
        // Setup the image.
        GreenfootImage img = new GreenfootImage(w.getWidth(), w.getHeight());
        img.setColor(Color.BLACK);
        img.fill();
        img.setTransparency(0);
        setImage(img);
        
        // Center on screen.
        setLocation(w.getWidth()/2, w.getHeight()/2);
    }
    public void act() {
        super.act();
    }
    /**
     * Starts the effect, increase robber spawn rate + # of robberies
     */
    public void startEffect() {

    }
    /**
     * Revert the effects
     */
    public void stopEffect() {
        
    }
    /**
     *  Changes stats for robbers 
     */
    private void setRobberStats(boolean time) {
        //robber
    }
}