package com.tsi.finance.simulator;

import java.util.Date;

/**
 *
 * @author luanv
 */

public class MarketData {
    
    private Date date;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Integer volume;

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getOpen() {
        return this.open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return this.high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return this.low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getClose() {
        return this.close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Integer getVolume() {
        return this.volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
    
    public MarketData() {
        
    }

    public MarketData(Date date, Double open, Double high, Double low, Double close, Integer volume) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "[date=" + date + ", open=" + open + ", high=" + high + ", low=" + low + ", close=" + close + ", volume=" + volume + "]";
    }

}

