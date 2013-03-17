import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;


public class ReadData {

	String path="C:\\Users\\Rahul\\SEPROJECT\\MSGSP\\src\\data.txt";
	
	ArrayList readFile(HashMap counter) throws IOException{
	int count=0;
		
		String text =new String();
		
			ArrayList<Integer> sequence= new ArrayList<Integer>();
			FileReader file= new FileReader(path);
			BufferedReader textData= new BufferedReader (file);
			String sstr=new String();

			while((text=textData.readLine()) != null){
						
				int first=-999,last=-999;
				first=text.indexOf('{');
				last = text.indexOf('}');		
				while(last < text.length() && first !=-1){
					String temp = new String();
					temp=text.substring(first, last+1);
				//	sequence=(parsetemp(temp,counter));
					first=text.indexOf('{',last);
					last = text.indexOf('}',first);
			     }		
			}
		
				return sequence;
		}
	
	HashMap parsetemp(String temp,HashMap counter){

		//Sequence sequence =new Sequence();
		int first =temp.indexOf('{');
		int last =temp.indexOf('}'),count;
		System.out.println(temp);
		int data=-99;
	
		int index = temp.indexOf(',', first);
		if (index ==-1 ){
			
			data=Integer.parseInt(temp.substring(first+1, last).trim());
			System.out.println(data);
			//sequence.Seq.add(data);
			//int count = counter.getObject(data);
		}
	
		while(index < last && index != -1){
			
			data = Integer.parseInt(temp.substring(first+1, index).trim());
			//sequence.Seq.add(data);
			System.out.println(data);
			first=index+1;
			index=temp.indexOf(',', first);
			if(index==-1){
				
				 data = Integer.parseInt(temp.substring(first+1, last).trim());
				 
			}
			
			
			//System.out.println(data);
		}
		//Increment the counter ,this is for init pass
		count = Integer.parseInt(counter.get(data).toString())+1;
		counter.put(data, count);
		return counter;
	}
	public static void main(String args[]){
		
		//ReadData rd = new ReadData();
		ReadPara rp = new ReadPara();
		MSGSP ms    = new MSGSP ();
		
		
		try {
			//rd.readFile();
			rp.readParamaeter();
			
			//ms.sort();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

