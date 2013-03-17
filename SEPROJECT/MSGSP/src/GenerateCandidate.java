import java.util.ArrayList;


public class GenerateCandidate {

	ArrayList<Sequence> cand= new ArrayList<Sequence>();
   Sequence Ck= new Sequence();
	public Sequence execute(Sequence fk) throws CloneNotSupportedException {
		//System.out.println("FK out"+fk.elemSeq.size());
		Element element= new Element();
	
		for(int i=0;i<fk.elemSeq.size();i++){
			
			for(int j=i+1;j<fk.elemSeq.size();j++){
				//System.out.println("FK out"+fk.elemSeq.size());
			//Check Here	
				if(element.canJoin(fk.elemSeq.get(i),fk.elemSeq.get(j))){
					
					//System.out.println("FK"+fk.elemSeq.size());
					join(fk.elemSeq.get(new Integer(i)),fk.elemSeq.get(new Integer (j)));
				}
			}
			
		}
		prune(fk);
		
		//prune(return Ck);
		return Ck;
	}
	
	public void join(Element element1,Element element2){
		int size=element1.elements.size();
		int element2size=element2.elements.size();
		Items eLast= new Items();
		Items eOne= new Items();
		//System.out.println(size-1);		
		ArrayList newList1 = new ArrayList(element1.elements);
		ArrayList newList2 = new ArrayList(element2.elements);
		//element1.elements.remove(size-1);
		if(element2size != 0){
	//		System.out.println("Before  " );
		 eLast=(Items) newList2.get(element2size-1);
		//System.out.println("After  " );
//	uncomment this later	//newList1.add(e);}
	//	Element element = new Element();
//		uncomment this later	element.elements.add(n);
//		uncomment this later	Ck.elemSeq.add(element);
	}}
	
	void prune(Sequence fk){
		
		
		
	}
}
