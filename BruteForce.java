package SubStrings;

public class BruteForce {
        private static String spaces ="";
       // private static String steps= "";
       // private static String temp="";
        private static StringBuffer sb=null;
        
	 public static int search2(String pat, String txt) {
            int m = pat.length();
            int n = txt.length();
            int i, j;
            spaces ="";
            String steps= "";
            String temp="";
            boolean newLine =  false;

            for (i = 0, j = 0; i < n && j < m; i++) {
                if (txt.charAt(i) == pat.charAt(j)){
                    steps +=pat.charAt(j);

                newLine=true;

                j++;

                }
                else{
                    i -= j;
                    spaces =spaces(i);
                    if(newLine==true){
                        temp = matched(i, steps);
                        sb.append(i+"\t"+j+"\t"+(i+j)+wall(i+j,8)+"|   "+spaces+temp +pat.charAt(j)+"\n");
                      //  System.out.println(i+"\t"+j+"\t"+(i+j)+wall(i+j,8)+"|   "+spaces+temp +pat.charAt(j));
                        steps="";
                        newLine=false;
                    }else{
                        sb.append(i+"\t"+j+"\t"+(i+j)+wall(i+j,8)+"|   "+spaces+pat.charAt(j)+"\n");
                        //System.out.println(i+"\t"+j+"\t"+(i+j)+wall(i+j,8)+"|   "+spaces+pat.charAt(j));
                    }
                    j = 0;

                }
            }
            if (j == m){ 
                sb.append(i-m+"\t"+j+"\t"+(i+j-pat.length())+wall(i+j-pat.length(),8)+"|   "+spaces(i-pat.length())+matched(i-pat.length(),pat)+" <--- match"+"\n");
                //System.out.println(i-m+"\t"+j+"\t"+(i+j-pat.length())+wall(i+j-pat.length(),8)+"|   "+spaces(i-pat.length())+matched(i-pat.length(),pat)+" <--- match");
                return i - m;


            }// found
            else{
                 sb.append("No match");
                 //System.out.println("No match");
                 return n;        // not found
            }
        }

	



	public static void main(String[] args) {
//           header("AasddCTCTGCCTACCTGCCTAG","CTGCCTAG");
	}
        public static StringBuffer header(String data ,String find){
            BruteForce br =new  BruteForce();
            sb = new StringBuffer();
            String num ="";
            for(int i = 0 ; i <data.length();i++ )
                num += i+" ";
            sb.append("i\tj\ti+j      |   "+num+"\n");
            //System.out.println("i\tj\ti+j      |   "+num);
            num = matched(0,data);
            sb.append("\t\t"+"         |   "+num+"\n");
           // System.out.println("\t\t"+"         |   "+num);
           
		
            br.search2(find,data);
            return sb;
        }
        
	public static String wall(int i,int well){
//            if(i>=1000){
//                return simpleSpacing(well-3);
//            }
            if(i>=100){
                return simpleSpacing(well-2);
            }
            else if(i>=10){
                return simpleSpacing(well-1);
            }
            else if(i>=0){
                return simpleSpacing(well);
            }
            return simpleSpacing(well-3);
		
		 
	 }
        public static String simpleSpacing(int i ){
            String space="";
            for(int j =0 ;j<i;j++){
                space+=" ";
            }
            return space;
	 }
        public static String spaces(int i){
            if(i==0)
                return spaces;
            if(i<=9)
                spaces+="  ";
            else if(i>9)
                spaces+="   ";
            return spaces;
	 }
	 public static String matched(int i,String pat){
            String patter="";
            for(int j =0  ; j<pat.length();j++,i++){
                if(i<9)
                    patter+=pat.charAt(j)+" ";
                else if(i<99)
                    patter+=pat.charAt(j)+"  ";
//                else if(i<999)
//                    patter+=pat.charAt(j)+"  ";
            }
            return patter;
            
	 }        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
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