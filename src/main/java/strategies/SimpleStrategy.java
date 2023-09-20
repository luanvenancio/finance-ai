package strategies;

import com.tsi.finance.simulator.Strategy;
import com.tsi.finance.simulator.MarketData;
import java.util.Date;

/**
 *
 * @author luanv
 */
public class SimpleStrategy implements Strategy {

    private State estado;
    private double precoOntem;
    private int posicao;
    private double slippage;
    private int volumeNegociado;
    private double capital;
    private MarketData lastMarketData;

    public SimpleStrategy() {
        this.slippage = 0;
        this.volumeNegociado = 1;
        this.capital = 0;
    }
    
    public SimpleStrategy(double slippage, int volumeNegociado, double capital) {
        this.slippage = slippage;
        this.volumeNegociado = volumeNegociado;
        this.capital = capital;
    }
    
    @Override
    public void create() {
        
        System.out.println("Creating the strategy - Simple Strategy");
        
        this.estado = State.FLAT;
        this.precoOntem = Double.MAX_VALUE;
        this.posicao = 0;
    
    }

    @Override
    public void start(Date date) {
        
        //System.out.println("[Simple Strategy] Starting - " + date.toString());
        
    }

    @Override
    public void update(MarketData update) {
    
        System.out.println("[Simple Strategy] MD - " + update.toString());
        
        double precoHoje = update.getClose();
        
        if (precoOntem != Double.MAX_VALUE){
            
            if (precoHoje > precoOntem && 
                    this.estado != State.SHORT){
                this.venda(update);
            }
            
            if (precoHoje < precoOntem && 
                    this.estado != State.LONG){
                this.compra(update);
            } 
        }
        
        this.precoOntem = update.getClose();
        this.lastMarketData = update;
    }

    @Override
    public void finish(Date date) {
        
        //System.out.println("[Simple Strategy] Finishing - " + date.toString());
        if (date == null){
            this.finalizarExecucao(this.lastMarketData);
        }
        System.out.println(this.capital);
        
    }
    
    private void compra (MarketData update){
        double volumeReal = this.volumeNegociado;
        if (this.estado != State.FLAT) {
            volumeReal = 2 * this.volumeNegociado;
        }
        this.capital = this.capital - 
                (update.getClose() + this.slippage) * volumeReal;
        this.estado = State.LONG;
    }
    
    private void venda (MarketData update){
        double volumeReal = this.volumeNegociado;
        if (this.estado != State.FLAT) {
            volumeReal = 2 * this.volumeNegociado;
        }
        this.capital = this.capital + 
                (update.getClose() - this.slippage) * volumeReal;
        this.estado = State.SHORT;
    }
    
    private void finalizarExecucao (MarketData update){
        double volumeReal = this.volumeNegociado;
        if (this.estado == State.LONG){
            this.capital = this.capital + (update.getClose() - this.slippage) * volumeReal;
            this.estado = State.FLAT;
        }
        if (this.estado == State.SHORT){
            this.capital = this.capital - (update.getClose() + this.slippage) * volumeReal;
            this.estado = State.FLAT;
        }

    }
    
}

