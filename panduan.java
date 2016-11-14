package œ‡º”≈–∂œ;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class panduan {
	public  static TextField f1;
	public static long a=System.currentTimeMillis()%60;
	public static long b=System.currentTimeMillis()%61;
  public static void main(String[]atgs){
	
	
	
	Frame f=new Frame ();
	Button okButton=new Button("OK");
	Button cancalButton=new Button("cancal");
	f1=new TextField (10);
	Label b1=new Label (a+"+"+b+"=");
	f.add(b1);
	f.add(f1);
	f.add(okButton);
	f.add(cancalButton);
	f.setLayout(new GridLayout(2,2));
	f.pack();
	f.setVisible(true);
	
     
	okButton.addActionListener(new SureClick());
	cancalButton.addActionListener(new CanClick() );
	
  }
  

	
}
class SureClick implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e){
			long k=Integer.parseInt(panduan.f1.getText());
			if(k==(panduan.a+panduan.b)){
				String output="good !!";
				JOptionPane.showMessageDialog(null,output);
			}
			else {
				String output="error!!";
				JOptionPane.showMessageDialog(null,output);
				
			}
		
	
		
			
		}
		
	}
class CanClick implements ActionListener {
	public void actionPerformed(ActionEvent e){
	
		System.exit(-1);
	}
	
}

