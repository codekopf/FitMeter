package BasicProgram;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
		String fileName = "data.csv";
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
				Menu.recordCreate(fileName, recordYear, recordMonth, recordDay, noStepsPerDay, noCaloriesPerDay);
				break;
	
			/* READ ALL RECORDS */
			case 2:
				System.out.println("You choosed to read all records");
				Menu.recordReadAll(fileName);
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
				Menu.recordEdit(fileName, recordYear, recordMonth, recordDay);
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
				Menu.recordDelete(fileName, recordYear, recordMonth, recordDay);
				break;
			default:
				System.out.println("THE END");
				break;
		}
	}

	public static void recordCreate(String fileName, int recordYear, int recordMonth, int recordDay, int noStepsPerDay, int noCaloriesPerDay) {
		Record newDailyRecord = new Record(recordYear, recordMonth, recordDay, noStepsPerDay, noCaloriesPerDay);
		newDailyRecord.createRecordInDocument(fileName);
	}
	
	public static void recordReadAll(String fileName) {
		// long startTime = System.nanoTime();
		int totalNumLines = 0;
		File file = new File(fileName);
		try (CSVReader reader = new CSVReader(new FileReader(file))) {
			for(String[] nextLine : reader) {
			    // nextLine[] is an array of values from the line
				System.out.println(nextLine[0] + "," + nextLine[1] + "," + nextLine[2] + "," + nextLine[3] + ",");
				totalNumLines++;
			}
			System.out.println("---------------------");
			System.out.println("File has " + totalNumLines + " lines.");
			reader.close();
		} catch (IOException e) {
			System.out.println("Unable to read the file: " + file.toString());
		}
		//long endTime = System.nanoTime();
		// double estTime = (endTime-startTime)/100000000.0;
		// System.out.println(estTime);
		file = null;
	}
	
	public static void recordEdit(String fileName, int recordYear, int recordMonth, int recordDay) {
		Scanner tempIn = new Scanner(System.in);
		List<String[]> allRecordsList = fetchAllRecords();
		
		// Set search pattern
		String pattern = recordYear + "-" + (recordMonth < 10 ? "0" : "") + recordMonth + "-" + (recordDay < 10 ? "0" : "") + recordDay;
		
		for(String[] record : allRecordsList) {
			if (record[0].contains(pattern)) {
				System.out.println(
						"Record exists:" + 
						record[0] + "\n" + 
						record[1] + "\n" + 
						record[2] + "\n" + 
						record[3] + "\n" + 
						"---------------------");
				System.out.println("How much steps?");
				record[1] = tempIn.nextLine();
				System.out.println("How much calories");
				record[2] = tempIn.nextLine();
			}
		}

		saveAllRecords(fileName, allRecordsList);
	}

	
	public static void recordDelete(String fileName, int recordYear, int recordMonth, int recordDay){
		List<String[]> allRecordsList = fetchAllRecords();
		
		// Set search pattern
		String pattern = recordYear + "-" + (recordMonth < 10 ? "0" : "") + recordMonth + "-" + (recordDay < 10 ? "0" : "") + recordDay;
		
		Iterator<String[]> allRecordsIterator = allRecordsList.iterator();
		List<String[]> allRecordsListNew = new ArrayList<String[]>();
		
		while (allRecordsIterator.hasNext()) {
			String[] currentRecord = allRecordsIterator.next();
			if (currentRecord[0].contains(pattern)) {
				allRecordsIterator.remove();
				System.out.println("Record has been deleted.");
			} else {
				allRecordsListNew.add(currentRecord);
			}
		}
		saveAllRecords(fileName, allRecordsListNew);
	}
	

	
	private static List<String[]> fetchAllRecords(){
		File file = new File("data.csv");
		List<String[]> l = new ArrayList<String[]>();
		try (CSVReader reader = new CSVReader(new FileReader(file))) {
			for(String[] nextLine : reader) {
			    // nextLine[] is an array of values from the line
				l.add(nextLine);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Unable to read the file: " + file.toString());
		}	
		return l;
	}
	
	private static void saveAllRecords(String fileName, List<String[]> l){
		File file = new File(fileName);
		
		FileOutputStream writer;
		try {
			writer = new FileOutputStream(file);
			writer.write(("").getBytes());
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(String[] record : l) {
			String row = record[0] + "," + record[1] + "," +  record[2] + "," +  record[3] + ",";
			try (BufferedWriter br = new BufferedWriter(new FileWriter(file, true))) {
				br.write(row);
				br.newLine();
			} catch(IOException e) {
				e.printStackTrace();
				System.out.println("Unable to read the file: " + file.toString());
			}
		}
		System.out.println("File updated.");
	}
}
