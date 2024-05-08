import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Effects here.
 * Super class for effects.
 * 
 * @author David
 * @version May 2024
 */
public abstract class Effect extends Actor
{
    /**
     * Act - do whatever the Effect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int actsLived, duration, targetFade;
    private boolean fadeIn;
    protected boolean startAct;
    protected MuseumRoom world;
    /**
     * Creates a effect that lasts for a specified amount of acts, and has a target transparency
     * throughout the effect's lifetime.
     * @param eventDuration how long the effect lasts.
     * @param fadeInTarget the target transparency to remain in
     */
    public Effect(int duration, int targetFade) {
        this.duration = duration;
        this.targetFade = targetFade;
        actsLived = 0;
        startAct = true;
        fadeIn = true;
    }
    public void addedToWorld(World w){
        if (!startAct) return;
        world = (MuseumRoom) w; 
        startEffect(); 
        startAct = false;
    }
    public void act() {
        actsLived++;
        if (fadeIn && getImage().getTransparency() < targetFade) { 
            fadeIn(3);
        }
        else fadeIn = false; // Done fading in
        
        // Event has run its course, so time to fade out gracefully.
        if (++actsLived >= duration) {
            fadeOut(3);
            if (getImage().getTransparency() <= 0) { //stop effect when its over
                stopEffect(); 
                List<Robber> robbers = getWorld().getObjects(Robber.class);
                for (Robber r: robbers) {
                    r.setSpeed(3); // set speed back
                }
                getWorld().removeObject(this);
                MuseumRoom.increaseDayCount();
            }
        }
    }
    /**
     * Increases the Effect's transparency by the given amount.
     * @param step how much transparency to gain.
     */
    protected void fadeIn(int step) {
        getImage().setTransparency(Math.min(getImage().getTransparency()+step, 255)); // Increase transparency, max 255
    }
    /**
     * Decreases the Effect's transparency by the given amount.
     * @param step how much transparency to lose.
     */
    protected void fadeOut(int step) {
        getImage().setTransparency(Math.max(getImage().getTransparency()-step, 0)); // Decrease transparency, min 0
    }
    /**
     * Code to run when the Effect becomes active.
     */
    public abstract void startEffect();
    /**
     * Code to run when the Effect has ended.
     */
    public abstract void stopEffect();
}