import java.util.ArrayList;
import java.util.Stack;

public class calculator {
	private char numberChars[] = {'0','1','2','3','4','5','6','7','8','9'};
	private char priorityOrder[] = {'^','*','/','-','+'};
	
	private String input;
	
	
	public String postFix()
	{
		StringBuilder postfix = new StringBuilder(50);
		Stack<Character> tempSt = new Stack<Character>();
		char cChar;//Current char of the input
		//reads each char of the input 
		for(int i =0; i < this.input.length() ; i++)
		{
			cChar = this.input.charAt(i);
			//Check if the cChar is a number
			for(int x = 0 ; x < this.numberChars.length ; x++)
			{
				if(cChar == numberChars[x])
				{
					postfix.append(cChar);
					break;
				}
				
			}
			
			if(!tempSt.empty())
			{
				int x;
				for(x =0; x < this.priorityOrder.length ; x++)
				{
					if(cChar == priorityOrder[x])
						break;
				}
				if(tempSt.peek())
			}
			
		}
		return "";
	}
	public String parseInput()
	{
		//Remove all white space
		return this.input.replaceAll("\\s+","");
	}

}
