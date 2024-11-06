package Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Screen extends JFrame implements Runnable, KeyListener {
    private boolean running;
    private BufferStrategy bs;
    private Graphics g;
    private Thread thread;
    private Canvas canvas;
    private Player player;
    private final int RADIO = 20;
    private final int WIDTH = 1050 , HEIGHT = 800;
    private final int BWIDTH = 100, BHEIGHT = 20;

    public Screen(Player player)
    {
        this.player = player;
        setTitle("BreakOutTEC");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new Canvas();

        canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH,HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH,HEIGHT));
        canvas.setFocusable(true);
        add(canvas);

        // Agregar el KeyListener al objeto Screen
        canvas.addKeyListener(this);

        // Solicitar el foco para el Canvas
        canvas.requestFocus();

    }
    public void draw()
    {
        g = bs.getDrawGraphics();
        // Limpiar la pantalla
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT); // Establecer el fondo a blanco

        // Dibujar bolas.
        for (int i=0; i<player.balls.size();i++)
        {
            g.setColor(Color.WHITE);
            g.fillOval(player.balls.get(i).getPositionX(), player.balls.get(i).getPositionY(), RADIO, RADIO); // Cambié la posición para que sea visible en el área visible

        }

        // Dibujar bloques
        for (int fila=0; fila<8 ; fila++)
        {
            for (int col=0; col<10 ; col++) {
                if (!player.brick[fila][col].isDestroy())
                {
                    g.setColor(player.brick[fila][col].getColor());
                    g.fillRect(player.brick[fila][col].getPositionX(), player.brick[fila][col].getPositionY(), BWIDTH, BHEIGHT);

                }
            }
        }

        g.setColor(Color.BLUE);
        g.fillRect(player.paddle.position,700,player.paddle.size,20);

        // Mostrar el contenido dibujado
        g.dispose();
        bs.show();
    }
    public void updat()
    {
        player.balls.get(0).move();
        if (player.balls.get(0).getPositionY()==HEIGHT && player.lives != 0){
            player.balls.get(0).reset();
            player.lives -=1;
        }
        if (player.balls.get(0).getPositionX()==0||player.balls.get(0).getPositionX()==WIDTH){
            player.balls.get(0).bounce(false,true);
        }
        for (int fila=0; fila<8 ; fila++)
        {
            for (int col = 0; col < 10; col++)
            {
                if(!player.brick[fila][col].isDestroy())
                {
                    if (player.balls.get(0).getPositionX()+RADIO/2 >= player.brick[fila][col].getPositionX() && player.balls.get(0).getPositionX()+RADIO/2 <= player.brick[fila][col].getPositionX()+BWIDTH &&
                            player.balls.get(0).getPositionY()+RADIO/2 >= player.brick[fila][col].getPositionY()+RADIO/2 && player.balls.get(0).getPositionY() <= player.brick[fila][col].getPositionY()+BHEIGHT)
                    {
                        if (player.balls.get(0).getPositionX()+RADIO/2 == player.brick[fila][col].getPositionX() || player.balls.get(0).getPositionX()+RADIO/2 == player.brick[fila][col].getPositionX()+BWIDTH ||
                                player.balls.get(0).getPositionY()+RADIO/2 == player.brick[fila][col].getPositionY()+RADIO/2 || player.balls.get(0).getPositionY() == player.brick[fila][col].getPositionY()+BHEIGHT)
                        {
                            player.brick[fila][col].colition();
                            player.balls.get(0).bounce(true,false);
                            if (player.brick[fila][col].getAntipoder()!=null)
                            {
                                if(player.brick[fila][col].Antipoder()=="RaquetaMitad")
                                {
                                    player.paddle.size /=2;
                                }
                                else
                                {
                                    player.balls.get(0).changeSpeed(false);
                                }
                            }
                            else if (player.brick[fila][col].getPoder()!=null)
                            {
                                if(player.brick[fila][col].Poder()=="MoreBall")
                                {
                                    //player.balls.add(new Ball());
                                }
                                else if(player.brick[fila][col].Poder()=="MoreLive")
                                {
                                    player.lives +=1;
                                }
                                else if(player.brick[fila][col].Poder()=="RaquetaDoble")
                                {
                                    player.paddle.size *=2;
                                }
                                else
                                {
                                    player.balls.get(0).changeSpeed(true);
                                }
                            }
                        }
                        else
                        {
                            player.brick[fila][col].colition();
                            player.balls.get(0).bounce(true,false);
                        }

                    }
                }
            }
        }
        if (player.balls.get(0).getPositionX()+RADIO/2 >= player.paddle.position && player.balls.get(0).getPositionX()+RADIO/2 <= player.paddle.position + player.paddle.size &&
        player.balls.get(0).getPositionY()+RADIO/2 >= 700 && player.balls.get(0).getPositionY()+RADIO/2 <= 720)
        {
            player.balls.get(0).bounce(true,false);
        }
    }
    public void start()
    {

        running = true;
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run()
    {
        canvas.createBufferStrategy(3);
        bs = canvas.getBufferStrategy();
        System.out.println("Inicia el hilo");
        while (running){
            updat();
            draw();

            try {
                thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        System.out.println("Key pressed");
        if (e.getKeyCode()==KeyEvent.VK_A)
        {
            player.paddle.position -= 20;
        }
        else if (e.getKeyCode()==KeyEvent.VK_D)
        {
            player.paddle.position += 20;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
