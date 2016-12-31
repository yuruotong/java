package 类实现;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

class Car extends JPanel {
	private int  i=650;
	 public void paint(Graphics g)
	 {
	  //调用父类函数进行初始化，绝对不可少
	  super.paint(g);
	 Image im= Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/car.jpg"));
	   g.drawImage(im, i, -7, 100,100,this);
	  
	 }
	 void set_x(int x){
		 i=x;
	 }
}

class CreatCm{
	int []speed={0,0,0,0};
	Car car1=new Car();
	Car car2=new Car();
	Car car3=new Car();
	Car car4=new Car();
	Frame f=new Frame("赛车");
	JTextField iCar1=new JTextField("输入赛车1速度");
	JTextField iCar2=new JTextField("输入赛车2速度");
	JTextField iCar3=new JTextField("输入赛车3速度");
	JTextField iCar4=new JTextField("输入赛车4速度");
	Thread thread1=new SetLocation(car1,speed[1]);  //用于设置小车的位置
	
	Panel control=new Panel();
	Panel conInput=new Panel();
	int c1spd,c2spd,c3spd,c4spd;
	CreatCm(){
    f.setLayout(new GridLayout(5,1));
	f.setBounds(150,150,800,400);
	

    c1spd=stoNumber(iCar1.getText());  //转换为string类型
     
    conInput.add(iCar1);
     
    f.add(conInput);
    f.add(car1);
	thread1.start();
	f.setVisible(true);

	
	}
	
    int stoNumber(String a){
    	int v=0; 
    	try{
    	   v=Integer.parseInt(a);
    	}catch(Throwable e){
    		
    	   v=0;// 这里也可以说是其他错误代号，或者直接抛出异常  
    	}
    	return v;
    	
    }
	
	
}



class SetLocation extends Thread{
Car car;
int speed;
SetLocation(Car car,int speed){
	
	this.car=car;
	this.speed=speed;
	
}
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
