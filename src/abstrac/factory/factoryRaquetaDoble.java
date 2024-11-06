package abstrac.factory;

import abstrac.product.RaquetaDoble;
import abstrac.product.poderes;

public class factoryRaquetaDoble implements factoryPoderes
{
    @Override
    public poderes createPoderes()
    {
        return new RaquetaDoble();
    }
}
