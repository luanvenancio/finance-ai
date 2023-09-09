package com.tsi.finance.simulator;

import strategies.SimpleStrategy;

/**
 *
 * @author luanv
 */
public class FinanceSimulator {

    public static void main(String[] args) {
        Simulator simulator = new Simulator ();
        
        simulator.readMarketData ("./market_data/BBDC4.csv");
        
        SimpleStrategy strategy = new SimpleStrategy ();
        simulator.addStrategy(strategy);
        
        simulator.startSimulation();
    }
}
