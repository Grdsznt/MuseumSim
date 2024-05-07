import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * An effect that turns the world to night
 * @author David
 * @version May 2 2024
 */
public class Nighttime extends Effect
{
    private static SuperSound ambience = new SuperSound("nightTimeAmbience.mp3", 1, 50);
    /**
     * Creates an effect that lasts for 1200 acts, and targets 100 transparency.
     */
    public Nighttime(){
        super(600, 150);
        ambience = new SuperSound("nightTimeAmbience.mp3", 1, 50);
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
     * Resumes playing the ambience
     */
    public static void resumeAmbience() {
        ambience.play();
    }
    /**
     * Pauses the ambience
     */
    public static void pauseAmbience() {
        ambience.pause();
    }
    /**
     * Starts the effect, increase robber spawn rate + # of robberies
     */
    public void startEffect() {
        ambience.play();
        setRobberStats(true);
    }
    /**
     * Revert the effects
     */
    public void stopEffect() {
        ambience.pause();
        setRobberStats(false);
    }
    /**
     *  Changes stats for robbers based on the time of day
     *  
     *  @param isNight  Input for whether it is night time or not
     */
    private void setRobberStats(boolean isNight) {
        world.setTime(isNight); 
        
        List<Robber> robbers = getWorld().getObjects(Robber.class);
        for (Robber r: robbers) {
            r.setSpeed(5);
        }
    }
}