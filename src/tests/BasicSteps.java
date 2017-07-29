package tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BasicSteps {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// CREATE EMPTY CSV FILE
		File file = new File("testing.csv");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// DELETE EMPTY CSV FILE
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRecordAdd() {
		// ADD NEW RECORD 
		fail("Not yet implemented");
	}
	
	@Test
	public void testRecordRead() {
		// READ NEW RECORD 
		fail("Not yet implemented");
	}
	@Test
	public void testRecordChange() {
		// CHANGE NEW RECORD
		fail("Not yet implemented");
	}
	
	@Test
	public void testRecordDelete() {
		// DELETE RECORD 
		fail("Not yet implemented");
	}

}
