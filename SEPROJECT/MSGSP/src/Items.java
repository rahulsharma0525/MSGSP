import java.util.ArrayList;
import java.util.Iterator;


public class Items {
	
	ArrayList<Integer> it = new ArrayList<Integer>();
Boolean contains(Items candItems, Items fileItems){
	int candValue=0,count=0;
	Iterator it= candItems.it.iterator();
	while(it.hasNext()){
		candValue=Integer.parseInt(it.next().toString());
		if(fileItems.it.contains(new Integer(candValue))){
				count++;
		
	}
}
	
	
	if(count==candItems.it.size()){
		//System.out.println("Here"+count);
		return true;
	}
	
	return false;
}
public void display(Integer item) {
	
		
		System.out.print(item+" ");
		
	
	// TODO Auto-generated method stub
	
}
}
