package Objets;

public class BlockFactory implements GameObjectFactory {
    @Override
    public Ball createBall() {
        throw new UnsupportedOperationException("BlockFactory no puede crear bolas.");
    }

    @Override
    public Block createBlock(int positionX, int positionY) {
        return new Block(positionX, positionY);
    }
}
