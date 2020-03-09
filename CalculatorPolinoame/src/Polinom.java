import java.util.ArrayList;
import java.util.HashMap;

public class Polinom {
	private ArrayList<Monom> m;
	
	double coeficient;
	int grad;
	
	public Polinom() {
		this.m = new ArrayList<Monom>();
	}
	
	public void addMon(Monom m) {
		this.m.add(m);
	}
	public double getCoeficient() {
		return coeficient;
	}
	public void setCoeficient(int coeficient) {
		this.coeficient = coeficient;
	}
	public int getGrad() {
		return grad;
	}
	public void setGrad(int grad) {
		this.grad = grad;
	}
	public String toString(){
		
		String s ="";
		for(int i=0;i<m.size();i++)
		{
			s += this.m.get(i);
		}
		return s;
	
		}
	public Polinom combina() {
	    Polinom a=new Polinom();
	    
	   // System.out.println(d);
	    a.m.addAll(this.m);
	    this.m.removeAll(this.m);
	    int d=a.m.get(0).getGrad();
	    while(d > -1) {
	    	Monom aux = new Monom();
		   for(Monom m1 : a.m)
		   {
			   if(m1.getGrad() == d) {
				 aux = aux.add(m1);  
			   }
		   }
		   this.m.add(aux);
		   d--;
	    }
		
	    return this;
	}

	public Polinom suma(Polinom b)
	{
		Polinom c=new Polinom();
		
		c.m.addAll(this.m);
		c.m.addAll(b.m);
		int suma=0;
		
		int d=Math.max(this.getGrad(), b.getGrad());
		
		
		
		c.combina();
		return c;
	}
	
	public Polinom diferenta(Polinom b)
	{
		Polinom c=new Polinom();
		
		
		c.m.addAll(this.m);
		for(Monom m1 : b.m) {
			c.m.add(new Monom(m1.getGrad(), -m1.getCoeficient()));
		}
		c.combina();
		return c;
	}
	
	public Polinom Derivare(Polinom b)
	{
		Polinom c=new Polinom();
		c.m.addAll(this.m);
		for(Monom m2: b.m) {
			c.m.add(new Monom(m2.getGrad()-1,m2.getCoeficient()*m2.getGrad()));
		}
		
		
		
		return c;
	}
	
	public Polinom Integrare(Polinom b)
	{
		Polinom c=new Polinom();
		c.m.addAll(this.m);
		for(Monom m2: b.m) {
			c.m.add(new Monom(m2.getGrad()+1,m2.getCoeficient()/m2.getGrad()));
		}
		
		
		
		return c;
	}
	
	public Polinom inmultire(Polinom b) {
		Polinom c=new Polinom();
		//c.m.addAll(this.m);
		for(int i=0;i<this.m.size();i++) {
			Monom m1=this.m.get(i);
			for(int j=0;j<b.m.size();j++) {
				Monom m2=b.m.get(j);
				Monom m3=m1.inmultire(m2);
				c.m.add(m3);
				
			}
			
		}
		c.combina();
		return c;
	}
	
	
	
}
