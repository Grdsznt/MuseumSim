import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Guard will have a detector. If it detects any robber by its detector, it will start to catch the robber.
 * 
 * Known bugs:
 * - loadAnimationImages();//!!!!!!!Later put into world
 * 
 * @author Jean
 * @version Apr 2024
 */
  
public class Guard extends Human
{
    //Store the world that it is added to
    World world;
    
    //Animation variables
    private int aniCount = 0;
    private int walkFrame = 0;
    private int runFrame = 0;
    private int walkGap = 9;
    private int runGap = 6;

    //Store walking animation images
    private static GreenfootImage[] walkRight = new GreenfootImage[3];
    private static GreenfootImage[] walkUp = new GreenfootImage[3];
    private static GreenfootImage[] walkLeft = new GreenfootImage[3];
    private static GreenfootImage[] walkDown = new GreenfootImage[3];
    
    //Store running animation images
    private static GreenfootImage[] runRight = new GreenfootImage[6];
    private static GreenfootImage[] runUp = new GreenfootImage[6];
    private static GreenfootImage[] runLeft = new GreenfootImage[6];
    private static GreenfootImage[] runDown = new GreenfootImage[6];
    
    //Get its direction
    private int direction; //0 is rest, 1 is right, 2 is up, 3 is left, 4 is down
    private double walkSpeed = 0.5;
    private double runSpeed = 2.5;
    
    //Store its own detector
    private Detector detector;
    private boolean isCatching = false; //Check if it is catching a robber
    
    //Store the robber it trys to catch
    private Robber robber;
    
    public Guard(int direction){
        
        loadAnimationImages();//!!!!!!!Later put into world
        
        //Set direction
        this.direction = direction;
        
        //Get its own detector
        detector = new Detector(this);
    }
    
    /**
     * When the Guard is added to world, add its detector as well.
     */
    public void addedToWorld(World w){
        world = w;
        double[] coordinate = detector.getCoordinates();
        w.addObject(detector, (int)coordinate[0], (int)coordinate[1]);
    }
    
    public void act()
    {
        //Start to catch the robber if is detected by the detector
        if(detector.detectedRobbers()){
            catchRobber(detector.getRobber());
        } else {
            isCatching = false;
            robber = null;
        }
        
        //If it is time to animate, animate it
        if((isCatching && aniCount%runGap==0) || (!isCatching && aniCount%walkGap==0)){
            animate();
        }
        
        //Change to the opposite direction if facing obstacles in front
        if(detectedObstacles()){
            direction = (direction+1)%4+1;
        }
        
        //Set its location based on its direction of facing & its catching status
        switch(direction){
            case 1: {
                if(isCatching){
                    setLocation(getPreciseX()+runSpeed, getPreciseY());
                } else {
                    setLocation(getPreciseX()+walkSpeed, getPreciseY());
                }
                break;
            }
            case 2: {
                if(isCatching){
                    setLocation(getPreciseX(), getPreciseY()-runSpeed);
                } else {
                    setLocation(getPreciseX(), getPreciseY()-walkSpeed);
                }
                break;
            }
            case 3: {
                if(isCatching){
                    setLocation(getPreciseX()-runSpeed, getPreciseY());
                } else {
                    setLocation(getPreciseX()-walkSpeed, getPreciseY());
                }
                break;
            }
            case 4: {
                if(isCatching){
                    setLocation(getPreciseX(), getPreciseY()+runSpeed);
                } else {
                    setLocation(getPreciseX(), getPreciseY()+walkSpeed);
                }
                break;
            }
        }
        
        //Reset frame if goes above
        walkFrame%=3;
        runFrame%=6;
        
        aniCount++;
    }
    
    /**
     * Load its animation images for walking & running.
     */
    public void loadAnimationImages(){
        for(int i=0; i<6; i++){
            //Running images
            runRight[i] = new GreenfootImage("Guard/run_right"+i+".png");
            runUp[i] = new GreenfootImage("Guard/run_up"+i+".png");
            runLeft[i] = new GreenfootImage("Guard/run_left"+i+".png");
            runDown[i] = new GreenfootImage("Guard/run_down"+i+".png");
            
            //If the index is more than 2, the walking array is already filled out.
            if(i>2){
                continue;
            }
            
            //Walking images
            walkRight[i] = new GreenfootImage("Guard/walk_right"+i+".png");
            walkUp[i] = new GreenfootImage("Guard/walk_up"+i+".png");
            walkLeft[i] = new GreenfootImage("Guard/walk_left"+i+".png");
            walkDown[i] = new GreenfootImage("Guard/walk_down"+i+".png");
        }
    }
    
    /**
     * Animate by setting its image based on its direction facing & its catching status.
     */
    public void animate(){
        switch(direction){
            case 1: {
                if(isCatching){
                    setImage(runRight[runFrame++]);
                } else {
                    setImage(walkRight[walkFrame++]);
                }
                break;
            }
            case 2: {
                if(isCatching){
                    setImage(runUp[runFrame++]);
                } else {
                    setImage(walkUp[walkFrame++]);
                }
                break;
            }
            case 3: {
                if(isCatching){
                    setImage(runLeft[runFrame++]);
                } else {
                    setImage(walkLeft[walkFrame++]);
                }
                break;
            }
            case 4: {
                if(isCatching){
                    setImage(runDown[runFrame++]);
                } else {
                    setImage(walkDown[walkFrame++]);
                }
                break;
            }
        }
    }
    
