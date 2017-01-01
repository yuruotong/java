package ¿‡ µœ÷;
import  java.lang.Math;

class Triangle extends GeometricObject{
	private double side1=1.0,side2=1.0,side3=1.0;
	Triangle(){
		side1=3.0;
		side2=6.0;
		side3=5.0;
		
	}
	Triangle(double in_side1,double in_side2,double in_side3){
		side1=in_side1;
		side2=in_side2;
		side3=in_side3;
		
		
	}
	
	public void setSide1(double a){
		
		side1=a;
	}
	public void setSide2(double b){
		
		side1=b;
	}
	public void setSide3(double c){
		
		side1=c;
	}
	
	 public static boolean isValidate(double a, double b, double c) {
		 boolean flag = false;
		 if ((a < b + c) && (a > Math.abs(b - c))) flag = true;
		
		 return flag;
		 }
	
	 public double getArea(){
		
		 if (true==isValidate(side1, side2, side3)) {
		 double s = (side1+side2+side3)/2.0;
		 s =  Math.sqrt(s * (s - side1) * (s -side2) * (s - side3));
		return s;
		 }
		 else return 0;

}
	
	 public double getPerimeter(){
		
		return side1+side2+side3;
	}
	
	
	public String toString(){
		
		return "Triangle: side1 = " + side1 + " side2 = " + side2 +  " side3 = " + side3;
	}
	
	
}
