import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This will be used on objects to detect if they are touching a certain type of class.
 * 
 * //Known bugs:
 * 
 * 
 * @author Jean
 * @version Apr 2024
 */
public class Detector extends SuperSmoothMover
{
    //Size
    private int width = 40;
    private int height = 20;
    //Draw the image
    private int[] xPoints = {0,width,width};
    private int[] yPoints = {height/2,0,height};
    private GreenfootImage triangle = new GreenfootImage(width,height);
    
    //Store its own guard
    private Guard guard;
    //The absolute difference of position between this guard & its detector
    private int xDif;
    private int yDif;
    
    public Detector(Guard guard){
        //Draw
        triangle.setColor(Color.GRAY);
        triangle.fillPolygon(xPoints, yPoints,3);
        //Set image
        setImage(triangle);
        //Get its own guard
        this.guard = guard;
        //Calculate its relative absolute dif in position
        xDif = guard.getWidth()/2 + getWidth()/2;
        yDif = guard.getHeight()/2 + getHeight()/2;
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
                y = guard.getPreciseY();
                break;
            }
            case 2: {
                x = guard.getPreciseX();
                y = guard.getPreciseY()-yDif;
                break;
            }
            case 3: {
                x = guard.getPreciseX()-xDif;
                y = guard.getPreciseY();
                break;
            }
            default: {
                x = guard.getPreciseX();
                y = guard.getPreciseY()+yDif;
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
