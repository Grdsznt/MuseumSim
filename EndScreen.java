import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * World for Displaying Results at End of the Game
 */
public class EndScreen extends World
{
    //Greenfoot image
    private GreenfootImage background;
    //Greenfoot sound
    private GreenfootSound music; 
    
    //For game statistics
    private SuperTextBox endOfGame;
    private Font comic;
    private int []stats;
    private int count; 
    private SuperDisplayLabel theStatBar;
    private HomeButton homeButton;
    
    // Restart Button
    
    /**
     * Constructor for objects of class DisplayResults.
     * 
     */
    public EndScreen()
    {    
        super(500,500,1);
        
        
        comic = new Font("Comic Sans MS", false, false, 16);
        String[] finalNote = {"GGs... Simulation is over. Here are your Stats"};
        endOfGame = new SuperTextBox(finalNote, Color.BLACK, Color.WHITE, comic, true, 375, 3, Color.YELLOW);
        
        endOfGame.update();
        int y = getHeight()- endOfGame.getImage().getHeight()/2;
        int x = endOfGame.getImage().getWidth()/2;
        addObject(endOfGame, x, y);
        
        stats = new int[3];
        String[] labels = new String[] {
            "Total Money Earned:", 
            "Thefts Prevented: ", 
            "Furniture Stolen: ",
            "Time "
        };
        
        theStatBar = new SuperDisplayLabel();
        theStatBar.setLabels(labels);
        addObject(theStatBar, getWidth()/2, 0);
        homeButton = new HomeButton("home", 3);
        addObject(homeButton, 250, 250);
    }
    
    /**
     * For user interactions on the end screen
     */
    public void act(){
        // if(Greenfoot.mouseClicked()){
            // //music.stop();
            // ==m Greenfoot.setWorld(new StartWorld());
        // }
        if(Greenfoot.mouseClicked(this)){
            //music.stop();
            Greenfoot.setWorld(new StartWorld());
        }
    }
    
    public void startMusic(){
        //music.playLoop();
    }
    
    public void stopped() {
        //music.pause();
    }
    
    public void moneyEarned()
    {
        
    }
    public void theftsPrevented()
    {
        
    }
    public void furnitureStolen()
    {
        
    }
    
}
