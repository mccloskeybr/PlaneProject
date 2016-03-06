package entity;

import component.Window;
import util.RenderUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by mccloskeybr on 3/5/16.
 */
public abstract class Entity {

    private double x, y;
    private double speed;
    private boolean movingLeft, movingRight, movingDown;
    private int width, height;
    private BufferedImage image;

    public Entity(BufferedImage image, double speed, double x, double y){

        this.image = image;

        this.x = x;
        this.y = y;
        this.speed = speed;

        this.width = image.getWidth() * RenderUtil.RENDER_SCALE;
        this.height = image.getHeight() * RenderUtil.RENDER_SCALE;

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public double getSpeed(){
        return speed;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public boolean ableMoveLeft(){
        return x > 0;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public boolean ableMoveRight(){
        return x + width < Window.WINDOW_WIDTH;
    }

    public boolean isMovingDown(){
        return movingDown;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public void setMovingDown(boolean movingDown){
        this.movingDown = movingDown;
    }

    public void update(double delta){

        if (isMovingLeft() && ableMoveLeft())
            setX(getX() - getSpeed() * delta);
        else if (isMovingRight() && ableMoveRight())
            setX(getX() + getSpeed() * delta);
        else if (isMovingDown())
            setY(getY() + getSpeed() * delta);

    }

    public void render(Graphics g){
        g.drawImage(image, (int) x, (int) y, width, height, null);
    }

}
