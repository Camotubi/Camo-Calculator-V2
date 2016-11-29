import java.util.ArrayList;
import java.util.Stack;

public class calculator {
	private char numberChars[] = {'0','1','2','3','4','5','6','7','8','9'};
	private char priorityOrder[] = {'+','-','/','*','^'};
	private  char parenthesis[] = {'(',')'};
	
	
	private String input= "0+5*(7-2*(6+9))";
	

	public String postFix()
	{
		StringBuilder postfix = new StringBuilder(50);
		Stack<Character> tempSt = new Stack<Character>();
		boolean isCCharNum = false;
		char cChar;//Current char of the input
		//reads each char of the input 
		for(int i =0; i < this.input.length() ; i++)
		{
			isCCharNum = false;
			cChar = this.input.charAt(i);
			//Check if the cChar is a number
			for(int x = 0 ; x < this.numberChars.length ; x++)
			{
				if(cChar == numberChars[x])
				{
					postfix.append(cChar);
					isCCharNum = true;
					break;
				}
				
			}
			if(cChar == parenthesis[0])
			{
				tempSt.push(cChar);
			}
			else
			{
				if(cChar != parenthesis[1])
				{
					if(!isCCharNum)
					{	
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
									postfix.append(tempSt.pop());
									
								}
							}while(!tempSt.empty() && poped );
							tempSt.push(cChar);
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
					while(tempSt.peek()!=parenthesis[0])
						postfix.append(tempSt.pop());
					tempSt.pop();
				}
			}
			
			
		}
		System.out.println(tempSt.size());
		while(tempSt.size()>0)
		{
			postfix.append(tempSt.pop());
		}
		return postfix.toString();
	}
	public String parseInput()
	{
		//Remove all white space
		return this.input.replaceAll("\\s+","");
	}

}
