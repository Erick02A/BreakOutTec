package Objets;

public class Ball
{
    private int RADIO = 20;
    private int speed_x,speed_y;
    private int position_x,position_y;

    public Ball()
    {
        speed_x = 10;
        speed_y = 10;
        position_x = 100;
        position_y = 100;
    }

    public int getRADIO() {
        return RADIO;
    }
    public int getSpeed_x() {
        return speed_x;
    }
    public void setSpeed_x(int speed_x) {
        this.speed_x = speed_x;
    }
    public int getSpeed_y() {
        return speed_y;
    }
    public void setSpeed_y(int speed_y) {
        this.speed_y = speed_y;
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
