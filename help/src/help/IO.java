package help;
import java.io.*;


public class IO {
	IO(){
		
		
	}
	

    void wTxt(String txt) throws IOException{

	    File file =new File("C:\\Users\\MyPC\\Desktop\\a.txt");

	      
	      if(!file.exists()){
	       file.createNewFile();
	      }
	      FileWriter fileWritter = new FileWriter(file);
	             BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
	             bufferWritter.write(txt);
	             bufferWritter.close();
		
		
	}
	String rTxt() throws IOException{
		
	
		FileReader fr=new FileReader("C:\\Users\\MyPC\\Desktop\\a.txt");
	            String out=null;
                BufferedReader bufferedReader = new BufferedReader(fr);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	if(out==null)
                    out=lineTxt+'\n';
                	else 
                   out=out+lineTxt+'\n';
                }
                
                fr.close();
               return out;
               
		
	}
}
