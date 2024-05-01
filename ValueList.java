import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A list of values shown in world.
 * 
 * @author Jean Pan
 * @version Apr 2024
 */
public class ValueList extends Actor
{
    //Image
    private GreenfootImage image;
    //Value
    private int fontSize = 18;
    private int width = 100;
    private SuperTextBox textLabel;
    private String value;    
    
    /**
     * Simple constructor.
     * 
     * @param GreenfootImage    The image shown for this list.
     * @param value             The value shown for this list.
     */
    public ValueList(GreenfootImage image, String value){
        this.image = image;
        this.value = value;
        
        //Set the image
        setImage(image);
        
        //Set text label
        textLabel = new SuperTextBox(value, new Font("Kalam", false, false, fontSize), width);
    }
    
    /**
     * Will be called automatically when the list is added to world.
     */
    public void addedToWorld(World w){
        if(w instanceof MuseumRoom){
            int middleX = getX();
            int middleY = getY();
            
            //The modified positions of text label
            int textX = middleX+80;
            int textY = middleY;
            
            //Add the text label
            w.addObject(textLabel, textX, textY);
        }
    }
    
    /**
     * Update the value in the list.
     * 
     * @param value The value that will be updated to this list.
     */
    public void updateValue(String value){
        textLabel.update(value);
    }
}
