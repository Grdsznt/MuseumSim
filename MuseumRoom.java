import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MuseumRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MuseumRoom extends Room
{
    
    private static int income = 0;
    private static int theftsPrevented = 0;
    private static int furnitureStolen = 0;
    private static int time = 0;
    // Obstacle Bounding Boxes
    private GreenfootImage worldImage = new GreenfootImage("room2.png");
    private Obstacle displayTable1 = new Obstacle(84, 49); //  (285, 723), (369, 674)
    private Obstacle displayTable2 = new Obstacle(73, 64); // (144, 544), (217, 480)
    private Obstacle brokenGlassBox = new Obstacle(85, 118); // (283, 272), (368, 154) //broken glass
    private Obstacle littleGlassBox = new Obstacle(31, 43); // (76, 140), (107, 97) // little top right box
    private Obstacle largeWoodBox = new Obstacle(106, 62); // (274, 402), (380, 346) // saturated brown box
    private Obstacle mediumGlassBox = new Obstacle(71, 61); // (424, 544), (495, 483)
    private Obstacle statue1 = new Obstacle(44, 68); // (89, 414), (133, 346)
    private Obstacle statue2 = new Obstacle(44, 68); // (513, 414), (556, 346)
    private Obstacle pillar1 = new Obstacle(39, 100); // (69, 665), (108, 566)
    private Obstacle pillar2 = new Obstacle(39, 100); // (536, 665), (574, 566)
    private Obstacle leftWall = new Obstacle(62, 548);
    private Obstacle rightWall = new Obstacle(62, 548);
    private Obstacle topWall = new Obstacle(513, 92);
    private Obstacle wallSegLeft = new Obstacle(117, 64);
    private Obstacle wallSegRight = new Obstacle(117, 64);
    
    private Robber rob1 = new Robber(5, 800, 1);
    
    /**
     * Constructor for objects of class MuseumRoom.
     * 
     */
    public MuseumRoom()
    { 
        super(661,816,0, 0);
        setBackground(worldImage);
        
        addObject(displayTable1, 327, 699);
        // displayTable1.setImage(new GreenfootImage(84, 49));
        
        addObject(displayTable2, 181, 512);
        // displayTable2.setImage(new GreenfootImage(73, 64));
        
        addObject(brokenGlassBox, 327, 213);
        // brokenGlassBox.setImage(new GreenfootImage(85, 118));
        
        addObject(littleGlassBox, 92, 119);
        // littleGlassBox.setImage(new GreenfootImage(31, 43));
        
        addObject(largeWoodBox, 329, 374);
        // largeWoodBox.setImage(new GreenfootImage(106, 62));
        
        addObject(mediumGlassBox, 464, 514);
        // mediumGlassBox.setImage(new GreenfootImage(85, 118));
        
        addObject(statue1, 111, 380);
        // statue1.setImage(new GreenfootImage(44, 68));
        
        addObject(statue2, 535, 380);
        // statue2.setImage(new GreenfootImage(44, 68));
        
        addObject(pillar1, 89, 590);
        // pillar1.setImage(new GreenfootImage(39, 100));
        
        addObject(pillar2, 555, 590);
        // pillar2.setImage(new GreenfootImage(39, 100));
        
        addObject(leftWall, 32, 366);
        // leftWall.setImage(new GreenfootImage(62, 548));
        
        addObject(rightWall, 626, 366);
        // rightWall.setImage(new GreenfootImage(62, 548));
        
        addObject(topWall, 326, 46);
        // topWall.setImage(new GreenfootImage(513, 92));
        
        addObject(wallSegLeft, 128, 218);
        // wallSegLeft.setImage(new GreenfootImage(117, 64));
        
        addObject(wallSegRight, 524, 218);
        // wallSegRight.setImage(new GreenfootImage(117, 64));
        
        addObject(rob1, 300, 500);
        
        Valuable v = new Valuable(200.50);
        addObject(v, 92, 119);
    }
    
    public void act() {
        
    }
    
    public static void incrementIncome()
    {
        income+= 100;
    }
    public static int incomeEarned()
    {
        return income;
    }
    
    public static int theftsPrevented()
    {
        return theftsPrevented;
    }
    
    public static int furnitureStolen()
    {
        return furnitureStolen;
    }
    
    public static int time()
    {
        return time;
    }
}
