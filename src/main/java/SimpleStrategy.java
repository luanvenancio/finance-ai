public class SimpleStrategy implements Strategy {

  @Override
  public void create() {
    System.out.println("Creating the strategy - Simple Strategy");
  }

  @Override
  public void start(LocalDate date) {
    System.out.println("[Simple Strategy] Starting - " + date.toString());
  }

  @Override
  public void update(MarketData marketData) {
    System.out.println("[Simple Strategy] MD - " + marketData.toString());
  }

  @Override
  public void finish(LocalDateDate date) {
    System.out.println("[Simple Strategy] Finished - " + date.toString());
  }
  
}
