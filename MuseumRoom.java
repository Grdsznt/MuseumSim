import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MuseumRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MuseumRoom extends Room
{
    public static int income = 0;
    
    // private int robbers = SetUpWorld.getRobbers();
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
    
    private Robber rob1 = new Robber(3, 800, 1);
    private Robber rob2 = new Robber(3, 800, 1);
    private Robber rob3 = new Robber(3, 800, 1);
    
    
    private List<Pair> robberSpawns;
    private List<Pair> guardSpawns;
    
    private int robbers, guards, valuables;
    
    /**
     * Constructor for objects of class MuseumRoom.
     * 
     */
    
    public class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x; this.y = y;
        }
        
    }

    public MuseumRoom(int robbers, int guards, int valuables)
    { 
        
        super(1000,816,0, 0);
        setBackground(worldImage);
        
        addObject(displayTable1, 327, 699);
        
        addObject(displayTable2, 181, 512);
        
        addObject(brokenGlassBox, 327, 213);
        
        addObject(littleGlassBox, 92, 119);
        
        addObject(largeWoodBox, 329, 374);
        
        addObject(mediumGlassBox, 464, 514);
        
        addObject(statue1, 111, 380);
        
        addObject(statue2, 535, 380);
        
        addObject(pillar1, 89, 590);
        
        addObject(pillar2, 555, 590);
        
        addObject(leftWall, 32, 366);
        
        addObject(rightWall, 626, 366);
        
        addObject(topWall, 326, 46);
        
        addObject(wallSegLeft, 128, 218);
        
        addObject(wallSegRight, 524, 218);
        
        // need to spawn robber in specific locations
        
        Valuable v = new Valuable(200.50);
        addObject(v, 92, 119);
        
        this.robbers = robbers; this.guards = guards; this.valuables = valuables;
        
        robberSpawns = new ArrayList<Pair>(3);
        guardSpawns = new ArrayList<Pair>(3);
        
        robberSpawns.add(new Pair(300, 500));
        robberSpawns.add(new Pair(200, 350));
        robberSpawns.add(new Pair(450, 350));
        
        Collections.shuffle(robberSpawns);
        
        for (int i = 0;i<robbers;i++) {
            Pair p = robberSpawns.remove(0);
            addObject(new Robber(3, 600, 4), p.x, p.y);
        }
        
        // guardSpawns.add(new Pair(300, 500));
        // guardSpawns.add(new Pair(200, 350));
        // guardSpawns.add(new Pair(450, 350));
        
        // Collections.shuffle(guardSpawns);
        
        // for (int i = 0;i<guards;i++) {
            // Pair p = guardSpawns.remove(0);
            // addObject(new Guard(0), p.x, p.y);
        // }
    }
    
    public void act() {
        
    }
}
