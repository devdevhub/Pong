import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor {
    
    private String direction;
    private int speed;
    private GreenfootSound bleep = new GreenfootSound("bleep.wav");
    
    public Ball() {
        int random = (int)(Math.random()*4+1);
        if (random == 1) {direction = "NW";}
        if (random == 2) {direction = "NE";}
        if (random == 3) {direction = "SW";}
        if (random == 4) {direction = "SE";}
        speed = 5;
    }
    
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        movement();
        rotation();
    }
    
    public void movement() {
        if (direction == "NW") {goNW();}
        if (direction == "NE") {goNE();}
        if (direction == "SW") {goSW();}
        if (direction == "SE") {goSE();}
    }
    
    public void rotation() {
        if (atPlayer()) {bleep.play();}
        if (atPlayer() && speed < 25) {speed++;}
        if (atPlayer() && direction == "NW") {goNE();}
        if (atPlayer() && direction == "NE") {goNW();}
        if (atPlayer() && direction == "SW") {goSE();}
        if (atPlayer() && direction == "SE") {goSW();}
        
        if (atNorthSouth() && direction == "NW") {goSW();}
        if (atNorthSouth() && direction == "NE") {goSE();}
        if (atNorthSouth() && direction == "SW") {goNW();}
        if (atNorthSouth() && direction == "SE") {goNE();}
        
        if (atWest()) {
            getWorld().getObjects(Score.class).get(0).updateScore("Player2");
            newBall();
        }
        else if (atEast()) {
            getWorld().getObjects(Score.class).get(0).updateScore("Player1");
            newBall();
        }
    }
    public void goNW() {
        direction = "NW";
        setLocation(getX()-speed, getY()-speed);
    }
    public void goNE() {
        direction = "NE";
        setLocation(getX()+speed, getY()-speed);
    }
    public void goSW() {
        direction = "SW";
        setLocation(getX()-speed, getY()+speed);
    }
    public void goSE() {
        direction = "SE";
        setLocation(getX()+speed, getY()+speed);
    }
    public void newBall() {
        getWorld().addObject(new Ball(), getWorld().getWidth()/2, getWorld().getHeight()/2);
        getWorld().removeObject(this);
    }
    
    /* collision */
    /************************************************************/
    public boolean atPlayer() {
        return getOneIntersectingObject(Player.class) != null;
    }
    public boolean atNorthSouth() {
        return ( /*north*/ getY()-getImage().getHeight()/2 <= 0
            ||   /*south*/ getY()+getImage().getHeight()/2 >= getWorld().getHeight());
    }
    public boolean atWest() {
        return getX()-getImage().getWidth()/2 <= 0;
    }
    public boolean atEast() {
        return getX()+getImage().getWidth()/2 >= getWorld().getWidth();
    }
    /************************************************************/
    
}