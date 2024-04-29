import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Has the logic to detect the mouse relation to the button
 * Calls the function in the subclass
 * 
 * @author Jerry Xing, Jean Pan, Felix Zhao
 * @version 
 */
public abstract class Button extends Actor
{
    protected static GreenfootSound[] clickEffects;
    protected static int clickIndex;
    protected boolean hover = false;
    protected boolean mouseDown = false;
    protected GreenfootImage[] imageStates;
    
    /**
     * The constructor for the Button with no parameters.
     */
    public Button(){
        
    }
    
    /**
     * The construtor for the Button
     * @param imageStates where the image is located
     * @param numstates is how many different states there are of that image (at most 3 are used)
     */
    public Button(String imagePath, int numStates) {
        GreenfootImage image = new GreenfootImage(imagePath + "_1.png");
        setImage(image);
        imageStates = new GreenfootImage[numStates];
        imageStates[0] = image;
        
        
        for (int i = 1; i < numStates; i++) {
            imageStates[i] = new GreenfootImage(imagePath + "_" + (i+1) + ".png");
        }
    }
    
    /**
     * Checks the state of the mouse in relation to the button
     * If the mouse is hovering
     * If the mouse is clicked on the button
     * If the mouse let go after clicking on the button
     */
    public void act()
    {
        //Do not act if it is an instance of the Option Button!
        if(this instanceof OptionButton) {
            return;
        }
        
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
     * Sets the scale for the buttons
     * @param width sets the width of the button to width
     * @param height sets the height of the button to height
     */
    public void setScale(int width, int height) {
        for (int i = 0; i < imageStates.length; i++) {
            imageStates[i].scale(width, height);
        }
    }
    
    /**
     * Action does nothing in this class but should be in the subclasses
     */
    public void action() {
        // Does nothing. Should be added in the subclasses
    }
    
    public static void init() {
        clickIndex = 0;
        clickEffects = new GreenfootSound[30];
        for (int i=0;i<clickEffects.length;i++) {
            clickEffects[i] = new GreenfootSound("click_sound.mp3");
            clickEffects[i].setVolume(40);
        }
    }
    
    //Code from Mr. Cohen
    public static void playClickSound() {
        clickEffects[clickIndex].play();
        clickIndex++;
        if (clickIndex >= clickEffects.length){
            clickIndex = 0;
        }
    }
}