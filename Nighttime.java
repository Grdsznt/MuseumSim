import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 *
 */
public class Nighttime extends Effect
{
    private static SuperSound ambience;
    /**
     * Creates an effect that lasts for 600 acts, and targets 150 transparency.
     */
    public Nighttime(){
        super(600, 150);
        ambience = new SuperSound("nightTimeAmbience.mp3", 1, 40);
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
    /** 
     * Plays the ambience
     */
    public static void playAmbience() {
        ambience.play();
    }
    /** 
     * Stops the ambience
     */
    public static void stopAmbience() {
        ambience.pause();
    }
    public void act() {
        super.act();
    }
    /**
     * Starts the effect, increase robber spawn rate + # of robberies
     */
    public void startEffect() {
        // Start ambient noise
        ambience.play();
        setRobberStats(false); // Set the Robbers stats to when it is night
    }
    /**
     * Revert the effects
     */
    public void stopEffect() {
        // Stop ambient noise
        ambience.stop();
        setRobberStats(true); // Set the Robbers stats to when it is day
    }
    /**
     *  Changes stats for robbers based on the time of day
     *  @param daytime Checks for if it is daytime or not
     */
    private void setRobberStats(boolean daytime) {
        world.setTime(daytime); //update time in the world 
        
        // Changes all Robbers to move at a set speed
        List<Robber> robbers = getWorld().getObjects(Robber.class);
        for (Robber r: robbers) {
            r.setSpeed(5);
        }
    }
}