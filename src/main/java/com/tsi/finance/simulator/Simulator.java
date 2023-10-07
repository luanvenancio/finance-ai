package com.tsi.finance.simulator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author luanv
 */
public class Simulator {
    
    private final ArrayList<MarketData> marketUpdate;
    private final ArrayList<Strategy> strategies;
    
    public Simulator () {
        this.marketUpdate = new ArrayList<>();
        this.strategies = new ArrayList<>();
        
    }
    
    public void addStrategy (Strategy strategy){
        this.strategies.add (strategy);
    }
    
    public void readMarketData (String path){
        ArrayList<String> tempMarketData = FileManager.stringReader(path);
        for (int i = 1; i < tempMarketData.size(); i++) {
            String temp = tempMarketData.get(i);
            this.marketUpdate.add(this.parseMarketData(temp));
        }
    }
    
    public void startSimulation () {
        
        for (Strategy strategy : this.strategies) {
            strategy.create();
        }
        
        for (int i = 0; i < marketUpdate.size(); i++){
            
            MarketData marketData = marketUpdate.get(i);
            
            for (Strategy strategy : this.strategies) {
                strategy.start(marketData.getDate());
            }
            
            for (Strategy strategy : this.strategies) {
                strategy.update(marketData);
            }
            
            for (Strategy strategy : this.strategies) {
                
                if (i == marketUpdate.size() - 1){
                    strategy.finish(null);
                }else {
                    strategy.finish(marketData.getDate());
                }
            }
        }
        
    }
    
    private MarketData parseMarketData (String line) {
        
        MarketData md = new MarketData ();
        
        String[] split = line.split(",");
        
        SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
        
        try {
            md.setDate(sdf.parse(split[0]));
        } catch (ParseException ex) {
            md.setDate(null);
            System.out.println("[ERROR] Date format error!!");
        }
        md.setOpen(Double.parseDouble(split[1]));
        md.setHigh(Double.parseDouble(split[2]));
        md.setLow(Double.parseDouble(split[3]));
        md.setClose(Double.parseDouble(split[4]));
        md.setVolume(Integer.parseInt(split[5]));
        
        return md;
    }
    
}
