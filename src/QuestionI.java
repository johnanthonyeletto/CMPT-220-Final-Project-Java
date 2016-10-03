import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class QuestionI {

	public static void main(String[] args) {
		try {
			// Create Buffered Reader and Buffered Writer
			BufferedReader reader = new BufferedReader(new FileReader("Passenger_Weather_Combined.csv"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("stop.csv"));
			// Initialize Arrays
			String[] attribute = new String[15];
			String[][] attributes = new String[77224][15];
			String line = reader.readLine();
			// Store Data In 2d Array
			int number = 0;
			while (line != null) {
				attribute = line.split(",");
				attributes[number] = attribute;
				line = reader.readLine();
				number++;
			}
			reader.close();
			// Create set in order to keep track of what elements were already
			// written to the csv file
			Set<Integer> stops = new TreeSet<Integer>();
			for (int i = 0; i < attributes.length; i++) {
				stops.add(Integer.parseInt(attributes[i][2]));
			}
			Iterator<Integer> itr = stops.iterator();
			while (itr.hasNext()) {
				writer.write(Integer.toString(itr.next()));
				writer.newLine();
			}
			writer.close();
			System.out.println("Done");

		} catch (IOException e) {

		}
	}

}
