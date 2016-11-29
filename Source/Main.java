
public class Main {
	public static void main(String args[])
	{
		calculator calc = new calculator();
		String arr[] = calc.postFix();
		for(int i = 0;i<arr.length ; i++)
			System.out.print(arr[i]);
	}
}
