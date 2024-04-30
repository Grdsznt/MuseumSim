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
    private final int initialValue;
    private final int maxValue;
    private int value;
    
    /**
     * Constructor of the Option Button.
     */
    public OptionButton(String text, int initialValue, int maxValue){
        this.text = text;
        this.initialValue = initialValue;
        this.maxValue = maxValue;
        this.value = initialValue;
        
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
            //Add the plus & minus buttons beside the text label
            /*
            world.addObject(new PlusButton(this), this.getX()+width/2+20, this.getY());
            world.addObject(new MinusButton(this), this.getX()-width/2-20, this.getY());
            */
        }
    }
    
    /**
     * If the user clicked on the plus or minus button beside the option button, the value of this option will be added by 1 or subtracted by 1, respectively.
     * 
     * @param changeInValue either 1 or -1
     */
    public void changeValue(int changeInValue){
        //Some errors might happen if the change in value is not 1 or -1, so just return it and do not make any changes to the value.
        if(Math.abs(changeInValue)!=1){
            return;
        }
        
        //If the value becomes less than the initial value or exceeds the maximum acceptable value, do not change
        if(value+changeInValue<initialValue || value+changeInValue>maxValue){
            return;
        }
        
        //Update the value
        value+=changeInValue;
        
        //Update the text label with the new value
        textLabel.update(text+value);
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
