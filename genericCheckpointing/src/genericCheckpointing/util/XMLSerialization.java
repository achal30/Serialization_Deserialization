package genericCheckpointing.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class XMLSerialization implements SerStrategy {

	public void processInput(SerializableObject sObject) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt",true));
			FileProcessor fp = new FileProcessor(bw);
			fp.write("<DPSerialization>");
			String line = "";
			Class cls = sObject.getClass();
			fp.write("<complexType xsi:type=\"genericCheckpointing.util."+cls.getSimpleName()+"\">");
			Field[] fields = cls.getDeclaredFields();

			for (Field field : fields) {
				Class[] signature = new Class[0];
				Object[] params = new Object[0];
				String fieldName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
				String methodName = "get" + fieldName;
				Class type = field.getType();
				String typeName = type.getName();
				if (typeName.contains("java.lang.String")) {
					typeName = "String";
				}
				Object val = null;
				Method meth = null;
				try {
					meth = cls.getMethod(methodName, signature);
				} catch (NoSuchMethodException | SecurityException e) {
					System.err.println("Error in getting method");
					e.printStackTrace();
					System.exit(1);
				} finally {
				}

				try {
					val = meth.invoke(sObject, params);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					System.err.println("Error in method invocation");
					e.printStackTrace();
					System.exit(1);
				}
				if(val instanceof Integer){
					Integer value = (Integer) val;
					if(value >= 10){
						line = "<"+field.getName()+" xsi:type=\"xsd:"+typeName.toLowerCase()+"\">" + value + "</"+field.getName()+">";
						fp.write(line);
					}
				}
				else if(val instanceof Long){
					Long value = (Long) val;
					if(value >= 10){
						line = "<"+field.getName()+" xsi:type=\"xsd:"+typeName.toLowerCase()+"\">" + value + "</"+field.getName()+">";
						fp.write(line);
					}
				}
				else if(val instanceof Double){
					Double value = (Double) val;
					if(value >= 10){
						line = "<"+field.getName()+" xsi:type=\"xsd:"+typeName.toLowerCase()+"\">" + value + "</"+field.getName()+">";
						fp.write(line);
					}
				}else{
					line = "<"+field.getName()+" xsi:type=\"xsd:"+typeName.toLowerCase()+"\">" + val + "</"+field.getName()+">";
					fp.write(line);
				}
				
			}
			fp.write("</complexType>");
			fp.write("</DPSerialization>");
			fp.close();
		} catch (IOException e) {
			System.err.println("error in serialization");
			System.exit(1);
		}

	}
	
	@Override
	public SerializableObject processInput(FileProcessor fp) {
		return null;
	}

}
