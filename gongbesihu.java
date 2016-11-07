
import javax.swing.JOptionPane;
public class gongbesihu {
public static void  main(String[] args){
	String In_put1 =JOptionPane.showInputDialog("please give me the first number");
	String In_put2 =JOptionPane.showInputDialog("please give me the second number");
	int  x=Integer.parseInt(In_put1);
	int  y=Integer.parseInt(In_put1);
	gongyue(x,y);

	
}
static void gongyue(int  m,int n){
	
	if(m<n)
	{
	   int t=m;
	   m=n;
	  n=t;
	}
	for(int i=n;i<=m*n;i++)
	{
	    if(i%m==0 && i%n==0)
	         {JOptionPane.showMessageDialog(null,"最小公倍数是："+i);break;}
	}
}
}
