package SubStrings;

public class BruteForce {
	private static String spaces ="";
	 public static int search2(String pat, String txt) {
	        int m = pat.length();
	        int n = txt.length();
	        int i, j;
	        String steps="";
	        
	        String temp="";
	        boolean newLine =  false;
	        
	        for (i = 0, j = 0; i < n && j < m; i++) {
	        	 
	        
	        	
	        	
	            if (txt.charAt(i) == pat.charAt(j)){
	            	
	            	steps +=pat.charAt(j);
	            	
	            	newLine=true;

	            	j++;

	            	
	            	}
	            else {
	            	
	            	i -= j;
	            	spaces =spaces(i);
	            	if(newLine==true){
	            		temp = matched(i, steps);
	            		System.out.println(i+"\t"+j+"\t"+(i+j)+wall(i+j,8)+"|   "+spaces+temp +pat.charAt(j));
	            		steps="";
	            		newLine=false;
	            	}else{
	            		System.out.println(i+"\t"+j+"\t"+(i+j)+wall(i+j,8)+"|   "+spaces+pat.charAt(j));
	            	}
	                j = 0;
	               
	            }
	        }
	        if (j == m){ 
	        	System.out.println(i-m+"\t"+j+"\t"+(i+j-pat.length())+wall(i+j-pat.length(),8)+"|   "+spaces(i-pat.length())+matched(i-pat.length(),pat)+" <--- match");
	        	return i - m;
	        	
	        	
	        }// found
	        else{
	        	System.out.println("No match");
	        	return n;        // not found
	        }
	    }
	 public static String wall(int i,int well){
		 if(i>=1000){
			 return simpleSpacing(well-1);
		 }
		 else if(i>=100){
			 return simpleSpacing(well-1);
		 }
		 else if(i>=10){
			 return simpleSpacing(well-1);
		 }
		 else if(i>=0){
			 return simpleSpacing(well);
		 }
		 return "SS";
		
		 
	 }
	 public static String simpleSpacing(int i ){
		String space="";
		 for(int j =0 ;j<i;j++){
			 space+=" ";
		 }
		 return space;
	 }
	 public static String matched(int i,String pat){
		 String patter="";
		 for(int j =0  ; j<pat.length();j++,i++){
			 if(i<9){
				 patter+=pat.charAt(j)+" ";
				
			 }
			 else if(i<99){
				 patter+=pat.charAt(j)+"  ";
				 
				
			 }
			 else if(i<999){
				 patter+=pat.charAt(j)+"  ";
				 
			 }
		 }
		 return patter;
	 }
//	 public static String matched(int i,String pat){
//		 if(i<=9){
//			 return pat.replace(""," ").trim();
//
//		 }
//		 else if(i<99){
//			return pat.replace("","  ").trim();
//			
//		 }
//		 else if(i<999){
//			 return pat.replace("","   ").trim();
//		 }
//		 
//		 return "SS";
//	 }
	 public static String spaces(int i){
		 if(i==0)
			 return spaces;
		 if(i<=9)
			 spaces+="  ";
		 else if(i>9)
			 spaces+="   ";
		 return spaces;
	 }
	public static void main(String[] args) {
		BruteForce br = new BruteForce();
		String data = "CTGCCTAG";
		String num ="";
		String find = "AasddCTCTGCCTACCTGCCTAG";
		for(int i = 0 ; i <find.length();i++ )
			num += i+" ";
		
	
		System.out.println("i\tj\ti+j      |   "+num);
		String word="";  
    	for(int sh=0;sh<find.length();sh++){
    		if (sh>=1000)
			word +=find.charAt(sh)+"    ";
    		else if(sh>=99)
			word +=find.charAt(sh)+"   ";
    		else if (sh>=9)
    			word+=find.charAt(sh)+"  ";
    		else if(sh>=0)
    			word+=find.charAt(sh)+" ";
    	}
    	System.out.println(0+"\t"+0+"\t"+(0+0)+"        |   "+word);
		System.out.println("\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E");
		
		br.search2(data,find);
	}
}
