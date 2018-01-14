package uk.co.ionas.alpha.limit;

public class AlphaEnginePublic {

	static Price[] priceFeed;  // please use your own price feed
	
    public static void main(String[] args) {
        AlphaEngine alphaEngine = new AlphaEngine();
        for (Price price : priceFeed){
            alphaEngine.run(price);
        }
    }

}