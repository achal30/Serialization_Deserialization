package genericCheckpointing.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class XMLDeserialization implements SerStrategy {

	@Override
	public void processInput(SerializableObject sObject) {

	}

	@Override
	public SerializableObject processInput(FileProcessor fp) {
		SerializableObject serObject = null;
		try {
			fp.readLine();
			List<String> objectLines = getObjectLines(fp);
			serObject = deserObject(objectLines);
			fp.readLine();
		} catch (IOException e) {
			
		}
		return serObject;

	}

	private List<String> getObjectLines(FileProcessor fp) throws IOException {
		String line = "";
		List<String> objectLines = new ArrayList<String>();
		while (!(line = fp.readLine()).contains("/complexType")) {
			objectLines.add(line);
		}
		return objectLines;
	}

	private SerializableObject deserObject(List<String> objectLines) {
		String clsName = objectLines.get(0).split("\"")[1];
		Class cls = null;
		Object obj = null;
		try {
			cls = Class.forName(clsName);
			obj = cls.newInstance();
		} catch (Exception e) {
			System.err.println("error in reflection");
			System.exit(1);
		}
		objectLines.remove(0);
		for (String line : objectLines) {
			Class[] signature = new Class[1];
			Object[] params = new Object[1];
			String type = line.split("xsd:")[1].split("\"")[0];
			String value = line.split(">")[1].split("<")[0];
			setType(type, value, signature, params);
			String variable = line.split("</")[1].split(">")[0];
			variable = variable.substring(0, 1).toUpperCase() + variable.substring(1);
			String methodName = "set" + variable;
			Method meth = null;
			try {
				meth = cls.getMethod(methodName, signature);
			} catch (NoSuchMethodException e) {
				System.err.println("method not found");
				System.exit(1);
			}

			try {
				meth.invoke(obj, params);
			} catch (InvocationTargetException e) {
				System.err.println("error in invocation");
				System.exit(1);
			} catch (IllegalArgumentException e) {
				System.err.println("error in argument");
				System.exit(1);
			} catch (IllegalAccessException e) {
				System.err.println("error in access");
				System.exit(1);
			}

		}
		return (SerializableObject) obj;
	}

	private void setType(String element, String elementVal, Object[] signature, Object[] params) {
		Class type = null;
		Object value = null;
		switch (element) {
		case "byte":
			type = Byte.TYPE;
			value = Byte.parseByte(elementVal);
			break;
		case "short":
			type = Short.TYPE;
			value = Short.parseShort(elementVal);
			break;
		case "long":
			type = Long.TYPE;
			value = Long.parseLong(elementVal);
			break;
		case "int":
			type = Integer.TYPE;
			value = Integer.parseInt(elementVal);
			break;
		case "float":
			type = Float.TYPE;
			value = Float.parseFloat(elementVal);
			break;
		case "double":
			type = Double.TYPE;
			value = Double.parseDouble(elementVal);
			break;
		case "boolean":
			type = Boolean.TYPE;
			value = Boolean.parseBoolean(elementVal);
			break;
		case "char":
			type = Character.TYPE;
			value = elementVal.charAt(0);
			break;
		case "string":
			type = String.class;
			value = elementVal;
			break;
		}
		signature[0] = type;
		params[0] = value;
	}
}
