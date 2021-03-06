package com.sf;

//Write a method that returns the first non-repeating char from a string.  Case insensitive.
//This example would return a lowercase L: �Salesforce is the best company to work for�.   



class FirstUniqueChar {

	public class MyClass {
		 private int input_string_index ;
		 private int count_repetitions ;
		 
		 MyClass(){
			 input_string_index =0;
			 count_repetitions =0;
		 }
		 public int getCount(){
			 System.out.println("count_repetitions = "+ count_repetitions);
			 return count_repetitions;
		 }
		 public void setCount(int value){
			 count_repetitions = value;
		 }
		 
		 public int getStrIndex(){
			 return input_string_index;
		 }
		 public void setStrIndex(int value){
			 input_string_index = value;
		 }
	}
	
public static char first_unique(String input_string1 ) {
 //precondition: handles ASCII strings only
 
 if (input_string1 == null) {
     throw new java.lang.NullPointerException();
     
 }
 int[] countarr = new int[256];
 int[] strindex = new int[256];
 int i;
 String input_string = input_string1.toLowerCase();
 for (i=0 ; i < input_string.length(); i++  ){
     //iterate over input_string and populate ascii array counts and str index 
     int ascii_value = (int) input_string.charAt(i);
	 //int count = asc_arr[ascii_value].getCount() ;
     int count = countarr[ascii_value];
     countarr[ascii_value] = count+1;
	 strindex[ascii_value] = i;                   
 }//end for loop
 
 //traverse the ascii array a 2nd time to find the first_unique element
 int min_index  = 256; 
 for (int j=0; j< 256; j++){
	 if(countarr[j]==1 && strindex[j]<min_index){
		 min_index = strindex[j];
	 }
 }
 if (min_index== -1)
	 return (Character) null;
 else 
	 return input_string.charAt(min_index);
 
}//end first_unique() 
   
public static void  main(String[] args){
	String s0= "Salesforce is the best company to work for";	
	String s = "ABCDabcdA0123";
	char s0_r =  FirstUniqueChar.first_unique(s0);
	char s_r =  FirstUniqueChar.first_unique(s);
	//System.out.println("desired output is "+ s_r);
	System.out.println("desired output is "+ s0_r);
}


}//end class