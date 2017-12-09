package genericCheckpointing.util;

public interface SerStrategy {
	
	void processInput(SerializableObject sObject);
	SerializableObject processInput(FileProcessor fp);
}
