package RandomAndDictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryReading {

	public static BufferedReader reader;
	
	private static boolean doesFileExist(String filename) throws IOException
	{
	  //Checking for file not found exception
	  try
	  {
	    reader = new BufferedReader(new FileReader(filename));
	    return true;
	  }
	  catch(FileNotFoundException e)
	  {
		  System.out.println("File not available at given location");
		  return false;
	  }
	}

	public static void main(String[] args) throws IOException {
		
		String path = System.getProperty("user.dir")+"\\src\\test\\dictionary.txt";
		if(doesFileExist(path))
		{
			String line;
			//Reading text file until end of file   
			while ((line=reader.readLine()) != null)
			{
				//Splitting line by -
				String word[] = line.split("–");
				for (String dictionary: word) 
				{
				 //Splitting meanings string by ,
				 String word1[] = dictionary.split(",");
			        for (String dictionary1: word1) 
			        {
				         System.out.println((dictionary1).trim()+"\n");
			        }
				}
				
			}
			//Closing reader
			reader.close();
		}
	}
}
