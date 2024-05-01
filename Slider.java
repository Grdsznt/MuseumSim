import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Slider here.
 * 
 * @author Jerry
 * @version (a version number or a date)
 */
public class Slider extends Actor {
    private int width;
    private int height;
    private int minValue;
    private int maxValue;
    private int currentValue;
    private boolean isHorizontal;
    private SliderListener listener;
    private String settingIdentifier; //Identifier for the setting

    // Constructor to initialize slider properties
    public Slider(int width, int height, int minValue, int maxValue, boolean isHorizontal) {
        this.width = width;
        this.height = height;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.isHorizontal = isHorizontal;
        this.currentValue = minValue; // Start with the minimum value
        updateImage(); // Update the slider's appearance
        //this.settingIdentifier = settingIdentifier;
    }
    
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        double percent = 0;
        if (mouse != null && (Greenfoot.mousePressed(this) || Greenfoot.mouseDragged(this))) {
            if (isHorizontal) {
                int mouseX = mouse.getX();
                percent = ((double)mouseX-(getX()-getImage().getWidth()/2.0))/getImage().getWidth();
                currentValue = (int)((minValue*(1-percent))+(maxValue*percent));
                currentValue = Math.max(currentValue, minValue);
                currentValue = Math.min(currentValue, maxValue);
                System.out.println("Current: "+ currentValue + " Min: " + minValue + "Max: " + maxValue + " mouseX: " + percent);
            } else {
                int mouseY = mouse.getY();
                currentValue = (int)mapValue(mouseY, height, 0, minValue, maxValue);
            }
            updateImage(); // Update slider appearance
            notifyListener(); // Notify listener of value change
    
            // Debug output
            //System.out.println("Mouse X: " + mouse.getX() + ", Mouse Y: " + mouse.getY());
            //System.out.println("Current Value: " + currentValue);
        }
    }


    
    private void updateImage() {
        GreenfootImage image = new GreenfootImage(width, height);
        // Draw the slider track
        image.setColor(Color.LIGHT_GRAY);
        if (isHorizontal) {
            image.fillRect(0, height / 2 - 5, width, 10);
        } else {
            image.fillRect(width / 2 - 5, 0, 10, height);
        }
    
        // Draw the slider button
        drawSliderButton(image);
        setImage(image);
    }

    
    // In your Slider class or wherever the button is created
    private void drawSliderButton(GreenfootImage image) {
        int buttonSize = 10; // Size of the slider button
        int buttonX, buttonY;
    
        if (isHorizontal) {
            buttonX = (int)((mapValue(currentValue, minValue, maxValue, 0, width - buttonSize)*getImage().getWidth()));
            buttonY = height / 2 - buttonSize / 2;
        } else {
            buttonX = width / 2 - buttonSize / 2;
            buttonY = (int)mapValue(currentValue, minValue, maxValue, height - buttonSize, 0);
        }
        System.out.println("X: " + buttonX);
        System.out.println("Y: " + buttonY);
        // Draw the slider button on top of the track
        image.setColor(Color.BLUE);
        image.fillOval(buttonX-buttonSize/2, buttonY, buttonSize, buttonSize);
    }




    private double mapValue(int value, int minValue, int maxValue, int minRange, int maxRange) {
        System.out.println(((value-minValue)/(double)(maxValue-minValue)));
        return ((value-minValue)/(double)(maxValue-minValue));
    }

    public interface SliderListener {
        void onValueChanged(String settingIndentifier, int value);
    }

    public void setSliderListener(SliderListener listener) {
        this.listener = listener;
    }
    
    private void notifyListener() {
        if (listener != null) {
            listener.onValueChanged(settingIdentifier, currentValue);
        }
    }

}

