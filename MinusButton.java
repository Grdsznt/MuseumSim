import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The minus button will minus a value of one to the option button that it is connected to.
 * 
 * @author Jean Pan
 * @version Apr 2024
 */
public class MinusButton extends Button
{
    //Store its own option button
    private OptionButton optionButton;
    
    /**
     * Constructor.
     */
    public MinusButton(OptionButton optionButton){
        this.optionButton = optionButton;
    }
    
    public void act()
    {
        //Subtract value 1 from the option
        if(Greenfoot.mouseClicked(this)){
            optionButton.changeValue(-1);
        }
    }
}
