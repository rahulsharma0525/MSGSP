import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class ReadPara {
	int index,i=0,count=0,setcount=0,k=2;
	float substr;
	float minimumMISValue;
	HashMap MIS = new HashMap();
	Sequence Fk= new Sequence();
	Element e = new Element();
	HashMap<Integer,Integer> counter = new HashMap<Integer,Integer>();
	HashMap<Integer,Integer> elementCount= new HashMap<Integer,Integer>();
	LinkedHashMap sortedMIS=new LinkedHashMap();//to hold the sorted MIS values

	
	Items  F1= new Items();
	ArrayList <Integer> sequence= new ArrayList<Integer>();
	//ArrayList<ArrayList <ArrayList>> candidate = new ArrayList<ArrayList <ArrayList>>();
	Sequence candid =new Sequence();
	Sequence testCandid =new Sequence();
	LinkedHashMap ind= new LinkedHashMap();
	String text = new String();
	String temp1=new String();
	String path="C:\\Users\\Rahul\\SEPROJECT\\MSGSP\\src\\para.txt";
	String path1="C:\\Users\\Rahul\\SEPROJECT\\MSGSP\\src\\data.txt";
	
	void readParamaeter() throws IOException, CloneNotSupportedException{
		
		float div=0,mis=0,firstMisValue=0;
		ArrayList<Integer> L= new ArrayList<Integer>();
		int flag=0,num=71;
		
		FileReader file= new FileReader(path);
		BufferedReader textData= new BufferedReader (file);
		int j,g,r;
		while((text=textData.readLine()) != null){
				
			index=text.indexOf('=');
			substr= Float.parseFloat((text.substring(index+1, text.length()).trim()));
			j=text.indexOf('(');
			g=text.indexOf(')');
			if (g==-1){
					break;
				}
				else{
					r=Integer.parseInt(text.substring(j+1,g).trim());
				}
				MIS.put(r, substr);
				i++;
		}
			int size=MIS.size();
			float[][] temp= new float[size][2];
			int key;
			Set Keys= MIS.keySet();
			Iterator it=Keys.iterator();
			i=0;
			
			while(it.hasNext()){
	
				key=Integer.parseInt(it.next().toString());
	
				temp[i][1]=Float.parseFloat((MIS.get(key).toString()));
				temp[i][0]=key;
				i++;
			}
	
	
			int minkey=0;
			float minValue,tempValue,tempKey;
			float value;
		
	//Sorting the Hash Map
			for(int n=0; n <= size-1;n++){
	
				j=n;
		
				minValue=temp[n][1];
				for(int k=n+1;k<MIS.size();k++){
			
				if ((temp[k][1]) < minValue ){
			
					minValue=temp[k][1];
					minkey=(int)(temp[k][0]);
					j=k;
				}
			}
		
		tempValue=temp[n][1];
		tempKey=temp[n][0];
		temp[n][1]=minValue;
		temp[n][0]=minkey;
		temp[j][0]=tempKey;
		temp[j][1]=tempValue;		
		
		
	}
	for(i=0;i<size;i++){
		
			sortedMIS.put(new Integer((int)temp[i][0]), new Float(temp[i][1]));
			counter.put(new Integer((int)temp[i][0]), new Integer(0));//Initialize counter for init pass
	}


initPass();//Invoke the init method

//Creating L in the sorted order
Set set2=sortedMIS.entrySet();
Iterator it2=set2.iterator();
while(it2.hasNext()){
	Map.Entry me=(Map.Entry)(it2.next());
	Integer key2=Integer.valueOf((me.getKey()).toString());
	value=Float.parseFloat(me.getValue().toString());
	
	mis=counter.get(key2);
	div=(mis)/num;
	
if(div >= firstMisValue && flag==1){
		
		L.add(key2);
	}
	
	if(div>=value && flag==0){
		firstMisValue=value;
		L.add(key2);
		minimumMISValue=value;
		flag=1;
		
	}
	
}


	
Iterator it3=L.iterator();
while(it3.hasNext()){
	
	firstMisValue=Float.parseFloat(it3.next().toString());
	count=counter.get((int)firstMisValue);
	mis=(float) MIS.get(new Integer((int) firstMisValue));
	value=count/(float)num;
	//System.out.println("count= "+count+" "+"Key= "+firstMisValue+"Value="+value);
	if(value >= mis){
		F1.it.add(new Integer((int)firstMisValue));
		
		
	}	
}


e.elements.add(F1);
Fk.elemSeq.add(e);
Level2CANDGEN secondLevelcand = new Level2CANDGEN();
GenerateCandidate cand = new GenerateCandidate();
Iterator FkIterator = Fk.elemSeq.iterator();
k=2;
while(FkIterator.hasNext()){
	
if(k==2){
candid=secondLevelcand.execute(L,counter,MIS);//generate second level candidate

}
else{
	System.out.println("In the else block"+Fk.elemSeq.size());
	candid=cand.execute(Fk);
}



for(int m=0;m<candid.elemSeq.size();m++){
	elementCount.put(new Integer(m),new Integer (0));}
Fk.elemSeq.clear();	

//This function is to get the count for each set which is used to get the final sequence
getSetCount();

for (int a=0;a< candid.elemSeq.size();a++){
	//System.out.println("count"+elementCount.get(new Integer(a)));
	if((elementCount.get(new Integer(a))/(float)71) > cmin(candid.elemSeq.get(new Integer(a)))) {
		
		Fk.elemSeq.add(candid.elemSeq.get(new Integer(a)));

		}
		
		
	}
//if(k==2){
//System.out.println("Fk "+Fk.elemSeq.size()+"Cand size"+candid.elemSeq.size());
System.out.print("Frequent set "+k+" "+'<');
for(int y=0;y < Fk.elemSeq.size();y++){
	
	Fk.display(Fk.elemSeq.get(y));
	
}
System.out.println('>');
//System.out.println("Fk "+Fk.elemSeq.size());

	
k++;
}}
	
	//This function retrns the minimum MIS value for a particular sequence
	float cmin(Element c){
		int key;
		float mis=0;
			ArrayList list= new ArrayList();
			Iterator elementiterator=c.elements.iterator();
			while(elementiterator.hasNext()){
			Items item=(Items) elementiterator.next();
			Iterator itemitrator = item.it.iterator();
			while(itemitrator.hasNext()){
				list.add(MIS.get(itemitrator.next()));
			}
			
			Collections.sort(list);
			
			}
		return (float) list.get(0);		
		
	}
	
	void initPass() throws IOException{
		
		ReadDataCount rdc = new ReadDataCount();
		counter=rdc.readFile(counter);//Reads the data and counts the occurrence for each item
		
		
	}
	
void getSetCount() throws IOException{
	//setCount=0;
		ArrayList<Integer> sequence= new ArrayList<Integer>();
		FileReader file= new FileReader(path1);
		int setCount=0;
		BufferedReader textData= new BufferedReader (file);
		String sstr=new String();
		//getTestCandid();	
		int readcount=0;
		while((text=textData.readLine()) != null){
			readcount++;
			//System.out.println("Text "+text);
			Element e = new Element();
			Sequence fileSequence = new Sequence();
			int first=-999,last=-999;
			first=text.indexOf('{');
			last = text.indexOf('}');		
			while(last < text.length() && first !=-1){
				String temp = new String();
				temp=text.substring(first, last+1);
				e.elements.add(parsetemp(temp));
				first=text.indexOf('{',last);
				last = text.indexOf('}',first);
				fileSequence.elemSeq.add(e);
			//	System.out.println(fileSequence.elemSeq.size());
		     }		
			int flag=0;
		//	System.out.println("Iteration "+readcount);
			
			
			//System.out.println("This Size"+candid.elemSeq.size());
			for(int i=0;i<candid.elemSeq.size();i++){
				flag=0;
				
				for(int j=0;j<fileSequence.elemSeq.size();j++){
					
					Element ele = new Element();
					if((ele.contains(candid.elemSeq.get(i),fileSequence.elemSeq.get(j))== true)&&(flag==0)){
						flag=1;
						setCount=Integer.parseInt(elementCount.get(i).toString())+1;
						elementCount.put(new Integer(i),new Integer(setCount));
					}
					
					
				}
				
			}
			
			
			
		}
		
	
	}
	Items parsetemp(String temp){
		Items item = new Items();
		Sequence sequence =new Sequence();
		int first =temp.indexOf('{');
		int last =temp.indexOf('}');
		int data=-99;
	
		int index = temp.indexOf(',', first);
		if (index ==-1 ){
			
			data=Integer.parseInt(temp.substring(first+1, last).trim());
			item.it.add(new Integer(data));
		}
	
		while(index < last && index != -1){
			
			data = Integer.parseInt(temp.substring(first+1, index).trim());
			item.it.add(new Integer(data));
			first=index;
			index=temp.indexOf(',', first+1);
			if(index==-1){
				
				 data = Integer.parseInt(temp.substring(first+1, last).trim());
				 item.it.add(new Integer(data));
			}
			
	}
		
		return item;
	}
	
		}
	
	

