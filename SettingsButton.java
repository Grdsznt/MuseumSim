import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsButton here.
 * 
 * @author Jerry
 * @version (a version number or a date)
 */
public class SettingsButton extends Button
{
    SetUpWorld suw;
    /**
     * Main Constructor for SettingButton
     * @param up Current state of button. True = button points up. False = button points down.
     */
    public SettingsButton(String imgPath, int numStates, SetUpWorld suw){
        super(imgPath, numStates);
        this.suw = suw;
    }
    
    public void act()
    {
        super.act();
    }
    
    public void action() {
        Greenfoot.setWorld(suw);
    }
}
