import java.util.* ;


public class Persoane implements Runnable{
	Coada c;
	Coada d;
	Coada e;
	Coada f;

	public Persoane(Coada c, Coada d, Coada e, Coada f) {
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		Thread t=new Thread(this,"Persoane");
		t.start();
	}
	
	public void run()

	{
		while(true)
		{
			c.getNum();
			try {
				Thread.sleep(1000);
			}catch(Exception e) {}
			
			d.getNum();
			try {
				Thread.sleep(2000);
			}catch(Exception e) {}
			
			e.getNum();
			try {
				Thread.sleep(3000);
			}catch(Exception e) {}
			
			f.getNum();
			try {
				Thread.sleep(4000);
			}catch(Exception e) {}
		}
	}
}
