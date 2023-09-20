package strategies;

import com.tsi.finance.simulator.MarketData;
import com.tsi.finance.simulator.Strategy;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author luanv
 */
public class SimpleMovingAverageStrategy implements Strategy {

    private State estado;
    private int posicao;
    private double slippage;
    private int volumeNegociado;
    private double capital;
    private MarketData lastMarketData;

    // VARIAVEIS DA ESTRATEGIA
    private int mediaMovelCurta;
    private int mediaMovelLonga;
    private ArrayList<Double> precoHistorico;

    public SimpleMovingAverageStrategy() {
        this.slippage = 0.0;
        this.volumeNegociado = 1;
        this.capital = 0;

        this.precoHistorico = new ArrayList<>();
        this.mediaMovelCurta = 7;
        this.mediaMovelLonga = 20;
    }

    public SimpleMovingAverageStrategy(double slippage,
            int volumeNegociado,
            double capital,
            int mediaMovelLonga,
            int mediaMovelCurta) {
        this.slippage = slippage;
        this.volumeNegociado = volumeNegociado;
        this.capital = capital;

        this.mediaMovelCurta = mediaMovelCurta;
        this.mediaMovelLonga = mediaMovelLonga;
        this.precoHistorico = new ArrayList<>();
    }

    @Override
    public void create() {

        System.out.println("Creating the strategy - Simple Strategy");

        this.estado = State.FLAT;
        this.posicao = 0;

    }

    @Override
    public void start(Date date) {

    }

    @Override
    public void update(MarketData update) {

        this.precoHistorico.add(update.getClose());

        if (precoHistorico.size() >= this.mediaMovelCurta && precoHistorico.size() >= this.mediaMovelLonga) {

            double mediaCurta = this.calcularMediaMovel(this.mediaMovelCurta);
            double mediaLonga = this.calcularMediaMovel(this.mediaMovelLonga);

            if (mediaLonga >= mediaCurta && this.estado != State.SHORT) {
                this.venda(update);
            } else if (mediaLonga <= mediaCurta && this.estado != State.LONG) {
                this.compra(update);
            }

        }

        this.lastMarketData = update;
    }

    @Override
    public void finish(Date date) {

        DecimalFormat df = new DecimalFormat("##.##");

        //System.out.println("[Simple Strategy] Finishing - " + date.toString());
        if (date == null) {
            this.finalizarExecucao(this.lastMarketData);
            System.out.println(df.format(this.capital) + "\t" + df.format(this.lastMarketData.getClose()));
        } else {
            // ESTIMATIVA DO RETORNO
            double capitalEstimado = this.capital;
            if (this.estado == State.LONG) {
                capitalEstimado = this.capital + this.lastMarketData.getClose();
            }
            if (this.estado == State.SHORT) {
                capitalEstimado = this.capital - this.lastMarketData.getClose();
            }
            System.out.println(df.format(capitalEstimado) + "\t" + df.format(this.lastMarketData.getClose()));
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

    public double calcularMediaMovel(int periodo) {
        double mediaMovel = 0;
        for (int i = this.precoHistorico.size() - 1, j = 0; i >= 0 && j < periodo; i--, j++) {
            mediaMovel += this.precoHistorico.get(i);
        }
        mediaMovel = mediaMovel / periodo;
        return mediaMovel;
    }

    public int getMediaMovelCurta() {
        return mediaMovelCurta;
    }

    public void setMediaMovelCurta(int mediaMovelCurta) {
        this.mediaMovelCurta = mediaMovelCurta;
    }

    public int getMediaMovelLonga() {
        return mediaMovelLonga;
    }

    public void setMediaMovelLonga(int mediaMovelLonga) {
        this.mediaMovelLonga = mediaMovelLonga;
    }

}
