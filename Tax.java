import javax.swing.JOptionPane;
public class Math {
   public static void main(String[] args){
	   
	   String Question =JOptionPane.showInputDialog("please give me you money :");
	   double answer=Double.parseDouble(Question);
	   if(0<answer&&answer<=10450){
		   JOptionPane.showMessageDialog(null,answer*0.10);
		   
	   }else if(10450<answer&&answer<=39800){
		   
		   JOptionPane.showMessageDialog(null,"The tax is"+1045+(answer-10450)*0.15);
	   }else if(39800<answer&&answer<=102800){
		   
		   JOptionPane.showMessageDialog(null,"The tax is"+5447.50+(answer-39800)*0.25);
	   }
else if(102800<answer&&answer<=166450){
		   
		   JOptionPane.showMessageDialog(null,"The tax is"+21197.50+(answer-102800)*0.28);
	   }
else if(166450<answer&&answer<=326450){
	   
	   JOptionPane.showMessageDialog(null,"The tax is"+39019.50+(answer-166450)*0.33);
}
	   
	   
		   
		   
	   }
	   
	   
   }
   
   
   
   

