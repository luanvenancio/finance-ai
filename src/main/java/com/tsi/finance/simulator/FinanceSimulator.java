package com.tsi.finance.simulator;

import strategies.GenerateDatabaseStrategy;
import strategies.ReturnStrategy;
/**
 *
 * @author luanv
 */
public class FinanceSimulator {

    public static void main(String[] args) {
        Simulator simulator = new Simulator ();
        
        simulator.readMarketData ("./market_data/BBDC4.csv");
        
        //SimpleStrategy strategy = new SimpleStrategy ();
        //simulator.addStrategy(strategy);
        //SimpleMovingAverageStrategy strategy = new SimpleMovingAverageStrategy();
        //simulator.addStrategy(strategy);
        
        //GenerateDatabaseStrategy strategy = new GenerateDatabaseStrategy();
        //simulator.addStrategy(strategy);
        
        ReturnStrategy strategy = new ReturnStrategy();
        simulator.addStrategy(strategy);
        
        simulator.startSimulation();
    }
}
