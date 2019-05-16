import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
 

 
public class CompanytoArrayList {
	public static void main(String[] args) {
		
		BufferedReader companyBuffer = null;
		
		try {
			String companyLine;
			companyBuffer = new BufferedReader(new FileReader("employee.csv"));
			
			// How to read file in java line by line???
			System.out.println("starting to read the selected file")
			while ((companyLine = companyBuffer.readLine()) != null) {
				System.out.println("Raw CSV data: " + companyLine);
				System.out.println("Converted ArrayList data: " + companyCSVtoArrayList(companyLine) + "\n");
			}
			System.out.println("Finally done....")

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (companyBuffer != null) companyBuffer.close();
			} catch (IOException companyException) {
				companyException.printStackTrace();
			}
		}
	}
	
	// Utility which converts CSV to ArrayList using Split Operation
	public static ArrayList<String> companyCSVtoArrayList(String companyCSV) {
		ArrayList<String> companyResult = new ArrayList<String>();
		
		if (companyCSV != null) {
			String[] splitData = companyCSV.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					companyResult.add(splitData[i].trim());
				}
			}
		}
		
		return companyResult;
	}
	
}
