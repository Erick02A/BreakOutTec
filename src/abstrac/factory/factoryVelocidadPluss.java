package abstrac.factory;

import abstrac.product.VelocidadPluss;
import abstrac.product.antipoderes;

public class factoryVelocidadPluss implements factoryAntipoderes
{
    @Override
    public antipoderes createAntiPoderes()
    {
        return new VelocidadPluss();
    }
}
