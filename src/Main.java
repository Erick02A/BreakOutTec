import Objets.Window;
import Objets.connection;
public class Main
{
    static Thread hilo = new connection();
    static Servidor servidor;
    public static void main(String[] args)
    {
        Window window = new Window();
        servidor = new Servidor();
        hilo.start();
    }
}
