package strategies;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import com.tsi.finance.simulator.FileManager;
import com.tsi.finance.simulator.MarketData;
import com.tsi.finance.simulator.Strategy;

/**
 *
 * @author luanv
 */
public class ReturnStrategy implements Strategy {

    private State estado;
    private int posicao;
    private double slippage;
    private int volumeNegociado;
    private double capital;
    private MarketData lastMarketData;
    private HashMap<String, Prediction> predictions;

    public ReturnStrategy() {
        this.slippage = 0.0;
        this.volumeNegociado = 1;
        this.capital = 0;
    }

    public ReturnStrategy(double slippage, int volumeNegociado, double capital) {
        this.slippage = slippage;
        this.volumeNegociado = volumeNegociado;
        this.capital = capital;
    }

    @Override
    public void create() {

        System.out.println("Creating the strategy - Return Simulation");

        this.estado = State.FLAT;
        this.posicao = 0;
        this.predictions = new HashMap<>();

        ArrayList<String> outputFile = FileManager.stringReader("./market_data/output.csv");
        for (int i = 1; i < outputFile.size(); i++) {
            String line = outputFile.get(i);
            String split[] = line.split(",");
            Prediction pred = new Prediction(split[0], Double.parseDouble(split[1]));
            this.predictions.put(split[0], pred);
        }

    }

    @Override
    public void start(Date date) {

    }

    @Override
    public void update(MarketData update) {

        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
        String currentDate = sdf.format(update.getDate());

        Prediction pred = this.predictions.get(currentDate);

        if (pred != null) {
            
            if (pred.getOutput() == 0
                    && this.estado != State.SHORT) {
                this.venda(update);
            }

            if (pred.getOutput() == 1
                    && this.estado != State.LONG) {
                this.compra(update);
            } 
        }
        
        this.lastMarketData = update;
        
    }

    @Override
    public void finish(Date date) {

        DecimalFormat df = new DecimalFormat("##.##");
        if (date == null) {
            this.finalizarExecucao(this.lastMarketData);
            System.out.println(df.format(this.capital) + "\t" + df.format(this.lastMarketData.getClose()));
        } else {
            double capitalEstimado = this.capital;
            if (this.estado == State.LONG) {
                capitalEstimado = this.capital + this.lastMarketData.getClose();
            }
            if (this.estado == State.SHORT) {
                capitalEstimado = this.capital - this.lastMarketData.getClose();
            }
            System.out.println(df.format(capitalEstimado) + "\t - " + df.format(this.lastMarketData.getClose()));
        }

    }

    private void compra(MarketData update) {
        double volumeReal = this.volumeNegociado;
        if (this.estado != State.FLAT) {
            volumeReal = 2 * this.volumeNegociado;
        }
        this.capital = this.capital
                - (update.getClose() + this.slippage) * volumeReal;
        this.estado = State.LONG;
    }

    private void venda(MarketData update) {
        double volumeReal = this.volumeNegociado;
        if (this.estado != State.FLAT) {
            volumeReal = 2 * this.volumeNegociado;
        }
        this.capital = this.capital
                + (update.getClose() - this.slippage) * volumeReal;
        this.estado = State.SHORT;
    }

    private void finalizarExecucao(MarketData update) {
        double volumeReal = this.volumeNegociado;
        if (this.estado == State.LONG) {
            this.capital = this.capital + (update.getClose() - this.slippage) * volumeReal;
            this.estado = State.FLAT;
        }
        if (this.estado == State.SHORT) {
            this.capital = this.capital - (update.getClose() + this.slippage) * volumeReal;
            this.estado = State.FLAT;
        }

    }

    private class Prediction {

        private String date;
        private double output;

        public Prediction() {

        }

        public Prediction(String date, double output) {
            this.date = date;
            this.output = output;
        }

        public String getData() {
            return date;
        }

        public void setData(String date) {
            this.date = date;
        }

        public double getOutput() {
            return output;
        }

        public void setOutput(double output) {
            this.output = output;
        }

    }

}