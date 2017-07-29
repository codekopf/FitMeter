### TODO ###
+ Turn project to Maven project
+ Divide program into smaller classes - RecordCreate , read, update, delete, ...  
+ Turn .txt recording to .csv with OpenCSV
+ Refactor - Create Menu class
+ Menu - select certain date range stats
+ More Unit tests
+ More comments 
+ DB API ?
+ Gradually build GUI with Spring, etc.
+ Create nice Readme.md details exp. how to run with console
+ + Create imports data with App arguments
+ Rename the App for FitMeter
+ Stats ? Graphs ?
+ interface Comparable for comparing ids


public class FileTest {
    public static void main(String args[]) {
        File f = new File(args[0]);
        System.out.println(f + (f.exists()? " is found " : " is missing "));
    }
}