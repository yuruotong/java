import javax.swing.JOptionPane;
public class Math {
   public static void main(String[] args){
	   long a=System.currentTimeMillis()%60;
	   long b=System.currentTimeMillis()%61;
	   String Question =JOptionPane.showInputDialog("please give me:"+a+"+"+b+"= :");
	   double answer=Double.parseDouble(Question);
	   if(answer==a+b){
		   String output="good !!";
		   JOptionPane.showMessageDialog(null,output);
		   
	   }else{
		   JOptionPane.showMessageDialog(null,"error");
		   
	   }
	   
	   
   }
   
   
   
   
}
