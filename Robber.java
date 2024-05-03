import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.lang.Math;
/**
 * Robber, the one who steals
 * 
 * @author Edwin, Nick, Jean, Jerry
 * @version May 2024
 */

// Issues: if there are multiple robbers, it will return
public class Robber extends Human
{
    //add frames to for the robber character
    private static GreenfootImage[] framesRight = {
            new GreenfootImage("Robber/rob.Right0.png"),new GreenfootImage("Robber/rob.Right1.png"),new GreenfootImage("Robber/rob.Right2.png"),
            new GreenfootImage("Robber/rob.Right3.png"),new GreenfootImage("Robber/rob.Right4.png"),new GreenfootImage("Robber/rob.Right5.png"),
            new GreenfootImage("Robber/rob.Right6.png")};
    private static GreenfootImage[] framesUp = {
            new GreenfootImage("Robber/rob.Up0.png"),new GreenfootImage("Robber/rob.Up1.png"),new GreenfootImage("Robber/rob.Up2.png"),
            new GreenfootImage("Robber/rob.Up3.png"),new GreenfootImage("Robber/rob.Up4.png"),new GreenfootImage("Robber/rob.Up5.png"),
            new GreenfootImage("Robber/rob.Up6.png")};
    private static GreenfootImage[] framesLeft = {
            new GreenfootImage("Robber/rob.Left0.png"),new GreenfootImage("Robber/rob.Left1.png"),new GreenfootImage("Robber/rob.Left2.png"),
            new GreenfootImage("Robber/rob.Left3.png"),new GreenfootImage("Robber/rob.Left4.png"),new GreenfootImage("Robber/rob.Left5.png"),
            new GreenfootImage("Robber/rob.Left6.png")};
    private static GreenfootImage[] framesDown = {
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
    Pair curTile, target = null;
    private boolean pathFound = false, returning = false, depositing = false, initial = true;
    private int centerX, centerY;
    private int station;
    /** 
     * Constructor for robber class
     * 
     * @param s     The speed of the robber
     * @param tR    The target radius of the robber
     * @param D     The initial direction of the robber
     * @param station   The position that the robber will go to
     */
    public Robber(double s, int tR, int D, int station){
        direction = D; 
        speed = s; targetRadius = tR;
        hasStolen = false; actNum = 1; frameNum = 0;
        enableStaticRotation(); isMoving = false;
        setIdleImage();
        this.station = station; // 0, 1, 2
        for (int i = 0;i<7;i++) {
            framesRight[i].scale(40, 55);
            framesLeft[i].scale(40, 55);
            framesUp[i].scale(40, 55);
            framesDown[i].scale(40, 55);
        } 
    }
    

    public void act()
    {
        if (initial) {
            centerX = getX(); centerY = getY();
            initial = false; 
            MuseumRoom mr = (MuseumRoom) getWorld();
            mr.setStation(station, true);
            isMoving = false;
        }
        if (actNum % 300 == 0 && targetValuable == null && !returning) {
            target = getRandomPositionWithinRadius(75); 
        }
        
        if (target != null) {
            moveTowardsTarget();
        }
        
        if(!isMoving)
            setIdleImage();
            
        animate();
        //goes back to default frame if not moving
        

        if (targetValuable != null && targetValuable.getWorld() == null){
            targetValuable = null;
        }
        if(targetValuable == null && actNum % 1600 == 0){
            getTargetValuable();
            target = null;
        }
        
        // If the robber has a target valuable and is not depositing
        if(targetValuable != null && !depositing && !returning){
            pathfind(targetValuable.getX()/20, targetValuable.getY()/20);
            animate();
        }
        // After the robber has gotten to the valuable's location, go to deposit the valuable
        if (depositing) {
            pathfind(33, 34); // return to deposit zone
            animate();
        }
        if (returning) {    
            if (station == 0) {
                pathfind(13, 22);
            } else if (station == 1) {
                pathfind(23, 17);
            } else {
                pathfind(10, 17);
            }
        }
        //take the valuable with me
        if(hasStolen){
            targetValuable.followRobber(this);
        }
        
        actNum++;
    }
    
    
    private void moveTowardsTarget() {
        int currentX = getX();
        int currentY = getY();
        int diffX = target.x - currentX;
        int diffY = target.y - currentY;
    
        if (Math.abs(diffX) > 3) { // Move horizontally if the horizontal distance is greater
            if (diffX > 0) {
                currentX += speed; // Move right
                direction = 1;
            } else {
                currentX -= speed; // Move left
                direction = 3;
            }
        } else if (Math.abs(diffY) > 3){ // Move vertically otherwise
            if (diffY > 0) {
                currentY += speed; // Move down
                direction = 4;
            } else {
                currentY -= speed; // Move up
                direction = 2;
            }
        }
    
        setLocation(currentX, currentY);
        
        // Check if target is reached
        if (Math.abs(diffX) <= speed && Math.abs(diffY) <= speed) {
            setLocation(target.x, target.y); // Snap to the target if very close
            isMoving = false;
            target = null;
        } else {
            isMoving = true;
        }
    }
    
    /**
     * Randomizes the position of the robber
     * 
     * @param radius    The radius sets the maximum distance the robber can move 
     */
    private Pair getRandomPositionWithinRadius(double radius) {
        Random random = new Random();
        boolean isValid = false;
        int curX = getX(), curY = getY();
        int newX = 0, newY = 0;
        
        while (!isValid) {
            double angle = 2 * Math.PI * random.nextDouble(); // Random angle
            double distance = radius * Math.sqrt(random.nextDouble()); // Random distance within the radius
        
            newX = (int) (centerX + distance * Math.cos(angle));
            newY = (int) (centerY + distance * Math.sin(angle));
        
            setLocation(newX, newY);
            
            // Check if the new location intersects with any Obstacles
            if (!detectedObstacles()) {
                isValid = true; // If no intersection, mark as valid and break loop
            }
        }
        setLocation(curX, curY);
        
        return new Pair(newX, newY);
    }

    //targeting code taken from bug simulation
    private void getTargetValuable(){

        //get all the valuables in range
        valuables = (ArrayList<Valuable>)getObjectsInRange(targetRadius+1,Valuable.class);
                
        if(valuables.size() > 0){
            //get a random valuable in range and set it as a target
            for (Valuable v: valuables) {
                targetValuable = valuables.get(Greenfoot.getRandomNumber(valuables.size()));
                if (!targetValuable.isStolen()) break;
            }
        }        
        
        if (targetValuable != null && targetValuable.isStolen()) targetValuable = null;
        else if (targetValuable != null) targetValuable.setStolen(true);
    }
    
    /**
     * Sets the robbers direction
     * 
     * @param D     The integer corresponding with the direction of the robber
     */
    public void setDirection(int D){
        if(D < 5 && D > 0){
            direction = D;
        }
    }
    public int getDirection(){
        return direction;
    }
    public boolean robbedSomething(){
        return targetValuable != null && targetValuable.isStolen();
    }
    public void setIdleImage(){
        if(direction == 1)
            setImage(framesRight[0]);
        if(direction == 2)
            setImage(framesUp[0]);
        if(direction == 3)
            setImage(framesLeft[0]);
        if(direction == 4)
            setImage(framesDown[0]);
    }
    
    /**
     * Sets the speed of the robber
     * 
     * @param speed     The integer corresponding to how fast the robber can move
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    
    public void animate() {
        // Animate the robber while moving
        // make sure that character is moving, modifies frame rate with y = mx + b
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
                    setImage(framesRight[frameNum]);//face right
                    break;
                case 2:
                    setImage(framesUp[frameNum]);//face up
                    break;
                case 3:
                    setImage(framesLeft[frameNum]);//face left
                    break;
                default:
                    setImage(framesDown[frameNum]);//face down defaultly
                    break;
            }
        }
    }
    // If did not do bfs, do it and get the path.
            
    public void pathfind(int destx, int desty) {
        if (!pathFound) {
            // Since the bfs works on 20x20 tiles, divide the x and y values by 20
            path = bfs(getX()/20, getY()/20, destx, desty);
            
            // If the robber cannot find a path
            if (path.size() == 0) return;
            
            // Get the targeted tile
            curTile = path.remove(0);
                        
            // Mark that bfs has already been done
            pathFound = true;
        }
        
        // Get the absolute x and y distances between the robber and the current tile
        int dx = Math.abs((curTile.x*20) - getX());
        int dy = Math.abs((curTile.y*20) - getY());
        
        isMoving = true;
        // If there is a gap, then adjust the x direction
        if (dx != 0) { 
            // if the robber is to the right of the targeted tile, move him left
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
            // If the robber is below the targeted tile, move him up
            if (getY() > curTile.y*20) {
                setLocation(getX(), getY()-speed);
                direction = 2; // set the direction to up
            } else {
                // Otherwise, move him down
                setLocation(getX(), getY()+speed);
                direction = 4; // set the direction to down
            }
        }
        
    
        // Check if target is reached (considering possible overshoot)
        if (Math.abs(dx) <= speed && Math.abs(dy) <= speed) {
            // Target reached
            setLocation(curTile.x*20, curTile.y*20); // Correct any minor overshoot
            if (!path.isEmpty()) {
                curTile = path.remove(0); // Get and remove the first element
            } else {
                if (depositing) {
                    hasStolen = false; // Set up to steal another valuable
                    getWorld().removeObject(targetValuable);
                    MuseumRoom mr = (MuseumRoom) getWorld();
                    station = mr.getStation();
                    mr.setStation(station, true);
                    mr.setMoney(targetValuable.getPrice());
                    mr.setValuables(1);
                    targetValuable = null;// No more targets
                    returning = true;
                    depositing = false;
                } else if (returning){
                    centerX = getX();
                    centerY = getY();
                    returning = false;
                }else {
                    hasStolen = true; // currently stealing, so set to pick up valuable
                    depositing = true; // return to deposit zone
                    MuseumRoom mr = (MuseumRoom) getWorld();
                    mr.setStation(station, false);
                }
                pathFound = false;
                curTile = null;
                isMoving = false;
            }
        } 
    }
    public boolean detectedObstacles(){
        if (getIntersectingObjects(Obstacle.class).size() != 0) return true;
        return false;
    }
    
    public Valuable getCurValuable() {
        return targetValuable;
    }
    /**
     * returns the station of the robber
     */
    public int getStation() {
        return station;
    }
}