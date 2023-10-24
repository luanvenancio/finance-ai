package financesimulator;

import financesimulator.strategies.GenerateDatabaseStrategy;
import financesimulator.strategies.ReturnStrategy;

public class FinanceSimulator {

    public static void main(String[] args) {
        Simulator simulator = new Simulator ();
        
        simulator.readMarketData ("./market_data/RENT3.csv");
        
        /*
        // Simple Strategy
        SimpleStrategy strategy = new SimpleStrategy ();
        simulator.addStrategy(strategy);
        */
        
        /*
        // Moving Average Strategy
        SimpleMovingAverageStrategy strategy = new SimpleMovingAverageStrategy();
        simulator.addStrategy(strategy);
        */
        
        /*
        // Generate Database Strategy
        GenerateDatabaseStrategy strategy = new GenerateDatabaseStrategy();
        simulator.addStrategy(strategy);
        */
        
        // Return Strategy
        ReturnStrategy strategy = new ReturnStrategy();
        simulator.addStrategy(strategy);
       
        simulator.startSimulation();
    }
}
