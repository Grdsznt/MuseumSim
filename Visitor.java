import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.ArrayList;
/**
 * Just an ordinary visitor
 * 
 * @author Edwin, Felix, Jerry
 * @version May 2 2024
 */
public class Visitor extends Human
{
    //animation frames of visitor
    //molly run animation all direction, 6 frames each
    private static GreenfootImage[] mollyRunRight = { new GreenfootImage("Molly/runR1.png"), new GreenfootImage("Molly/runR2.png"), new GreenfootImage("Molly/runR3.png"), new GreenfootImage("Molly/runR4.png"), new GreenfootImage("Molly/runR5.png"), new GreenfootImage("Molly/runR6.png") };
    private static GreenfootImage[] mollyRunUp = { new GreenfootImage("Molly/runU1.png"), new GreenfootImage("Molly/runU2.png"), new GreenfootImage("Molly/runU3.png"), new GreenfootImage("Molly/runU4.png"), new GreenfootImage("Molly/runU5.png"), new GreenfootImage("Molly/runU6.png")};
    private static GreenfootImage[] mollyRunLeft = { new GreenfootImage("Molly/runL1.png"), new GreenfootImage("Molly/runL2.png"), new GreenfootImage("Molly/runL3.png"), new GreenfootImage("Molly/runL4.png"), new GreenfootImage("Molly/runL5.png"), new GreenfootImage("Molly/runL6.png") };
    private static GreenfootImage[] mollyRunDown = { new GreenfootImage("Molly/runD1.png"), new GreenfootImage("Molly/runD2.png"), new GreenfootImage("Molly/runD3.png"), new GreenfootImage("Molly/runD4.png"), new GreenfootImage("Molly/runD5.png"), new GreenfootImage("Molly/runD6.png") };
    //molly idle animation 4 direction, 6 frames each
    private static GreenfootImage[] mollyIdleRight = { new GreenfootImage("Molly/idleR1.png"), new GreenfootImage("Molly/idleR2.png"), new GreenfootImage("Molly/idleR3.png"), new GreenfootImage("Molly/idleR4.png"), new GreenfootImage("Molly/idleR5.png"), new GreenfootImage("Molly/idleR6.png") };
    private static GreenfootImage[] mollyIdleUp = { new GreenfootImage("Molly/idleU1.png"), new GreenfootImage("Molly/idleU2.png"), new GreenfootImage("Molly/idleU3.png"), new GreenfootImage("Molly/idleU4.png"), new GreenfootImage("Molly/idleU5.png"), new GreenfootImage("Molly/idleU6.png")};
    private static GreenfootImage[] mollyIdleLeft = { new GreenfootImage("Molly/idleL1.png"), new GreenfootImage("Molly/idleL2.png"), new GreenfootImage("Molly/idleL3.png"), new GreenfootImage("Molly/idleL4.png"), new GreenfootImage("Molly/idleL5.png"), new GreenfootImage("Molly/idleL6.png") };
    private static GreenfootImage[] mollyIdleDown = { new GreenfootImage("Molly/idleD1.png"), new GreenfootImage("Molly/idleD2.png"), new GreenfootImage("Molly/idleD3.png"), new GreenfootImage("Molly/idleD4.png"), new GreenfootImage("Molly/idleD5.png"), new GreenfootImage("Molly/idleD6.png") };
    //molly idle hoping 4 directoins, 6 frames each
    private static GreenfootImage[] mollyHopRight = { new GreenfootImage("Molly/hopR1.png"), new GreenfootImage("Molly/hopR2.png"), new GreenfootImage("Molly/hopR3.png"), new GreenfootImage("Molly/hopR4.png"), new GreenfootImage("Molly/hopR5.png"), new GreenfootImage("Molly/hopR6.png") };
    private static GreenfootImage[] mollyHopUp = { new GreenfootImage("Molly/hopU1.png"), new GreenfootImage("Molly/hopU2.png"), new GreenfootImage("Molly/hopU3.png"), new GreenfootImage("Molly/hopU4.png"), new GreenfootImage("Molly/hopU5.png"), new GreenfootImage("Molly/hopU6.png")};
    private static GreenfootImage[] mollyHopLeft = { new GreenfootImage("Molly/hopL1.png"), new GreenfootImage("Molly/hopL2.png"), new GreenfootImage("Molly/hopL3.png"), new GreenfootImage("Molly/hopL4.png"), new GreenfootImage("Molly/hopL5.png"), new GreenfootImage("Molly/hopL6.png") };
    private static GreenfootImage[] mollyHopDown = { new GreenfootImage("Molly/hopD1.png"), new GreenfootImage("Molly/hopD2.png"), new GreenfootImage("Molly/hopD3.png"), new GreenfootImage("Molly/hopD4.png"), new GreenfootImage("Molly/hopD5.png"), new GreenfootImage("Molly/hopD6.png") };
    //molly reading a book animation, only down direction, 18 frames
    private static GreenfootImage[] mollyRead = { new GreenfootImage("Molly/read1.png"), new GreenfootImage("Molly/read2.png"), new GreenfootImage("Molly/read3.png"), new GreenfootImage("Molly/read4.png"), new GreenfootImage("Molly/read5.png"), new GreenfootImage("Molly/read6.png"), 
            new GreenfootImage("Molly/read7.png"),  new GreenfootImage("Molly/read8.png"), new GreenfootImage("Molly/read9.png"), new GreenfootImage("Molly/read10.png"), new GreenfootImage("Molly/read11.png"), new GreenfootImage("Molly/read12.png"),
            new GreenfootImage("Molly/read13.png"), new GreenfootImage("Molly/read14.png"), new GreenfootImage("Molly/read15.png"), new GreenfootImage("Molly/read16.png"), new GreenfootImage("Molly/read17.png"), new GreenfootImage("Molly/read18.png") };
    //molly checking phone animation, only down direction, 9 frames
    private static GreenfootImage[] mollyPhone = {new GreenfootImage("Molly/phone1.png"), new GreenfootImage("Molly/phone2.png"),new GreenfootImage("Molly/phone3.png"),new GreenfootImage("Molly/phone4.png"),new GreenfootImage("Molly/phone5.png"),new GreenfootImage("Molly/phone6.png"),
            new GreenfootImage("Molly/phone7.png"),new GreenfootImage("Molly/phone8.png"),new GreenfootImage("Molly/phone9.png") };   
    //adam runing animation, 4 direction, 6 frames each
    private static GreenfootImage[] adamRunRight = { new GreenfootImage("Adam/runR1.png"), new GreenfootImage("Adam/runR2.png"), new GreenfootImage("Adam/runR3.png"), new GreenfootImage("Adam/runR4.png"), new GreenfootImage("Adam/runR5.png"), new GreenfootImage("Adam/runR6.png") };
    private static GreenfootImage[] adamRunUp = { new GreenfootImage("Adam/runU1.png"), new GreenfootImage("Adam/runU2.png"), new GreenfootImage("Adam/runU3.png"), new GreenfootImage("Adam/runU4.png"), new GreenfootImage("Adam/runU5.png"), new GreenfootImage("Adam/runU6.png")};
    private static GreenfootImage[] adamRunLeft = { new GreenfootImage("Adam/runL1.png"), new GreenfootImage("Adam/runL2.png"), new GreenfootImage("Adam/runL3.png"), new GreenfootImage("Adam/runL4.png"), new GreenfootImage("Adam/runL5.png"), new GreenfootImage("Adam/runL6.png") };
    private static GreenfootImage[] adamRunDown = { new GreenfootImage("Adam/runD1.png"), new GreenfootImage("Adam/runD2.png"), new GreenfootImage("Adam/runD3.png"), new GreenfootImage("Adam/runD4.png"), new GreenfootImage("Adam/runD5.png"), new GreenfootImage("Adam/runD6.png") };
    //adam idle animation, 4 direction and 6 frames each
    private static GreenfootImage[] adamIdleRight = { new GreenfootImage("Adam/idleR1.png"), new GreenfootImage("Adam/idleR2.png"), new GreenfootImage("Adam/idleR3.png"), new GreenfootImage("Adam/idleR4.png"), new GreenfootImage("Adam/idleR5.png"), new GreenfootImage("Adam/idleR6.png") };
    private static GreenfootImage[] adamIdleUp = { new GreenfootImage("Adam/idleU1.png"), new GreenfootImage("Adam/idleU2.png"), new GreenfootImage("Adam/idleU3.png"), new GreenfootImage("Adam/idleU4.png"), new GreenfootImage("Adam/idleU5.png"), new GreenfootImage("Adam/idleU6.png")};
    private static GreenfootImage[] adamIdleLeft = { new GreenfootImage("Adam/idleL1.png"), new GreenfootImage("Adam/idleL2.png"), new GreenfootImage("Adam/idleL3.png"), new GreenfootImage("Adam/idleL4.png"), new GreenfootImage("Adam/idleL5.png"), new GreenfootImage("Adam/idleL6.png") };
    private static GreenfootImage[] adamIdleDown = { new GreenfootImage("Adam/idleD1.png"), new GreenfootImage("Adam/idleD2.png"), new GreenfootImage("Adam/idleD3.png"), new GreenfootImage("Adam/idleD4.png"), new GreenfootImage("Adam/idleD5.png"), new GreenfootImage("Adam/idleD6.png") };
    //adam reading book animation, only down direction, 18 frames
    private static GreenfootImage[] adamRead = { new GreenfootImage("Adam/read1.png"), new GreenfootImage("Adam/read2.png"), new GreenfootImage("Adam/read3.png"), new GreenfootImage("Adam/read4.png"), new GreenfootImage("Adam/read5.png"), new GreenfootImage("Adam/read6.png"), 
            new GreenfootImage("Adam/read7.png"),  new GreenfootImage("Adam/read8.png"), new GreenfootImage("Adam/read9.png"), new GreenfootImage("Adam/read10.png"), new GreenfootImage("Adam/read11.png"), new GreenfootImage("Adam/read12.png"),
            new GreenfootImage("Adam/read13.png"), new GreenfootImage("Adam/read14.png"), new GreenfootImage("Adam/read15.png"), new GreenfootImage("Adam/read16.png"), new GreenfootImage("Adam/read17.png"), new GreenfootImage("Adam/read18.png") };
    //adam checking phone animation, only down direction, 9 frames
    private static GreenfootImage[] adamPhone = {new GreenfootImage("Adam/phone1.png"), new GreenfootImage("Adam/phone2.png"),new GreenfootImage("Adam/phone3.png"),new GreenfootImage("Adam/phone4.png"),new GreenfootImage("Adam/phone5.png"),new GreenfootImage("Adam/phone6.png"),
            new GreenfootImage("Adam/phone7.png"),new GreenfootImage("Adam/phone8.png"),new GreenfootImage("Adam/phone9.png") };   

