import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsButton extends Button
{
    /**
     * Main Constructor for SettingButton
     * @param up Current state of button. True = button points up. False = button points down.
     */
    public SettingsButton(String imgPath, int numStates){
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
    
    public void action() {
        Greenfoot.setWorld(new SetUpWorld());
    }
}
