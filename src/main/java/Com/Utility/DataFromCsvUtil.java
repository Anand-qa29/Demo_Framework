package Com.Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFromCsvUtil {	
	
	 public static List<List<String>> readCsv(String filePath) {
	        List<List<String>> rows = new ArrayList<>();

	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] values = line.split(",");
	                List<String> row = new ArrayList<>();
	                for (String value : values) {
	                    row.add(value);
	                }
	                rows.add(row);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return rows;
	    }

}
