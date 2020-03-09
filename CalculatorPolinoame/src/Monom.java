
public class Monom {
	
	private int coeficient;
	private int grad;
	
	public Monom() {
		this.grad = 0;
		this.coeficient = 0;
	}
	
	public Monom(int p, int c) {
		this.grad = p;
		this.coeficient = c;
	}
	public int getCoeficient() {
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
	
	/*public String toString(){
		//Monom x;
		String s=coeficient + "*x^" + grad;
		return s;
		}
*/
	public String toString() {
		
	String s = "";
	if(grad == 0)
	{
		s += "";
	}
	else {
		if(coeficient >= 0) {
			s="+" + coeficient + "*x^" + grad;
		}
		else s=coeficient + "*x^" + grad;
	}
	return s;
	}
	
	public Monom add(Monom m) {
		Monom result = new Monom();
		
		result.coeficient = this.coeficient + m.coeficient;
		
		result.grad = Math.max(this.grad, m.grad);
		
		return result;
	}

	public Monom inmultire(Monom m2) {
		// TODO Auto-generated method stub
        Monom result = new Monom();
		
		result.coeficient = this.coeficient * m2.coeficient;
		
		result.grad = this.grad+ m2.grad;
		
		return result;
	}
}
