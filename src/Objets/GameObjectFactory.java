package Objets;

public interface GameObjectFactory {
    Ball createBall();
    Block createBlock(int positionX, int positionY);
}


