import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SetUpWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SetUpWorld extends World
{
    private Color white = Color.WHITE;
    private Color black = Color.BLACK;
    private Font boringFont = new Font ("Joystix", false, false, 18);
    /**
     * Constructor for objects of class SetUpWorld.
     * 
     */
    public SetUpWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        
        String[] tempTextGuards = {"Number Of Guards"};
        SuperTextBox editNumOfGuards = new SuperTextBox(tempTextGuards, Color.BLACK, Color.WHITE, boringFont, true, 300, 3, Color.YELLOW);
        
        editNumOfGuards.update();
        int tempY = getHeight() - editNumOfGuards.getImage().getHeight()/2;
        int tempX = editNumOfGuards.getImage().getWidth()/2;
        addObject(editNumOfGuards, tempX, tempY);
        
        
    }
}
