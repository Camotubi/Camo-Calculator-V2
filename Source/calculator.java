import java.util.ArrayList;
import java.util.Stack;

public class calculator {
	private char numberChars[] = {'-','0','1','2','3','4','5','6','7','8','9'};
	private char priorityOrder[] = {'+','/','*','^'};
	private  char parenthesis[] = {'(',')'};
	
	
	private String input= "0+51*(7+-2*(6+99))";
	

	public String[] postFix()
	{
		/*
		 * This function convert an infix argument to a postfix ordered array following the order of priority 
		 * stated priorityOrder[] attribute.
		 * the infix string should not have any spaces and it should be a operand infront of every non-first negative character. (if the numberChars[] and priorityOrder[] input should be
		 * 2+-4. The reason of this is that the negative character is treated as a number character, not as a operand.
		 * It also should be noted that if there are 2 operands of the same level of priority, the one at the left will be added to postFixArr first
		 * 
		 */
		ArrayList<String> postfixArr = new ArrayList<String>();	//Holds every term and operand of the input ordered in postfix
		StringBuilder tmpStr = new StringBuilder(50);			//Used to concat number characters
		Stack<Character> tempSt = new Stack<Character>();		// Stack used as a buffer for the operands
		boolean isCCharNum = false;								//
		char cChar;												//Current char of the input
		for(int i =0; i < this.input.length() ; i++)			
		{	
			isCCharNum = false;
			cChar = this.input.charAt(i);
			
			if(cChar == parenthesis[0])
			{
				tempSt.push(cChar);
			}
			else
			{
				if(cChar != parenthesis[1])
				{
					for(int x = 0 ; x < this.numberChars.length ; x++)	//Check if the cChar is a number
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
							int a,b;// a holds the "level of priority" of cChar and b holds the one of the last operand in the stack
							boolean poped;
							do
							{
								poped = false;
								a=-1;
								b=-1;
								for(int x =0; x < this.priorityOrder.length ; x++) //finds the level of priority of cChar and the last operand in the stack.
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
		return  postfixArr.toArray(new String[postfixArr.size()]);
	}
	public String parseInput()
	{
		//Remove all white space
		return this.input.replaceAll("\\s+","");
	}

}
