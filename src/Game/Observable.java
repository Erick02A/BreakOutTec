package Game;

import Player.Observer;

public interface Observable
{
    public void addObserver(Observer observer);

    public void deletObserver();
    public void notifi();
}
