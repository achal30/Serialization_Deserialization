package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject{
	
	private int myInt;
	private int myOtherInt;
	private long myLong;
	private long myOtherLong;
	private boolean myBool;
	private String myString;
	
	
	public MyAllTypesFirst(int myIntIn, int myOtherIntIn, long myLongIn, long myOtherLongIn, boolean myBoolIn, String myStringIn){
		
		myInt = myIntIn;
		myOtherInt = myOtherIntIn;
		myLong = myLongIn;
		myOtherLong = myOtherLongIn;
		myBool = myBoolIn;
		myString = myStringIn;
	}
	

	public int getMyInt(){
		return myInt;
	}
	
	public void setMyInt(int myIntIn){
		myInt = myIntIn;
	}
	
	public int getMyOtherInt(){
		return myOtherInt;
	}
	
	public void setMyOtherInt(int myOtherIntIn){
		myOtherInt = myOtherIntIn;
	}
	
	public long getMyLong(){
		return myLong;
	}
	
	public void setMyLong(long myLongIn){
		myLong = myLongIn;
	}
	
	public long getMyOtherLong(){
		return myOtherLong;
	}
	
	public void setMyOtherLong(long myOtherLongIn){
		myOtherLong = myOtherLongIn;
	}
	
	public boolean getMyBool(){
		return myBool;
	}
	
	public void setMyBool(boolean myBoolIn){
		myBool = myBoolIn;
	}
	
	public String getMyString(){
		return myString;
	}
	
	public void setMyString(String myStringIn){
		myString = myStringIn;
	}
	
	@Override
	public boolean equals(Object O){
		if(!(O instanceof MyAllTypesFirst)){
			return false;
		}
		MyAllTypesFirst obj = (MyAllTypesFirst) O;
		if(this.myInt == obj.getMyInt() && this.myBool == obj.getMyBool() && this.myLong == obj.getMyLong() && this.myOtherInt == obj.getMyOtherInt() && this.myOtherLong == obj.getMyOtherLong() && this.myString.equals(obj.getMyString())){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return (myInt + myOtherInt);
	}
	
	
}

