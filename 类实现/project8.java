package 类实现;
import java.lang.Math;
public class project8 {
	
	private int i;
	private int []numberA;
	private int []numberB;
	 A a=new A();  //继承实现线程A
	 B b=new B();  //接口实现线程B
	 C c; 
	 Thread threadb=new Thread(b);	
	
	
	
		
	public void text() throws InterruptedException{
	
        
       
		 a.start();
		 threadb.start();
		 a.join();
		 threadb.join();
		  c=new C(a,b);
		 
		
		 
		
		
	
		
	}
 
}

class A extends Thread{
	int i;
	int []numberA=new int [4];
	int []sleepA=new int [4];
	public void run(){
		for(i=0;i<4;i++){
	     numberA[i]=(int)(Math.random()*10);
		try {
			sleepA[i]=(int)(Math.random()*2000);
			sleep(sleepA[i]);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	public int[] getNumber(){
		return numberA;
	}
	public int[] getSleep(){
		return sleepA;
	}
	

}

class B  implements Runnable{
    int []numberB=new int [4];
    int []sleepB=new int [4];
	int i;
	public void run(){
		for(i=0;i<4;i++){
		numberB[i]=(int)(Math.random()*10);
	     try {
	    	 sleepB[i]=(int)(Math.random()*2000);
				
			Thread.sleep(sleepB[i]);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	public int[] getNumber(){
		return numberB;
	}
	public int[] getSleep(){
		return sleepB;
	}
	


}

class C {

	A a;
	B b;
	String winer;
	static int pointA=0,pointB=0;
	  C(A a,B b){
		this.a=a;
		this.b=b;
		System.out.println("       A        "+"|"+"       B      ");
		System.out.printf("次数 :睡眠时间 变量  分数"+"|"+"睡眠时间 变量  分数\n");
		
		compare();
		if(pointA>pointB) winer="winer is A";
		else if(pointA<pointB)winer="winer isB";
		else winer="No winer";
	    System.out.println(winer);
		
	}  
	void compare(){
		for(int i=0;i<4;i++){
		if(a.numberA[i]==b.numberB[i]){
			pointA++;
			pointB++;
			
		}
		else if(a.numberA[i]>b.numberB[i]){
			
			pointA+=2;
		
		}
	     else {
		  
		  pointB+=2;
		
	     }
		System.out.printf("第%1d次:%4d %2d %3d|%4d %2d %3d\n",i+1,a.getSleep()[i],a.getNumber()[i],pointA,b.getSleep()[i],b.getNumber()[i],pointB);
		}
	  } 
	}


