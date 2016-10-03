import java.io.*;
import java.util.ArrayList;

public class QuestionIII {
	private static void sortNumbers(String[] array) {
		for (int i = 0; i <= array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (Integer.parseInt(array[j]) > Integer.parseInt(array[j + 1])) {
					switchNumbers(j, j + 1, array);
				}
			}
		}
	}

	private static void switchNumbers(int i, int j, String[] array) {
		String temporary = array[i];
		array[i] = array[j];
		array[j] = temporary;
	}

	public static void main(String[] args) {
		try {
			// Create Buffered Reader and Buffered Writer
			BufferedReader reader = new BufferedReader(new FileReader("Passenger_Weather_Combined.csv"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("Question_III.csv"));
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
			writer.write("StopID");
			writer.write(",");
			writer.write("Passenger_On_Weekday_GoodWeather");
			writer.write(",");
			writer.write("Passenger_On_Weekday_FairWeather");
			writer.write(",");
			writer.write("Passenger_On_Weekday_BadWeather");
			writer.write(",");
			writer.write("Passenger_On_Weekend_GoodWeather");
			writer.write(",");
			writer.write("Passenger_On_Weekend_FairWeather");
			writer.write(",");
			writer.write("Passenger_On_Weekend_BadWeather");
			writer.write(",");
			writer.write("Passenger_off_Weekday_GoodWeather");
			writer.write(",");
			writer.write("Passenger_off_Weekday_FairWeather");
			writer.write(",");
			writer.write("Passenger_off_Weekday_BadWeather");
			writer.write(",");
			writer.write("Passenger_off_Weekend_GoodWeather");
			writer.write(",");
			writer.write("Passenger_off_Weekend_FairWeather");
			writer.write(",");
			writer.write("Passenger_off_Weekend_BadWeather");
			writer.newLine();
			ArrayList<String> stops = new ArrayList<String>();
			for (int i = 0; i < attributes.length; i++) {
				String stopId = attributes[i][2];
				if (stops.contains(stopId)) {
					continue;
				} else {
					stops.add(stopId);
				}
			}
			String[] stopIDs = new String[stops.size()];
			for (int i = 0; i < stopIDs.length; i++) {
				stopIDs[i] = stops.get(i);
			}
			sortNumbers(stopIDs);
			for (int i = 0; i < stopIDs.length; i++) {
				String currentStopID = stopIDs[i];
				double Passenger_On_Weekday_GoodWeather_Sum = 0;
				double Passenger_On_Weekday_FairWeather_Sum = 0;
				double Passenger_On_Weekday_BadWeather_Sum = 0;
				double Passenger_On_Weekend_GoodWeather_Sum = 0;
				double Passenger_On_Weekend_FairWeather_Sum = 0;
				double Passenger_On_Weekend_BadWeather_Sum = 0;
				double Passenger_off_Weekday_GoodWeather_Sum = 0;
				double Passenger_off_Weekday_FairWeather_Sum = 0;
				double Passenger_off_Weekday_BadWeather_Sum = 0;
				double Passenger_off_Weekend_GoodWeather_Sum = 0;
				double Passenger_off_Weekend_FairWeather_Sum = 0;
				double Passenger_off_Weekend_BadWeather_Sum = 0;
				int stopCount = 0;
				for (int j = 0; j < attributes.length; j++) {
					if (currentStopID.equals(attributes[j][2])) {
						stopCount++;
						if (attributes[j][7].equals("weekday")) {
							if (Double.parseDouble(attributes[j][14]) > 88) {
								Passenger_On_Weekday_GoodWeather_Sum = Passenger_On_Weekday_GoodWeather_Sum
										+ Double.parseDouble(attributes[j][4]);
								Passenger_off_Weekday_GoodWeather_Sum = Passenger_off_Weekday_GoodWeather_Sum
										+ Double.parseDouble(attributes[j][5]);
							} else if (Double.parseDouble(attributes[j][14]) > 68
									&& Double.parseDouble(attributes[j][14]) < 88) {
								Passenger_On_Weekday_FairWeather_Sum = Passenger_On_Weekday_FairWeather_Sum
										+ Double.parseDouble(attributes[j][4]);
								Passenger_off_Weekday_FairWeather_Sum = Passenger_off_Weekday_FairWeather_Sum
										+ Double.parseDouble(attributes[j][5]);
							} else if (Double.parseDouble(attributes[j][14]) < 68) {
								Passenger_On_Weekday_BadWeather_Sum = Passenger_On_Weekday_BadWeather_Sum
										+ Double.parseDouble(attributes[j][4]);
								Passenger_off_Weekday_BadWeather_Sum = Passenger_off_Weekday_BadWeather_Sum
										+ Integer.parseInt(attributes[j][5]);
							}
						} else if (attributes[j][7].equals("weekend")) {
							if (Double.parseDouble(attributes[j][14]) > 88) {
								Passenger_On_Weekend_GoodWeather_Sum = Passenger_On_Weekend_GoodWeather_Sum
										+ Double.parseDouble(attributes[j][4]);
								Passenger_off_Weekend_GoodWeather_Sum = Passenger_off_Weekend_GoodWeather_Sum
										+ Double.parseDouble(attributes[j][5]);
							} else if (Double.parseDouble(attributes[j][14]) > 68
									&& Double.parseDouble(attributes[j][14]) < 88) {
								Passenger_On_Weekend_FairWeather_Sum = Passenger_On_Weekend_FairWeather_Sum
										+ Double.parseDouble(attributes[j][4]);
								Passenger_off_Weekend_FairWeather_Sum = Passenger_off_Weekend_FairWeather_Sum
										+ Double.parseDouble(attributes[j][5]);
							} else if (Double.parseDouble(attributes[j][14]) < 68) {
								Passenger_On_Weekend_BadWeather_Sum = Passenger_On_Weekend_BadWeather_Sum
										+ Double.parseDouble(attributes[j][4]);
								Passenger_off_Weekend_BadWeather_Sum = Passenger_off_Weekend_BadWeather_Sum
										+ Double.parseDouble(attributes[j][5]);
							}
						}
					}
				}
				writer.write(currentStopID);
				writer.write(",");
				writer.write(Double.toString(Passenger_On_Weekday_GoodWeather_Sum / stopCount));
				writer.write(",");
				writer.write(Double.toString(Passenger_On_Weekday_FairWeather_Sum / stopCount));
				writer.write(",");
				writer.write(Double.toString(Passenger_On_Weekday_BadWeather_Sum / stopCount));
				writer.write(",");
				writer.write(Double.toString(Passenger_On_Weekend_GoodWeather_Sum / stopCount));
				writer.write(",");
				writer.write(Double.toString(Passenger_On_Weekend_FairWeather_Sum / stopCount));
				writer.write(",");
				writer.write(Double.toString(Passenger_On_Weekend_BadWeather_Sum / stopCount));
				writer.write(",");
				writer.write(Double.toString(Passenger_off_Weekday_GoodWeather_Sum / stopCount));
				writer.write(",");
				writer.write(Double.toString(Passenger_off_Weekday_FairWeather_Sum / stopCount));
				writer.write(",");
				writer.write(Double.toString(Passenger_off_Weekday_BadWeather_Sum / stopCount));
				writer.write(",");
				writer.write(Double.toString(Passenger_off_Weekend_GoodWeather_Sum / stopCount));
				writer.write(",");
				writer.write(Double.toString(Passenger_off_Weekend_FairWeather_Sum / stopCount));
				writer.write(",");
				writer.write(Double.toString(Passenger_off_Weekend_BadWeather_Sum / stopCount));
				writer.newLine();
			}
			writer.close();
			System.out.println("Done");
		} catch (IOException e) {
		}
	}

}
