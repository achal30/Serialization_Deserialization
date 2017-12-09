package genericCheckpointing.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

public class Driver {

	public static void main(String[] args) {
		if (args.length != 3) {
			System.err.println("Invalid arguments");
			System.exit(1);
		}

		int N = 0;
		try {
			N = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.err.println("invalid value for number of objects");
			System.exit(1);
		}

		ProxyCreator pc = new ProxyCreator();

		StoreRestoreHandler handler = new StoreRestoreHandler();

		// create a proxy
		StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(new Class[] { StoreI.class, RestoreI.class }, handler);

		MyAllTypesFirst myFirst;
		MyAllTypesSecond mySecond;

		if (args[0].equals("deser")) {
			System.out.println("Running in deser mode: ");
			handler.setFile(args[2]);
			for (int j = 0; j < N; j++) {
				System.out.println("Value of object " + (j + 1));
				SerializableObject deserObj = ((RestoreI) cpointRef).readObj("XML");
				System.out.println(deserObj.toString());
			}
			handler.close();
		} else {
			System.out.println("Running in serDeser mode. Check output.txt");
			// The code below is for "serdeser" mode
			// For "serdeser" mode, both the serialize and deserialize
			// functionality should be called.

			// create a data structure to store the objects being serialized
			// NUM_OF_OBJECTS refers to the count for each of MyAllTypesFirst
			// and MyAllTypesSecond
			List<SerializableObject> objOldList = new ArrayList<SerializableObject>();
			List<SerializableObject> objNewList = new ArrayList<SerializableObject>();
			for (int i = 0; i < N; i++) {

				// FIXME: create these object instances correctly using an
				// explicit value constructor
				// use the index variable of this loop to change the values of
				// the arguments to these constructors
				myFirst = generateRandomFirst();
				mySecond = generateRandomSecond();
				objOldList.add(myFirst);
				objOldList.add(mySecond);

				// FIXME: store myFirst and mySecond in the data structure
				((StoreI) cpointRef).writeObj(myFirst, 1000, "XML");
				((StoreI) cpointRef).writeObj(mySecond, 2000, "XML");

			}

			SerializableObject myRecordRet;
			handler.setFile("output.txt");
			// create a data structure to store the returned ojects
			for (int j = 0; j < 2 * N; j++) {

				myRecordRet = ((RestoreI) cpointRef).readObj("XML");
				objNewList.add(myRecordRet);
			}
			int mismatchCount = 0;
			for (int j = 0; j < 2 * N; j++) {
				SerializableObject oldObj = objOldList.get(j);
				SerializableObject newObj = objNewList.get(j);
				if (!oldObj.equals(newObj)) {
					mismatchCount++;
				}
			}

			System.out.println("Count of not equal objects: " + mismatchCount);
		}
	}

	public static String getRandomString() {
		String chars = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		StringBuilder result = new StringBuilder();
		Random rand = new Random();
		while (result.length() < 6) {
			int index = rand.nextInt(35);
			result.append(chars.charAt(index));
		}
		return result.toString();
	}

	public static MyAllTypesFirst generateRandomFirst() {
		Random rand = new Random();
		int myInt = rand.nextInt((Integer.MAX_VALUE - 1)) + 1;
		if(myInt < 10){
			myInt = 0;
		}
		int myOtherInt = rand.nextInt(Integer.MAX_VALUE - 1) + 1;
		if(myOtherInt < 10){
			myOtherInt = 0;
		}
		long myLong = rand.nextLong();
		if(myLong < 10){
			myLong = 0;
		}
		long myOtherLong = rand.nextLong();
		if(myOtherLong < 10){
			myOtherLong = 0;
		}
		int bool = rand.nextInt(1);
		boolean myBool = false;
		if (bool == 1) {
			myBool = true;
		}
		String myString = getRandomString();
		MyAllTypesFirst first = new MyAllTypesFirst(myInt, myOtherInt, myLong, myOtherLong, myBool, myString);
		return first;
	}

	public static char getRandomChar() {
		String chars = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		Random rand = new Random();
		int index = rand.nextInt(35);
		return chars.charAt(index);
	}

	public static MyAllTypesSecond generateRandomSecond() {
		Random rand = new Random();
		short myShortT = (short) rand.nextInt(Short.MAX_VALUE - 1);
		short myOtherShortT = (short) rand.nextInt(Short.MAX_VALUE - 1);
		float myFloatT = rand.nextFloat();
		double myDoubleT = rand.nextDouble() + 1;
		if(myDoubleT < 10){
			myDoubleT = 0;
		}
		double myOtherDoubleT = rand.nextDouble() + 1;
		if(myOtherDoubleT < 10){
			myOtherDoubleT = 0;
		}
		char myCharT = getRandomChar();
		return new MyAllTypesSecond(myDoubleT, myOtherDoubleT, myFloatT, myShortT, myOtherShortT, myCharT);
	}

}
