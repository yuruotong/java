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
	int i;  //循环变量
	int sleepTime; //保存sleep时间
	Socket socket; //创建socket
	private DataOutputStream toSever;  //创建写入流
	public void run(){
		try {
			socket=new Socket("127.0.0.1",8001); //实例化socket
			toSever=new DataOutputStream(socket.getOutputStream());  //实例化写入流
			
			//--------------------------------------------------------
	         for(i=0;i<4;i++){   //进行4次比较
	         sleepTime=(int)(Math.random()*2000);
		      sleep(sleepTime);
		      //---------------------------------------------------------------
		      toSever.writeInt((int)(Math.random()*10));  //将生成的数字发送
		      toSever.writeInt(sleepTime);
		    
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
	

}
class ThreadB  extends Thread{
    int sleepTime;
	int i;
	byte[] buf; //用于封装数据
   String str; //要发送的数据
    DatagramPacket dp;//创建数据报
	DatagramSocket ds;//设置端口号
	public void run(){
		 try {
			ds=new DatagramSocket();
		    
		for(i=0;i<4;i++){  //这里发送4次数据
		 
	       sleepTime=(int)(Math.random()*2000);

			Thread.sleep(sleepTime);
	       //--------------------------------------------------------------
		   str=(int)(Math.random()*10)+"";  //生成随机数字
		   buf=str.getBytes(); 
		   dp=new DatagramPacket(buf, buf.length,InetAddress.getByName("localhost"),8005); 
		   ds.send(dp);
		   
		  // --------------------------------------------------------

		    str=sleepTime+"";
		    buf=str.getBytes();    //转化为字节
		   dp=new DatagramPacket(buf, buf.length,InetAddress.getByName("localhost"),8005);//实例化数据报 
		   ds.send(dp);  //利用socket发送数据报
		   //------------------------------------------------------------
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
			//-------------------------------------------------------------服务器端初始准备
			// 对于A的tcp服务器端口
			ServerSocket serverSocketTcp=new ServerSocket(8001);  //利用端口8001来接收
			Socket socket=serverSocketTcp.accept();
			DataInputStream input=new DataInputStream(socket.getInputStream());
			// 对于B的udp服务器端口
			 DatagramSocket  serverSocketUdp = new DatagramSocket(8005);//利用端口8005来接收
			  byte[] recvBuf = new byte[100];  //接受数据包大小
			  DatagramPacket recvPacket1= new DatagramPacket(recvBuf, recvBuf.length);//接收数据报设置
			  
			  //----------------------------------------------------------------------------
			  System.out.println("       A        "+"|"+"       B      ");
				System.out.printf("次数 :睡眠时间 变量  分数"+"|"+"睡眠时间 变量  分数\n");
				//----------------------------------------------------------------
			while(true){

			        numberA=input.readInt();
					sleepA=input.readInt();
					 serverSocketUdp.receive(recvPacket1);
					numberB = Integer.parseInt(new String(recvBuf,0,recvPacket1.getLength()));
					 serverSocketUdp.receive(recvPacket1);
					 sleepB = Integer.parseInt(new String(recvBuf,0,recvPacket1.getLength()));
		             compare(numberA,numberB,sleepA,sleepB,i);
		              i++;  //这里i用来计算次数
		              if(i==4){  //因为发送的数据是4个
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