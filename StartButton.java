import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author Jerry, Jean Pan
 * @version (a version number or a date)
 */
public class StartButton extends Button
{
    public StartButton(String imgPath, int numStates) {
        super(imgPath, numStates);
    }
    
    public void act()
    {
        if (Greenfoot.mouseMoved(this)) {
            hover = true;
            if (imageStates.length > 1) {
                setImage(imageStates[1]);
            }
        } else if (Greenfoot.mouseMoved(null)) {
            hover = false;
            mouseDown = false;
            if (imageStates.length > 2) {
                setImage(imageStates[0]);
            }
        }
        
        if (Greenfoot.mousePressed(this) && !mouseDown) {
            mouseDown = true;
            if (imageStates.length > 2) {
                setImage(imageStates[2]);
            }
        }
                                                                                                                                                                                                                                                                       
        if (Greenfoot.mouseClicked(this) && mouseDown) {
            playClickSound();
            action();
            mouseDown = false;
            if (imageStates.length > 2) {
                setImage(imageStates[1]);
            }

        } else if (Greenfoot.mouseClicked(null)) {
            mouseDown = false;
            if (imageStates.length > 2) {
                setImage(imageStates[0]);
            }
        }
    }
    
    /**
     * If the user clicks the start button, the world will jump to Museum Room.
     */
    public void action() {
        StartWorld sw = (StartWorld) getWorld();
        Greenfoot.setWorld(new MuseumRoom(sw.getSetUp().getNumberOfRobbers(), sw.getSetUp().getNumberOfGuards(), sw.getSetUp().getNumberOfValuables(), sw.getSetUp().getRobberSpawnRate(), sw.getSetUp().getVisitorSpawnRate()));
        StartWorld.music.pause();
    }
}
