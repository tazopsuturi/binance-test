import java.io.IOException;

public class BinanceTest {
	
	private static final double MIN_PRICE = 50000.00;  // Example lower bound for price
	private static final double MAX_PRICE = 100000.00;  // Example upper bound for price
	private static final String RECIPIENT_EMAIL = "recipient@gmail.com";
	
	public static void main(String[] args) {
		try {
			BinanceAPI binanceAPI = new BinanceAPI();
			SendEmail sendEmail = new SendEmail();
			
			String btcPrice = binanceAPI.getExchangeInfo();
			double btcPriceDouble = Double.parseDouble(btcPrice);
			
			System.out.println("Current btc price: $" + btcPrice);
			
			if (btcPriceDouble >= MIN_PRICE && btcPriceDouble <= MAX_PRICE) {
				sendEmail.sendEmail(RECIPIENT_EMAIL, "BTC Price Alert", "BTC price is between $" + MIN_PRICE + " and $" + MAX_PRICE);
			}else {
				System.out.println("BTC price is not between $" + MIN_PRICE + " and $" + MAX_PRICE);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
