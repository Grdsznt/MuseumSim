import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Emote here.
 * emote that character can make
 * @author Nick
 * @version (a version number or a date)
 */
public class Emote extends SuperSmoothMover
{
    private static GreenfootImage[] emotionFrames = {new GreenfootImage("Mood0.png"), new GreenfootImage("Mood1.png"), new GreenfootImage("Mood2.png"), new GreenfootImage("Mood3.png"), 
                                                     new GreenfootImage("Mood4.png"), new GreenfootImage("Mood5.png"), new GreenfootImage("Mood6.png"), new GreenfootImage("Mood7.png"), };
    private int emoteType;// 1 :) , 2 :( , 3 >:( , 4 :| , 5 -_- , 6 :O , 7 heart eyes
    private int actNum;
    public Emote(int emotion){
        if(emotion < 8 && emotion > 0){
            emoteType = emotion;
        }
        actNum = 0;
        setImage(emotionFrames[0]);
    }
    /**
     * Act - do whatever the Emote wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(actNum == 30){
            setImage(emotionFrames[emoteType]);
        }
        if(actNum == 120){
            getWorld().removeObject(this);
        }
        actNum++;
    }
}
