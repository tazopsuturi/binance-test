import java.io.IOException;

public class BinanceTest {
	
	public static void main(String[] args) {
		try {
			String exchangeInfo = new BinanceAPI().getExchangeInfo();
			System.out.println(exchangeInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
