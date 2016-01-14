import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Player {
    
    private int speed;
    
    public Player2() {
        speed = 10;
    }
    
    /**
     * Act - do whatever the Player2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        movement();
    }
    
    protected void movement() {
        if (Greenfoot.isKeyDown("I")) {
            if (atNorth()) {setLocation(getX(), getY()+speed);}
            setLocation(getX(), getY()-speed);
        }
        if (Greenfoot.isKeyDown("K")) {
            if (atSouth()) {setLocation(getX(), getY()-speed);}
            setLocation(getX(), getY()+speed);
        }
    }
    
    /* collision */
    /************************************************************/
    public boolean atNorth() {
        return getY()-getImage().getHeight()/2 <= 0;
    }
    public boolean atSouth() {
        return getY()+getImage().getHeight()/2 >= getWorld().getHeight();
    }
    /************************************************************/
    
}