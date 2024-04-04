import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Guard will have a detector. If it detects any robber by its detector, it will start to catch the robber.
 * 
 * @author Jean
 * @version Apr 2024
 */
public class Guard extends People
{
    //Animation variables
    private int frame = 0;
    private int aniCount = 0;
    private int aniGap = 6;
    
    //Store animation images
    private static GreenfootImage[] right = new GreenfootImage[6];
    private static GreenfootImage[] up = new GreenfootImage[6];
    private static GreenfootImage[] left = new GreenfootImage[6];
    private static GreenfootImage[] down = new GreenfootImage[6];
    
    //Get its direction
    private int direction = 1; //0 is rest, 1 is right, 2 is up, 3 is left, 4 is down
    private double speed = 2.5;
    
    //Store its own detector
    private Detector detector;
    
    public Guard(){
        detector = new Detector(this);
    }
    
    public void act()
    {
        aniCount++;
        
        switch(direction){
            case 1: {
                move(speed);
                break;
            }
            case 2: {
                setLocation(getX(), getY()-speed);
                break;
            }
            case 3: {
                move(-speed);
                break;
            }
            case 4: {
                setLocation(getX(), getY()+speed);
                break;
            }
        }
        
        //Reset frame if goes above
        frame%=6;
        
        if(aniCount%aniGap==0){
            animate();
        }
        
    }
    
    /**
     * Load its animation images.
     */
    public void loadAnimationImages(){
        for(int i=0; i<6; i++){
            right[i] = new GreenfootImage("right"+i);
            up[i] = new GreenfootImage("up"+i);
            left[i] = new GreenfootImage("left"+i);
            down[i] = new GreenfootImage("down"+i);
        }
    }
    
    /**
     * Animate by setting its image based on its direction facing.
     */
    public void animate(){
        switch(direction){
            case 1: {
                setImage(right[frame]);
                break;
            }
            case 2: {
                setImage(up[frame]);
                break;
            }
            case 3: {
                setImage(left[frame]);
                break;
            }
            case 4: {
                setImage(down[frame]);
                break;
            }
        }
    }
    
    public void rotate(){
        
    }
    
    /**
     * 
     */
    public void detectRobbers(){
        
    }
}
