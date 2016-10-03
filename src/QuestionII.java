import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class QuestionII {

	public static void main(String[] args) {
		try {
			// Create Buffered Reader and Buffered Writer
			BufferedReader reader = new BufferedReader(new FileReader("Passenger_Weather_Combined.csv"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("trip.csv"));
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
			Set<String> trips = new HashSet<String>();
			for (int i = 0; i < attributes.length; i++) {
				String dateAndTime = attributes[i][9] + "," + attributes[i][10];
				trips.add(dateAndTime);
			}
			Iterator<String> itr = trips.iterator();
			while (itr.hasNext()) {
				writer.write(itr.next());
				writer.newLine();
			}
			writer.close();
			System.out.println("Done");
		} catch (IOException e) {

		}
	}

}
