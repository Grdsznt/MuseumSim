import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * MuseumRoom is the room where all the action takes place. It is utter chaos in this newly opened museum
 * and thus highly suspectible to robbery despite the museums dreams to become one of the biggst.
 * 
 * @author Edwin, Jean
 * @version May 2 2024
 */
public class MuseumRoom extends Room
{

    private static GreenfootSound roomBGM = new GreenfootSound("Sneaky-Snitch.mp3");

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
    private Obstacle topWall = new Obstacle(635, 92);
    private Obstacle wallSegLeft = new Obstacle(125, 64);
    private Obstacle wallSegRight = new Obstacle(125, 64);
    private Obstacle leftBound = new Obstacle(40, 223);
    private Obstacle rightBound = new Obstacle(4, 223);
    private Obstacle lowerBound = new Obstacle(663, 7);
    
    private List<Pair> robberSpawns;
    private List<Pair> guardSpawns;
    
    private int robbers, guards, valuables, robberSpawnRate, visitorSpawnRate;
    private int actCount;
    
    private static DayCounter dayCounter;
    private static Text museumText; 
    
    //Variables
    private int money = 0;
    private int valuablesStolenNumber = 0;
    private int robbersCatchedNumber = 0;
    private int income = 0;
    
    //Images
    private GreenfootImage moneyImage = new GreenfootImage("money.png");
    private GreenfootImage valuableImage = new GreenfootImage("valuable.png");
    private GreenfootImage robberImage = new GreenfootImage("robber.png");
    //Statistics
    private Statistic moneyEarned = new Statistic(moneyImage, money, "$");
    private Statistic valuablesStolen = new Statistic(valuableImage, valuablesStolenNumber);
    private Statistic robbersCatched = new Statistic(robberImage, robbersCatchedNumber);
    private Statistic museumIncome = new Statistic(moneyImage, income, "$");
    
    //Images
    private GreenfootImage potImage = new GreenfootImage("PinkPot.png");
    private GreenfootImage silverPotImage = new GreenfootImage("SilverPot.png");
    private GreenfootImage GoldPotImage = new GreenfootImage("GoldPot.png");
    private GreenfootImage TallPotImage = new GreenfootImage("valuableArtPot.png");
    private GreenfootImage ShortPotImage = new GreenfootImage("valuableArtPot2.png");
    //Price List
    private ValueList potPriceLabel = new ValueList(potImage, "$"+Pot.price);
    private ValueList silverPotPriceLabel = new ValueList(silverPotImage, "$"+SilverPot.price);
    private ValueList goldPotPriceLabel = new ValueList(GoldPotImage, "$"+GoldPot.price);
    private ValueList tallPotPriceLabel = new ValueList(TallPotImage, "$"+AntiquePotTall.price);
    private ValueList shortPotPriceLabel = new ValueList(ShortPotImage, "$"+AntiquePotShort.price); 
    
    private boolean isNight = false;
    
    private int actNum = 0;
        
    private boolean robberLoc[] = new boolean[3];
    private int robIndx = 0;
    
    //Stores the possible locations of valuables
    private static int[][] valuableLocation = new int[6][2];
    //Stores the boolean for each valuable
    private boolean[] valuableInWorld = {false, false, false, false, false, false}; //{Pot, SilverPot, GoldPot, AntiquePotTall, AntiquePotShort, Pot
    //List of valuables that needs to be acted because it is removed from the world & needs to be spawned again
    ArrayList<Valuable> roomValuables = new ArrayList<Valuable>();
    
