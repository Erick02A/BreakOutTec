package abstrac.factory;

import abstrac.product.VelocidadMinus;
import abstrac.product.poderes;

public class factoryVelicidadMinus implements factoryPoderes
{
    @Override
    public poderes createPoderes()
    {
        return new VelocidadMinus();
    }
}
