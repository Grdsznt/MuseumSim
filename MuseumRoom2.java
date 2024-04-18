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
    
    public static int income = 0;
    public MuseumRoom2()
    { 
        super(661,816,0, 0);
        setBackground(worldImage);
        addObject(displayTable1, 327, 699);
        addObject(displayTable2, 181, 512);
        addObject(brokenGlassBox, 326, 213);
        addObject(littleGlassBox, 92, 119);
        addObject(largeWoodBox, 327, 374);
        addObject(mediumGlassBox, 460, 514);
        addObject(statue1, 156, 380);
        addObject(statue2, 535, 380);
        addObject(pillar1, 89, 616);
        addObject(pillar2, 555, 616);
    }
}
