package help;
import java.awt.*;
import java.util.regex.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import java.io.IOException;
public class Help {
public static void main(String []args) {

new zlButton();

}
}
class zlButton{  //���ڶ��尴ť
	
	 Frame f=new Frame("����˹��        //��������ϵqq:1256305343");
	 Panel twoButton=new Panel();
	 
	 Button sure=new Button("����");
	 Button add=new Button("����");
	 
	 TextArea in_put=new TextArea(); //����ѧϰ����
	 TextArea show_result=new TextArea();//չʾ����
	
	
	zlButton(){
		
		
		sure.addActionListener(new Sure());
		add.addActionListener(new Sure().new Add());
		add.setFont(new Font("����", Font.PLAIN, 50));
		sure.setFont(new Font("����", Font.PLAIN, 50));
		in_put.setFont(new Font("����", Font.PLAIN, 30));
		twoButton.add(sure);
		twoButton.add(add);
		twoButton.setLayout(new GridLayout(1,2));
		f.add(in_put);
		f.add(twoButton);
		f.add(show_result);
		f.setLayout(new GridLayout(3,1));
		f.setSize(600,600);
		winCenter(f);  //���ھ��г���
	    f.setVisible(true);
	    f.addWindowListener(new WindowAdapter(){
	    	
	    	public void windowClosing(WindowEvent e){
	    		System.exit(0);}
	    	
	    });
	
	}
	void winCenter(Frame f){
		int windowWidth = f.getWidth();                     //��ô��ڿ�

	     int windowHeight = f.getHeight();                   //��ô��ڸ�

	     Toolkit kit = Toolkit.getDefaultToolkit();              //���幤�߰�

	     Dimension screenSize = kit.getScreenSize();             //��ȡ��Ļ�ĳߴ�

	     int screenWidth = screenSize.width;                     //��ȡ��Ļ�Ŀ�

	     int screenHeight = screenSize.height;                   //��ȡ��Ļ�ĸ�

	     f.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//���ô��ھ�����ʾ
		
		
	}

