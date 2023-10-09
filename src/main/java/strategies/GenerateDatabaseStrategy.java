
package strategies;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.tsi.finance.simulator.FileManager;
import com.tsi.finance.simulator.MarketData;
import com.tsi.finance.simulator.Strategy;

public class GenerateDatabaseStrategy implements Strategy{

    private double precoOntem;
    private String linha;
    private ArrayList<String> arquivoCsv;
    
    @Override
    public void create() {
        
        precoOntem = 0;
        this.arquivoCsv = new ArrayList<>();
        String header = "Date,Open,High,Low,Close,Volume,Return,Output\n";
        FileManager.writer("./market_data/Database2.csv", header);
    
    }

    @Override
    public void start(Date date) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(MarketData update) {
    
        double saidaOntem = precoOntem - update.getClose();
        linha = linha + "," + saidaOntem;
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        if (saidaOntem > 0){
            linha = linha + ",1";
        }
        else {
            linha = linha + ",0";
        }
        
        if (precoOntem != 0){
            System.out.println(linha);
            this.arquivoCsv.add(linha);
            FileManager.writerAppend("./market_data/Database2.csv", linha + "\n");
        }
        
        linha = fmt.format(update.getDate()) + "," +
                update.getOpen() + "," +
                update.getHigh() + "," +
                update.getLow() + "," +
                update.getClose() + "," +
                update.getVolume();
        
        this.precoOntem = update.getClose();
    }

    @Override
    public void finish(Date date) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
