import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SurpriseEnd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoodEnd extends EndWorld
{
    private int actNum;
    private static GreenfootSound yuanshen = new GreenfootSound("yuanshen.mp3");
    private static GreenfootSound GEBGM = new GreenfootSound("shed a light.mp3");
    private Image white;
    private Image genshin;
    /**
     * Constructor for objects of class SurpriseEnd.
     * 
     */
    public GoodEnd()
    {
        super(new MuseumRoom(1,1,1,1));
        actNum = 0;
        GreenfootImage image = new GreenfootImage("Robber/genshin.png");
        image.scale(1200,800);
        genshin = new Image (image);
        white = new Image (new GreenfootImage("Robber/white.png"));
        addObject(white, getWidth()/2, getHeight()/2);
    }

    public void act(){

        if(actNum == 740){
            addObject(genshin, getWidth()/2, getHeight()/2);
        }
        if(actNum > 740 && actNum < 840){
            int transparency = (int) (255 * ((double) (actNum - 740) /100));
            if(transparency < 256){
                genshin.getImage().setTransparency(transparency);
            }
        }
        if (actNum > 1240 && actNum < 1340) {
            int transparency = (int) (255 * (1 - ((double)(actNum - 1240) / (1340 - 1240))));
            genshin.getImage().setTransparency(transparency);
        }
        if(actNum == 1340){
            removeObject(genshin);
            removeObject(white);
        }
        if(actNum > 1440){
            dropDownMenu.moveNow();
            if(Greenfoot.getRandomNumber (10) == 0){
                int numParticles = Greenfoot.getRandomNumber(8) + 2;
                firework(Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getWidth()),numParticles , 2);
            }
        }

        actNum++;
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

    public void started(){
        yuanshen.play();
    }
}
