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
class zlButton{  //用于定义按钮
	
	 Frame f=new Frame("艾宾斯浩        //有问题联系qq:1256305343");
	 Panel twoButton=new Panel();
	 
	 Button sure=new Button("生成");
	 Button add=new Button("整合");
	 
	 TextArea in_put=new TextArea(); //接收学习内容
	 TextArea show_result=new TextArea();//展示内容
	
	
	zlButton(){
		
		
		sure.addActionListener(new Sure());
		add.addActionListener(new Sure().new Add());
		add.setFont(new Font("宋体", Font.PLAIN, 50));
		sure.setFont(new Font("宋体", Font.PLAIN, 50));
		in_put.setFont(new Font("宋体", Font.PLAIN, 30));
		twoButton.add(sure);
		twoButton.add(add);
		twoButton.setLayout(new GridLayout(1,2));
		f.add(in_put);
		f.add(twoButton);
		f.add(show_result);
		f.setLayout(new GridLayout(3,1));
		f.setSize(600,600);
		winCenter(f);  //窗口居中出现
	    f.setVisible(true);
	    f.addWindowListener(new WindowAdapter(){
	    	
	    	public void windowClosing(WindowEvent e){
	    		System.exit(0);}
	    	
	    });
	
	}
	void winCenter(Frame f){
		int windowWidth = f.getWidth();                     //获得窗口宽

	     int windowHeight = f.getHeight();                   //获得窗口高

	     Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包

	     Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸

	     int screenWidth = screenSize.width;                     //获取屏幕的宽

	     int screenHeight = screenSize.height;                   //获取屏幕的高

	     f.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
		
		
	}

	class Sure implements ActionListener{  
		  private IO io=new IO();
		  String textStudy;
		  String textAll;
		private int k1;
		public void actionPerformed(ActionEvent e){
				
               	textStudy=in_put.getText(); //学习内容
               	textAll=in_put.getText(); //学习内容
                show_result.setFont(new Font("宋体", Font.PLAIN, 20));
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
		
		class Add implements ActionListener{    //确认按钮的内部类,用于调用窗口1内容，从而进行对比
			

	    
			public void actionPerformed(ActionEvent e){
				
				
				String txt=null;
		    	try {
					 txt=io.rTxt();//读取内容
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
		    	
		    	
		    	
		    	System.out.println("由时间得到的学习内容是："+get_study(txt,"16年11月25日"));
		    	
		    
		    	//-----------------------------------------------------------------------------------
		    	
		    	
		    	/*StringBuffer txtBuffer = new StringBuffer(txt);
				StringBuffer txtStudyBuffer = new StringBuffer("\n"+textStudy);
		    	for(int f=1;f<=txt.length();f++){
		    		for(int e1=1;e1<=5;e1++){
		    			if(get_date(txt,f)!="-1"){
		    	       int i=get_date(txt,f).compareTo(get_date(textAll,e1));  //两次比较结果赋值给i
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
			 public  int getCharacterPosition(String string ,int i,String character){ //i是第几次出现 
			      
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
		
		      public String get_study(String txt,String date){  //输入时间，返回在txt中对应的的学习内容
		    	  String textStudy1=null;
		    	  int k1 = 0,f1=0;
		    	  
		    	  for(int i=1;i<=txt.length();i++){
		    		  System.out.println("167行 get_date(txt,i)的值是："+get_date(txt,i));
		    	    if(date==get_date(txt,i)){ 
		   
	    		      k1=getCharacterPosition(txt,1,"----------------");
		    	      f1=getCharacterPosition(txt,i+1,"----------------"); 
		    	      System.out.println("寻找-----的结果是："+k1);
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
			  public String get_date(String address,int i){  //输入文本，返回时间段(文本，日期的第几次出现)
				   String tdate=null;//用于保存时间
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
	SetTime(int day){  //i为1是hour,为2是day，day用于修改，过的天数   
 
        this.day=day;
		    
     
	}
	SetTime(int day,int hour){
		this.day=day;
		this.hour=hour;
		
	}
	String get_time(){
		Calendar cal=Calendar.getInstance();
		if(hour!=0) {  //只在第一天有用
	     SimpleDateFormat format = new java.text.SimpleDateFormat("yy年MM月dd日|   hh：mm");
		 cal.add(Calendar.HOUR_OF_DAY, +hour);  
		 return format.format(cal.getTime());
		}
		else {
		SimpleDateFormat format = new java.text.SimpleDateFormat("yy年MM月dd日|");
		cal.add(Calendar.DAY_OF_MONTH, +day);
		return format.format(cal.getTime());
		
		}
		
		
		
		
	}
	
		
	
}


