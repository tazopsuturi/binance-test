package service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestDataReader {
	private static final Map<String, String> testData = new HashMap<>();
	
	public static void loadTestData(String csvFilePath) {
		try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
			reader.skip(1);
			
			String[] line;
			while ((line = reader.readNext()) != null) {
				if (line.length >= 2) {
					String key = line[0].trim();
					String value = line[1].trim();
					testData.put(key, value);
				}
			}
		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key) {
		return testData.get(key);
	}
}