package ��ʵ��;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

class Car extends JPanel {
	private int  i=650;
	 public void paint(Graphics g)
	 {
	  //���ø��ຯ�����г�ʼ�������Բ�����
	  super.paint(g);
	 Image im= Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/car.jpg"));
	   g.drawImage(im, i, -7, 100,100,this);
	  
	 }
	 void set_x(int x){
		 i=x;
	 }
}

class CreatCm{
	
	Car car1=new Car();
	Car car2=new Car();
	Car car3=new Car();
	Car car4=new Car();
	Frame f=new Frame("����");
	JTextField iCar1=new JTextField("��������1�ٶ�");
	JTextField iCar2=new JTextField("��������2�ٶ�");
	JTextField iCar3=new JTextField("��������3�ٶ�");
	JTextField iCar4=new JTextField("��������4�ٶ�");
	int []speed={0,0,0,0,0}; //����С���ٶ�
	Thread thread1=new SetLocation(car1);  //��������С��1���ٶ�
	Thread thread2=new SetLocation(car2);
	Thread thread3=new SetLocation(car3);
	Thread thread4=new SetLocation(car4);
	Panel control=new Panel();
	Panel conInput=new Panel();
	int c1spd,c2spd,c3spd,c4spd;
	CreatCm(){
    f.setLayout(new GridLayout(5,1));
	f.setBounds(150,150,800,400);
    c1spd=stoNumber(iCar1.getText());  //ת��Ϊstring����
    conInput.setLayout(new GridLayout(1,4));
    conInput.add(iCar1);  //������������
    conInput.add(iCar2);
    conInput.add(iCar3);
    conInput.add(iCar4);
    f.add(conInput);
    f.add(car1);
    f.add(car2);
    f.add(car3);
    f.add(car4);
    thread1.start();
	thread2.start();
	thread3.start();
	thread4.start();
	f.setVisible(true);

	
	}
	
    int stoNumber(String a){
    	int v=0; 
    	try{
    	   v=Integer.parseInt(a);
    	}catch(Throwable e){
    		
    	   v=0;// ����Ҳ����˵������������ţ�����ֱ���׳��쳣  
    	}
    	return v;
    	
    }
	
	
}



class SetLocation extends Thread{
Car car;
int speed=0;
SetLocation(Car car){
	
	this.car=car;
	
}
void setSpeed(int speed){
	
	this.speed=speed;}
public void run(){
	
	int i=800;
	for(;i>-100;i--){
    if(i==-99)i=800;
     car.set_x(i);
     car.repaint();
     try {
         Thread.sleep(speed);
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
     
	}
}
	
}
