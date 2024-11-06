package abstrac.factory;

import abstrac.product.MoreLive;
import abstrac.product.poderes;

public class factoryMoreLive implements factoryPoderes
{
    @Override
    public poderes createPoderes()
    {
        return new MoreLive();
    }
}
