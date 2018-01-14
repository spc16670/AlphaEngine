package uk.co.ionas.alpha.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import uk.co.ionas.alpha.data.Pair;
import uk.co.ionas.alpha.data.Tick;


public abstract class LoadFile {

	public static List<Tick> loadTicks(Pair pair, String path) {
		Reader r = null;
		BufferedReader br = null;
		List<Tick> prices = null;
		try {
			try {
				r = new FileReader(path);
				br = new BufferedReader(r);
				prices = new ArrayList<Tick>();
				String line = null;
				while((line = br.readLine()) != null) {
					String[] tokens = line.split(",");
					String dateStr = tokens[0].trim();
					LocalDateTime dateTime = Dates.toLocalDateTime(dateStr, "yyyyMMdd HHmmssSSS");
					String bidStr = tokens[1].trim();
					Double bid = new Double(bidStr);
					String askStr = tokens[2].trim();
					Double ask = new Double(askStr);
					prices.add(new Tick(pair, bid, ask, dateTime));
				}
			} finally {
				if (br != null) br.close();
				if (r != null) r.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prices;
		
	}
}
