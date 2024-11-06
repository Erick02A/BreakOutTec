package Game;
import Player.Observer;
import Player.Player;
import abstrac.factory.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Observable, Observer
{
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private Observable observable;
    private Brick brick[][] = new Brick[8][10];
    public Game()
    {
        Color color = Color.red;
        for (int fila=0; fila<8 ; fila++)
        {
            if(fila==0|fila==1)
            {
                color = Color.red;
            }
            else if (fila==2|fila==3)
            {
                color = Color.orange;
            }
            else if (fila==4|fila==5)
            {
                color = Color.yellow;
            }
            else if (fila==6|fila==7)
            {
                color = Color.green;
            }
            for (int col=0; col<10 ; col++)
            {
                int random = 0;
                random = (int)(Math.random()*6);
                if(random==1)
                {
                    brick[fila][col] = new Brick(col,fila,color,(new factoryMoreBall()).createPoderes(),null);
                }
                else if (random==2)
                {
                    brick[fila][col] = new Brick(col,fila,color,(new factoryMoreLive()).createPoderes(),null);
                }
                else if (random==3)
                {
                    brick[fila][col] = new Brick(col,fila,color,(new factoryRaquetaDoble()).createPoderes(),null);
                }
                else if (random==4)
                {
                    brick[fila][col] = new Brick(col,fila,color,null,(new factoryRaquetaMitad()).createAntiPoderes());
                }
                else if (random==5)
                {
                    brick[fila][col] = new Brick(col,fila,color,(new factoryVelicidadMinus()).createPoderes(),null);
                }
                else if (random==6)
                {
                    brick[fila][col] = new Brick(col,fila,color,null,(new factoryVelocidadPluss()).createAntiPoderes());
                }
                else
                {
                    brick[fila][col] = new Brick(col,fila,color,null,null);
                }
                //System.out.println("Se agrega un brick en: ("+String.valueOf(fila)+","+String.valueOf(col)+")  "+String.valueOf(color));
            }
        }
    }
    public Brick[][] getBircks(){
        //System.out.println(brick[0][0].getColor());
        return brick;
    }
    public void setObservable(Observable observable)
    {
        this.observable = observable;
    }
    @Override
    public void addObserver(Observer observer)
    {
        if (observers.size()==4)
        {
            System.out.println("No se puede agregar mas Jugadores.");
        }
        else
        {
            observers.add(observer);
            System.out.println("Se agrego un jugador");
        }
    }

    @Override
    public void deletObserver()
    {
    }

    @Override
    public void notifi()
    {
        for (Observer observer :observers)
        {
            observer.update();
        }
    }

    @Override
    public void update()
    {

    }
}
