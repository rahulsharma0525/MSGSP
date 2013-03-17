import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class ReadDataCount {

String path="C:\\Users\\Rahul\\SEPROJECT\\MSGSP\\src\\data.txt";
	
	HashMap readFile(HashMap map) throws IOException{
	int count=0,count1;
		String text =new String();
		ArrayList previousElement = new ArrayList (); 
		FileReader file= new FileReader(path);
		BufferedReader textData= new BufferedReader (file);
		
	
		while((text=textData.readLine()) != null){
			previousElement.clear();
			String sstr="";
			for(int j=0;j<text.length();j++){
				
				if(Character.isDigit(text.charAt(j))){
					sstr=sstr+text.charAt(j);
					
				}
				
				else if((text.charAt(j)) == '}'){
					//System.out.println(map.size());
					
					if(previousElement.contains(sstr)==false || previousElement.size()==0 ){
					count1=(int)map.get(Integer.parseInt(sstr));
					count1=count1+1;
					previousElement.add(sstr);
					
					map.put((Integer.valueOf(sstr)),new Integer(count1));			
					}sstr="";
			}
				else if((text.charAt(j)) == ','){
				
					if(previousElement.contains(sstr)== false || previousElement.size()==0){
					count1=(int)map.get(Integer.parseInt(sstr));
					count1=count1+1;
					previousElement.add(sstr);
					map.put((Integer.valueOf(sstr)),new Integer(count1));
					}
					sstr="";
				}
				
			
		}
	
}
		return map;
}
	}