    public class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
    /**
     * Constructor for objects of class MuseumRoom.
     */
    public MuseumRoom(int robbers, int guards, int valuables, int robberSpawnRate, int visitorSpawnRate)
    { 
        super(1000,816,0, 0);
        setBackground(worldImage);
        
        addObject(displayTable1, 327, 699);
        //Add the location to the 2D array
        valuableLocation[0][0] = 331;
        valuableLocation[0][1] = 670;
        
        addObject(displayTable2, 181, 512);
        //Add the location to the 2D array
        valuableLocation[1][0] = 184;
        valuableLocation[1][1] = 483;
        
        addObject(brokenGlassBox, 327, 213);
        //Add the location to the 2D array
        valuableLocation[2][0] = 331;
        valuableLocation[2][1] = 162;
        
        addObject(littleGlassBox, 92, 119);
        //Add the location to the 2D array
        valuableLocation[3][0] = 94;
        valuableLocation[3][1] = 86;
        
        addObject(largeWoodBox, 329, 374);
        //Add the location to the 2D array
        valuableLocation[4][0] = 331;
        valuableLocation[4][1] = 346;
        
        addObject(mediumGlassBox, 464, 514);
        //Add the location to the 2D array
        valuableLocation[5][0] = 466;
        valuableLocation[5][1] = 486;
        
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
        
        this.robbers = robbers; this.guards = guards; this.valuables = valuables; this.robberSpawnRate = robberSpawnRate; this.visitorSpawnRate = visitorSpawnRate;
        
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
                addObject(new Robber(3, 600, 4, 1), p.x, p.y);
                robberLoc[1] = true;
            } else  {
                addObject(new Robber(3, 600, 4, 2), p.x, p.y);
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
        
        
        //Add the statistics at the top right of the world
        int xPos = 780;
        addObject(moneyEarned, xPos, 100);
        addObject(valuablesStolen, xPos, 175);
        addObject(robbersCatched, xPos, 250);
        addObject(museumIncome, xPos, 350);
        
        //Add the price list at the bottom right of the world
        getBackground().drawImage(new GreenfootImage("Current Price", 24, Color.BLACK, Color.WHITE), xPos-5, 450);
        addObject(potPriceLabel, xPos, 505);
        addObject(silverPotPriceLabel, xPos, 565);
        addObject(goldPotPriceLabel, xPos, 625);
        addObject(tallPotPriceLabel, xPos, 685);
        addObject(shortPotPriceLabel, xPos, 745);
        
        dayCounter = new DayCounter();
        addObject(dayCounter, 830, 50);
        
        museumText = new Text("Museum Stats");
        addObject(museumText, 830, 300);
        
        //Spawn all valuables randomly
        spawnValuables();
        
        setPaintOrder(Statistic.class, ValueList.class, SuperTextBox.class, Nighttime.class, Robber.class);
        roomBGM.playLoop();
    }
    public void started() {
        roomBGM.playLoop();
        if(isNight) Nighttime.resumeAmbience();
    }
    public void stopped(){
        roomBGM.stop();
        if(isNight) Nighttime.pauseAmbience();
    }
    
    /**
     * Setter for if the world is night or not 
     */
    public void setTime(boolean isNight){
        this.isNight = isNight;
    }
    /**
     * If a valuable is stolen by the robber and put to the deposit position, it is considered "gone".
     * If this is the case, clear out the position to spawn the next valuable.
     * 
     * @param index     The index indicated which specific Valuable needs to clear out.
     */
    public void clearValuablePosition(int index){
        valuableInWorld[index] = false;
    }
    
    //Over all profit Income grow 
    public void gainIncome(int newIncome){
        this.income += newIncome;
    }
    
    public void act() {        
        actCount++;
        isNight = (actCount % 1600) < 600;
        if(actCount % 1600 == 0) {
            Nighttime night = new Nighttime();
            addObject(night, 500, 408);
        }
        if (actCount % (600/visitorSpawnRate) == 0 && !isNight) {
            addObject(new Visitor(1000, 1), 20, 670);
        }
        // Randomly spawn robber if 2 stations are vacant, spawn robber at specific location if only 1 station is vacant
        if (actCount % (600/robberSpawnRate) == 0 && getObjects(Robber.class).size() < 3) {
            if (robberLoc[0] == true) {
                if (robberLoc[1] == true) {
                    addObject(new Robber(3, 600, 4, 2), 450, 350);
                    robberLoc[2] = true;
                } else if (robberLoc[2] == true) {
                    addObject(new Robber(3, 600, 4, 1), 200, 350);
                    robberLoc[1] = true;
                } else {
                    int rand = Greenfoot.getRandomNumber(2)+1;
                    if (rand == 1) {
                        addObject(new Robber(3, 600, 4, rand), 200, 350);
                    } else {
                        addObject(new Robber(3, 600, 4, rand), 450, 350);
                    }
                    robberLoc[rand] = true;
                }
            } else if (robberLoc[1] == true) {
                if (robberLoc[0] == true) {
                    addObject(new Robber(3, 600, 4, 2), 450, 350);
                    robberLoc[2] = true;
                } else if (robberLoc[2] == true) {
                    addObject(new Robber(3, 600, 4, 0), 330, 500);
                    robberLoc[0] = true;
                } else {
                    int rand = Greenfoot.getRandomNumber(2);
                    if (rand == 1) {
                        addObject(new Robber(3, 600, 4, 2), 450, 350);
                        robberLoc[2] = true;
                    } else {
                        addObject(new Robber(3, 600, 4, 0), 330, 500);
                        robberLoc[0] = true;
                    }
                }
            } else if (robberLoc[2] == true) {
                if (robberLoc[0] == true) {
                    addObject(new Robber(3, 600, 4, 1), 200, 350);
                    robberLoc[1] = true;
                } else if (robberLoc[1] == true) {
                    addObject(new Robber(3, 600, 4, 0), 330, 500);
                    robberLoc[0] = true;
                } else {
                    int rand = Greenfoot.getRandomNumber(2);
                    if (rand == 1) {
                        addObject(new Robber(3, 600, 4, rand), 200, 350);
                    } else {
                        addObject(new Robber(3, 600, 4, rand), 330, 500);
                    }
                    robberLoc[rand] = true;
                }
            } else {
                int rand = Greenfoot.getRandomNumber(3);
                if (rand == 0) {
                    addObject(new Robber(3, 600, 4, rand), 330, 500);
                } else if (rand == 1) {
                    addObject(new Robber(3, 600, 4, rand), 200, 350);
                } else {
                    addObject(new Robber(3, 600, 4, rand), 400, 350);
                }
                robberLoc[rand] = true;
            }
        }
        
        //Prepare to spawn each Valuable
        for(Valuable v : roomValuables){
            if(v.getWaiting()){
                v.prepareToSpawn();
            }
        }
    }
    
