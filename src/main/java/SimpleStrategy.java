public class SimpleStrategy implements Strategy {

    @Override
	public void create() {
		System.out.println("Creating the strategy - Simple Strategy");
    }
	
    @Override
	public void start(Date date) {
		System.out.println("[Simple Strategy] Starting - " + date.toString());
	}
	
    @Override
	public void update( marketData update) {
		System.out.println("[Simple Strategy] MD - " + update.toString());
	}
	
    @Override
	public void finish(Date date) {
		System.out.println("[Simple Strategy] Finished - " + date.toString());
	}

}