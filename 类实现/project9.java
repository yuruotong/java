package 类实现;
import java.io.IOException;
import java.net.*;
import java.io.*;


public class project9 {
ThreadA a=new ThreadA();
ThreadB b=new ThreadB();
Sever c =new Sever();
void text(){
c.start();;
a.start();
b.start();

}

}




class ThreadA extends Thread{
	int i;
	int []numberA=new int [4];
	int []sleepA=new int [4];
	private DataOutputStream toSever;
	public void run(){
		try {
			Socket socket=new Socket("127.0.0.1",8001);
			
			toSever=new DataOutputStream(socket.getOutputStream());
	
		
		for(i=0;i<4;i++){
	         numberA[i]=(int)(Math.random()*10);
		
			sleepA[i]=(int)(Math.random()*2000);
		    sleep(sleepA[i]);
		    toSever.writeInt(numberA[i]);
		    toSever.writeInt(sleepA[i]);
		    
		}
			
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	

	public int[] getNumber(){
		return numberA;
	}
	public int[] getSleep(){
		return sleepA;
	}
	

}
class ThreadB  extends Thread{
    int []numberB=new int [4];
    int []sleepB=new int [4];
	int i;
	byte[] buf; //用于封装数据

	String str; //要发送的数据

	DatagramPacket dp;//创建数据报
	DatagramSocket ds;//设置端口号
	public void run(){
		 try {
			ds=new DatagramSocket();
		    
		for(i=0;i<4;i++){
		numberB[i]=(int)(Math.random()*10);
	     
	      sleepB[i]=(int)(Math.random()*2000);

			Thread.sleep(sleepB[i]);
			str=numberB[i]+"";
			 buf=str.getBytes(); 
		   dp=new DatagramPacket(buf, buf.length,InetAddress.getByName("localhost"),8005); 
		   ds.send(dp);
		   
		  // --------------------------------------------------------

		    str=sleepB[i]+"";
		    buf=str.getBytes(); 
		   dp=new DatagramPacket(buf, buf.length,InetAddress.getByName("localhost"),8005); 
		   ds.send(dp);
		}
		
		
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
			catch (SocketException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//监听端口 
		 catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
		
	public int[] getNumber(){
		return numberB;
	}
	public int[] getSleep(){
		return sleepB;
	}
	


}
class Sever extends  Thread {
	String winer;
	static int pointA=0,pointB=0;
	int numberA;
	int sleepA;
	int numberB;
	int sleepB;
    int i=0; //用于统计比较次数
    String text1;//B中发送的数据
    String text2;//B中发送的数据
	public void run(){
		      
		try {
			// 对于A的tcp服务器端口
			ServerSocket serverSocketTcp=new ServerSocket(8001);
			Socket socket=serverSocketTcp.accept();
			DataInputStream input=new DataInputStream(socket.getInputStream());
			// 对于B的udp服务器端口
			 DatagramSocket  serverSocketUdp = new DatagramSocket(8005);
			  byte[] recvBuf = new byte[100];  //接受数据包大小
			  DatagramPacket recvPacket1= new DatagramPacket(recvBuf, recvBuf.length);//数据报
			  System.out.println("       A        "+"|"+"       B      ");
				System.out.printf("次数 :睡眠时间 变量  分数"+"|"+"睡眠时间 变量  分数\n");
			while(true){

			        numberA=input.readInt();
					sleepA=input.readInt();
					 serverSocketUdp.receive(recvPacket1);
					 int numberB = Integer.parseInt(new String(recvBuf,0,recvPacket1.getLength()));
					 serverSocketUdp.receive(recvPacket1);
					 int sleepB = Integer.parseInt(new String(recvBuf,0,recvPacket1.getLength()));
		            
		              
		              compare(numberA,numberB,sleepA,sleepB,i);
		              i++;
		              if(i==4){
					 if(pointA>pointB) winer="winer is A";
						else if(pointA<pointB)winer="winer isB";
						else winer="No winer";
					    System.out.println(winer);}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}
	
	void compare(int A,int B ,int sA,int sB,int i){
		
		if(A==B){
			pointA++;
			pointB++;
			
		}
		else if(A>B){
			
			pointA+=2;
		
		}
	     else {
		  
		  pointB+=2;
		
	     }
		System.out.printf("第%1d次:%4d %2d %3d|%4d %2d %3d\n",i+1,sA,A,pointA,sB,B,pointB);
		}
	   
	
	
	
	
}