
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;
import service.TestDataReader;

public class BinanceAPI {
	
	static {
		TestDataReader.loadTestData("src/test/resources/sendemaildata.csv");
	}
	
	public String getExchangeInfo() throws IOException {
		
		String apiUrl = TestDataReader.getValue("binanceAPIUrl");
		if (apiUrl == null || apiUrl.isEmpty()) {
			throw new IllegalArgumentException("binanceAPIUrl is missing in CSV");
		}
		
		URL url = new URL(apiUrl);
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
		
		return json.getString("price");
	}
}
