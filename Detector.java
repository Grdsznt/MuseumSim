import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This will be used on objects to detect if they are touching a certain type of class.
 * 
 * //Known bugs:
 * //Set paint order to put the detector under the guard
 * 
 * @author Jean
 * @version Apr 2024
 */
public class Detector extends SuperSmoothMover
{
    //Set the image
    private GreenfootImage detectorImage = new GreenfootImage("detector.png");
    
    //Size
    private int width = detectorImage.getWidth();
    private int height = detectorImage.getHeight();
    
    //Store its own guard
    private Guard guard;
    //The absolute difference of position between this guard & its detector
    private int xDif;
    private int yDif;
    
    public Detector(Guard guard){
        //Set image
        detectorImage.setTransparency(100); //Set transparency to 100
        setImage(detectorImage);
        //Get its own guard
        this.guard = guard;
        //Calculate its relative absolute dif in position
        xDif = guard.getWidth()/2 + getWidth()/2;
        yDif = guard.getHeight()/2;
    }
    
    public void act()
    {
        //Let the detector follow its Guard
        double[] coordinate = getCoordinates();
        setLocation(coordinate[0],coordinate[1]);
        //Adjust the Detector's rotation in case it does not match with the Guard's.
        setRotation((360-(guard.getDirection()-1)*90)%360);
    }
    
    /** 
     * Get the updated coordinates based on the guard's direction & position.
     */
    public double[] getCoordinates(){
        //The position of the detector
        double x, y;
        switch(guard.getDirection()){
            case 1: {
                x = guard.getPreciseX()+xDif;
                y = guard.getPreciseY()+guard.getWidth();
                break;
            }
            case 2: {
                x = guard.getPreciseX();
                y = guard.getPreciseY()-yDif;
                break;
            }
            case 3: {
                x = guard.getPreciseX()-xDif;
                y = guard.getPreciseY()+guard.getWidth();
                break;
            }
            default: {
                x = guard.getPreciseX();
                y = guard.getPreciseY()+2*yDif;
                break;
            }
        }
        double[] coordinates = {x,y};
        return coordinates;
    }
    
    /**
     * Get the width of the detector.
     */
    public int getWidth(){
        return width;
    }
    
    /**
     * Get the height of the detector.
     */
    public int getHeight(){
        return height;
    }
}
