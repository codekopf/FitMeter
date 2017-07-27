/*
 * Made by Andrej Buday 2016
 * V.: Java SE 1.8
 */
package BasicProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Menu.printWelcomeMessage();

		try (Scanner in = new Scanner(System.in)) {
			int menuNumber;
			// ArrayList<StepsRecord> allRecords = new ArrayList<StepsRecord>();
			// int recordID;

			do {
				Menu.printBasicMenu();
				menuNumber = in.nextInt();
				switch (menuNumber) {
				/* CREATE NEW RECORD */
				case 1:
					Menu.recordCreate();
					break;

				/* READ RECORDS */
				case 2:
					Menu.recordRead();
					break;

				/* EDIT RECORD */
				case 3:
					Menu.recordEdit();
					break;

				/* DELETE RECORD */
				case 4:
					Menu.recordDelete();
					break;
				default:
					System.out.println("THE END");
					break;
				}
			} while (menuNumber != 0);
		}
	}
}
