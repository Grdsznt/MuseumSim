import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Has the logic to detect the mouse relation to the button
 * Calls the function in the subclass
 * 
 * @author Jerry Xing
 * @version 
 */
public class HomeButton extends Button
{
    private StartWorld temp;
    /**
     * The construtor for the Button
     * @param imageStates where the image is located
     * @param numstates is how many different states there are of that image (at most 3 are used)
     */
    public HomeButton(String imagePath, int numStates, StartWorld previousWorld) {
        super(imagePath, numStates);
        temp = previousWorld;
    }
    
    /**
     * Checks the state of the mouse in relation to the button
     * If the mouse is hovering
     * If the mouse is clicked on the button
     * If the mouse let go after clicking on the button
     */
    public void act()
    {
        super.act();
    }
    
    /**
     * Action does nothing in this class but should be in the subclasses
     */
    public void action() {
        Greenfoot.setWorld(temp);
        StartWorld.music.playLoop(); //Music doesn't resume when switching to new StartWorld
    }
    
}