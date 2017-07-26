package BasicProgram;

public class Menu {
	
	public static void printWelcomeMessage() {
		System.out.println("Welcome in basic step meter data collection program.");
	}
	
	public static void printBasicMenu(){
		System.out.println("What would you like to do?");
		System.out.println("------------------------------------------\n" + "MENU:\n" + "Press 1 to add new record\n"
				+ "Press 2 to read all previous records\n" + "Press 3 to edit certain record\n"
				+ "Press 4 to delete record\n" + "Press 0 to end program\n"
				+ "------------------------------------------");
	}

}
