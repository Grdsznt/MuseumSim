import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.lang.Math;
import java.util.Random;
import java.util.*;
/**
 * Write a description of class Robber here.
 * 
 * @author Edwin, Nick
 * @version (a version number or a date)
 */
public class Robber extends Human
{
    //add frames to for the robber character
    private static GreenfootImage[] FramesRight = {
            new GreenfootImage("Robber/rob.Right0.png"),new GreenfootImage("Robber/rob.Right1.png"),new GreenfootImage("Robber/rob.Right2.png"),
            new GreenfootImage("Robber/rob.Right3.png"),new GreenfootImage("Robber/rob.Right4.png"),new GreenfootImage("Robber/rob.Right5.png"),
            new GreenfootImage("Robber/rob.Right6.png")};
    private static GreenfootImage[] FramesUp = {
            new GreenfootImage("Robber/rob.Up0.png"),new GreenfootImage("Robber/rob.Up1.png"),new GreenfootImage("Robber/rob.Up2.png"),
            new GreenfootImage("Robber/rob.Up3.png"),new GreenfootImage("Robber/rob.Up4.png"),new GreenfootImage("Robber/rob.Up5.png"),
            new GreenfootImage("Robber/rob.Up6.png")};
    private static GreenfootImage[] FramesLeft = {
            new GreenfootImage("Robber/rob.Left0.png"),new GreenfootImage("Robber/rob.Left1.png"),new GreenfootImage("Robber/rob.Left2.png"),
            new GreenfootImage("Robber/rob.Left3.png"),new GreenfootImage("Robber/rob.Left4.png"),new GreenfootImage("Robber/rob.Left5.png"),
            new GreenfootImage("Robber/rob.Left6.png")};
    private static GreenfootImage[] FramesDown = {
            new GreenfootImage("Robber/rob.Down0.png"),new GreenfootImage("Robber/rob.Down1.png"),new GreenfootImage("Robber/rob.Down2.png"),
            new GreenfootImage("Robber/rob.Down3.png"),new GreenfootImage("Robber/rob.Down4.png"),new GreenfootImage("Robber/rob.Down5.png"),
            new GreenfootImage("Robber/rob.Down6.png")};
    //Randomizer cuz greenfoot one doesn't let me use it or something
    private static Random r = new Random();
    //instance variables
    private int actNum,frameNum;
    private boolean hasStolen, isMoving;
    private Valuable targetValuable;
    private ArrayList<Valuable> valuables;
    private double speed;
    private int targetRadius;
    private int direction;//1 right, 2 up, 3 left, 4 down
    
    private List<Pair> path;
    Pair curValuable;
    public Robber(double s, int tR, int D){
        direction = D;
        setIdleImage();
        speed = s; targetRadius = tR;
        hasStolen = false; actNum = 0; frameNum = 0;
        enableStaticRotation(); isMoving = false;
    }

