import java.util.ArrayList;
import java.util.Stack;

public class calculator {
	private char numberChars[] = {'-','0','1','2','3','4','5','6','7','8','9'};
	private char priorityOrder[] = {'+','/','*','^'};
	private  char parenthesis[] = {'(',')'};
	
	
	private String input= "0+51*(7+-2*(6+99))";
	

	public String postFix()
	{
		ArrayList<String> postfixArr = new ArrayList<String>();
		StringBuilder tmpStr = new StringBuilder(50);
		Stack<Character> tempSt = new Stack<Character>();
		boolean isCCharNum = false;
		char cChar;//Current char of the input
		//reads each char of the input 
		for(int i =0; i < this.input.length() ; i++)
		{
			isCCharNum = false;
			cChar = this.input.charAt(i);
			//Check if the cChar is a number
			if(cChar == parenthesis[0])
			{
				tempSt.push(cChar);
			}
			else
			{
				if(cChar != parenthesis[1])
				{
					for(int x = 0 ; x < this.numberChars.length ; x++)
					{
						if(cChar == numberChars[x])
						{

							tmpStr.append(cChar);
							isCCharNum = true;
							System.out.println(cChar);
							break;
						}
						
					}
					if(!isCCharNum)
					{	
						if(tmpStr.length()!=0)
						{
							postfixArr.add(tmpStr.toString());
							tmpStr.setLength(0);
						}
						
						if(!tempSt.empty() && tempSt.peek() != parenthesis[0])
						{
							int a,b;
							boolean poped;
							do
							{
								poped = false;
								a=-1;
								b=-1;
								for(int x =0; x < this.priorityOrder.length ; x++)
								{
									if(cChar == priorityOrder[x])
										a=x;
									if(tempSt.peek() == priorityOrder[x])
										b=x;
								}
								if(a!=-1 && b!=-1 && a<=b)
								{
									poped = true;

									postfixArr.add(String.valueOf(tempSt.pop()));
									
								}
							}while(!tempSt.empty() && poped );
							tempSt.push((cChar));
						}
						else
						{
							System.out.println(cChar);
							tempSt.push(cChar);
						}
	
					}
				}
				else
				{
					if(tmpStr.length()>0)
					{
						postfixArr.add(tmpStr.toString());
						tmpStr.setLength(0);
					}

					while(tempSt.peek()!=parenthesis[0])
						postfixArr.add(String.valueOf(tempSt.pop()));
					tempSt.pop();
				}
			}
			
			
		}

		while(tempSt.size()>0)
		{
			//postfix.append(tempSt.pop());
			postfixArr.add(String.valueOf(tempSt.pop()));
		}
		for(int i = 0;i<postfixArr.size();i++)
			System.out.print(postfixArr.get(i));
		return postfix.toString();
	}
	public String parseInput()
	{
		//Remove all white space
		return this.input.replaceAll("\\s+","");
	}

}
