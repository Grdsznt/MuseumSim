import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ruinedMuseum here.
 * abstract class for ending screen, includes a drop down menu that display the statistics
 * @author (your name) Nick, Edwin
 * @version (a version number or a date)
 */
public abstract class  EndWorld extends World
{
    protected MuseumRoom room;
    
    protected HomeButton homeButton;
    protected DropDownMenu dropDownMenu;
    protected Image moneySymbol, moneySymbolTwo, moneyText, valuableSymbol, valuableText, robber, robberText, incomeText;
    protected int moneyMade, robbersCatched, valuablesStolen;//there are the stats needed to be displayed
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
        moneyText = new Image("Money Robbed : " + room.getMoney()); //fill moneyMade here
        addObject(moneyText, getWidth()/2, 0);
        
        //valuable stats
        valuableSymbol = new Image(new GreenfootImage("valuable.png"));
        addObject(valuableSymbol, getWidth()/2, 0);
        valuableText = new Image("Valuables Stolen : " + room.getValuables());//fill valuable stollen here
        addObject(valuableText, getWidth()/2, 0);
        
        //robber stats
        robber = new Image(new GreenfootImage("robber.png"));
        addObject(robber, getWidth()/2, 0);
        robberText = new Image("Robbers Caught : " + room.getRobbers());//fill robbersCatched here
        addObject(robberText, getWidth()/2, 0);
        
        // Museum income stats
        moneySymbolTwo = new Image(new GreenfootImage("money.png"));
        addObject(moneySymbolTwo, getWidth()/2, 0);
        incomeText = new Image("Maximum Income : " + room.getMaxIncome());
        addObject(incomeText, getWidth()/2, 0);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            StartWorld sw = new StartWorld();
            Greenfoot.setWorld(sw);
        }
        //let content inside menu follow the menu when dropping down
        
            homeButton.followActor(dropDownMenu, 0,100);
            moneySymbol.followActor(dropDownMenu, -170, 10);
            moneyText.followActor(dropDownMenu, 0, 10);
            valuableSymbol.followActor(dropDownMenu, -170, -40);
            valuableText.followActor(dropDownMenu, 0, -40);
            robber.followActor(dropDownMenu, -170, -90);
            robberText.followActor(dropDownMenu, 0, -90);
            moneySymbolTwo.followActor(dropDownMenu, -170, 60);
            incomeText.followActor(dropDownMenu, 0, 60);
        
    }
}
