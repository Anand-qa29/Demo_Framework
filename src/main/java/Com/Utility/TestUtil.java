package Com.Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestUtil {
	
	
	public static long IMPLICIT_WAIT =20;

	public static long PAGE_LOAD_TIMEOUT =20;
	
	
	public  List<List<String>> data(String path) {
		List<List<String>> rows=new ArrayList<>();
		try (BufferedReader br= new BufferedReader(new FileReader(path))){
			String line;
			while((line=br.readLine()) !=null){
				String values[]=line.split(",");
				List<String> row=new ArrayList<>();
				for(String value:values) {
					row.add(value);
				}
				rows.add(row);				
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
		
	}

}
 