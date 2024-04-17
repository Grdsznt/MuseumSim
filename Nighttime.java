import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NightTime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nighttime extends Effect
{
    /**
     * Creates an effect that lasts for 1200 acts, and targets 100 transparency.
     */
    public Nighttime(){
        super(1200, 1000);
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
