package abstrac.factory;

import abstrac.product.RaquetaMitad;
import abstrac.product.antipoderes;

public class factoryRaquetaMitad implements factoryAntipoderes
{
    @Override
    public antipoderes createAntiPoderes()
    {
        return new RaquetaMitad();
    }
}
