import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The option buttons in the SetUpWorld.
 * 
 * @author Jean Pan
 * @version Apr 2024
 */
public class OptionButton extends Button
{
    //Background image
    private int width = 350;
    private int height = 40;
    private Color backgroundColor = Color.LIGHT_GRAY;
    
    //Text label
    private SuperTextBox textLabel; //From Mr.Cohen's Library
    private String text;
    private int fontSize = 20;
    private Color textColor = Color.BLACK;
    
    //The value
    private int value;
    
    private Slider slider;
    
    /**
     * Constructor of the Option Button.
     * 
     * @param text      The text that you want the button to display
     * @param initialValue      The minimum value that the button can be toggled
     * @param maxValue      The maximum value that the button can be toggled
     */
    public OptionButton(String text, Slider slider){
        this.text = text;
        this.slider = slider;
        value=slider.getValue();
        //Set background image
        GreenfootImage backgroundImage = new GreenfootImage(width, height);
        backgroundImage.setColor(backgroundColor);
        backgroundImage.fill();
        setImage(backgroundImage);
        
        //Set text label
        textLabel = new SuperTextBox(text+value, backgroundColor, textColor, new Font("Kalam", false, false, fontSize), true, width, 0, null);
    }
    
    /**
     * This method is called automatically at the time when this option button is added to a world.
     */
    public void addedToWorld(World world){
        //If it is a Set Up World
        if(world instanceof SetUpWorld){
            //Add the text label
            world.addObject(textLabel, this.getX(), this.getY());
        }
    }
    
    public void act() {
        changeValue();
    }
    
    /**
     * If the user clicked on the plus or minus button beside the option button, the value of this option will be added by 1 or subtracted by 1, respectively.
     * 
     * @param changeInValue either 1 or -1
     */
    public void changeValue(){
        //Some errors might happen if the change in value is not 1 or -1, so just return it and do not make any changes to the value.
        value = slider.getValue();
        textLabel = new SuperTextBox(text+value, backgroundColor, textColor, new Font("Kalam", false, false, fontSize), true, width, 0, null);
    }
    
    /**
     * Return the value.
     * 
     * @return int  The value of this option button.
     */
    public int getValue(){
        return value;
    }
}
