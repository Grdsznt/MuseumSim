import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SurpriseEnd here.
 * good ending of the game
 * @author Nick
 * @version (a version number or a date)
 */
public class GoodEnd extends EndWorld
{
    private int actNum;
    private static GreenfootSound yuanshen = new GreenfootSound("yuanshen.mp3");
    private static GreenfootSound GEBGM = new GreenfootSound("shed a light.mp3");
    private static GreenfootSound kaching = new GreenfootSound("kaching.mp3");
    private Image white;
    private Image genshin;
    /**
     * Constructor for objects of class SurpriseEnd.
     * 
     */
    public GoodEnd(MuseumRoom room)
    {
        super(room);
        actNum = 0;
        GreenfootImage image = new GreenfootImage("Robber/genshin.png");
        image.scale(1150,800);
        genshin = new Image (image);
        white = new Image (new GreenfootImage("Robber/white.png"));
        addObject(white, getWidth()/2, getHeight()/2);
    }
    /**
     * act method for the class, includes a congratulation effect
     * 
     */
    public void act(){
        super.act();
        //code between makes a congratulation effect
        if(actNum ==0){
            yuanshen.play();
        }
        if(actNum == 420){
            addObject(genshin, getWidth()/2, getHeight()/2);
        }
        if(actNum > 420 && actNum < 520){
            int transparency = (int) (255 * ((double) (actNum - 420) /100));
            if(transparency < 256){
                genshin.getImage().setTransparency(transparency);
            }
        }
        if (actNum > 650 && actNum < 750) {
            int transparency = (int) (255 * (1 - ((double)(actNum - 650) / 100)));
            if(transparency < 256){
                genshin.getImage().setTransparency(transparency);
            }
        }
        if(actNum == 750){
            removeObject(genshin);
            removeObject(white);
        }
        if(actNum > 750){
            dropDownMenu.moveNow();
            if(Greenfoot.getRandomNumber (10) == 0){
                int numParticles = Greenfoot.getRandomNumber(4)+2;
                firework(Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getWidth()),numParticles , 2);
                kaching.play();
            }
        }
        if(actNum == 820){
            GEBGM.play();
        }
        //System.out.println(actNum);
        actNum++;
    }
    /**
     * gold coins dropping effect for ending screen
     * 
     * @param x         x coord for the orgin
     * @param y         y coord for the orgin (needs an orgin to know where the particles are spread out from)
     * @param numPart   number of particles of each effect
     * @param partSpeed initial speed of the particles
     */
    public void firework(int x, int y, int numPart, int partSpeed){
        //this one takes the x and y coords as parameter to deteremine where the center is
        for(int i = 0; i < numPart; i++){
            double angle = i*2*Math.PI/numPart;
            double xVel = (Math.cos(angle)*partSpeed);
            double yVel = (Math.sin(angle)*partSpeed);
            if(Greenfoot.getRandomNumber(3) == 0){
                Image image = new Image(new GreenfootImage("Robber/primogem.png"), "1");
                addObject(image, x, y);
                image.turnTowards(x,y);
                image.turn(90);
                image.setVel(xVel, yVel);
            }
            else{
                Image image = new Image(new GreenfootImage("Robber/mora.png"), "1");
                addObject(image, x, y);
                image.turnTowards(x,y);
                image.turn(90);
                image.setVel(xVel, yVel);
            }
            //angleChange += Math.PI/5;
        }
    }

    public void stopped(){
        GEBGM.stop();
        yuanshen.stop();
    }
}
