package wordcount;
//��չ����
import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;
public class extendedFun {
	//�ݹ鴦���Ŀ¼�µ�ͬ�����ļ�
	static void allfile(String[] list){
		int lenth=list.length;
		String message=null;
		String myfile=null;
		myfile=list[lenth-1];
		if(lenth==9)
			//-a   -w(-l,-c) -w(-l.-c)  -w(-l.-c) in.c -e stop.txt -o out.txt 	
			myfile=list[4];
		//  -l -w -c file.c -e stop.txt -o out.txt
		//-a -w -c file.c -e stop.txt -o out.txt
		if(lenth==8)
			  myfile=list[3];
	      //  -l -w file.c -e stop.txt -o out.txt
			//-a -w  file.c -e stop.txt -o out.txt
			if(lenth==7)
				  myfile=list[2];
		if(lenth==6){
			// -w in.c -e stop.txt -o out.txt
			if(list[0].equals("-w")&&list[1].endsWith(".c")&&list[2].equals("-e")
					&&list[3].endsWith(".txt")&&list[4].equals("-o")&&list[5].endsWith(".txt"))
			       myfile=list[1];
			//-w -l -c in.c-o out.txt
			//-a -l -c in.c-o out.txt
			else if((list[0].equals("-l")||list[0].equals("-c")||list[0].equals("-w")||list[0].equals("-a"))
					&&(list[1].equals("-l")||list[1].equals("-c")||list[1].equals("-w"))
					&&(list[2].equals("-l")||list[2].equals("-c")||list[2].equals("-w"))&&
					list[3].endsWith(".c")&&list[4].equals("-o")&&list[5].endsWith(".txt"))
					myfile=list[3];
		}
			
		//-l(-c -w) in.c -o out.txt
		if(lenth==4&&(list[0].equals("-l")||list[0].equals("-c")||list[0].equals("-w"))&&
				list[1].endsWith(".c")&&list[2].equals("-o")&&list[3].endsWith(".txt"))
				myfile=list[1];
		//-w in.c -e stop.txt 
		if(lenth==4&&list[0].equals("-w")&&
				list[1].endsWith(".c")&&list[2].equals("-e")&&list[3].endsWith(".txt"))
			myfile=list[1];
		File directory = new File("");//����Ϊ��
		String courseFile;
		try {
			courseFile = directory.getCanonicalPath();//��ȡ��ǰĿ¼·��
			 // ���ָ���ļ�����  
	        File file = new File(courseFile);   
	        // ��ø��ļ����ڵ������ļ�   
	        File[] array = file.listFiles();   
	        File afile=new File(myfile); 
	        String fileName=afile.getName();    
	        String fileTyle=fileName.substring(fileName.lastIndexOf("."),fileName.length()); //��ȡ�ļ�����
	        for(int i=0;i<array.length;i++)
	        {   
	            if(array[i].isFile())//������ļ�
	            {   
	                if(array[i].getName().endsWith(fileTyle)){
	                	if(lenth==2){
	                	if(list[0].equals("-l")||list[0].equals("-c")||list[0].equals("-w"))
	                		//-l *.c
	                			basecount.putAtoB(basecount.print(list[0],array[i].getName()), null);//һ������Ĭ�����
	                	else if(list[0].equals("-a")){
	                		//-a *.c
	                		basecount.putAtoB(moredata(array[i].getName()),null);//��ϸ����
	                	}
	                	}
	                	else if(lenth==3&&(list[0].equals("-l")||list[0].equals("-c")||list[0].equals("-w"))&&
	                			(list[1].equals("-l")||list[1].equals("-c")||list[1].equals("-w"))){//��������Ĭ�����
	                		//-l -w *.c
	                		basecount.putAtoB(basecount.print(list[0],array[i].getName()), null);
	                		basecount.putAtoB(basecount.print(list[1], array[i].getName()), null);
	                	}
	                	else if(lenth==3&&list[0].equals("-a")&&(list[1].equals("-l")||list[1].equals("-c")||list[1].equals("-w"))){//��������Ĭ�����
	                		//-a -w *.c
	                		basecount.putAtoB(basecount.print(list[1],array[i].getName()), null);
	                		basecount.putAtoB(moredata(array[i].getName()), null);
	                	}
	                	else if(lenth==4){//��������Ĭ�����
	                		////-l(-c -w) in.c -o out.txt
	                		if((list[0].equals("-l")||list[0].equals("-c")||list[0].equals("-w"))&&
				                  list[1].endsWith(".c")&&list[2].equals("-o")&&list[3].endsWith(".txt"))
	                			basecount.putAtoB(basecount.print(list[0], array[i].getName()),list[3]);
	                		//-l -w -c *.c 
	                		else if((list[0].equals("-l")||list[0].equals("-c")||list[0].equals("-w"))&&
	                					(list[1].equals("-l")||list[1].equals("-c")||list[1].equals("-w"))&&
	                					(list[2].equals("-l")||list[2].equals("-c")||list[2].equals("-w"))
	                					&&list[3].endsWith(".c")){
	                		basecount.putAtoB(basecount.print(list[0],array[i].getName()), null);
	                		basecount.putAtoB(basecount.print(list[1], array[i].getName()), null);
	                		basecount.putAtoB(basecount.print(list[2],array[i].getName()), null);
	                		}
	                		//-a -w -c *.c 
	                		else if(list[0].equals("-a")&&(list[1].equals("-l")||list[1].equals("-c")||list[1].equals("-w"))&&
	                					(list[2].equals("-l")||list[2].equals("-c")||list[2].equals("-w"))
	                					&&list[3].endsWith(".c")){
	                		basecount.putAtoB(basecount.print(list[1], array[i].getName()), null);
	                		basecount.putAtoB(basecount.print(list[2],array[i].getName()), null);
	                		basecount.putAtoB(moredata(array[i].getName()), null);
	                		}
	                		//-w in.c -e stop.txt 
	                		else 	if(lenth==4&&list[0].equals("-w")&&
	            				list[1].endsWith(".c")&&list[2].equals("-e")&&list[3].endsWith(".txt"))
	                			basecount.putAtoB(stopcount(array[i].getName(),list[3]), null);
	                	}
	                	else if(lenth==6)
	                	{
	                		//-w *.c -e stop.txt -o out.txt
	                		//System.out.println(array[i].getName()+list[3]);
	            			// -w in.c -e stop.txt -o out.txt
	            			if(list[0].equals("-w")&&list[1].endsWith(".c")&&list[2].equals("-e")
	            					&&list[3].endsWith(".txt")&&list[4].equals("-o")&&list[5].endsWith(".txt"))
	                		   basecount.putAtoB(extendedFun.stopcount(array[i].getName(),list[3]), list[5]);
	            			//-w -l -c in.c-o out.txt
	            			else if((list[0].equals("-l")||list[0].equals("-c")||list[0].equals("-w"))
	            					&&(list[1].equals("-l")||list[1].equals("-c")||list[1].equals("-w"))
	            					&&(list[2].equals("-l")||list[2].equals("-c")||list[2].equals("-w"))&&
	            					list[3].endsWith(".c")&&list[4].equals("-o")&&list[5].endsWith(".txt"))
	            			{
	            				//System.out.println(list[0]+" "+list[1]+" "+list[2]+"  "+list[3]+"  "+list[4]+"  "+list[5]);
	            				basecount.putAtoB(basecount.print(list[0],array[i].getName()),list[5]);
	            				basecount.putAtoB(basecount.print(list[1],array[i].getName()),list[5]);
	            				basecount.putAtoB(basecount.print(list[2],array[i].getName()),list[5]);
	            			}
	            			//-a-l -c in.c-o out.txt
	            			else if(list[0].equals("-a")
	            					&&(list[1].equals("-l")||list[1].equals("-c")||list[1].equals("-w"))
	            					&&(list[2].equals("-l")||list[2].equals("-c")||list[2].equals("-w"))&&
	            					list[3].endsWith(".c")&&list[4].equals("-o")&&list[5].endsWith(".txt"))
	            			{
	            				//System.out.println(list[0]+" "+list[1]+" "+list[2]+"  "+list[3]+"  "+list[4]+"  "+list[5]);
	            				//basecount.putAtoB(basecount.print(list[0],array[i].getName()),list[5]);
	            				basecount.putAtoB(basecount.print(list[1],array[i].getName()),list[5]);
	            				basecount.putAtoB(basecount.print(list[1],array[i].getName()),list[5]);
	            				basecount.putAtoB(extendedFun.moredata(array[i].getName()),list[5]);
	            			}
	                	}
	                	else if(lenth==7)
	                	{
	                		if(list[0].equals("-a")){
	                			//-a -l   *.c -e stop.txt -o out.txt
                			basecount.putAtoB(basecount.print(list[1],array[i].getName()), list[6]);
	                		basecount.putAtoB(moredata(array[i].getName()),list[6]);
	                		basecount.putAtoB(stopcount(array[i].getName(),list[4]),list[6]);
	                		}   
	                		else {
	                			//-c -l   *.c -e stop.txt -o out.txt
	                			basecount.putAtoB(basecount.print(list[0],array[i].getName()), list[6]);
	                			basecount.putAtoB(basecount.print(list[1],array[i].getName()), list[6]);
		                		basecount.putAtoB(stopcount(array[i].getName(),list[4]),list[6]);
	                		}
	                			
	                	}
	                	else if(lenth==8)
	                	{
	                		if(list[0].equals("-a")){
	                			//-a -l -w   *.c -e stop.txt -o out.txt
                			basecount.putAtoB(basecount.print(list[1],array[i].getName()), list[7]);
	                		basecount.putAtoB(basecount.print(list[2], array[i].getName()),list[7]);
	                		basecount.putAtoB(moredata(array[i].getName()),list[7]);
	                		basecount.putAtoB(stopcount(array[i].getName(),list[5]),list[7]);
	                		}   
	                		else {
	                			//-c -l -w   *.c -e stop.txt -o out.txt
	                			basecount.putAtoB(basecount.print(list[0],array[i].getName()), list[7]);
	                			basecount.putAtoB(basecount.print(list[1],array[i].getName()), list[7]);
		                		basecount.putAtoB(basecount.print(list[2], array[i].getName()),list[7]);
		                		basecount.putAtoB(stopcount(array[i].getName(),list[5]),list[7]);
	                		}
	                			
	                	}
	                	else if(lenth==9)
	                	{
	                		if(list[0].equals("-a")){
	                			//-a -l -w   -c *.c -e stop.txt -o out.txt
                			basecount.putAtoB(basecount.print(list[1],array[i].getName()), list[8]);
	                		basecount.putAtoB(basecount.print(list[2], array[i].getName()),list[8]);
	                		basecount.putAtoB(basecount.print(list[3], array[i].getName()),list[8]);
	                		basecount.putAtoB(moredata(array[i].getName()),list[8]);
	                		basecount.putAtoB(stopcount(array[i].getName(),list[6]),list[8]);
	                		}          		
	                	}
	                	else System.out.println("�����ʽ����");
	                }
	            }
	        }   
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
  //ͳ�ƴ�����/����/ע����
	static String moredata(String myfile)throws FileNotFoundException {  
		File file=new File(myfile);
  	 // ��¼ע������  
       long annotationLine = 0;  
      // ��¼�հ�����  
      long blankLine = 0;  
      // ��¼��Ч���������  
      long codeLine = 0;   
      //��ע��
      long notLine=0;
      if (file == null || !file.exists())   
          throw new FileNotFoundException(file + "���ļ������ڣ�"); 
      BufferedReader br = null;  
      // �жϴ����Ƿ�Ϊע����  
      boolean comment = false;  
      int whiteLines = 0;  
      int commentLines = 0;  
      int normalLines = 0;       
      try {  
          br = new BufferedReader(new FileReader(file));  
          String line = "";  
          while ((line = br.readLine()) != null) {  
              line = line.trim();  
              if (line.matches("^[//s&&[^//n]]*$")||line.equals("{")||line.equals("}")) {  
                  // ���� :����ȫ���ǿո���ʽ�����ַ�������������룬��ֻ�в�����һ������ʾ���ַ������硰{��
                  whiteLines++;      
              } 
             /* ���в��Ǵ����У����ұ��а���ע�͡�һ����Ȥ����������Щ����Ա���ڵ��ַ������ע�ͣ�
              *  }//ע��
              */
              else if (line.startsWith("/*") && !line.endsWith("*/")||((line.startsWith("{/*")||line.startsWith("}/*"))&&!line.endsWith("*/"))){
                  // �жϴ���Ϊ"/*"��ͷ��ע����  
                  commentLines++;  
                  comment = true;  
              } else if (comment == true && !line.endsWith("*/")&&!line.startsWith("*/")) {  
                  // Ϊ����ע���е�һ�У����ǿ�ͷ�ͽ�β��
              	notLine++;
                  commentLines++;  
              } else if (comment == true && (line.endsWith("*/")||line.startsWith("*/"))) {  
                  // Ϊ����ע�͵Ľ�����  
                  commentLines++;  
                  comment = false;  
              } else if (line.startsWith("//")|| line.startsWith("}//")||line.startsWith("{//")||
              		    ((line.startsWith("{/*") ||line.startsWith("}/*")||line.startsWith("/*")) && line.endsWith("*/"))) {  
                  // ����ע����  
                  commentLines++;  
              } else {  
                  // ����������  
              	//System.out.println(line);
                  normalLines++;  
              }  
          }    	
      } catch (FileNotFoundException e) {  
          e.printStackTrace();  
      } catch (IOException e) {  
          e.printStackTrace();  
      } finally {  
          if (br != null) {  
              try {  
                  br.close();  
                  br = null;  
              } catch (IOException e) {  
                  e.printStackTrace();  
              }  
          }  
             
      }    
      String message=(myfile+",������/����/ע����:"+(normalLines+notLine)+
    		  "/"+whiteLines+"/"+(commentLines-notLine)+"\r\n");//����"\r\n"����"\n"
      return message;
  } 
  //����ͣ�ôʱ���дͳ�Ƶ�����
	static String  stopcount(String thefile,String txt){
  	int stopcount=0;
  	int wordcount=0;
  	File stopfile=new File(txt);
		File file=new File(thefile);
		ArrayList<String> stop=new ArrayList<String>(3);		
//     ����stopfile.txt�ĵ��ʵ�һ����̬string�����б���	
		if(stopfile.exists()){
			try{
				FileInputStream fis=new FileInputStream(stopfile);
				InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
				BufferedReader br=new BufferedReader(isr);
				String line=new String("");
				StringBuffer sb=new StringBuffer();
				 TreeMap<String, Integer> map = new TreeMap<>(); 
				String[] split =null;
				while((line=br.readLine())!=null){
					 sb.append(line);
			        split = line.split("\\s+");  
			       for (int i = 0; i < split.length; i++) {  
//			          ��ȡ��ÿһ������  
			            Integer integer = map.get(split[i]);  
//			          ������������map��û�У���ֵ1  
			            if(null==integer){  
			                map.put(split[i], 1);  
			            }
			        }  
		        } 		
				Set<String> keySet = map.keySet();  
		        for (String string : keySet) {  
		        	stop.add(string);    
		        }
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
		//ͳ��stop�������Ŀ
		if(file.exists()){
			try{
				FileInputStream fis=new FileInputStream(file);
				InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
				BufferedReader br=new BufferedReader(isr);
				String line=new String("");
				StringBuffer sb=new StringBuffer();
				 TreeMap<String, Integer> map = new TreeMap<>(); 
				while((line=br.readLine())!=null){
			        String[] split = line.split("\\s++|\\.|,|\\;|\\(|\\)|\\[|\\]|\\<|\\>|\\=|\\-|\\+|\\*|\\/|\\{|\\}");  //ȥ������ո�\\s+
			        for (int i = 0; i < split.length; i++) { 		        	
//			          ��ȡ��ÿһ������  
			            Integer integer = map.get(split[i]);  
//			          ������������map��û�У���ֵ1  
			            if(null==integer){  
			                map.put(split[i], 1);  
			            }else{  
//			              ����У���ԭ���ĸ����ϼ���һ  
			                map.put(split[i], ++integer);  
			            }  
			        }  
				}
//		      ����������key��ȡ����Ӧ��value  
		        Set<String> keySet = map.keySet();  
		        for (String string : keySet) { 
		        	int i=0;
		        	if(!(string.equals(""))){
		        	wordcount+=map.get(string);
               while(i<stop.size()){
		        	   if(string.equalsIgnoreCase(stop.get(i++)))//�����ִ�Сд�ж�
		           { 
		         		   stopcount+=map.get(string);
		                    //System.out.println(string+":"+map.get(string));  
		        	   }}
		        	   
		      }
		        } 
		        //System.out.println(wordcount+"  "+stopcount+"  "+(wordcount-stopcount));
				sb.append(line);
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
		String  message=(thefile+", ������(ͣ�ú󣩣�"+(wordcount-stopcount)+"\r\n");//����"\r\n"����"\n"
		return message;
  }	
} 