    /**
     * Get the current direction.
     */
    public int getDirection(){
        return direction;
    }
    
    /**
     * Get the width of the Guard.
     */
    public int getWidth(){
        return 32;
    }
    
    /**
     * Get the height of the Guard.
     */
    public int getHeight(){
        return 64;
    }
    
    /**
     * Catch the robber that is in range.
     * 
     * @param detectedRobber    The robber that is detected by its detector, but not the guard itself.
     */
    public void catchRobber(Robber detectedRobber){
        isCatching = true;
        //Follow the robber that is detected by the detector.
        followRobber(detectedRobber);
        //If the Guard detects a Robber itself, it is catched & removed from the world. Check right & up & left & down in the range of 32 units.
        switch(direction){
            case 1: {
                this.robber = (Robber)getOneObjectAtOffset(32,0,Robber.class);
                break;
            }
            case 2: {
                this.robber = (Robber)getOneObjectAtOffset(0,-32,Robber.class);
                break;
            }
            case 3: {
                this.robber = (Robber)getOneObjectAtOffset(-32,0,Robber.class);
                break;
            }
            default: {
                this.robber = (Robber)getOneObjectAtOffset(0,32,Robber.class);
            }
        }
        
        //If a robber is detected
        if(robber!=null){
            world.removeObject(robber);
            isCatching = false;
            this.robber = null;
        }
    }
    
    /**
     * Follow the robber as it runs.
     * 
     * @param detectedRobber    The robber object that is detected by the detector.
     */
    public void followRobber(Robber detectedRobber){
        double robberX = detectedRobber.getPreciseX();
        double robberY = detectedRobber.getPreciseY();
        double guardX = this.getPreciseX();
        double guardY = this.getPreciseY();
        
        //If they are at the same x (while moving in y) or y position (while moving in x), do not move the guard.
        if((direction%2==0 && robberX==guardX) || (direction%2==1 && robberY==guardY)) {
            return;
        }
        
        //Moving vertically
        if(direction%2==0){
            if(robberX<guardX){
                //Check if we can move left
                if(getOneObjectAtOffset(0,(int)(robberX-guardX),Obstacle.class)==null){
                    //If there is some objects in front of the Guard, turn to the other direction where the robber could possibly be at.
                    if(detectedObstacles()){
                        this.direction = 3;
                    } else {
                        //If there is still spaces in front, do not change direction
                        double xChange = guardX-robberX;
                        if(xChange>2){
                            xChange = 2;
                        }
                        setLocation(getX()-xChange, getY());
                    }
                }
            } else {
                //Check if we can move right
                if(getOneObjectAtOffset(0,(int)(guardX-robberX),Obstacle.class)==null){
                    //If there is some objects in front of the Guard, turn to the other direction where the robber could possibly be at.
                    if(detectedObstacles()){
                        this.direction = 1;
                    } else {
                        //If there is still spaces in front, do not change direction
                        double xChange = robberX-guardX;
                        if(xChange>2){
                            xChange = 2;
                        }
                        setLocation(getX()+xChange, getY());
                    }
                }
            }
            //Check if to change to the opposite direction based on the robber's Y position
            switch(direction){
                case 2: {
                    if(robberY>guardY){
                        direction = 4;
                    }
                }
                case 4: {
                    if(robberY<guardY){
                        direction = 2;
                    }
                }
            }
        } 
        //Moving horizontally
        else {
            if(robberY<guardY){
                //Check if we can move up
                if(getOneObjectAtOffset(0,(int)(robberY-guardY),Obstacle.class)==null){
                    //If there is some objects in front of the Guard, turn to the other direction where the robber could possibly be at.
                    if(detectedObstacles()){
                        this.direction = 2;
                    } else {
                        //If there is still spaces in front, do not change direction
                        double yChange = guardY-robberY;
                        if(yChange>2){
                            yChange = 2;
                        }
                        setLocation(getX(), getY()-yChange);
                    }
                }
            } else {
                //Check if we can move down
                if(getOneObjectAtOffset(0,(int)(guardY-robberY),Obstacle.class)==null){
                    //If there is some objects in front of the Guard, turn to the other direction where the robber could possibly be at.
                    if(detectedObstacles()){
                        this.direction = 4;
                    } else {
                        //If there is still spaces in front, do not change direction
                        double yChange = robberY-guardY;
                        if(yChange>2){
                            yChange = 2;
                        }
                        setLocation(getX(), getY()+yChange);
                    }
                }
            }
            //Check if to change to the opposite direction based on the robber's X position
            switch(direction){
                case 1: {
                    if(robberX<guardX){
                        direction = 3;
                    }
                }
                case 3: {
                    if(robberX>guardX){
                        direction = 1;
                    }
                }
            }
        }
    }
    
    /**
     * Check if there is any obstacles in front of the Guard.
     * 
     * @return boolean  True if there is any obstacles. False otherwise.
     */
    public boolean detectedObstacles(){
        switch(direction){
            case 1: {
                if(getOneObjectAtOffset(20,0,Obstacle.class)!=null){
                    return true;
                } 
                return false;
            }
            case 2: {
                if(getOneObjectAtOffset(0,-20,Obstacle.class)!=null){
                    return true;
                } 
                return false;
            }
            case 3: {
                if(getOneObjectAtOffset(-20,0,Obstacle.class)!=null){
                    return true;
                } 
                return false;
            }
            default: {
                if(getOneObjectAtOffset(0,20,Obstacle.class)!=null){
                    return true;
                } 
                return false;
            }
        }
    }
}
