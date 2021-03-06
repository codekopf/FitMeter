package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BasicProgram.Record;

public class UnitTest {
	
	private static String testFileName = "test.csv";

	@Before
	public void setUp() throws Exception {
		
		// CREATE NEW CSV FILE AND POPULATE IT WITH RANDOM DATA
		File testFile = new File(testFileName);
		ArrayList<Record> allRecords = new ArrayList<Record>();
		Record newDailyRecord1 = new Record(2016, 01, 14, 4000, 70000); 
		allRecords.add(newDailyRecord1);
		Record newDailyRecord2 = new Record(2015, 05, 21, 5000, 45000);
		allRecords.add(newDailyRecord2);
		Record newDailyRecord3 = new Record(2010, 02, 21, 8000, 8000);
		allRecords.add(newDailyRecord3);
		Record newDailyRecord4 = new Record(2016, 07, 04, 4000, 9800);
		allRecords.add(newDailyRecord4);
		Record newDailyRecord5 = new Record(2014, 06, 1, 50, 14000);
		allRecords.add(newDailyRecord5);
		Record newDailyRecord6 = new Record(2013, 07, 11, 80, 81);
		allRecords.add(newDailyRecord6);

		for (Record record : allRecords) {
			record.createRecordInDocument(testFileName);
		}
        
        // TODO ASSERT COUNT NUMBERS OF ROWS
	}
	
	@After
	public void tearDown() throws Exception {
		// DELETE CSV FILE
		File testFile = new File(testFileName);
        if (testFile.delete()) {
        	System.out.println("File deleted " + testFileName + " was deleted.");
        } else {
        	System.out.println("File was not deleted.");
        }
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
		assertEquals("Checkl fierst", "A", "A");
		assertEquals("Chgeck second", "B", "B");
	}

	public void testGet() {
		// try {
		// fail("Check out of bands");
		// } catch (IndexOutOfBoundsExceptions e) {
		//
		// }
		//

		assertEquals("Checkl fierst", "A", "A");
		assertEquals("Chgeck second", "B", "A");

	}

}
