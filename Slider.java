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

    // Constructor to initialize slider properties
    public Slider(int width, int height, int minValue, int maxValue, boolean isHorizontal) {
        this.width = width;
        this.height = height;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.isHorizontal = isHorizontal;
        this.currentValue = minValue; // Start with the minimum value
        updateImage(); // Update the slider's appearance
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
    
    private void drawSliderButton(GreenfootImage image) {
        int buttonSize = 20; // Size of the slider button
        int buttonX, buttonY;
    
        if (isHorizontal) {
            buttonX = mapValue(currentValue, minValue, maxValue, 0, width - buttonSize);
            buttonY = height / 2 - buttonSize / 2;
        } else {
            buttonX = width / 2 - buttonSize / 2;
            buttonY = mapValue(currentValue, minValue, maxValue, height - buttonSize, 0);
        }
    
        // Draw the slider button
        image.setColor(Color.BLUE);
        image.fillOval(buttonX, buttonY, buttonSize, buttonSize);
    }

    private int mapValue(int value, int minValue, int maxValue, int minRange, int maxRange) {
        return minRange + (maxRange - minRange) * (value - minValue) / (maxValue - minValue);
    }

    public interface SliderListener {
        void onValueChanged(int value);
    }

    public void setSliderListener(SliderListener listener) {
        this.listener = listener;
    }
    
    private void notifyListener() {
        if (listener != null) {
            listener.onValueChanged(currentValue);
        }
    }

}

