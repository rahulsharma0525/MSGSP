import java.util.ArrayList;
import java.util.Iterator;


public class Sequence {
	ArrayList<Element> elemSeq = new ArrayList<Element>();

	public void display(Element element) {
		// TODO Auto-generated method stub
		//Element element = new Element();
		Items item= new Items();
		
		for(int i=0;i< element.elements.size();i++){
			System.out.print("{");
			element.display(element.elements.get(new Integer(i)));
			System.out.print("}");
			
		}
		System.out.print(",");
	
}}
