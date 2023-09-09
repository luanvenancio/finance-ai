package main.java;

public interface Strategy {
    
    public void create();

    public void start(LocalDate date);

    public void update(MarketData marketData);

    public void finish(LocalDate date);
}
