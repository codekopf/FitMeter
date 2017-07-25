package BasicProgram;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StepsRecord
{
	private int noStepsPerDay;
	private int noCaloriesPerDay;
	private int recordDay;
	private int recordMonth;
	private int recordYear;
	
	/* Constructor */
	public StepsRecord (int recordYear, int recordMonth, int recordDay, int noStepsPerDay, int noCaloriesPerDay)
	{
		this.recordYear = recordYear;
		this.recordMonth = recordMonth;
		this.recordDay = recordDay;
		this.noStepsPerDay = noStepsPerDay;
		this.noCaloriesPerDay = noCaloriesPerDay;
	}
	
	/*
	 * Convert record to string
	 */
	public String toString()
	{
		return recordYear + "." + recordMonth + "." + recordYear + " - " + noStepsPerDay + " steps - " + noCaloriesPerDay + " calories\n";
	}
	
	/*
	 * Get record calories per day
	 */
	public int getCaloriesPerDay()
	{
		return this.noCaloriesPerDay;
	}
	
	/*
	 * Get record steps per day
	 */
	public int getStepsPerDay()
	{
		return this.noStepsPerDay;
	}
	
	/*
	 * Edit record and set new properties 
	 */
	public void setProperties(int noStepsPerDay, int noCaloriesPerDay, int recordYear, int recordMonth, int recordDay)
	{
		this.noStepsPerDay = noStepsPerDay;
		this.noCaloriesPerDay = noCaloriesPerDay;
		this.recordYear = recordYear;
		this.recordMonth = recordMonth;
		this.recordDay = recordDay;	
	}
	
	public void createRecordInDocument() {		
		String records = String.format("%4d %02d %02d %5d %5d", recordYear , recordMonth, recordDay, noStepsPerDay, noStepsPerDay);
		
		File file = new File("records.txt");
		try (BufferedWriter br = new BufferedWriter(new FileWriter(file, true))) {
			br.write(records);
			br.newLine();
			System.out.println("File updated.");
		} catch(IOException e) {
			System.out.println("Unable to read the file: " + file.toString());
		}
	}
}