    private static int numberOfVisitors = 0;
    private boolean willReadBook, willLookPhone, isMoving; //yes is true, no is false
    private int visitDuration;// in units of acts
    private int actNum, frameNum, speed;
    private boolean mollyOrAdam;//true is molly, false is adam
    private int direction;//1 right, 2 up, 3 left, 4 down
    private Emote emote;
    
    protected boolean playing = false, flag = false, toSpot = false, isNew=false, leaving=false, insane=false, pathFound = false, targeting = false;
    private int targetX, targetY;
    
    
    Pair curTile;
    private ArrayList<Pair> path;

    /**
     * Constructor for the visitor
     * 
     * @param time   The length of time the visitor stays in the world
     * @param speed     How fast the visitor moves
     */
    public Visitor(int time, int speed){
        visitDuration = time;
        numberOfVisitors++;
        willReadBook = false; willLookPhone = false; isMoving = false;
        mollyOrAdam = Greenfoot.getRandomNumber(2) == 0;//molly or adam is randomized
        actNum = 0; frameNum = 0;
        direction = 4;
        this.speed = speed;
        if(mollyOrAdam){
            setImage(mollyIdleDown[0]);
        }
        else{
            setImage(adamIdleDown[0]);
        }
    }
    
    public void addedToWorld(World w){
        if(!isNew){//prevent z sort problems
            isNew=true;
        }
        MuseumRoom mr = (MuseumRoom) getWorld();
        mr.setIncome(80);
    }
    /** 
     * Constructor for visitor
     * 
     * @param time The length of time the visitor stays in the world
     */
    public Visitor(int time){
        visitDuration = time;
        numberOfVisitors++;
        willReadBook = false; willLookPhone = false; isMoving = false;
        mollyOrAdam = Greenfoot.getRandomNumber(2) == 0;//molly or adam is randomized
        actNum = 0; frameNum = 0;
        direction = 4;
        this.speed = speed;
        if(mollyOrAdam){
            setImage(mollyIdleDown[0]);
        }
        else{
            setImage(adamIdleDown[0]);
        }
    }

