package abstrac.factory;

import abstrac.product.MoreBall;
import abstrac.product.poderes;

public class factoryMoreBall implements factoryPoderes
{
    @Override
    public poderes createPoderes()
    {
        return new MoreBall();
    }
}
