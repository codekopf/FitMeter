/*
 * Made by Andrej Buday 2016
 * V.: Java SE 1.8
 */
package BasicProgram;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Menu.printWelcomeMessage();

		try (Scanner in = new Scanner(System.in)) {
			int menuNumber;
			do {
				Menu.printBasicMenu();
				menuNumber = in.nextInt();
				Menu.cyrclingSwitch(menuNumber);
			} while (menuNumber != 0);
			in.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
