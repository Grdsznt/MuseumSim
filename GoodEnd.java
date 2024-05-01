import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SurpriseEnd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoodEnd extends EndWorld
{

    /**
     * Constructor for objects of class SurpriseEnd.
     * 
     */
    public GoodEnd()
    {
        super(new MuseumRoom(1,1,1,1));
    }
    public void firework(int x, int y, int numPart, int partSpeed){
        //this one takes the x and y coords as parameter to deteremine where the center is
        for(int i = 0; i < numPart; i++){
            double angle = i*2*Math.PI/numPart;
            double xVel = (Math.cos(angle)*partSpeed);
            double yVel = (Math.sin(angle)*partSpeed);
            Image image = new Image(new GreenfootImage("Robber/mora.png"), "1");
            addObject(image, x, y);
            image.turnTowards(x,y);
            image.turn(90);
            image.setVel(xVel, yVel);
            //angleChange += Math.PI/5;
        }
    }
    public void act(){
        if(Greenfoot.getRandomNumber (60) == 0){
            int numParticles = Greenfoot.getRandomNumber(5) + 2;
            firework(Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getWidth()),numParticles , 2);
        }
    }
}
