package Objets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Block
{
    private int WIDTH,HEIGHT;
    private int position_x,position_y;
    private boolean destroy;
    private JButton button;

    public Block(int position_x, int position_y)
    {
        WIDTH = 200;
        HEIGHT = 100;
        this.position_x = position_x;
        this.position_y = position_y;
        destroy = false;
        button = new JButton();
        if (position_y<2){
            button.setBackground(Color.red);
        } else if (position_y<4) {
            button.setBackground(Color.orange);
        } else if (position_y<6) {
            button.setBackground(Color.yellow);
        } else {
            button.setBackground(Color.green);
        }
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window.addPowerUp(position_x,position_y);
                // Aquí puedes poner la lógica que deseas ejecutar al hacer clic en el botón
            }
        });
    }

    public int getWIDTH() {
        return WIDTH;
    }
    public int getHEIGHT() {
        return HEIGHT;
    }
    public int getPosition_x() {
        return position_x;
    }
    public int getPosition_y() {
        return position_y;
    }
    public JButton getButton(){
        return button;
    }
    public boolean getDestroy(){
        return destroy;
    }
    public void setDestroy(boolean destroy){
        this.destroy = destroy;
    }
}
