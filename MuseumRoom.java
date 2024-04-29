import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MuseumRoom here.
 * 
 * @author Edwin, Jean
 * @version (a version number or a date)
 */
public class MuseumRoom extends Room
{
    public static int income = 0;
    
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
    private Obstacle wallSegLeft = new Obstacle(125, 64);
    private Obstacle wallSegRight = new Obstacle(125, 64);
    private Obstacle leftBound = new Obstacle(40, 223);
    private Obstacle rightBound = new Obstacle(10, 223);
    private Obstacle lowerBound = new Obstacle(663, 7);
    
    private List<Pair> robberSpawns;
    private List<Pair> guardSpawns;
    
    private int robbers, guards, valuables, spawnRate;
    private int actCount;
    
    //Variables
    private int money = 0;
    private int valuablesStolenNumber = 0;
    private int robbersCatchedNumber = 0;
    //Images
    private GreenfootImage moneyImage = new GreenfootImage("money.png");
    private GreenfootImage valuableImage = new GreenfootImage("valuable.png");
    private GreenfootImage robberImage = new GreenfootImage("robber.png");
    //Statistics
    private Statistic moneyEarned = new Statistic(moneyImage, money, "$");
    private Statistic valuablesStolen = new Statistic(valuableImage, valuablesStolenNumber);
    private Statistic robbersCatched = new Statistic(robberImage, robbersCatchedNumber);
    
    private int actNum = 0;
        
    private boolean robberLoc[] = new boolean[3];
    private int robIndx = 0;
    
    private static int dayCount;
    
    public class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x; this.y = y;
        }
        
    }
    /**
     * Constructor for objects of class MuseumRoom.
     */
    public MuseumRoom(int robbers, int guards, int valuables, int spawnRate)
    { 
        super(1000,816,0, 0);
        setBackground(worldImage);
        
        addObject(displayTable1, 327, 699);
        
        addObject(displayTable2, 181, 512);
        
        addObject(brokenGlassBox, 327, 213);
        
        addObject(littleGlassBox, 92, 119);
        
        addObject(largeWoodBox, 329, 374);
        
        addObject(mediumGlassBox, 464, 514);
        
        addObject(statue1, 115, 380);
        
        addObject(statue2, 539, 380);
    
        addObject(pillar1, 93, 590);
        
        addObject(pillar2, 559, 590);
        
        addObject(leftWall, 32, 366);
        
        addObject(rightWall, 626, 366);
        
        addObject(topWall, 326, 46);
        
        addObject(wallSegLeft, 125, 218);
        
        addObject(wallSegRight, 530, 218);
        
        addObject(leftBound, 680, 720);
        
        addObject(rightBound, 0, 720);
        
        addObject(lowerBound, 330, 850);
        
        // need to spawn robber in specific locations
        
        // Valuable v = new Valuable(200.50);
        // addObject(v, 92, 119);
        
        this.robbers = robbers; this.guards = guards; this.valuables = valuables; this.spawnRate = spawnRate;
        
        robberSpawns = new ArrayList<Pair>(3);
        guardSpawns = new ArrayList<Pair>(3);
        
        robberSpawns.add(new Pair(330, 500));
        robberSpawns.add(new Pair(200, 350));
        robberSpawns.add(new Pair(450, 350));
        
        Collections.shuffle(robberSpawns);
        
        for (int i = 0;i<robbers;i++) {
            Pair p = robberSpawns.remove(0);
            if (p.x == 330 && p.y == 500) {
                addObject(new Robber(3, 600, 4, 0), p.x, p.y);
                robberLoc[0] = true;
            }
            else if (p.x == 200 && p.y == 350) {
                addObject(new Robber(3, 600, 4, 2), p.x, p.y);
                robberLoc[1] = true;
            } else  {
                addObject(new Robber(3, 600, 4, 1), p.x, p.y);
                robberLoc[2] = true;
            }
        }
        
        guardSpawns.add(new Pair(330, 770));
        guardSpawns.add(new Pair(420, 200));
        guardSpawns.add(new Pair(240, 200));
        
        Collections.shuffle(guardSpawns);
        
        for (int i = 0;i<guards;i++) {
            Pair p = guardSpawns.remove(0);
            addObject(new Guard(1), p.x, p.y);
        }
        actCount = 1;
        // Valuable v2 = new Valuable(0);
        // addObject(v2, 650, 675);
        Visitor v = new Visitor(1600, 3);
        addObject(v, 0, 670);
        
        //Add the statistics at the top of the world
        int xPos = 780;
        addObject(moneyEarned, xPos, 100);
        addObject(valuablesStolen, xPos, 200);
        addObject(robbersCatched, xPos, 300);
        
        dayCount = 0;
        setPaintOrder(Statistic.class, SuperTextBox.class, Nighttime.class, Robber.class);
    }
    
    //Over all profit Income grow 
    public void gainIncome(int newIncome){
        income = income + newIncome;
    }
    
    public void act() {
        actCount++;
        if(actCount % 1200 == 0) {
            Nighttime night = new Nighttime();
            addObject(night, 500, 408);
            Valuable v = new Valuable(200.50);
            addObject(v, 92, 119);
        }
        if (actCount % (600/spawnRate) == 0 && getObjects(Robber.class).size() < 3) {
            if (robberSpawns.size() == 0) {
                robberSpawns.add(new Pair(330, 500));
                robberSpawns.add(new Pair(200, 350));
                robberSpawns.add(new Pair(450, 350));
            }
            Collections.shuffle(robberSpawns);
            Pair p = robberSpawns.remove(0);
            if (p.x == 330 && p.y == 500) {
                addObject(new Robber(3, 600, 4, 0), p.x, p.y);
                robberLoc[0] = true;
            }
            else if (p.x == 200 && p.y == 350) {
                addObject(new Robber(3, 600, 4, 2), p.x, p.y);
                robberLoc[1] = true;
            } else  {
                addObject(new Robber(3, 600, 4, 1), p.x, p.y);
                robberLoc[2] = true;
            }
        }
    }
    
    /**
     * Set the new value of money.
     * 
     * @param change    The change in the amount of money hold in room.
     */
    public void setMoney(int change){
        money += change;
        moneyEarned.updateValue(money);
    }
    
    /**
     * Set the new number of valuables stolen.
     * 
     * @param change    The change in the amount of valuables stolen from room.
     */
    public void setValuables(int change){
        valuablesStolenNumber += change;
        valuablesStolen.updateValue(valuablesStolenNumber);
    }
    
    /**
     * Set the new value of robbers catched.
     * 
     * @param change    The change in the amount of robbers catched in room.
     */
    public void setRobbers(int change){
        robbersCatchedNumber += change;
        robbersCatched.updateValue(robbersCatchedNumber);
        if (actNum % 1600 == 0) {
            Valuable v = new Valuable(200.50);
            addObject(v, 92, 119);
        }
        actNum++;
    }
    
    public void setStation(int stationNumber, boolean b) {
        robberLoc[stationNumber] = b;
    }
    
    public int getStation() {
        if (robberLoc[0] == false) {
            return 0;
        } else if (robberLoc[1] == false) {
            return 1;
        } else {
            return 2;
        }

    }
    
    public static void increaseDayCount() {
        dayCount++;
    }
    
    public void started() {
        StartWorld.music.pause();
    }
    
    public void paused() {
        StartWorld.music.pause();
    }
}
