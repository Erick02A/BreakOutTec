import Game.Game;
import Player.*;

public class Main
{
    public static void main(String[] args)
    {
         Game game = new Game();
         Player player1 = new Player("Erick",game,game.getBircks());
         game.addObserver(player1);
         player1.addObserver(game);
         game.setObservable(player1);
    }
}