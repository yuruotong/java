package ¿‡ µœ÷;

interface  Colorable {
	 public abstract void howToColor();

}
interface Comparable{
	
	
} 


interface Cloneable{}

class Square extends GeometricObject implements Colorable{
	double side1,side2;
	
	public void howToColor(){
		
		
	}
	
	 public  double getArea(){
		 
		 return side1*side2;
		 
	 }

	
	  public double getPerimeter(){
		  
		  return side1*2+side2*2;
	  }
}


class Octagon extends GeometricObject{
	private double side;
 public  double getArea(){
		 
	 return (2.0+4.0/Math.sqrt(2))*side*side;
		 
	 }

	
	  public double getPerimeter(){
		  
		  return side*8.0;
	  }
}