package genericCheckpointing.xmlStoreRestore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerStrategy;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.XMLDeserialization;
import genericCheckpointing.util.XMLSerialization;

public class StoreRestoreHandler implements InvocationHandler {
	private FileProcessor fp;

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		String methodName = m.getName();
		SerStrategy strategy;
		if (methodName.equals("writeObj")) {
			strategy = new XMLSerialization();
			serializeData((SerializableObject) args[0], strategy);
		} else {
			strategy = new XMLDeserialization();
			return strategy.processInput(fp);
		}
		return null;
	}

	public void serializeData(SerializableObject sObject, SerStrategy sStrategy) {
		sStrategy.processInput(sObject);
	}

	public void setFile(String name) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(name));
			fp = new FileProcessor(br);
		} catch (IOException e) {
			System.err.println("Error setting file in handler");
			System.exit(1);
		}
	}

	public void close() {
		if (fp != null) {
			try {
				fp.close();
			} catch (IOException e) {
				System.err.println("Error in closing file");
				System.exit(1);
			}
		}
	}
}
