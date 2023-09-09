package com.tsi.finance.simulator;

import java.util.Date;

/**
 *
 * @author luanv
 */
public interface Strategy {
    
    public void create ();
    
    public void start (Date date);
    
    public void update (MarketData update);
    
    public void finish (Date date);
    
}
