import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ruinedMuseum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndWorld extends World
{
    private MuseumRoom room;
    
    private HomeButton homeButton;
    protected DropDownMenu dropDownMenu;
    private Image moneySymbol, moneyText, valuableSymbol, valuableText, robber, robberText;
    private int moneyMade, robbersCatched, valuablesStolen;//there are the stats needed to be displayed
    /**
     * Constructor for objects of class ruinedMuseum.
     * 
     */
    public EndWorld(MuseumRoom room)
    {    
        super(1000, 800, 1);
        this.room = room;
        //add dropdown menu
        dropDownMenu = new DropDownMenu(getWidth(), getHeight());
        addObject(dropDownMenu, getWidth()/2, 0);
        //add homebuttong
        homeButton = new HomeButton("home", 3, new StartWorld());
        addObject(homeButton, getWidth()/2, 0);
        //display money made, symbol plus text
        moneySymbol = new Image(new GreenfootImage("money.png"));
        addObject(moneySymbol, getWidth()/2, 0);
                                        moneyText = new Image("$Money$ Made : " + room.getMoney());//fill moneyMade here
        addObject(moneyText, getWidth()/2, 0);
        //valuable stats
        valuableSymbol = new Image(new GreenfootImage("valuable.png"));
        addObject(valuableSymbol, getWidth()/2, 0);
                                        valuableText = new Image("ValuablesStolen : " + room.getValuables());//fill valuable stollen here
        addObject(valuableText, getWidth()/2, 0);
        //robber stats
        robber = new Image(new GreenfootImage("robber.png"));
        addObject(robber, getWidth()/2, 0);
                                        robberText = new Image("RobbersCatched : " + room.getRobbers());//fill robbersCatched here
        addObject(robberText, getWidth()/2, 0);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            StartWorld sw = new StartWorld();
            Greenfoot.setWorld(sw);
        }
        //let content inside menu follow the menu when dropping down
        if(dropDownMenu.checkIfMoving()){
            homeButton.followActor(dropDownMenu, 0,100);
            moneySymbol.followActor(dropDownMenu, -170, 30);
            moneyText.followActor(dropDownMenu, 0, 30);
            valuableSymbol.followActor(dropDownMenu, -170, -20);
            valuableText.followActor(dropDownMenu, 0, -20);
            robber.followActor(dropDownMenu, -170, -70);
            robberText.followActor(dropDownMenu, 0, -70);
        }
    }
}
