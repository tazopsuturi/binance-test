# Bitcoin Price Alert System

A Java application that monitors the Bitcoin (BTC) price using the Binance API.  
Sends email alerts when the price falls within a user-defined range.  

## Features
- Fetches real-time BTC price from Binance API.  
- Sends email alerts via Gmail when the price is within a specified range.  
- Configurable via a CSV file (credentials, API URLs, etc.).  
- Easy-to-modify price thresholds.  

## Prerequisites
- **Java 8 or higher**
- **Gmail Account** (with [App Password](https://myaccount.google.com/apppasswords) enabled)
- **Maven** or **Gradle** (for dependency management)
- CSV file with configuration data (see [Configuration](#configuration))

## Installation
1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/bitcoin-price-alert.git
   cd bitcoin-price-alert
   ```
   
2. **Build the project**:
   ```bash
   mvn clean install
    ```
   
## Configuration
1. **Create a CSV file** named `config.csv` in the `src/main/resources` directory.  
   ```bash
   key,value
   email,your-email@gmail.com
   password,your-gmail-app-password
   recipient.email,alert-recipient@example.com
   binanceAPIUrl,binance-api-url
   ```
   
2. **Generate a Gmail App Password:**  
   - Go to [Google Account](https://myaccount.google.com/apppasswords) and sign in.  
   - Select **Mail** and **Other** from the dropdown.  
   - Enter a name and click **Generate**.  
   - Copy the generated password and paste it in the `config.csv` file.

### Project Structure
```
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── service/
│ │ │ │ └── TestDataReader.java # Reads CSV configuration
│ │ │ ├── SendEmail.java # Handles email sending
│ │ │ ├── BinanceAPI.java # Fetches BTC price from Binance
│ │ │ └── BinanceTest.java # Main class with price logic
│ │ └── resources/
│ │ └── testdata.csv # Configuration file
├── pom.xml # Maven dependencies
└── README.md
```