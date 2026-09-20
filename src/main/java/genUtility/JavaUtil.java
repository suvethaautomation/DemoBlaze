package genUtility;

import java.util.Random;

public class JavaUtil {

	
	public int randomNumber(int i)
	{
		Random rand=new Random();
		int randNum = rand.nextInt(i);
		return randNum;
	}
}
