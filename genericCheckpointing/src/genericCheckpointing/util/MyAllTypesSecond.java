package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject{
	
	private double myDoubleT;
	private double myOtherDoubleT;
	private float myFloatT;
	private short myShortT;
	private short myOtherShortT;
	private char myCharT;
	
	public MyAllTypesSecond() {
	}
	
	public MyAllTypesSecond(double myDoubleTIn, double myOtherDoubleTIn, float myFloatTIn, short myShortTIn, short myOtherShortTIn, char myCharTIn){
		
		myDoubleT = myDoubleTIn;
		myOtherDoubleT = myOtherDoubleTIn;
		myFloatT = myFloatTIn;
		myShortT = myShortTIn;
		myOtherShortT = myOtherShortTIn;
		myCharT = myCharTIn;
		
	}
	
	
	public double getMyDoubleT(){
		return myDoubleT;
	}
	
	public void setMyDoubleT(double myDoubleTIn){
		myDoubleT = myDoubleTIn;
	}

	public double getMyOtherDoubleT(){
		return myOtherDoubleT;
	}
	
	public void setMyOtherDoubleT(double myOtherDoubleTIn){
		myOtherDoubleT = myOtherDoubleTIn;
	}
	
	public float getMyFloatT(){
		return myFloatT;
	}
	
	public void setMyFloatT(float myFloatTIn){
		myFloatT = myFloatTIn;
	}
	
	public short getMyShortT(){
		return myShortT;
	}
	
	public void setMyShortT(short myShortTIn){
		myShortT = myShortTIn;
	}
	
	public short getMyOtherShortT(){
		return myOtherShortT;
	}
	
	public void setMyOtherShortT(short myOtherShortTIn){
		myOtherShortT = myOtherShortTIn;
	}
	
	public char getMyCharT(){
		return myCharT;
	}
	
	public void setMyCharT(char myCharTIn){
		myCharT = myCharTIn;
	}
	
	@Override
	public boolean equals(Object O){
		if(!(O instanceof MyAllTypesSecond)){
			return false;
		}
		MyAllTypesSecond obj = (MyAllTypesSecond) O;
		if(this.myCharT == obj.getMyCharT() && this.myShortT == obj.myShortT && this.myOtherShortT == obj.getMyOtherShortT() && this.myFloatT == obj.getMyFloatT() && this.myDoubleT == obj.myDoubleT && this.myOtherDoubleT == obj.myOtherDoubleT ){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return (myShortT + myOtherShortT);
	}
	
	@Override
	public String toString(){
		String result = "Class: MyAllTypesSecond    Data member values: myShortT = "+myShortT+" myOtherShortT = "+myOtherShortT+" myFloatT = "+myFloatT+" myDoubleT = "+myDoubleT+" myOtherDoubleT = "+myOtherDoubleT+" myCharT = "+myCharT;
		return result;
	}
}
