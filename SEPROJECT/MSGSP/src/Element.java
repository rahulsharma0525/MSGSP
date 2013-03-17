import java.util.ArrayList;
import java.util.Iterator;


public class Element implements Cloneable {
	ArrayList<Items> elements = new ArrayList<Items>();
	int key=0;
	public Element(Element element) {
		// TODO Auto-generated constructor stub
		
		
	}

	public Element() {
		// TODO Auto-generated constructor stub
	}

	Boolean contains(Element candidElement,Element fileElement){
		int setCount=0,flag=0;
		Items item = new Items();
		//Element ele1= new Element();
		//ele1=
	//	System.out.println("SetCount "+candidElement.elements.size());
		
		for(int i=0;i<candidElement.elements.size();i++){
			flag=0;
			
			for(int j=0;j<fileElement.elements.size();j++){
				 
				/*if(flag==1){
					j=key+1;
				}*/
				
				if((item.contains((candidElement.elements.get(i)),fileElement.elements.get(j))== true) && flag==0){
					setCount++;
					key=j;
				//	System.out.println("Came here");
					
					flag=1;
					//i++;
					//return true;
					//System.out.println("Came here "+setCount);
				}
				 
				
			}
			
		}
		if(setCount == candidElement.elements.size()){
		//	System.out.println("SetCount "+setCount);
			return true;
		}
		return false;
	}

	public boolean canJoin(Element element1, Element element2) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		//Element temp1=(Element) element1.clone();
	//	Element temp1 = (Element) super.clone();
		ArrayList newList1 = new ArrayList(element1.elements);
		ArrayList newList2= new ArrayList(element2.elements);
	//	newList.add("lolnewlist");
	//	System.out.println(" copied list "+newList.toString());
	//	System.out.println(" original list "+element1.elements.toString());
		
		if( element1.elements == newList1){
			System.out.println(" equal ");
		}
		Element temp2=(Element) element2.clone();
		
		
		pruneFirst(newList1);
		pruneLast(newList2);
		
		if(equals(newList1,newList2)){
			
			return true;
			
		}
	return false;
		
	}
	public boolean equals(ArrayList element1,ArrayList element2){
		Items item1= new Items();
		Items item2= new Items();
		int item=0,itemCount=0,elementCount=0;
		if(element1.size() == element2.size()){
		for(int i=0;i<element1.size();i++){
		//System.out.println("Rahul"+i);	
			item1=(Items) element1.get(i);
			item2=(Items) element2.get(i);
			if(item1.it.size()==item2.it.size()){
				Iterator iterator = item1.it.iterator();
				while(iterator.hasNext()){
					item=Integer.parseInt(iterator.next().toString());
					if(item2.it.contains(item)){
						
						itemCount++;
					}
					
				}
				if(itemCount==item1.it.size()){
					elementCount++;
					
				}
			}
			
		}}
		
		if(elementCount==element1.size()){
			
			return true;
		}
		
		return false;
	}
	
	
	public void pruneFirst(ArrayList temp1){
	Items item=new  Items();
		item=(Items) temp1.get(0);
		
		if(item.it.size()==1){
			temp1.remove(0);
			
		}
		else{
			
			item.it.remove(0);
		}
		
		
	}
	public void pruneLast(ArrayList temp2){
		
		int size=temp2.size();
		Items item=new Items();
		item=(Items) temp2.get(size-1);
		int listSize= item.it.size();
		
		if(item.it.size()==1){
			temp2.remove(size-1);
			
		}
		else{
			
			item.it.remove(listSize-1);
		}
		
	}

	public void display(Items items) {
		// TODO Auto-generated method stub
		for(int i=0;i<items.it.size();i++){
			items.display(items.it.get(i));
			
		}
		
	}
	
}