    /**
     * Act - do whatever the Robber wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //testing animation
        if (Greenfoot.isKeyDown("up")) {
            int curX = getX(), curY = getY();
            setLocation(curX, curY - speed); // Move up
            if (!detectedObstacles()) {
                direction = 2;
                isMoving = true;
            } else {
                setLocation(curX, curY); // Move back if detected obstacle
            }
        }
        else if (Greenfoot.isKeyDown("down")) {
            int curX = getX(), curY = getY();
            setLocation(curX, curY + speed); // Move down
            if (!detectedObstacles()) {
                direction = 4;
                isMoving = true;
            } else {
                setLocation(curX, curY); // Move back if detected obstacle
            }
        }
        else if (Greenfoot.isKeyDown("left")) {
            int curX = getX(), curY = getY();
            setLocation(curX-speed, curY); // Move left
            if (!detectedObstacles()) {
                direction = 3;
                isMoving = true;
            } else {
                setLocation(curX, curY); // Move back if detected obstacle
            }
        }
        else if (Greenfoot.isKeyDown("right")) {
            int curX = getX(), curY = getY();
            setLocation(curX+speed, curY); // Move right
            if (!detectedObstacles()) {
                direction = 1;
                isMoving = true;
            } else {
                setLocation(curX, curY); // Move back if detected obstacle
            }
        }
        else{
            isMoving = false;
        }
        //animation
        //make sure that character is moving, modifies frame rate with y = mx + b
        if(isMoving && actNum % (speed !=0 ? (int) (-6 * speed + 20) : 10) == 0){
            
            //changing the frame
            if(frameNum >= 6){
                frameNum = 0;
            }
            else{
                frameNum++;
            }
            //shows the character facing the direction it should be facing
            switch(direction){
                case 1:
                    setImage(FramesRight[frameNum]);//face right
                    break;
                case 2:
                    setImage(FramesUp[frameNum]);//face up
                    break;
                case 3:
                    setImage(FramesLeft[frameNum]);//face left
                    break;
                case 4:
                    setImage(FramesDown[frameNum]);//face down
                    break;
                default:
                    setImage(FramesDown[frameNum]);//face down defaultly
                    break;
            }
        }
        //goes back to default frame if not moving
        if(!isMoving)
            setIdleImage();

        // Add your action code here.
        if (targetValuable != null && targetValuable.getWorld() == null){
                targetValuable = null;
        }
        if(targetValuable == null){
            getTargetValuable();
        }
        if(targetValuable != null){
            //move towards it and steal it
            // path = bfs(getX()/20, getY()/20, targetValuable/20, targetValuableY/20);
            curValuable = path.remove(0);
            int dx = curValuable.c*20 - getX();
            int dy = curValuable.r*20 - getY();
            
            if (dx != 0) {
                double moveX = speed * (int)Math.signum(dx); // Determine direction
                setLocation(getX() + moveX, getY());
            }
            // Once aligned horizontally, move vertically
            else if (dy != 0) {
                double moveY = speed * (int)Math.signum(dy); // Determine direction
                setLocation(getX(), getY() + moveY);
            }
            // Check if target is reached (considering possible overshoot)
            if (Math.abs(dx) <= speed && Math.abs(dy) <= speed) {
                // Target reached
                setLocation(curValuable.c*20, curValuable.r*20); // Correct any minor overshoot
                if (!path.isEmpty()) {
                    curValuable = path.remove(0); // Get and remove the first element
                } else {
                    curValuable = null;
                    targetValuable = null;// No more targets
                }
            }
            switch(direction){
                case 1:
                    setImage(FramesRight[frameNum]);//face right
                    break;
                case 2:
                    setImage(FramesUp[frameNum]);//face up
                    break;
                case 3:
                    setImage(FramesLeft[frameNum]);//face left
                    break;
                case 4:
                    setImage(FramesDown[frameNum]);//face down
                    break;
                default:
                    setImage(FramesDown[frameNum]);//face down defaultly
                    break;
            }
            robThatSh1t();
        }
        
        //take the valuable with me
        if(hasStolen){
            targetValuable.followRobber(this);
        }
        
        actNum++;
    }

    //targeting code taken from bug simulation
    private void getTargetValuable(){

        //get all the valuables in range
        valuables = (ArrayList<Valuable>)getObjectsInRange(targetRadius+1,Valuable.class);

        if(valuables.size() > 0){
            //get a random valuable in range and set it as a target
            targetValuable = valuables.get(Greenfoot.getRandomNumber(valuables.size()));

        }        

        
    }
    //rob the object and take it with oneself
    private void robThatSh1t(){
        if(targetValuable != null){
            
            if(intersects(targetValuable)){
                targetValuable.stealMe();
                hasStolen = true;
            }
            /**
            //do pythagorean theorem to figure out the distance between robber and valuabe
            double valuableDistance = Math.sqrt(Math.pow(this.getX() - targetValuable.getX(),2) + Math.pow(this.getY() - targetValuable.getY(),2));
            //replace ten with an apporiate value here!!!
            if(valuableDistance < 10 && !targetValuable.isStolen()){
                targetValuable.stealMe();
                hasStolen = true;
            }
            */
            
        }
    }
    private void walkRandomly(){
        
    }

    private void enterRoom(){

    }

    public void setDirection(int D){
        if(D < 5 && D > 0){
            direction = D;
        }
    }
    public int getDirection(){
        return direction;
    }
    public boolean robbedSomething(){
        return hasStolen;
    }
    public void setIdleImage(){
        if(direction == 1)
            setImage("Robber/rob.Right0.png");
        if(direction == 2)
            setImage("Robber/rob.Up0.png");
        if(direction == 3)
            setImage("Robber/rob.Left0.png");
        if(direction == 4)
            setImage("Robber/rob.Down0.png");
    }
     
    public boolean detectedObstacles(){
        switch(direction){
            case 1: {
                if(getOneObjectAtOffset(20,0,Object.class)!=null){
                    return true;
                } 
                return false;
            }
            case 2: {
                if(getOneObjectAtOffset(0,-20,Object.class)!=null){
                    return true;
                } 
                return false;
            }
            case 3: {
                if(getOneObjectAtOffset(-20,0,Object.class)!=null){
                    return true;
                } 
                return false;
            }
            default: {
                if(getOneObjectAtOffset(0,20,Object.class)!=null){
                    return true;
                } 
                return false;
            }
        }
    }
}
