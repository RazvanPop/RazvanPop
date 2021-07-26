/*package Controller;

import java.util.ArrayList;

public class ConcreteSubject implements Subject{

	private ArrayList<ConcreteObserver> allPlante;
	private ArrayList<Observer>observers;
	private String state;
	
	public ConcreteSubject()
	{
		allPlante=new ArrayList<>();
		observers=new ArrayList<>();
	}
	
	public void addAllPlante(ConcreteObserver o) {
		allPlante.add(o);
		notifyAllObservers();
		}
	
	public void setState(String state) {
		this.state = state;
	}

	public ArrayList<ConcreteObserver> getState(){
		return allPlante;
	}
	
//	@Override
	/*public void attach(Observer o) {
		observers.add(o);
	}
	//public void detach(Observer o) {
		
	//}
	@Override
	public void notifyAllObservers() {
		for(int i=0;i<observers.size();i++)
		{
			observers.get(i).updateP(this);
		}
	}

	@Override
	public void dettach(Observer o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}
	
			
}
*/