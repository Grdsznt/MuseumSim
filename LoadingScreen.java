import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoadingScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoadingScreen extends World
{
    private int counter;
    private String[] imgs;
    public LoadingScreen()
    {    
        super(1000,800,1);
        
        
        imgs = new String[5];
        counter = 0;
    }
    public void act(){
        while(++counter != 2400){
            animateHourGlass();
        }
        //Greenfoot.setWorld(new MuseumRoom());
    }
    public void animateHourGlass(){
        if(counter %60 == 0)
        {
        for(int i = 1; i < imgs.length; i++)
            {
                imgs [i] = "hour" +i+".png";
            }
        }
    }
}
