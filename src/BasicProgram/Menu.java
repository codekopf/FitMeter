package BasicProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;

public class Menu {
	
	public static void printWelcomeMessage() {
		System.out.println("Welcome in basic step meter data collection program.");
	}
	
	public static void printBasicMenu(){
		System.out.println("What would you like to do?");
		System.out.println(
				"------------------------------------------\n" + 
				"MENU:\n" + "Press 1 to add new record \n" + 
				"Press 2 to read all previous records \n" + 
				"Press 3 to edit certain record \n" + 
				"Press 4 to delete record \n" + 
				"Press 0 to end program \n"
				+ "------------------------------------------");
	}
	
	public static void cyrclingSwitch(int menuNumber) {
		int noStepsPerDay, noCaloriesPerDay, recordYear, recordMonth, recordDay;
		Scanner in = new Scanner(System.in);
		switch (menuNumber) {
			/* CREATE NEW RECORD */
			case 1:	
				System.out.println("You choosed to create new record");
				System.out.println("Which year?");
				recordYear = in.nextInt();
				System.out.println("Which month?");
				recordMonth = in.nextInt();
				System.out.println("Which day?");
				recordDay = in.nextInt();
				System.out.println("How much steps?");
				noStepsPerDay = in.nextInt();
				System.out.println("How much calories");
				noCaloriesPerDay = in.nextInt();
				Menu.recordCreate(recordYear, recordMonth, recordDay, noStepsPerDay, noCaloriesPerDay);
				break;
	
			/* READ ALL RECORDS */
			case 2:
				System.out.println("You choosed to read all records");
				Menu.recordReadAll();
				break;
	
			/* EDIT SPECIFIC RECORD */
			case 3:		
				System.out.println("You choosed to edit certain record");
				System.out.println("Which year?");
				recordYear = in.nextInt();
				System.out.println("Which month?");
				recordMonth = in.nextInt();
				System.out.println("Which day?");
				recordDay = in.nextInt();
				System.out.println("Searching...");
				Menu.recordEdit(recordYear, recordMonth, recordDay);
				break;
	
			/* DELETE SPECIFIC RECORD */
			case 4:			
				System.out.println("You choosed to delete record");
				System.out.println("Select ID of record you would like to remove.");
				System.out.println("Record has been removed.");
				System.out.println("Which year?");
				recordYear = in.nextInt();
				System.out.println("Which month?");
				recordMonth = in.nextInt();
				System.out.println("Which day?");
				recordDay = in.nextInt();
				System.out.println("Searching...");
				Menu.recordDelete(recordYear, recordMonth, recordDay);
				break;
			default:
				System.out.println("THE END");
				break;
		}
	}

	public static void recordCreate(int recordYear, int recordMonth, int recordDay, int noStepsPerDay, int noCaloriesPerDay) {
		Record newDailyRecord = new Record(recordYear, recordMonth, recordDay, noStepsPerDay, noCaloriesPerDay);
		newDailyRecord.createRecordInDocument();
	}
	
	public static void recordReadAll() {
		
		// TODO - Ask to sort by ID or Date; ps. Comparable
		// interface
		// Collections.sort(allRecords);
		
		// long startTime = System.nanoTime();

		int totalNumLines = 0;
		File file = new File("data.csv");
		try (CSVReader reader = new CSVReader(new FileReader(file))) {
			for(String[] nextLine : reader) {
			    // nextLine[] is an array of values from the line
				System.out.println(nextLine[0] + ", " + nextLine[1] + ", " + nextLine[2] + ", " + nextLine[3]);
				totalNumLines++;
			}
			
//			String sCurrentLine;
//			while ((sCurrentLine = reader.readLine()) != null) {
//				System.out.println(sCurrentLine);
//				totalNumLines++;
//			}
			System.out.println("---------------------");
			System.out.println("File has " + totalNumLines + " lines.");
			reader.close();
		} catch (IOException e) {
			System.out.println("Unable to read the file: " + file.toString());
		}

		//long endTime = System.nanoTime();
		
		// double estTime = (endTime-startTime)/100000000.0;
		// System.out.println(estTime);
		// TODO - Maybe remove StepsRecords toString method
		// System.out.println(allRecords.toString());
		file = null;
	}
	
	public static void recordEdit(int recordYear, int recordMonth, int recordDay) {
		ArrayList<String> arr = new ArrayList<String>();
		
		//CSVReader reader = new CSVReader(new FileReader("yourfile.csv"));
	    //List<String[]> myEntries = reader.readAll();

		File fileToRewrite = new File("data.csv");

		try (BufferedReader br = new BufferedReader(new FileReader(fileToRewrite))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				arr.add(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Set search pattern
		String pattern = recordYear + " " + (recordMonth < 10 ? "0" : "") + recordMonth + " "
				+ (recordDay < 10 ? "0" : "") + recordDay;

		// TEST System.out.println(pattern);

		// Loop trough the records to find a match
		for (String currLine : arr) {
			if (currLine.contains(pattern)) {
				System.out.println("Record exists:" + "---------------------");

				arr.set(arr.indexOf(currLine), "XXXX YYY");
			}
		}

		try (BufferedWriter br = new BufferedWriter(new FileWriter(fileToRewrite))) {
			for (String currLine : arr) {
				br.write(currLine);
				br.newLine();
			}
			System.out.println("File updated.");
		} catch (IOException e) {
			System.out.println("Unable to read the file: " + fileToRewrite.toString());
		}
	}
	
	public static void recordDelete(int recordYear, int recordMonth, int recordDay){

		ArrayList<String> arr2 = new ArrayList<String>();

		File fileToRewrite2 = new File("data.csv");

		try (BufferedReader br = new BufferedReader(new FileReader(fileToRewrite2))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				arr2.add(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Set search pattern
		String pattern2 = recordYear + " " + (recordMonth < 10 ? "0" : "") + recordMonth + " "
				+ (recordDay < 10 ? "0" : "") + recordDay;

		// TEST System.out.println(pattern);

		// Loop trough the records to find a match
		for (String currLine : arr2) {
			if (currLine.contains(pattern2)) {

				arr2.set(arr2.indexOf(currLine), "");
				System.out.println("Record removed" + "---------------------");
			}
		}

		try (BufferedWriter br = new BufferedWriter(new FileWriter(fileToRewrite2))) {
			for (String currLine : arr2) {
				if (currLine != null && !currLine.isEmpty()) {
					br.write(currLine);
					br.newLine();
				}
			}
			System.out.println("File updated.");
		} catch (IOException e) {
			System.out.println("Unable to read the file: " + fileToRewrite2.toString());
		}
	}
}
