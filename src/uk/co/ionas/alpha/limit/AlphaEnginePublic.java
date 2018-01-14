package uk.co.ionas.alpha.limit;

import java.time.ZoneOffset;
import java.util.List;

import uk.co.ionas.alpha.data.Pair;
import uk.co.ionas.alpha.data.Tick;
import uk.co.ionas.alpha.util.LoadFile;

public class AlphaEnginePublic {

	static Price[] priceFeed;  // please use your own price feed
	
	static {
		String path = "./resources/historical/eur_usd/2017/12/DAT_ASCII_EURUSD_T_201712.csv";
		List<Tick> ticks = LoadFile.loadTicks(Pair.EUR_USD, path);
		priceFeed = new Price[ticks.size()];
		for (int i = 0; i<ticks.size(); i++) {
			Tick t = ticks.get(i);
			Price p = new Price(
				new Float(t.getBid())
				, new Float(t.getAsk())
				, t.getDateTime().toInstant(ZoneOffset.UTC).toEpochMilli());
			priceFeed[i] = p;
		}
	}
    public static void main(String[] args) {
        AlphaEngine alphaEngine = new AlphaEngine();
        for (Price price : priceFeed){
            alphaEngine.run(price);
        }
    }

   
}