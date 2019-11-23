package Fakehalla.Game;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public interface Updatable { // interface of every object that is going to be moving (move = update + draw)
    public final Vector2D gravity = new Vector2D(new Point2D(0,0.5));
    public void update(double dt, double gameWidth, double gameHeight, ArrayList<Updatable> objToInteract, ArrayList<Rectangle> gameObj);
    public boolean inBounds(double widthLimit, double heightLimit,double stepX, double stepY);

}