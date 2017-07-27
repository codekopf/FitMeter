package BasicProgram;
import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UnitTest {

	@Before
	public void setUp() throws Exception {
		ArrayList<Record> allRecords = new ArrayList<Record>();
		// noStepsPerDay, noCaloriesPerDay, recordYear, recordMonth, recordDay, recordID;
		// TODO - Unit tests
		// TEST
		Record newDailyRecord1 = new Record(2016, 01, 14, 4000, 70000); // TEST
		allRecords.add(newDailyRecord1); // TEST
		Record newDailyRecord2 = new Record(2015, 05, 21, 5000, 45000); // TEST
		allRecords.add(newDailyRecord2); // TEST
		Record newDailyRecord3 = new Record(2010, 02, 21, 8000, 8000); // TEST
		allRecords.add(newDailyRecord3); // TEST
		Record newDailyRecord4 = new Record(2016, 07, 04, 4000, 9800); // TEST
		allRecords.add(newDailyRecord4); // TEST
		Record newDailyRecord5 = new Record(2014, 06, 1, 50, 14000); // TEST
		allRecords.add(newDailyRecord5); // TEST
		Record newDailyRecord6 = new Record(2013, 07, 11, 80, 81); // TEST
		allRecords.add(newDailyRecord6); // TEST
		
		for(Record record : allRecords) {
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
