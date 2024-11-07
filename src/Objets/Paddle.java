package Objets;

public class Paddle {
    private int HEIGTH,width;
    private int speed;
    private int position_x,position_y;

    public Paddle(){
        HEIGTH = 50;
        width = 100;
        speed = 10;
        position_x = 100;
        position_y = 100;
    }

    public int getHEIGTH() {
        return HEIGTH;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getPosition_x() {
        return position_x;
    }
    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }
    public int getPosition_y() {
        return position_y;
    }
    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }
}
