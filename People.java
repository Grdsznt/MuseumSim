import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Map;

/**
 * Write a description of class People here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class People extends Actor
{
    protected double speed;
    protected double maxSpeed;
    public void act()
    {
        
    }
    
    public Actor targetActor(Actor act, int dis) 
    {
        Actor a;
        int distance = dis;
        ArrayList<Actor> targets = (ArrayList<Actor>)getObjectsInRange(dis, Actor.class);
        double closestTargetDistance = 0;
        double distanceToActor;
        Actor closest = null;
        if(targets.size() > 0) 
        {
            closest = targets.get(0);
            closestTargetDistance = distanceFrom(closest);
            for(Actor ac: targets) {
                distanceToActor = distanceFrom(Actor);
                if(distanceToActor < closestTargetDistance)
                {
                    closest = a; 
                    closestTargetDistance = distanceToActor;
                }
                
            }
        }
        return closest;
    }
    /**
     *  Method used to find the distance between two actors 
     */
    protected double distanceFrom (Actor act)
    {
        double a = Math.abs(getX()-act.getX());
        double b = Math.abs(getY()-act.getY());
        double c = Math.hypot(a,b);
        return c;
    }
}
