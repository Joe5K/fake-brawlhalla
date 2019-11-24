package Fakehalla.Game.Entity;

import Fakehalla.Game.Vector2D;
import javafx.geometry.Point2D;

import java.util.ArrayList;

public class Shot extends Entity implements Updatable{
    private double shotSpeed;
    private boolean hit;
    private final double shotToPlayer = 0.25;
    private final static String bulletFileName = "src/resources/bullet.png";

    public Shot(Point2D startPosition,Direction playerDirection, double shotWidth,double shotHeight,double playerWidth, double playerHeight)
    {
        super(startPosition,playerDirection,shotWidth,shotHeight);
        this.shotSpeed = 10;
        this.hit = true;
        setVelocity(new Vector2D(new Point2D(shotSpeed,0)));
        chooseFace();
        chooseStartPosition(playerWidth,playerHeight);
        setDefaultTexture(new Texture(bulletFileName));
    }

    @Override
    public void update(double dt, double gameWidth, double gameHeight, ArrayList<Updatable> objToInteract,ArrayList<Block> gameObj)
    {
        this.getVelocity().multiply(dt);
        this.setPosition(this.getPosition().add(this.getVelocity().getDirection()));
    }

    @Override
    public boolean inBounds(double widthLimit,double heightLimit, double stepY)
    {
        return this.getBody().getX() <= widthLimit && this.getBody().getX() + this.getBody().getWidth() >= 0;
    }

    public boolean isHit() { return this.hit; }

    public void setHit(boolean hit) { this.hit = hit; }

    private void chooseFace()
    {
        if(this.getDirection() == Direction.LEFT)
        {
            this.shotSpeed *= -1;
            setVelocity(new Vector2D(new Point2D(this.getVelocity().getDirection().getX()*-1,this.getVelocity().getDirection().getY())));
        }
    }

    private void chooseStartPosition(double playerWidth, double playerHeight)
    {
        if(this.getDirection() == Direction.LEFT)
        {
            this.setPosition(new Point2D(this.getPosition().getX() - this.getBody().getWidth()/2 - 1, this.getPosition().getY() + playerHeight*shotToPlayer));
        }
        else
        {
            this.setPosition(new Point2D(this.getPosition().getX() + playerWidth + 1, this.getPosition().getY()+ playerHeight*shotToPlayer ));
        }
    }
}