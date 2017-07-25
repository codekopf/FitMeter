package BasicProgram;
import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UnitTest {

	@Before
	public void setUp() throws Exception {
		ArrayList<StepsRecord> allRecords = new ArrayList<StepsRecord>();
		// noStepsPerDay, noCaloriesPerDay, recordYear, recordMonth, recordDay, recordID;
		// TODO - Unit tests
		// TEST
		StepsRecord newDailyRecord1 = new StepsRecord(2016, 01, 14, 4000, 70000); // TEST
		allRecords.add(newDailyRecord1); // TEST
		StepsRecord newDailyRecord2 = new StepsRecord(2015, 05, 21, 5000, 45000); // TEST
		allRecords.add(newDailyRecord2); // TEST
		StepsRecord newDailyRecord3 = new StepsRecord(2010, 02, 21, 8000, 8000); // TEST
		allRecords.add(newDailyRecord3); // TEST
		StepsRecord newDailyRecord4 = new StepsRecord(2016, 07, 04, 4000, 9800); // TEST
		allRecords.add(newDailyRecord4); // TEST
		StepsRecord newDailyRecord5 = new StepsRecord(2014, 06, 1, 50, 14000); // TEST
		allRecords.add(newDailyRecord5); // TEST
		StepsRecord newDailyRecord6 = new StepsRecord(2013, 07, 11, 80, 81); // TEST
		allRecords.add(newDailyRecord6); // TEST
		
		for(StepsRecord record : allRecords) {
			record.createRecordInDocument();
		}
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		assertEquals("Checkl fierst", "A","A");
		assertEquals("Chgeck second", "B", "B");
	}
	
	public void testGet(){
//		try {
//			fail("Check out of bands");
//		} catch (IndexOutOfBoundsExceptions e) {
//			
//		}
//		
		
		
		assertEquals("Checkl fierst", "A","A");
		assertEquals("Chgeck second", "B", "A");
		
	}

}
