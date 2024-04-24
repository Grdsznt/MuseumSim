import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The plus button will add a value of one to the option button that it is connected to.
 * 
 * @author Jean Pan
 * @version Apr 2024
 */
public class PlusButton extends Button
{
    //Store its own option button
    private OptionButton optionButton;
    
    /**
     * Constructor.
     */
    public PlusButton(OptionButton optionButton){
        this.optionButton = optionButton;
    }
    
    public void act()
    {
        //Add value 1 to the option
        if(Greenfoot.mouseClicked(this)){
            optionButton.changeValue(1);
        }
    }
}
