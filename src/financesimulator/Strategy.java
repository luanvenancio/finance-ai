package financesimulator;

import java.util.Date;

public interface Strategy {

    public void create();

    public void start(Date date);

    public void update(MarketData update);

    public void finish(Date date);

}
