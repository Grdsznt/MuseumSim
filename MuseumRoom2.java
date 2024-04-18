import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MuseumRoom2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MuseumRoom2 extends Room
{

    /**
     * Constructor for objects of class MuseumRoom2.
     * 
     */
    
    // Obstacle Bounding Boxes
    private GreenfootImage worldImage = new GreenfootImage("room2.png");
    private Object displayTable1 = new Object(84, 49); //  (285, 723), (369, 674)
    private Object displayTable2 = new Object(73, 64); // (144, 544), (217, 480)
    private Object brokenGlassBox = new Object(85, 118); // (283, 272), (368, 154) //broken glass
    private Object littleGlassBox = new Object(31, 43); // (76, 140), (107, 97) // little top right box
    private Object largeWoodBox = new Object(106, 62); // (274, 402), (380, 346) // saturated brown box
    private Object mediumGlassBox = new Object(71, 61); // (424, 544), (495, 483)
    private Object statue1 = new Object(44, 68); // (89, 414), (133, 346)
    private Object statue2 = new Object(44, 68); // (513, 414), (556, 346)
    private Object pillar1 = new Object(39, 100); // (69, 665), (108, 566)
    private Object pillar2 = new Object(39, 100); // (536, 665), (574, 566)
    private Object leftWall = new Object(62, 548);
    private Object rightWall = new Object(62, 548);
    private Object topWall = new Object(513, 92);
    private Object wallSegLeft = new Object(117, 64);
    private Object wallSegRight = new Object(117, 64);
    
    private Robber rob1 = new Robber(3, 50, 0);
    
    public MuseumRoom2()
    { 
        super(661,816,0, 0);
        setBackground(worldImage);
        
        addObject(displayTable1, 327, 699);
        displayTable1.setImage(new GreenfootImage(84, 49));
        
        addObject(displayTable2, 181, 512);
        displayTable2.setImage(new GreenfootImage(73, 64));
        
        addObject(brokenGlassBox, 327, 213);
        brokenGlassBox.setImage(new GreenfootImage(85, 118));
        
        addObject(littleGlassBox, 92, 119);
        littleGlassBox.setImage(new GreenfootImage(31, 43));
        
        addObject(largeWoodBox, 329, 374);
        largeWoodBox.setImage(new GreenfootImage(106, 62));
        
        addObject(mediumGlassBox, 464, 514);
        mediumGlassBox.setImage(new GreenfootImage(85, 118));
        
        addObject(statue1, 111, 380);
        statue1.setImage(new GreenfootImage(44, 68));
        
        addObject(statue2, 535, 380);
        statue2.setImage(new GreenfootImage(44, 68));
        
        addObject(pillar1, 89, 616);
        pillar1.setImage(new GreenfootImage(39, 100));
        
        addObject(pillar2, 555, 616);
        pillar2.setImage(new GreenfootImage(39, 100));
        
        addObject(leftWall, 32, 366);
        leftWall.setImage(new GreenfootImage(62, 548));
        
        addObject(rightWall, 626, 366);
        rightWall.setImage(new GreenfootImage(62, 548));
        
        addObject(topWall, 326, 46);
        topWall.setImage(new GreenfootImage(513, 92));
        
        addObject(wallSegLeft, 128, 218);
        wallSegLeft.setImage(new GreenfootImage(117, 64));
        
        addObject(wallSegRight, 524, 218);
        wallSegRight.setImage(new GreenfootImage(117, 64));
        
        addObject(rob1, 500, 500);
    }
    
    public void act() {
        
    }
}