	class Sure implements ActionListener{  
		  private IO io=new IO();
		  String textStudy;
		  String textAll;
		private int k1;
		public void actionPerformed(ActionEvent e){
				
               	textStudy=in_put.getText(); //ѧϰ����
               	textAll=in_put.getText(); //ѧϰ����
                show_result.setFont(new Font("����", Font.PLAIN, 20));
		        textAll=
    		            new SetTime(1).get_time()+"\n"+"----------------"+"\n"+textStudy+"\n"+"----------------"+"\n"+
                        new SetTime(3).get_time()+"\n"+"----------------"+"\n"+textStudy+"\n"+"----------------"+"\n"+
                        new SetTime(7).get_time()+"\n"+"----------------"+"\n"+textStudy+"\n"+"----------------"+"\n"+
                        new SetTime(15).get_time()+"\n"+"----------------"+"\n"+textStudy+"\n"+"----------------"+"\n"+
                        new SetTime(30).get_time()+"\n"+"----------------"+"\n"+textStudy+"\n"+"----------------"+"\n";
		                show_result.setText(textAll);
		                 try {
							io.wTxt(textAll);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		      
		
		}
		
		class Add implements ActionListener{    //ȷ�ϰ�ť���ڲ���,���ڵ��ô���1���ݣ��Ӷ����жԱ�
			

	    
			public void actionPerformed(ActionEvent e){
				
				
				String txt=null;
		    	try {
					 txt=io.rTxt();//��ȡ����
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
		    	
		    	
		    	
		    	System.out.println("��ʱ��õ���ѧϰ�����ǣ�"+get_study(txt,"16��11��25��"));
		    	
		    
		    	//-----------------------------------------------------------------------------------
		    	
		    	
		    	/*StringBuffer txtBuffer = new StringBuffer(txt);
				StringBuffer txtStudyBuffer = new StringBuffer("\n"+textStudy);
		    	for(int f=1;f<=txt.length();f++){
		    		for(int e1=1;e1<=5;e1++){
		    			if(get_date(txt,f)!="-1"){
		    	       int i=get_date(txt,f).compareTo(get_date(textAll,e1));  //���αȽϽ����ֵ��i
					   if(i==0){
						
						int k=getCharacterPosition(txt,i,"\\|");
						txtBuffer.insert(k+1,txtStudyBuffer);
						break;
					}
					if(i>0){
						
						
					}
		    		}
		    		}
		    	}*/
			   //-----------------------------------------------------------------------------------------
				
				}
				
				}
				/*void BubbleSort1(int arr[], int num)
		    	{
		    	    int i, j;
		    	    for (i = 0; i < num; i++)
		    	    {
		    	        for (j = 1; j < num - i; j++)
		    	        {
		    	            if (arr[j - 1] > arr[j])
		    	                swap1(&arr[j - 1], &arr[j]);
		    	        }
		    	    }*/
			 public  int getCharacterPosition(String string ,int i,String character){ //i�ǵڼ��γ��� 
			      
			         Matcher slashMatcher = Pattern.compile(character).matcher(string);  
			        int mIdx = 0; 
			        boolean f;
			        while(f=slashMatcher.find()==true) {  
			           mIdx++; 
			           if(mIdx == i) break;
			         }  
			        
			        if(f==false) return -1;
			        return slashMatcher.start();  
			     }  
		
		      public String get_study(String txt,String date){  //����ʱ�䣬������txt�ж�Ӧ�ĵ�ѧϰ����
		    	  String textStudy1=null;
		    	  int k1 = 0,f1=0;
		    	  
		    	  for(int i=1;i<=txt.length();i++){
		    		  System.out.println("167�� get_date(txt,i)��ֵ�ǣ�"+get_date(txt,i));
		    	    if(date==get_date(txt,i)){ 
		   
	    		      k1=getCharacterPosition(txt,1,"----------------");
		    	      f1=getCharacterPosition(txt,i+1,"----------------"); 
		    	      System.out.println("Ѱ��-----�Ľ���ǣ�"+k1);
		    	      for(int t=k1+1;t<=f1-1;t++){
							if(textStudy1==null) textStudy1=txt.charAt(t)+"";
							else textStudy1=txt.charAt(t)+textStudy1;
						}
		    	      break;
		   
		    	  }
		    	    else if(get_date(txt,i)=="-1") {textStudy1="-1";break;}
		    	      
		    		     
		    	  }
		    	  return textStudy1;
		      }
			  public String get_date(String address,int i){  //�����ı�������ʱ���(�ı������ڵĵڼ��γ���)
				   String tdate=null;//���ڱ���ʱ��
				   int k;
				   if((k=getCharacterPosition(address,i,"\\|"))>0){
					
					for(int t=1;t<=9;t++){
						if(tdate==null) tdate=address.charAt(k-t)+"";
						else tdate=address.charAt(k-t)+tdate;
					}
					
					return tdate;
					
			   }
				   else return"-1";
			  
		}
	}


     
	
}
class SetTime{
	int day=0;
	int hour=0;
	SetTime(int day){  //iΪ1��hour,Ϊ2��day��day�����޸ģ���������   
 
        this.day=day;
		    
     
	}
	SetTime(int day,int hour){
		this.day=day;
		this.hour=hour;
		
	}
	String get_time(){
		Calendar cal=Calendar.getInstance();
		if(hour!=0) {  //ֻ�ڵ�һ������
	     SimpleDateFormat format = new java.text.SimpleDateFormat("yy��MM��dd��|   hh��mm");
		 cal.add(Calendar.HOUR_OF_DAY, +hour);  
		 return format.format(cal.getTime());
		}
		else {
		SimpleDateFormat format = new java.text.SimpleDateFormat("yy��MM��dd��|");
		cal.add(Calendar.DAY_OF_MONTH, +day);
		return format.format(cal.getTime());
		
		}
		
		
		
		
	}
	
		
	
}


