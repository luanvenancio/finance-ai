package com.tsi.finance.simulator;

import strategies.SimpleMovingAverageStrategy;
import strategies.SimpleStrategy;
import strategies.GenerateDatabase;

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
        GenerateDatabase strategy = new GenerateDatabase();
        simulator.addStrategy(strategy);

        /*
            STARTING THE SIMULATION
         */
        simulator.startSimulation();

    }

}
