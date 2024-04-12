    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Guard will have a detector. If it detects any robber by its detector, it will start to catch the robber.
 * 
 * Known bugs:
 * - loadAnimationImages();//!!!!!!!Later put into world
 * - change direction if meet obstacles at the front
 * 
 * @author Jean, Edwin
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
        if(detector.detectedRobbers()){
            catchRobber();
        }
        
        //If it is time to animate, animate it
        if((isCatching && aniCount%runGap==0) || (!isCatching && aniCount%walkGap==0)){
            animate();
        }
        
        //Set its location based on its direction of facing & its catching status
        switch(direction){
            case 1: {
                
                if(isCatching){
                    if (adj[(getX()+(int)runSpeed)*20][getY()*20] != 1) 
                        setLocation(getPreciseX()+runSpeed, getPreciseY());
                } else {
                    if (adj[(getX()+(int)walkSpeed)*20][getY()*20] != 1) 
                        setLocation(getPreciseX()+walkSpeed, getPreciseY());
                }
                break;
            }
            case 2: {
                if(isCatching){
                    if (adj[getX()*20][(getY()-(int)runSpeed)*20] != 1) 
                        setLocation(getPreciseX(), getPreciseY()-runSpeed);
                } else {
                    if (adj[getX()*20][(getY()-(int)walkSpeed)*20] != 1) 
                        setLocation(getPreciseX(), getPreciseY()-walkSpeed);
                }
                break;
            }
            case 3: {
                if(isCatching){
                    if (adj[(getX()-(int)runSpeed)*20][getY()*20] != 1) 
                        setLocation(getPreciseX()-runSpeed, getPreciseY());
                } else {
                    if (adj[(getX()-(int)walkSpeed)*20][getY()*20] != 1) 
                        setLocation(getPreciseX()-walkSpeed, getPreciseY());
                }
                break;
            }
            case 4: {
                if(isCatching){
                    if (adj[getX()*20][(getY()+(int)runSpeed)*20] != 1)
                        setLocation(getPreciseX(), getPreciseY()+runSpeed);
                } else {
                    if (adj[getX()*20][(getY()+(int)walkSpeed)*20] != 1)
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
     */
    public void catchRobber(){
        isCatching = true;
        //If the Guard touches the Robber, it is catched & removed from the world.
        if(isTouching(Robber.class)){
            Robber robber = detector.getRobber();
            world.removeObject(robber);
            isCatching = false;
        }
    }
}
