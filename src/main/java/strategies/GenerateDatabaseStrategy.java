package strategies;

import java.util.ArrayList;
import java.util.Date;

import com.tsi.finance.simulator.FileManager;
import com.tsi.finance.simulator.MarketData;
import com.tsi.finance.simulator.Strategy;
import java.text.SimpleDateFormat;

/**
 *
 * @author luanv
 */
public class GenerateDatabaseStrategy implements Strategy {

    private double precoAmanha;
    private double precoHoje;
    private int posicao;
    private ArrayList<MarketData> historico;

    public GenerateDatabaseStrategy() {
        this.precoHoje = 0;
    }

    @Override
    public void create() {

        System.out.println("Creating the strategy - Simple Strategy");

        String header = "Date,Open,High,Low,Close,Volume,Return,Output\n";
        FileManager.writer("./market_data/Database.csv", header);

        this.posicao = 0;
        this.historico = new ArrayList<>();
    }

    @Override
    public void start(Date date) {

        System.out.println("[Simple Strategy] Starting - " + date.toString());

    }

    @Override
    public void update(MarketData update) {

        /*
            PROCESSING THE MARKET DATA TO TAKE DECISIONS
         */
        this.precoAmanha = update.getClose();
        
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        System.out.println("[Simple Strategy] MD - " + update.toString());
        if (posicao > 0) {
            Double retorno = precoAmanha - precoHoje;
            //String data = historico.get(historico.size() - 1).getOpen() + "," + historico.get(historico.size() - 1).getHigh() + "," + historico.get(historico.size() - 1).getLow() + "," + historico.get(historico.size() - 1).getClose() + "," + historico.get(historico.size() - 1).getVolume() + "," + retorno + "\n";
            String data = fmt.format(historico.get(historico.size() - 1).getDate()) + "," + historico.get(historico.size() - 1).getOpen() + "," + historico.get(historico.size() - 1).getHigh() + "," + historico.get(historico.size() - 1).getLow() + "," + historico.get(historico.size() - 1).getClose() + "," + historico.get(historico.size() - 1).getVolume() + "," + retorno + "," + (retorno > 0 ? 1 : 0) + "\n";
            FileManager.writerAppend("./market_data/Database.csv", data);
        }

        posicao++;

        //this.precoAmanha = update.getClose();
        this.precoHoje = update.getClose();
        this.historico.add(update);
    }

    @Override
    public void finish(Date date) {

        //System.out.println("[Simple Strategy] Finishing - " + date.toString());
    }

}
