import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**

 * Write a description of class Effects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    protected MuseumWorld world;
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
        world = (MuseumWorld) w; 
        startEffect(); 
        startAct = false;
    }
    public void act() {
        if (fadeIn && getImage().getTransparency() < targetFade) { 
            fadeIn(1);
        }
        else fadeIn = false; // Done fading in
        
        // Event has run its course, so time to fade out gracefully.
        if (++actsLived >= duration) {
            fadeOut(1);
            if (getImage().getTransparency() <= 0) { //stop effect when its over
                stopEffect(); 
                getWorld().removeObject(this);
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