
public class Coada {
	
	int num;
	boolean v=false;
	

	public synchronized void getNum() {
		while(!v)
		{
			try {wait();}catch(Exception e) {}
		}
		System.out.println("Scoatere client: "+num);
		System.out.println("Clientul a fost scos din coada");
		
		Main.tf.setText(""+num);
		Main.tf2.setText(""+num);
		Main.tf3.setText(""+num);
		Main.tf4.setText(""+num);
		
		
		v=false;
		notify();
	}

	public synchronized void setNum(int num) {
		
		while(v)
		{
			try {wait();}catch(Exception e) {}
		}
		System.out.println("Adaugare client: "+num);
		System.out.println("Clientul a fost adaugat in coada");
		
		Main.tf.setText(""+num);
		Main.tf2.setText(""+num);
		Main.tf3.setText(""+num);
		Main.tf4.setText(""+num);
		
		this.num = num;
		v=true;
		notify();
	}
	
	
}