    /**
     * Randomly spawn different valuables at different locations.
     */
    public void spawnValuables(){
        for(int i=0; i<valuableLocation.length; i++){
            int x = valuableLocation[i][0];
            int y = valuableLocation[i][1];
            //If something is there, do not spawn any
            if(getObjectsAt(x, y, Valuable.class).size()!=0){
                continue;
            }
            
            //For this location, find a valuable to be spawned
            boolean hasFalse = false;
            for(boolean value : valuableInWorld) {
                if(!value) {
                    hasFalse = true;
                    break;
                }
            }
            while(hasFalse){
                //If something is false in the array, still ramdomly get number
                int random = Greenfoot.getRandomNumber(valuableInWorld.length);
                if(valuableInWorld[random]==true){
                    continue;
                }
                //If this object at this index 'random' is not currently in world, then get the valuable coresponding to this index
                Valuable valuable;
                switch(random){
                    case 0: {
                        valuable = new Pot(x,y);
                        break;
                    }
                    case 1: {
                        valuable = new SilverPot(x,y);
                        break;
                    }
                    case 2: {
                        valuable = new GoldPot(x,y);
                        break;
                    }
                    case 3: {
                        valuable = new AntiquePotTall(x,y);
                        break;
                    }
                    case 4: {
                        valuable = new AntiquePotShort(x,y);
                        break;
                    }
                    default: {
                        valuable = new Pot(x,y);
                        break;
                    }
                }
                
                //Spawn the valuable at x & y
                addObject(valuable, x, y);
                valuableInWorld[random] = true;
                //Go to the next location
                break;
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
    
    public void setIncome(int change){
        income += change;
        museumIncome.updateValue(income);
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
            //Valuable v = new Valuable(200.50);
            //addObject(v, 92, 119);
        }
        actNum++;
    }
    
    /**
     * Add the Valuable to the ArrayList.
     * 
     * @param v     The Valuable that needs to be added.
     */
    public void addValuables(Valuable v){
        roomValuables.add(v);
    }
    
    /*
     * Remove the Valuable from the ArrayList.
     * 
     * @param v     The Valuable that needs to be removed.
     */
    /*public void removeValuables(Valuable v){
        roomValuables.remove(v);
    }*/
    
    /**
     * Get the current value of money.
     */
    public int getMoney(){
        return money;
    }
    
    /**
     * Get the current number of valuables stolen.
     */
    public int getValuables(){
        return valuablesStolenNumber;
    }
    
    /**
     * Get the new value of robbers catched.
     */
    public int getRobbers(){
        return robbersCatchedNumber;
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
    /**
     * Increases the day count
     */
    public static void increaseDayCount() {
        dayCounter.incrementDayCount();
    }
    /**
     * Returns whether it is currently night time.
     */
    public boolean isNighttime(){
        return isNight;
    }
}
