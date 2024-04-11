import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * World for Displaying Results at End of the Game
 */
public class DisplayResults extends World
{
    private SuperTextBox endOfGame;
    private Font comic;
    private int []stats;
    private int count; 
    private SuperDisplayLabel theStatBar;    
    /**
     * Constructor for objects of class DisplayResults.
     * 
     */
    public DisplayResults()
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
