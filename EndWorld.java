import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ruinedMuseum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndWorld extends World
{
    //
    /**
     * Constructor for objects of class ruinedMuseum.
     * 
     */
    private HomeButton homeButton;
    private DropDownMenu dropDownMenu;
    private Image moneySymbol, moneyText, valuableSymbol, valuableText, robber, robberText;
    private int moneyMade, robbersCatched, valuablesStolen;//there are the stats needed to be displayed
    public EndWorld()
    {    
        super(1000, 800, 1);
                                        //fill the stats ty
                                        moneyMade = 0;
                                        robbersCatched = 0;
                                        valuablesStolen = 0;
        //add dropdown menu
        dropDownMenu = new DropDownMenu(getWidth(), getHeight());
        addObject(dropDownMenu, getWidth()/2, 0);
        //add homebuttong
        homeButton = new HomeButton("home", 3, new StartWorld());
        addObject(homeButton, getWidth()/2, 0);
        //display money made, symbol plus text
        moneySymbol = new Image(new GreenfootImage("money.png"));
        addObject(moneySymbol, getWidth()/2, 0);
                                        moneyText = new Image("$Money$ Made : 100");//fill moneyMade here
        addObject(moneyText, getWidth()/2, 0);
        //valuable stats
        valuableSymbol = new Image(new GreenfootImage("valuable.png"));
        addObject(valuableSymbol, getWidth()/2, 0);
                                        valuableText = new Image("ValuablesStolen : 100");//fill valuable stollen here
        addObject(valuableText, getWidth()/2, 0);
        //robber stats
        robber = new Image(new GreenfootImage("robber.png"));
        addObject(robber, getWidth()/2, 0);
                                        robberText = new Image("RobbersCatched : 100");//fill robbersCatched here
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
