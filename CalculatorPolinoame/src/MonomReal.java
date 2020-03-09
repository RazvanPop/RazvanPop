
public class MonomReal {
	private float coeficient;
	private float grad;
	public float getCoeficient() {
		return coeficient;
	}
	public void setCoeficient(float coeficient) {
		this.coeficient = coeficient;
	}
	public float getGrad() {
		return grad;
	}
	public void setGrad(float grad) {
		this.grad = grad;
	}
	
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
		
		public MonomReal add2(MonomReal m) {
			MonomReal result = new MonomReal();
			
			result.coeficient = this.coeficient + m.coeficient;
			
			result.grad = Math.max(this.grad, m.grad);
			
			return result;
		}
	

}
