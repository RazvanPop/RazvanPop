
import java.util.* ;


public class Magazin  implements Runnable{

	Coada c;
	Coada d;
	Coada e;
	Coada f;
	
	
	public Magazin(Coada c, Coada d, Coada e, Coada f) {
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		Thread t=new Thread(this,"Magazin");
		
		t.start();
		
	}
	
	
	 public void run()
	 {
		 int i=1;
		 int j=1;
		 int k=1;
		 int l=1;
		 while(true)
		 {
			 c.setNum(i++);
			 try {
				 Thread.sleep(1000);
			 }catch(Exception e) {}
			
			 d.setNum(j++);
			 try {
				 Thread.sleep(2000);
			 }catch(Exception e) {}
			 
			 e.setNum(k++);
			 try {
				 Thread.sleep(3000);
			 }catch(Exception e) {}
			 
			 f.setNum(l++);
			 try {
				 Thread.sleep(4000);
			 }catch(Exception e) {}
		 }
		 
		
		 
	 }
	 
	
	 
}
