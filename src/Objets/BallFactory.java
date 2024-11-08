package Objets;

public class BallFactory implements GameObjectFactory {
    @Override
    public Ball createBall() {
        return new Ball();
    }

    @Override
    public Block createBlock(int positionX, int positionY) {
        throw new UnsupportedOperationException("BallFactory no puede crear bloques.");
    }
}

