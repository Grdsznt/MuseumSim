import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * Valuables spawned in place in the Museum Room.
 * 
 * @author Jean, Nick
 * @version May 2024
 */
public abstract class Valuable extends Actor
{
    private MuseumRoom room;
    private int actCount;
    
    private GreenfootImage image;
    private int indexInList;
    private int price;
    private boolean isStolen;
    private int x;
    private int y;
    private boolean needsReturn;

    //After 5s, spawn a new one if it is stolen and does not need to be returned.
    private final int actRefreshGap = 300;
    private boolean isWaiting = false;
    
    /**
     * A simple constructor that sets Right the stolen state and the price of a valuable
     * 
     * @param image     The image of this valuable
     * @param index     The index of this valuable
     * @param price     The price of this valuable
     * @param x         The x position of this valuable
     * @param y         The y position of this valuable
     */
    public Valuable(GreenfootImage image, int index, int price, int x, int y){
        this.actCount = 0;
        this.image = image;
        this.indexInList = index;
        this.price = price;
        this.x = x;
        this.y = y;
        isStolen = false;
        needsReturn = false;
        
        setImage(image);
        if (this instanceof Art) {
            image.scale(65, 86);
            setImage(image);
        }
    }
    
    public void addedToWorld(World w){
        if(w instanceof MuseumRoom){
            this.room = (MuseumRoom) w;
            //room.addValuables(this, indexInList);
        }
    }

    public void act()
    {
        //If it is stolen by the robber and the robber is catched in the middle, go back to its original position.
        if(!isStolen && (getX()!=x || getY()!=y)){
            needsReturn = true;
        }
        
        //Return to its original position after 2 seconds.
        if(needsReturn){
            actCount++;
            //If 2s is past, put it back.
            if(actCount==120){
                setLocation(x,y);
                actCount = 0;
                needsReturn = false;
            }
        }
    }
    
    /**
     * Prepare the Valuable to be spawned.
     */
    public void prepareToSpawn(){
        actCount++;
        //If 5s is past & money is enough in room, spawn a new one.
        if(actCount>=actRefreshGap && room.getIncome()>=price){
            room.setIncome(-price);
            room.addObject(this, x, y);
            actCount = 0;
            isStolen = false;
            isWaiting = false;
        }
    }

    /**
     * Sets this valuable's state as stolen or not
     * 
     * @param b     Used to change the state of isStolen
     * 
     */
    public void setStolen(boolean b){
        isStolen = b;
    }
    
    /**
     * Set this valuable's waiting state.
     * 
     * @param value     The value that should be setting to
     * 
     */
    public void setWaiting(boolean value){
        isWaiting = value;
    }
    
    /**
     * When robber has stolen valuable. The valuable follows the robber.
     * 
     * @param robber    The robber that has stolen this valuable
     */
    public void followRobber(Robber robber){
        int yOffset;
        int xOffset;
        switch(robber.getDirection()){
            case 1:
                //facing right
                yOffset = robber.getY();
                xOffset = robber.getX() + robber.getImage().getWidth()/2;
                setLocation(xOffset, yOffset);
                break;
            case 2:
                //facing up
                yOffset = robber.getY() - robber.getImage().getHeight()/2;
                xOffset = robber.getX();
                setLocation(xOffset, yOffset);
                break;
            case 3:
                //facing left
                yOffset = robber.getY();
                xOffset = robber.getX() - robber.getImage().getWidth()/2;
                setLocation(xOffset, yOffset);
                break;
            case 4:
                //facing down
                yOffset = robber.getY() + robber.getImage().getHeight()/2 - 5;
                xOffset = robber.getX();
                setLocation(xOffset, yOffset);
                break;
        }
    }

    /**
     * returns the state of this valuable
     *  @return true if is stolen, false if it's not
     */
    public boolean isStolen(){
        return this.isStolen;
    }

    /**
     * returns the price of this valuable
     *  @return int price of this valuable
     */
    public int getPrice(){
        return this.price;
    }

    /**
     * Returns if this is waiting to be spawned.
     * 
     * @return boolean      True if it is waiting to be spawned, false otherwise.
     */
    public boolean getWaiting(){
        return this.isWaiting;
    }
}
