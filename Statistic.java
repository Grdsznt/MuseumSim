import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * It shows the statistics shown in Museum Room.
 * 
 * @author Jean
 * @version Apr 25, 2024
 */
public class Statistic extends Actor
{
    //Image
    private GreenfootImage image;
    //Value
    private int fontSize = 18;
    private int width = 30;
    private SuperTextBox textLabel;
    private boolean hasPrefix = false;
    private String prefix;
    private int value;    
    
    /**
     * Simple constructor without a prefix sign.
     * 
     * @param GreenfootImage    The image shown for this statistic.
     * @param value             The value shown for this statistic.
     */
    public Statistic(GreenfootImage image, int value){
        this.image = image;
        this.value = value;
        
        //Set text label
        textLabel = new SuperTextBox(""+value, new Font("Kalam", false, false, fontSize), width);
    }
    
    /**
     * Constructor with a prefix sign.
     * 
     * @param GreenfootImage    The image shown for this statistic.
     * @param value             The value shown for this statistic.
     * @param prefix            The sign put in front of the value for this statistic.
     */
    public Statistic(GreenfootImage image, int value, String prefix){
        this.image = image;
        this.value = value;
        this.prefix = prefix;
        this.hasPrefix = true;
        
        //Set text label
        textLabel = new SuperTextBox(prefix+value, new Font("Kalam", false, false, fontSize), width);
    }
    
    public void act()
    {
        
    }
    
    /**
     * Update the value of the statistic.
     * 
     * @param value The value that will be updated to this statistic.
     */
    public void updateValue(int value){
        //If there is a prefix, add the prefix.
        if(hasPrefix){
            textLabel.update(prefix+value);
        } else {
            //If not, just update the value.
            textLabel.update(""+value);
        }
    }
}
