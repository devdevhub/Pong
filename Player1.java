import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Player {
    
    private int speed;
    
    public Player1() {
        speed = 10;
    }
    
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        movement();
    }
    
    protected void movement() {
        if (Greenfoot.isKeyDown("W")) {
            if (atNorth()) {setLocation(getX(), getY()+speed);}
            setLocation(getX(), getY()-speed);
        }
        if (Greenfoot.isKeyDown("S")) {
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