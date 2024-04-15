import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MuseumRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MuseumRoom extends Room
{
    private GreenfootImage worldImage = new GreenfootImage("room1.png");
    
    public MuseumRoom(int wid, int hei, int aOfO, int inc) {
       //super(wid, hei, aOfO, inc);
       super(1000,800,0, 0);    
       setBackground(worldImage);
       // setHeight(hei); setWidth(wid);
    }
    
    /**
     * Act - do whatever the MuseumRoom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public int[][] updGrid() {
        int adj[][] = new int[70][50];
        // room obstacle : adj[r][c] = 1 
        // adj[1][28] = 1;
        // adj[2][28] = 1;
        // adj[1][27] = 1;
        // adj[2][27] = 1;
        // adj[1][26] = 1;
        // adj[2][26] = 1;
        // adj[1][25] = 1;
        // adj[2][25] = 1;
        // adj[1][24] = 1;
        // adj[2][24] = 1;
        // adj[1][23] = 1;
        // adj[2][23] = 1;
        // take obstacle block upper right corner, lower left corner, and then set the tiles (/20) to 1
        // may need to change tile size smaller if precision issues
        return adj;
    }
}
