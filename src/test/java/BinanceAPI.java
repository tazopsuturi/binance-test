
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

public class BinanceAPI {
	
	public String getExchangeInfo() throws IOException {
		URL url = new URL("https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder response = new StringBuilder();
		
		String line;
		while ((line = reader.readLine()) != null) {
			response.append(line);
		}
		reader.close();
		
		JSONObject json = new JSONObject(response.toString());
		
		return json.toString(2);
	}
}
