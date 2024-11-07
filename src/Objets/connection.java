package Objets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class connection extends Thread {
    public static String message = "";
    public void run()
    {
        try (ServerSocket serverSocket = new ServerSocket(1234))
        {
            System.out.println("Servidor Java iniciado, esperando conexión en el puerto 1234...");

            while (true)
            {
                // Espera a que un cliente se conecte
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado");


                try
                {
                    // Bucle de comunicación con el cliente
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    while (true)
                    {
                        // Leer mensaje del cliente
                        String mensaje = in.readLine();

                        if (mensaje != null)
                        {
                            System.out.println("Mensaje del cliente en C: " + mensaje);
                            Window.resivedMessage(mensaje);

                            // Mensaje de respuesta al cliente
                            System.out.println(message);
                            out.println(message);
                            message = "";
                        }
                        else
                        {
                            // Si el mensaje es null, el cliente cerró la conexión
                            System.out.println("El cliente se ha desconectado.");
                            break; // Salimos del bucle de comunicación con este cliente
                        }

                        // Pausa de 1 segundo entre respuestas
                        Thread.sleep(1000);
                    }
                }
                catch (IOException e) {
                    System.out.println("Error de conexión con el cliente: " + e.getMessage());
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    // Cerrar el socket después de que el cliente se desconecte
                    try
                    {
                        socket.close();
                        System.out.println("Conexión con el cliente cerrada.");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
