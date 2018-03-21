package wordcount;
//��������
import java.io.*;
import java.util.Set;
import java.util.TreeMap;
public class basecount {
	//�ַ�����������������
    public static String print(String action1,String sourcefile){
    	int linecount=0;
    	int charcount=0;
    	int wordcount=0;
		File file=new File(sourcefile);
		if(file.exists()){
			try{
				FileInputStream fis=new FileInputStream(file);
				InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
				BufferedReader br=new BufferedReader(isr);
				String line=new String("");
				StringBuffer sb=new StringBuffer();
				 TreeMap<String, Integer> map = new TreeMap<>();
				 
				while((line=br.readLine())!=null)
				{
					
					linecount++;
					sb.append(line);
					charcount+=line.length();
 			        String[] split = line.split("\\s++|\\.|,|\\;|\\(|\\)|\\[|\\]|\\<|\\>|\\=|\\-|\\+|\\*|\\/|\\{|\\}|\\_");  
 			        for (int i = 0; i < split.length; i++) { 
// 			          ��ȡ��ÿһ������  
 			            Integer integer = map.get(split[i]);  
// 			          ������������map��û�У���ֵ1  
 			            if(null==integer){  
 			                map.put(split[i], 1);  
 			            }else{  
// 			              ����У���ԭ���ĸ����ϼ���һ  
 			                map.put(split[i], ++integer);  
 			            }  
 			        }  
 				}
				
// 		      ����������key��ȡ����Ӧ��value  
 		        Set<String> keySet = map.keySet();  
 		        for (String string : keySet)
 		        	if(!(string.equals("")))//{
 		        	wordcount+=map.get(string);
 		        //	System.out.println(string);}
				   br.close();
				   isr.close();
				   fis.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			catch(UnsupportedEncodingException e){
				e.printStackTrace();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
            String message=null;
            if(action1.equals("-l"))
                  message=(sourcefile+",   ������"+linecount+"\r\n");//����"\r\n"����"\n"
            else if(action1.equals("-c"))
            	 message=(sourcefile+",   �ַ�����"+charcount+"\r\n");//����"\r\n"����"\n"
            else if(action1.equals("-w"))
            	 message=(sourcefile+",   ��������"+wordcount+"\r\n");//����"\r\n"����"\n"
           return message;
    }
    
   static void putAtoB(String message,String thefile){//��message�����thefile��
	   try{
			//��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
			if(thefile==null)
				thefile="result.txt";
			FileWriter writer = new FileWriter(thefile, true);
           if(message.toCharArray()!=null)  writer.write(message.toCharArray());
           else System.out.println("�޸ò���");
			writer.close();
		}
		catch(IOException e){
			System.out.println("File read/write Error"+e);
		}
   }	
}
