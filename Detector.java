import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This will be used on objects to detect if they are touching a certain type of class.
 * 
 * @author Jean
 * @version Apr 2024
 */
public class Detector extends SuperSmoothMover
{
    //Set the image
    private GreenfootImage detectorImage = new GreenfootImage("detector.png");
    
    //Original size
    private int width = detectorImage.getWidth();
    private int height = detectorImage.getHeight();
    
    //Store its own guard
    private Guard guard;
    //The absolute difference of position between this guard & its detector
    private int xDif;
    private int yDif;
    
    //Store the robber it detects
    private Robber robber;
    
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
        updateWidthHeight();
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
     * The width & height of the image will change after it is rotated so they should be updated every time after an rotation.
     */
    public void updateWidthHeight(){
        width = getImage().getWidth();
        height = getImage().getHeight();
    }
    
    /**
     * The collision points will change after the image is rotated so the collision points should also be updated based on the new width and height of the image.
     *
     * @param direction     The direction of the guard & detector to determine which set of collision points to give
     * @return int[][]   The 2D array containing the x direction & y direction collision points
     */
    public int[][] getCollisionPoints(int direction){
        //Collision points 2D array
        int[][] collisionPointsRight = {
                                            {-width/2, 0, 0, width/2, width/2, width/2}, 
                                            {0, -height/4, height/4, -height/2, 0, height/2}
                                        };
        int[][] collisionPointsUp = {
                                            {0, -width/4, width/4, -width/2, 0, width/2}, 
                                            {height/2, 0, 0, -height/2, -height/2, -height/2}
                                    };
        int[][] collisionPointsLeft = {
                                            {width/2, 0, 0, -width/2, -width/2, -width/2}, 
                                            {0, -height/4, height/4, -height/2, 0, height/2}
                                        };
        int[][] collisionPointsDown = {
                                            {0, -width/4, width/4, -width/2, 0, width/2}, 
                                            {-height/2, 0, 0, height/2, height/2, height/2}
                                        };
        switch(direction){
            case 1: return collisionPointsRight;
            case 2: return collisionPointsUp;
            case 3: return collisionPointsLeft;
            default: return collisionPointsDown;
        }
    }
    
    /**
     * Detect if this detector detects any robber in range.
     * 
     * @return boolean  True if detects a robber, false otherwise.
     */
    public boolean detectedRobbers(){
        boolean detected = false;
        int[][] collisionPoints = getCollisionPoints(guard.getDirection());
        for(int i=0; i<collisionPoints[0].length; i++){
            Robber temp = (Robber)getOneObjectAtOffset(collisionPoints[0][i],collisionPoints[1][i],Robber.class);
            if(temp!=null){
                robber = temp;
                detected = true;
            }
        }
        //Set robber = null if nothing is detected this time
        if(!detected){
            robber = null;
        }
        return detected;
    }
    
    /**
     * Get the robber.
     * 
     * @return Robber  The robber it detects
     */
    public Robber getRobber(){
        return robber;
    }
    
    /**
     * Get the width of the detector.
     * 
     * @return int  width of the current image
     */
    public int getWidth(){
        return width;
    }
    
    /**
     * Get the height of the detector.
     * 
     * @return int  height of the current image
     */
    public int getHeight(){
        return height;
    }
}
