package wordcount;
import java.io.*;
public class wc{
	public static void main(String[] args) throws FileNotFoundException {
		int len=args.length;
		String one,two,three,four,five,six,seven,eight,night;//�������
		if(len<=1)
			System.out.println("�밴�ո�ʽ����");
		else {
			if(len==2)
			{
				one=args[0];
				two=args[1];
				if(one.equals("-a")&&two.endsWith(".c"))
						//-a file.c
						//System.out.println("morrdate");
						basecount.putAtoB(extendedFun.moredata(two),null);
				     //-l(-c,-w) file.c
				else if((one.equals("-l")||one.equals("-c")||one.equals("-w"))&&two.endsWith(".c"))
					 basecount.putAtoB(basecount.print(one, two),null);
				else System.out.println("�޸ò���");							
			}
			else if(len==3)
			{
				one=args[0];two=args[1];three=args[2];
				if(three.endsWith(".c")){
					//-l -c in.c
					if((one.equals("-l")||one.equals("-c")||one.equals("-w")&&
							     (two.equals("-l")||two.equals("-c")||two.equals("-w"))))//�������ܴ����ļ�
					{
						 basecount.putAtoB(basecount.print(one, three), null);
						 basecount.putAtoB(basecount.print(two, three), null);
					}
					//-s -l file.c     
					else if(one.equals("-s")&&(two.equals("-l")||two.equals("-c")||two.equals("-w")||two.equals("-a")))//�ݹ鴦���ļ�����ͳ�Ƶ��ʡ��ַ����У�����������С�ע���кͿ���)
						     {  
						     String[] list={two,three};
						      extendedFun.allfile(list);
						     }
					//-a -c file.c
					else if(one.equals("-a")&&(two.equals("-l")||two.equals("-c")||two.equals("-w")))
					{
						basecount.putAtoB(basecount.print(two,three), null);
						basecount.putAtoB(extendedFun.moredata(three),null);
					}
					else System.out.println("�����ʽ����");
			          }
				
				//file.c -e stop.txt
             else if(three.endsWith(".txt")&&two.equals("-e")&&one.endsWith(".c")){//ͣ�ôʱ�,������
          	   	basecount.putAtoB(	extendedFun.stopcount(one, three),null);
				}
				else System.out.println("�����ʽ����");
		}
			else if(len==4){
				one=args[0];two=args[1];three=args[2];four=args[3];
				if(four.endsWith(".c")){
					//-l -c -w in.c
						if((one.equals("-l")||one.endsWith("-c")||one.equals("-w"))&&
								(two.equals("-l")||two.equals("-c")||two.equals("-w"))
								&&(three.equals("-l")||three.equals("-c")||three.equals("-w")))//�������ܴ����ļ�
								{
							basecount.putAtoB(basecount.print(one, four), null);
							basecount.putAtoB(basecount.print(two, four), null);
							basecount.putAtoB(basecount.print(three, four), null);
								}
						
						//-s -l -w in.c
						else if(one.equals("-s")&&(two.equals("-l")||two.equals("-c")||two.equals("-w")||two.equals("-a"))
									&&(three.equals("-l")||three.equals("-c")||three.equals("-w")))//�ݹ鴦���ļ�����ͳ�Ƶ��ʡ��ַ�����)
							{
									String[] list={two,three,four};
									extendedFun.allfile(list);
								}		
						
						//-a-l -w in.c
						else if(one.equals("-a")&&(two.equals("-l")||two.equals("-c")||two.equals("-w")||two.equals("-a"))
									&&(three.equals("-l")||three.equals("-c")||three.equals("-w")))
							{
									basecount.putAtoB(basecount.print(two,four),null);
									basecount.putAtoB(basecount.print(three,four),null);
									basecount.putAtoB(extendedFun.moredata(four),null);
								}				
							else System.out.println("�����ʽ����");
							}
				
				//-l(-c -w) in.c -o out.txt
					else if((one.equals("-l")||one.equals("-w")||one.equals("-c"))&&two.endsWith(".c")
							       &&three.equals("-o")&&four.endsWith(".txt"))
					             basecount.putAtoB(basecount.print(one, two),four);
				
				//-a in.c -o out.txt
					else if(one.equals("-a")&&two.endsWith(".c")
							       &&three.equals("-o")&&four.endsWith(".txt"))
							basecount.putAtoB(extendedFun.moredata(two),four);
				
				//-w in.c -e out.txt
					else if(one.equals("-w")&&two.endsWith(".c")&&three.equals("-e")&&four.endsWith(".txt"))
					{
						//System.out.println(one+"  "+two+"  "+three+"  "+four);
						basecount.putAtoB(extendedFun.stopcount(two,four),null);
					}
					else System.out.println("�밴����ȷ��ʽ����");			
			}
			else if(len==5){
				one=args[0];two=args[1];three=args[2];four=args[3];five=args[4];
				
				//��������ָ����� -l -c in.c -o out.txt
				if((one.equals("-l")||one.endsWith("-c")||one.equals("-w"))&&
						(two.equals("-l")||two.equals("-c")||two.equals("-w"))&&
						three.endsWith(".c")&&four.equals("-o")&&five.endsWith(".txt")){
					basecount.putAtoB(basecount.print(one,three),five);
					basecount.putAtoB(basecount.print(two,three),five);
			       }
				//-s -l(-c -w) in.c -o out.txt
				else if(one.equals("-s")&&(two.equals("-l")||two.equals("-c")||two.equals("-w"))&&three.endsWith(".c")
						&&four.equals("-o")&&five.endsWith(".txt")){
					String[] list={two,three,four,five};
					extendedFun.allfile(list);
				}
				//-a -l(-c -w) in.c -o out.txt
				else if(one.equals("-a")&&(two.equals("-l")||two.equals("-c")||two.equals("-w"))&&three.endsWith(".c")
						&&four.equals("-o")&&five.endsWith(".txt")){
						basecount.putAtoB(basecount.print(two,three),five);
						basecount.putAtoB(extendedFun.moredata(three),five);	
				}
				//-a -l -c -w in.c 
				else if(one.equals("-a")&&(two.equals("-l")||two.equals("-c")||two.equals("-w"))&&
						(three.equals("-l")||three.equals("-c")||three.equals("-w"))&&
						(four.equals("-l")||four.equals("-c")||four.equals("-w"))&&five.endsWith(".c")){
						basecount.putAtoB(basecount.print(two,five),null);
						basecount.putAtoB(basecount.print(three,five),null);
						basecount.putAtoB(basecount.print(four,five),null);
						basecount.putAtoB(extendedFun.moredata(five),null);	
				}
				//-s -w in.c -e stop.txt 
				else if(one.equals("-s")&&two.equals("-w")&&three.endsWith(".c")&&
						four.equals("-e")&&five.endsWith(".txt"))
						{
							String[] list={two,three,four,five};
							extendedFun.allfile(list);
						}
				//-s -w -l -c in.c
				else if(one.equals("-s")&&(two.equals("-l")||two.equals("-c")||two.equals("-w")||two.equals("-a"))&&
						(three.equals("-l")||three.equals("-c")||three.equals("-w"))&&
						(four.equals("-l")||four.equals("-c")||four.equals("-w"))&&five.endsWith(".c")){
					String[] list={two,three,four,five};
					extendedFun.allfile(list);
				}
				else System.out.println("�밴�ո�ʽ����");
			}
			else if(len==6){
				one=args[0];two=args[1];three=args[2];four=args[3];five=args[4];six=args[5];
				//��������ָ�����
				//-l -c -w in.c -o out.txt
				if((one.equals("-l")||one.equals("-c")||one.equals("-w"))&&
						(two.equals("-l")||two.equals("-c")||two.equals("-w"))&&
						(three.equals("-l")||three.equals("-c")||three.equals("-w"))&&
						four.endsWith(".c")&&five.equals("-o")&&six.endsWith(".txt")){
					basecount.putAtoB(basecount.print(one,four),six);
					basecount.putAtoB(basecount.print(two,four),six);
					basecount.putAtoB(basecount.print(three,four),six);
			       }
				//-a-c -w in.c -o out.txt
				else if(one.equals("-a")&&	(two.equals("-l")||two.equals("-c")||two.equals("-w"))&&
						(three.equals("-l")||three.equals("-c")||three.equals("-w"))&&
						four.endsWith(".c")&&five.equals("-o")&&six.endsWith(".txt")){
					basecount.putAtoB(basecount.print(two,four),six);
					basecount.putAtoB(basecount.print(three,four),six);
					basecount.putAtoB(extendedFun.moredata(four),six);
			       }
				//-w file.c -e stop.txt -o jj.txt
				else if(one.equals("-w")&&two.endsWith(".c")&&three.equals("-e")&&four.endsWith(".txt")
						&&five.equals("-o")&&six.endsWith(".txt")	)
				{
					//System.out.println(two+"  "+four+"  "+six);
					basecount.putAtoB(extendedFun.stopcount(two,four),six);
				}
				else System.out.println("�밴�ո�ʽ����");
			}
			else if(len==7){
				one=args[0];two=args[1];three=args[2];four=args[3];five=args[4];six=args[5];seven=args[6];
				//-a -l -c -w in.c -o out.txt
				 if(one.equals("-a")&&(two.equals("-l")||two.equals("-c")||two.equals("-w"))&&
						(three.equals("-l")||three.equals("-c")||three.equals("-w"))&&
						(four.equals("-l")||four.equals("-c")||four.equals("-w"))
						&&five.endsWith(".c")&&six.equals("-o")&&seven.endsWith(".txt")){
						basecount.putAtoB(basecount.print(two,five),seven);
						basecount.putAtoB(basecount.print(three,five),seven);
						basecount.putAtoB(basecount.print(four,five),seven);
						basecount.putAtoB(extendedFun.moredata(five),seven);	
				}
				//�ݹ鴦��ʹ��ͣ�ñ��ĵ�������ָ�����
				//-s -w in.c -e stop.txt -o out.txt
				 else if(one.equals("-s")&&two.equals("-w")&&three.endsWith(".c")
						&&four.equals("-e")&&five.endsWith(".txt")&&six.equals("-o")&&seven.endsWith(".txt"))
						{
							String[]  list={two,three,four,five,six,seven};
							extendedFun.allfile(list);
						}
				//-s -w -l -c in.c-o out.txt
				//-s -a -l -c in.c -o out.txt
				else if(one.equals("-s")&&(two.equals("-l")||two.equals("-w")||two.equals("-c")||two.equals("-a"))&&
						(three.equals("-l")||three.equals("-w")|three.equals("-c"))&&
						(four.equals("-l")||four.equals("-w")||four.equals("-c"))&&
						five.endsWith(".c")&&six.equals("-o")&&seven.endsWith(".txt"))
				{
					//System.out.println(two+" "+three+" "+four+"  "+five+"  "+six+"  "+seven);
					String[] list={two,three,four,five,six,seven};
					//System.out.println(two+" "+three+" "+four+"  "+five+"  "+six+"  "+seven);
					extendedFun.allfile(list);
				}
				else System.out.println("�޸ò���");
			}
			
			else if(len==8)	{one=args[0];two=args[1];three=args[2];four=args[3];five=args[4];six=args[5];seven=args[6];eight=args[7];
			//-s -a   -w(-l.-c) in.c -e stop.txt -o out.txt 
			// -s -l  -c file.c -e stop.txt -o out.txt
			if(one.equals("-s")&&(two.equals("-a")||two.equals("-c")||two.equals("-l")||two.equals("-w"))
					&&(three.equals("-l")||three.equals("-c")||three.equals("-w"))
					&&four.endsWith(".c")&&five.equals("-e")&&six.endsWith(".txt")
					&&seven.equals("-o")&&eight.endsWith(".txt"))
				{
						String[] list={two,three,four,five,six,seven,eight};
						extendedFun.allfile(list);
				}
		  
			else System.out.println("�밴�ո�ʽ����");
		}
			
			else if(len==9){
				one=args[0];two=args[1];three=args[2];four=args[3];five=args[4];six=args[5];seven=args[6];eight=args[7];night=args[8];
				//-s -a   -w(-l,-c) -w(-l.-c) in.c -e stop.txt -o out.txt 
				// -s -l -w -c file.c -e stop.txt -o out.txt
				if(one.equals("-s")&&(two.equals("-a")||two.equals("-c")||two.equals("-l")||two.equals("-w"))
						&&(three.equals("-l")||three.equals("-c")||three.equals("-w"))
						&&(four.equals("-l")||four.equals("-c")||four.equals("-w"))&&five.endsWith(".c")
						&&six.equals("-e")&&seven.endsWith(".txt")&&eight.equals("-o")&&night.endsWith(".txt"))
					{
							String[] list={two,three,four,five,six,seven,eight,night};
							extendedFun.allfile(list);
					}
			
				else System.out.println("�밴�ո�ʽ����");
			}
			else if(len==10){
				one=args[0];two=args[1];three=args[2];four=args[3];five=args[4];six=args[5];seven=args[6];eight=args[7];night=args[8];
				String ten=args[9];
				//-s -a   -w(-l,-c) -w(-l.-c)  -w(-l.-c) in.c -e stop.txt -o out.txt 
				if(one.equals("-s")&&two.equals("-a")&&(three.equals("-l")||three.equals("-c")||three.equals("-w"))
						&&(four.equals("-l")||four.equals("-c")||four.equals("-w"))&&
						(five.equals("-l")||five.equals("-c")||five.equals("-w"))&&six.endsWith(".c")
						&&seven.equals("-e")&&eight.endsWith(".txt")&&night.equals("-o")&&ten.endsWith(".txt"))
					{
							String[] list={two,three,four,five,six,seven,eight,night,ten};
							extendedFun.allfile(list);
					}
				else System.out.println("�밴�ո�ʽ����");
			}
			else System.out.println("�밴�ո�ʽ����");			
	}
	}
	}
