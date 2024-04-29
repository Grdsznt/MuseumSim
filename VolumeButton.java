import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VolumeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VolumeButton extends Button
{
    private GreenfootImage image;
    private static int currentVolume;
    private boolean type;
    /**
     * Act - do whatever the VolumeButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public VolumeButton(String imagePath, int numStates, boolean type) {
        super(imagePath, numStates);
        this.type = type;
        
        if(type) {
            setImage("volumeUp.png");
        }
        else {
            setImage("volumeDown.png");
        }
    }
    public void act()
    {
        super.act();
    }
    public void action() {
        if(type) {
            currentVolume+=5;
        }
        else if (!type) {
            currentVolume-=5;
        }
    }
}
