import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World for Displaying Results at End of the Game
 */
public class DisplayResults extends World
{
    private SuperTextBox endOfGame;
    private Font comic;
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
