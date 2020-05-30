import java.io.File;
import java.util.*;

public class DifficultyLevel {
	public static void main(String args[])
	{
		Scanner fileName=new Scanner(System.in);
		System.out.print("enter the filename");
		String get=fileName.nextLine();
		try
		{
			File file=new File(get);
			fileName.close();
			Scanner s=new Scanner(file);
			String inputfile[]=new String[20];
			int i=0,count=0;
			while(s.hasNextLine())
			{
				inputfile[i++]=s.nextLine();
			}
			i=0;
		String type=inputfile[i++],manualdifficulty=inputfile[i++];   //manual difficulty level and type of question whether it is mcq/fillup/programming/match the following
		
		type=type.toLowerCase();
		manualdifficulty =manualdifficulty.toLowerCase();
		float difficulty=0,x=0; // Output difficulty level
		if(manualdifficulty.equals("easy"))
			x=0;
		else if(manualdifficulty .equals("medium"))
			x=1;
		else
			x=2;
		int n=Integer.parseInt(inputfile[i++]),one=0,qns=0,hints=0,compile=0; // Number of students who attended this question
		if(type.contains("mcq"))
		{

			qns=Integer.parseInt(inputfile[i++]);	//Number of times the answer was changed for mcqs
			hints=Integer.parseInt(inputfile[i++]);	//Hints used
		}
		
		else if(type.contains("programming"))
		{

			compile=Integer.parseInt(inputfile[i++]);	//Number of times the program compiled
			hints=Integer.parseInt(inputfile[i++]);	//Hints used
			String program=inputfile[i++];
		}
		else
		{
			hints=Integer.parseInt(inputfile[i++]);	//No of hints used
		}

		String feedback=inputfile[i++];
		float avg=0;
		System.out.print("no. of right, wrong and partial and max marks");
		int right=Integer.parseInt(inputfile[i++]),wrong=Integer.parseInt(inputfile[i++]),partial=Integer.parseInt(inputfile[i++]),maxmarks=Integer.parseInt(inputfile[i++]);
		difficulty = (right/n)*100;

		if(type.contains("mcq"))
		{
			if(difficulty>80&&x==0)
			{
				System.out.print("EASY - "+difficulty);
			}
			else if(difficulty<15&&x==2)
			{
				System.out.print("DIFFICULT - "+difficulty);
			}
			else
			{
				if(qns>n/2)
				{
					difficulty-=(qns/n)*10;
				}
				if(hints>n/2)
				{
					difficulty-=(hints/n)*10;
				}
				if(difficulty<15)
					System.out.print("DIFFICULT - "+difficulty);
				else if(difficulty>80)
					System.out.print("EASY - "+difficulty);
				else
				System.out.print("MEDIUM - "+difficulty);
			}
		}
		else if(type.contains("fillup"))
		{
			if(difficulty>80&&x==0)
			{
				System.out.print("EASY - "+difficulty);
			}
			else if(difficulty<15&&x==2)
			{
				System.out.print("DIFFICULT - "+difficulty);
			}
			else
			{
				difficulty+=((partial/n)*100);
				
				if(hints>n/3)
				{
					difficulty-=(hints/n)*10;
				}
				if(difficulty<15)
					System.out.print("DIFFICULT - "+difficulty);
				else if(difficulty>80)
					System.out.print("EASY - "+difficulty);
				else
				System.out.print("MEDIUM - "+difficulty);
			}
		}
		else if(type.contains("programming"))
		{
			if(partial>right&&partial>wrong)
			{
				difficulty=(partial/n)*100;
				System.out.print("MEDIUM - "+difficulty);
			}
			if((compile-n)<(n/2)&&difficulty>80&&x==0)
				System.out.print("EASY - "+difficulty);	
			if(difficulty<15&&x==2)
				System.out.print("DIFFICULT - "+difficulty);
			else
			{
				System.out.print("MEDIUM - "+difficulty);
			}
		}
		else if(type.contains("match"))
		{
			if(difficulty>80&&x==0)
			{
				System.out.print("EASY - "+difficulty);
			}
			else if(difficulty<15&&x==2)
			{
				System.out.print("DIFFICULT - "+difficulty);
			}
			else
			{
				if(hints>n/2)
				{
					difficulty-=(hints/n)*10;
				}
				if(difficulty<15)
					System.out.print("DIFFICULT - "+difficulty);
				else if(difficulty>80)
					System.out.print("EASY - "+difficulty);
				else
				System.out.print("MEDIUM - "+difficulty);
			}
		}
		}
		catch(Exception e)
		{
		}
		}
}
