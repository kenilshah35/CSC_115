/*
* Name: Kenil C. Shah
* ID: V00903842
* Date: 7 June 2018
* Filename: MedListRefBased.java
* Details: CSc 115 Assignment 2
*/

import java.util.NoSuchElementException;

public class MedListRefBased implements List<Medication> {
	
	private MedicationNode head;
	private int count;
	private MedicationNode prev;
	private MedicationNode curr;
	
	public MedListRefBased(){
		
		head=null;
		count=0;
	}
	
	/*
	*A private helper method for use within the file only
	*assigns prev and curr nodes around the index
	*/
	private void assignPreviousandCurrent(int index){
		
		prev=null;
		curr=head;
		
		if(curr != null){
			for(int i=0;i<index;i++){
				prev = curr;
				curr = curr.next;
			}
		}
	}
	
	public void add(Medication k,int index) {
		
		if (index < 0 || index > count) {
			throw new IndexOutOfBoundsException("The index "+index+" is out of bounds.");
		}
		
		MedicationNode newNode = new MedicationNode(k);
		
		assignPreviousandCurrent(index);
		newNode.next=curr;
		if(curr !=null ) curr.prev = newNode;
		
		if(prev==null){
			
			head=newNode;
			count++;
			//System.out.println("I am in if");
		}
		else{
			
			//System.out.println("I am in start of else");
			
			if(prev.next==null){
				
				prev.next=newNode;
				newNode.prev=prev;
				
				count++;
			}
			else{
				
				prev.next=newNode;
				newNode.next=curr;
				newNode.prev=prev;
				curr.prev=newNode;
				
				count++;
			}
			
			//System.out.println("I am in end of else");
		}
	}
	
	public Medication get(int index){
		
		if (index < 0 || index > count-1) {
			throw new IndexOutOfBoundsException("The index "+index+" is out of bounds.");
		}
		
		MedicationNode temp = head;
		
		for(int i=0;i<index;i++) temp=temp.next;
		
		return temp.item;
	}
	
	public boolean isEmpty(){
		
		return (head == null);
	}
	
	public int size(){
		
		return count;
	}
	
	public int indexOf(Medication k){
		
		MedicationNode temp = head;
		
		for(int i=0;i<count;i++){
			
			if(temp.item.equals(k)) return i;
			
			temp=temp.next;
		}
		
		return -1;
	}
	
	public void remove(int index){
		
		if (index < 0 || index > count-1) {
			throw new IndexOutOfBoundsException("The index "+index+" is out of bounds.");
		}
		
		assignPreviousandCurrent(index);
		
		if(prev==null){
			head=curr.next;
			curr.next.prev = null;
			curr=null;
			count--;
		}
		else{
			if(curr.next==null){
				prev.next=null;
				curr=null;
				count--;
			}
			else{
				prev.next=curr.next;
				curr.next.prev=prev;
				count--;
			}
		}
	}
	
	public void removeAll(){
		head=null;
		count=0;
	}
	
	public void remove(Medication k){
		
		MedicationNode temp=head;
		
		while(temp != null){
			
			if(temp.item.equals(k)){
				int index = indexOf(temp.item);
				remove(index);
			}
			
			temp=temp.next;
		}
	}
	
	public String toString(){
		
		if (count == 0) return "{}";
		
		StringBuilder output = new StringBuilder("List: {\n");
		
		MedicationNode temp = head;
		
		while(temp!=null){
			
			output.append("\t" + temp.item);
			
			if(temp.next != null) output.append(",");
			
			output.append("\n");
			
			temp=temp.next;
		}
		
		output.append("}");
		
		return output.toString();
	}
	
	public static void main(String [] args){
		
		MedListRefBased list = new MedListRefBased();
		Medication meds = new Medication("meperidine",100);
		Medication meds1 = new Medication("paracetamol",650);
		Medication meds2 = new Medication("paracetamol",650);
		list.add(meds,0);
		list.add(new Medication("acetylsalicylic acid",325),0);
		list.add(new Medication("acetominophen",100),0);
		list.add(new Medication("cimetidine",150),3);
		list.add(new Medication("meperidine",100),0);
		list.add(meds1,2);
		list.add(meds1,3);
		System.out.println(list);
		
		System.out.println(list.size());
		
		System.out.println(list.get(3));
		System.out.println(list.get(0));
		System.out.println(list.get(5));
		
		System.out.println(list.isEmpty());
		
		System.out.println(list.indexOf(meds));
		System.out.println(list.indexOf(meds1));
		
		
		list.remove(0);
		System.out.println(list);
		System.out.println(list.size());
		
		list.remove(3);
		System.out.println(list);
		System.out.println(list.size());
		
		list.remove(3);
		System.out.println(list);
		System.out.println(list.size());
		
		list.remove(meds1);
		System.out.println(list);
		System.out.println(list.size());
		
		list.removeAll();
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.isEmpty());
	}
}