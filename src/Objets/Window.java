package Objets;

import Objets.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame
{
    private final int WIDTH = 1400 , HEIGHT = 800;
    private final int BWIDTH = 100, BHEIGHT = 20;
    private JPanel panel;
    private static Player player = new Player("Player1");
    public static JCheckBox pow1 = new JCheckBox("1");
    public static JCheckBox pow2 = new JCheckBox("2");
    public static JCheckBox pow3 = new JCheckBox("3");
    public static JCheckBox pow4 = new JCheckBox("4");
    public static JCheckBox pow5 = new JCheckBox("5");
    public static JCheckBox pow6 = new JCheckBox("6");
    public static JTextField newPuntaje = new JTextField();
    public static JCheckBox puntaje =new JCheckBox("Cambiar puntaje");
    public Window()
    {
        setTitle("BreakOutTEC");//Titulo de la ventana;
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        panel = new JPanel();

        for (int i = 0; i<14; i++)
        {
            for (int j =0; j<8; j++)
            {
                player.addBlock(i,j);
                player.getBlocks()[i][j].getButton().setBounds(BWIDTH*i,BHEIGHT*j+200,BWIDTH,BHEIGHT);
                panel.add(player.getBlocks()[i][j].getButton());
            }
        }
        newPuntaje.setBounds(BWIDTH*8,150,BWIDTH,BHEIGHT);
        panel.add(newPuntaje);

        pow1.setBounds(0,150,BWIDTH,BHEIGHT);
        pow2.setBounds(BWIDTH,150,BWIDTH,BHEIGHT);
        pow3.setBounds(BWIDTH*2,150,BWIDTH,BHEIGHT);
        pow4.setBounds(BWIDTH*3,150,BWIDTH,BHEIGHT);
        pow5.setBounds(BWIDTH*4,150,BWIDTH,BHEIGHT);
        pow6.setBounds(BWIDTH*5,150,BWIDTH,BHEIGHT);
        puntaje.setBounds(BWIDTH*6,150,BWIDTH+50,BHEIGHT);
        ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
        checkBoxes.add(pow1);
        checkBoxes.add(pow2);
        checkBoxes.add(pow3);
        checkBoxes.add(pow4);
        checkBoxes.add(pow5);
        checkBoxes.add(pow6);
        checkBoxes.add(puntaje);

        for (JCheckBox checkBox : checkBoxes)
        {
            checkBox.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // Si el JCheckBox actual está seleccionado, deseleccionar los otros
                    if (checkBox.isSelected())
                    {
                        for (JCheckBox otherCheckBox : checkBoxes)
                        {
                            if (otherCheckBox != checkBox)
                            {
                                otherCheckBox.setSelected(false);
                            }
                        }
                    }
                }
            });
        }
        panel.add(pow1);
        panel.add(pow2);
        panel.add(pow3);
        panel.add(pow4);
        panel.add(pow5);
        panel.add(pow6);
        panel.add(puntaje);

        panel.setBounds(0,0,WIDTH,HEIGHT);
        panel.setLayout(null);
        add(panel);
    }

    public static void addPowerUp(int position_x,int position_y)
    {
        System.out.println("Press"+position_x+position_y);
        if(pow1.isSelected())
        {
            connection.message = position_x + "," + position_y + "," + 1;
        }
        else if (pow2.isSelected())
        {
            connection.message = position_x + "," + position_y + "," + 2;
        }
        else if (pow3.isSelected())
        {
            connection.message = position_x + "," + position_y + "," + 3;
        }
        else if (pow4.isSelected())
        {
            connection.message = position_x + "," + position_y + "," + 4;
        }
        else if (pow5.isSelected())
        {
            connection.message = position_x + "," + position_y + "," + 5;
        }
        else if (pow6.isSelected())
        {
            connection.message = position_x + "," + position_y + "," + 6;
        }
        else if (puntaje.isSelected())
        {
            connection.message = position_x + "," + position_y + "," + newPuntaje.getText();
        }
        else
        {
            connection.message = position_x + "," + position_y + "," + 0;
        }
    }

    public static void resivedMessage(String message)
    {
        if (message != "")
        {
            String[] datos = message.split(",");
            player.getBlocks()[Integer.parseInt(datos[0])][Integer.parseInt(datos[1])].getButton().setVisible(false);
        }
    }
}
