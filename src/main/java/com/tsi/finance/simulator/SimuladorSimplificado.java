package com.tsi.finance.simulator;

import strategies.SimpleMovingAverageStrategy;
import strategies.SimpleStrategy;
import strategies.GenerateDatabaseStrategy;

/**
 *
 * @author luanv
 */
public class SimuladorSimplificado {

    public static void main(String[] args) {
        Simulator simulator = new Simulator();

        /*
            READING MARKET DATA
         */
        simulator.readMarketData("./market_data/BBDC4.csv");

        /*
            CREATING A STRATEGY
         */
        //SimpleStrategy strategy = new SimpleStrategy ();
        //simulator.addStrategy(strategy);
        //SimpleMovingAverageStrategy strategy = new SimpleMovingAverageStrategy();
        //simulator.addStrategy(strategy);
        GenerateDatabaseStrategy strategy = new GenerateDatabaseStrategy();
        simulator.addStrategy(strategy);

        /*
            STARTING THE SIMULATION
         */
        simulator.startSimulation();

    }

}