    /**
     * Act - do whatever the Visitor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //testing section
        if(Greenfoot.isKeyDown("a")){
            expressEmotion();
        }
        if (actNum % 900 == 0 && !leaving) {
            pickNewTarget();
            targeting = true;
        }
        if (!pathFound && targeting) {
            // Since the bfs works on 20x20 tiles, divide the x and y values by 20
            path = bfs(getX()/20, getY()/20, targetX/20, targetY/20);
            
            if (path.size() != 0){
                // Get the targeted tile
                curTile = path.remove(0);
                            
                // Mark that bfs has already been done
                pathFound = true;
            }

            
        }
        if(leaving) {
            // Get the absolute x and y distances between the robber and the current tile
            int dx = 0;
            int dy = 0;
            if(this.curTile != null){
                 dx = Math.abs((curTile.x*20) - getX());
                 dy = Math.abs((curTile.y*20) - getY());
            }
                     
            isMoving = true;
            // If there is a gap, then adjust the x direction
            if (dx != 0) { 
                // if the visitor is to the right of the targeted tile, move him left
                if (getX() > curTile.x*20) {
                    setLocation(getX() - speed, getY());
                    direction = 3; // set the direction to left
                } else {
                    // otherwise, move him right
                    setLocation(getX() + speed, getY());
                    direction = 1; // set the direction to right
                }
            }
            // Once aligned horizontally, move vertically
            else if (dy != 0) {
                // If the visitor is below the targeted tile, move him up
                if (getY() > curTile.y*20) {
                    setLocation(getX(), getY()-speed);
                    direction = 2; // set the direction to up
                } else {
                    // Otherwise, move him down
                    setLocation(getX(), getY()+speed);
                    direction = 4; // set the direction to down
                }
            }
            
            // Check if target is reached
            if (Math.abs(dx) <= speed && Math.abs(dy) <= speed && curTile != null) {
                setLocation(curTile.x*20, curTile.y*20);
                if (!path.isEmpty()) {
                    curTile = path.remove(0);
                }
                else {
                    getWorld().removeObject(this);
                    numberOfVisitors--;
                }
            }
        }
        else if (targeting){ 
            // Get the absolute x and y distances between the robber and the current tile
            int dx = 0;
            int dy = 0;
            if(this.curTile != null){
                 dx = Math.abs((curTile.x*20) - getX());
                 dy = Math.abs((curTile.y*20) - getY());
            }
            
            // System.out.println(curTile.x + " " + curTile.y);
         
            isMoving = true;
            // If there is a gap, then adjust the x direction
            if (dx != 0) { 
                // if the visitor is to the right of the targeted tile, move him left
                if (getX() > curTile.x*20) {
                    setLocation(getX() - speed, getY());
                    direction = 3; // set the direction to left
                } else {
                    // otherwise, move him right
                    setLocation(getX() + speed, getY());
                    direction = 1; // set the direction to right
                }
            }
            // Once aligned horizontally, move vertically
            else if (dy != 0) {
                // If the visitor is below the targeted tile, move him up
                if (getY() > curTile.y*20) {
                    setLocation(getX(), getY()-speed);
                    direction = 2; // set the direction to up
                } else {
                    // Otherwise, move him down
                    setLocation(getX(), getY()+speed);
                    direction = 4; // set the direction to down
                }
            }
            
            // Check if target is reached
            if (Math.abs(dx) <= speed && Math.abs(dy) <= speed && curTile != null) {
                setLocation(curTile.x*20, curTile.y*20);
                if (!path.isEmpty()) {
                    curTile = path.remove(0);
                }
                else {
                    pathFound = false;
                    isMoving = false;
                    curTile = null;
                    targeting = false;
                }
            }
        }
        
        
        //animation section
        if(mollyOrAdam){
            ///molly animation, second condition controls frame rate

            if(isMoving && actNum % (speed !=0 ? (int) (-5 * speed + 25) : 10) == 0){
                //moving animation, set isMoving to true to play this section
                
                //changing the frame
                if(frameNum >= mollyRunDown.length - 1){
                    frameNum = 0;
                }
                else{
                    frameNum++;
                }
                //shows the character facing the direction it should be facing
                switch(direction){
                    case 1:
                        setImage(mollyRunRight[frameNum]);//face right
                        break;
                    case 2:
                        setImage(mollyRunUp[frameNum]);//face up
                        break;
                    case 3:
                        setImage(mollyRunLeft[frameNum]);//face left
                        break;
                    case 4:
                        setImage(mollyRunDown[frameNum]);//face down
                        break;
                    default:
                        setImage(mollyRunDown[frameNum]);//face down defaultly
                        break;
                }
            }
            else if(willLookPhone){
                //looking at phone animation, call lookAtPhone() to activate this animation
                if(actNum % 10 == 0){
                    //changing the frame
                    if(frameNum >= mollyPhone.length - 1){
                        frameNum = 0;
                        willLookPhone = false;
                    }
                    else{
                        frameNum++;
                    }
                    setImage(mollyPhone[frameNum]);
                }
            }
            else if(willReadBook){
                //looking at phone animation, call lookAtPhone() to activate this animation
                if(actNum % 10 == 0){
                    //changing the frame
                    if(frameNum >= mollyRead.length - 1){
                        frameNum = 0;
                        willReadBook = false;
                    }
                    else{
                        frameNum++;
                    }
                    setImage(mollyRead[frameNum]);
                }
            }
            else{
                //idle animation, 1 frame per 10 acts
                if(actNum % 10 == 0){
                    //changing the frame
                    if(frameNum >= mollyIdleDown.length - 1){
                        frameNum = 0;
                    }
                    else{
                        frameNum++;
                    }
                    //shows the character facing the direction it should be facing
                    switch(direction){
                        case 1:
                            setImage(mollyIdleRight[frameNum]);//face right
                            break;
                        case 2:
                            setImage(mollyIdleUp[frameNum]);//face up
                            break;
                        case 3:
                            setImage(mollyIdleLeft[frameNum]);//face left
                            break;
                        case 4:
                            setImage(mollyIdleDown[frameNum]);//face down
                            break;
                        default:
                            setImage(mollyIdleDown[frameNum]);//face down defaultly
                            break;
                    }
                }
            }

        }else{
            // Adam animation, second condition controls frame rate
            if (isMoving && actNum % (speed !=0 ? (int) (-5 * speed + 25) : 10) == 0) {
                // Moving animation, set isMoving to true to play this section

                // Changing the frame
                if (frameNum >= adamRunDown.length - 1) {
                    frameNum = 0;
                } else {
                    frameNum++;
                }
                // Shows the character facing the direction it should be facing
                switch (direction) {
                    case 1:
                        setImage(adamRunRight[frameNum]);// Face right
                        break;
                    case 2:
                        setImage(adamRunUp[frameNum]);// Face up
                        break;
                    case 3:
                        setImage(adamRunLeft[frameNum]);// Face left
                        break;
                    case 4:
                        setImage(adamRunDown[frameNum]);// Face down
                        break;
                    default:
                        setImage(adamRunDown[frameNum]);// Face down defaultly
                        break;
                }
            } else if (willLookPhone) {
                // Looking at phone animation, call lookAtPhone() to activate this animation
                if (actNum % 10 == 0) {
                    // Changing the frame
                    if (frameNum >= adamPhone.length - 1) {
                        frameNum = 0;
                        willLookPhone = false;
                    } else {
                        frameNum++;
                    }
                    setImage(adamPhone[frameNum]);
                }
            } else if (willReadBook) {
                // Looking at phone animation, call lookAtPhone() to activate this animation
                if (actNum % 10 == 0) {
                    // Changing the frame
                    if (frameNum >= adamRead.length - 1) {
                        frameNum = 0;
                        willReadBook = false;
                    } else {
                        frameNum++;
                    }
                    setImage(adamRead[frameNum]);
                }
            } else {
                // Idle animation, 1 frame per 10 acts
                if (actNum % 10 == 0) {
                    // Changing the frame
                    if (frameNum >= adamIdleDown.length - 1) {
                        frameNum = 0;
                    } else {
                        frameNum++;
                    }
                    // Shows the character facing the direction it should be facing
                    switch (direction) {
                        case 1:
                            setImage(adamIdleRight[frameNum]);// Face right
                            break;
                        case 2:
                            setImage(adamIdleUp[frameNum]);// Face up
                            break;
                        case 3:
                            setImage(adamIdleLeft[frameNum]);// Face left
                            break;
                        case 4:
                            setImage(adamIdleDown[frameNum]);// Face down
                            break;
                        default:
                            setImage(adamIdleDown[frameNum]);// Face down defaultly
                            break;
                    }
                }
            }
        }
        //randomly express some emotion when visiting
        if(Greenfoot.getRandomNumber(1800) ==0 && !leaving){
            expressEmotion();
        }
        if (Greenfoot.getRandomNumber(1800) ==0 && !leaving && !isMoving) {
            lookAtPhone();
        }
        if(emote != null && getWorld() instanceof MuseumRoom){
            emote.followActor(this, 16, -24);
        }
        //remove visitor when time is up
        if(visitDuration <= 0){
            /*numberOfVisitors--;
            getWorld().removeObject(this);
            */
           if(!leaving) {
               leaveMuseum();
            }
           
        }
        actNum++;
        if(visitDuration >0 ) {
            visitDuration--;
        }
    }

    public void readBook(){
        if(!willLookPhone && !willReadBook){
            willReadBook = true;
            frameNum = 0;
        }
    }

    public void lookAtPhone(){
        if(!willLookPhone && !willReadBook){
            willLookPhone = true;
            frameNum = 0;
        }
    }
    private void expressEmotion(){
        emote = new Emote(Greenfoot.getRandomNumber(7)+1);
        getWorld().addObject(emote, getX() + 16, getY() - 24);
    }
    
    private void pickNewTarget() {
        World world = getWorld();
        Random random = new Random();
        int curX = getX(), curY = getY();
        boolean validTarget = false;
        while (!validTarget) {
            int x = random.nextInt(661);
            int y = random.nextInt(816);
            
            // Temporarily move to new position to check for collisions
            setLocation(x, y);
            if (getIntersectingObjects(Obstacle.class).isEmpty() && ((Math.abs(x-curX) > 20) || (Math.abs(y-curY) > 20))) {
                // If no collision, set this as the new target
                targetX = x;
                targetY = y;
                validTarget = true;
            }
        }
        // Reset location after checking
        setLocation(curX, curY);
    }
    
    private boolean isPathBlocked(int newX, int newY) {
        int curX = getX(), curY = getY();
        setLocation(newX, newY);
        boolean blocked = !getIntersectingObjects(Obstacle.class).isEmpty();
        setLocation(getX(), getY()); // Reset position after check
        return blocked;
    }

       
    
    //get the number of visitors
    public static int getNumVisitors(){
        return numberOfVisitors;
    }
    
    private void leaveMuseum() {
        targetX = 20; targetY = 670;
        int curX = getX(), curY = getY();
        leaving = true;
        targeting= true;
        //20, 670
    }
}
