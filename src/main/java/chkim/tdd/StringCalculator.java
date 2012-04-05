package chkim.tdd;


import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class StringCalculator {

	
	public int add(String i) {
		
		int result = 0;
		
		if(i.isEmpty()){
			result = 0;
		}else{
			
			if( i.contains(",")) {
				String[] numbers = i.split(",|\n");
				result = sumStringsArray(numbers); 
			}else if(i.contains("//")){
				Matcher m = Pattern.compile("//(.)\n(.*)").matcher(i);
				m.find();
				String customDelimeter = m.group(1);
				String[] tokens = m.group(2).split(Pattern.quote(customDelimeter));
				result = sumStringsArray(tokens); 
			}else{
				result = Integer.parseInt(i);
			}
			
		}
		
		return result;
	}
	
	private int sumStringsArray(String[] addString){
		int result = 0;
		for(int f=0; f < addString.length ; f++){
			int tmp =  Integer.parseInt(addString[f]);
			
			if(tmp < 0){
				throw new RuntimeException();
				
			}
			result = result + tmp; 
		}
		return result;
	}

}
