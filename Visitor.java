import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Visitor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    protected boolean playing = false, flag = false, toSpot = false, isNew=false, leaving=false, insane=false;
    private int visitDuration;// in units of acts
    private SpotManager.DetailedSpot target;
    
    
    
    public void addedToWorld(World w){
        if(!isNew){//prevent z sort problems
            isNew=true;
            //attempts to target, if unable then remove as would do nothing
            target=SpotManager.attemptTarget(this);
            if(target==null)getWorld().removeObject(this);
        }
        
        
        
        MuseumRoom2.income +=100;
        
    }
   
    public Visitor(int time){
        visitDuration = time;
        numberOfVisitors++;
    }
    /**
     * Act - do whatever the Visitor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
    
    
    //get the number of visitors
    public static int getNumVisitors(){
        return numberOfVisitors;
    }
    
    
    
}
