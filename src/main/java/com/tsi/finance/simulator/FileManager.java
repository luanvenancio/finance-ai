package com.tsi.finance.simulator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luanv
 */

public class FileManager {
    
    public static ArrayList<MarketData> stringReader (String path){ 
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            ArrayList<MarketData> marketDatas = new ArrayList<>();
            String line = br.readLine();
        
            //int count = 0;
            while (line != null) {
                /*if (count == 0) {
                    count++;
                    continue;
                }*/
                
                String[] attributes = line.split(",");
                /*for(String m : attributes) {
                    System.out.println(m);
                }*/
                MarketData marketData = createMarketData(attributes);

                marketDatas.add(marketData);
                line = br.readLine();
            }
            
            br.close();
            return marketDatas;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private static MarketData createMarketData(String[] values){
        //MarketData md = new MarketData();
        
        SimpleDateFormat sdf = new SimpleDateFormat ("MM/dd/yyyy HH:mm:ss");
        Date date = null;
        Double open = 0.0, high = 0.0, low = 0.0, close = 0.0;
        int volume = 0;
            
        try {
          
            date = sdf.parse(values[0]);

            //LocalDate date = LocalDate.parse(values[0]);
            open = DecimalFormat.getNumberInstance().parse(values[1]).doubleValue();
            high = DecimalFormat.getNumberInstance().parse(values[2]).doubleValue();
            low = DecimalFormat.getNumberInstance().parse(values[3]).doubleValue();
            close = DecimalFormat.getNumberInstance().parse(values[4]).doubleValue();
            /*Double open = Double.parseDouble(values[1]);
            Double high = Double.parseDouble(values[2]);
            Double low = Double.parseDouble(values[3]);
            Double close = Double.parseDouble(values[4]);*/
            volume = Integer.parseInt(values[5]);
            /*md.setOpen(Double.parseDouble(values[1]));
            md.setHigh(Double.parseDouble(values[2]));
            md.setLow(Double.parseDouble(values[3]));
            md.setClose(Double.parseDouble(values[4]));
            md.setVolume(Integer.parseInt(values[5]));*/
        } catch (ParseException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //return md;

        return new MarketData(date, open, high, low, close, volume);
    }
    
    public static void writer (String path, String text){ 
        BufferedWriter buffWrite = null; 
        try {
            buffWrite = new BufferedWriter(new FileWriter(path));
            buffWrite.append(text);
            buffWrite.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                buffWrite.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    
    public static void writerAppend (String path, String text){ 
        BufferedWriter buffWrite = null; 
        try {
            buffWrite = new BufferedWriter(new FileWriter(path, true));
            buffWrite.append(text);
            buffWrite.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                buffWrite.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
}