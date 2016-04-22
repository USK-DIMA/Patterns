import ru.uskov.dmitry.DemonstratorSystemOut;
import ru.uskov.dmitry.abstractFabric.AbstractFabricDemonstrator;

import org.jboss.weld.environment.se.*;

public class Main {


    public static void main(String[] args) {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        DemonstratorSystemOut fabricDemonstration = container.instance().select(AbstractFabricDemonstrator.class).get();

        fabricDemonstration.start();
        weld.shutdown();
    }
}
