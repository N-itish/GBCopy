package com.nitish.MainProgram;
import java.io.File;
import com.nitish.DataStorage.DataStore;
import com.nitish.Threads.CopierThread;


public class Main {
	private static String source;
	private static String ERRORLOG = "C:\\Users\\Lenovo\\Desktop\\ErrorLog.txt";

	public static void main(String ...args)
	{  
		source = DataStore.source;
		GetFileLocations fileLocations = new GetFileLocations();
		System.out.println("Copying");
		//Selecting the source file
		File Sourcefile = new File(source);
		fileLocations.getAllFileLocation(Sourcefile);
		//Checking if there are more than 8 file so we don't waste the threads 
		if(DataStore.filePaths.size() >= 8)
		{
			//Creating 8 threads to write 8 different files
			for(int i = 0;i<8;i++)
			{
					CopierThread copierThread = new CopierThread(i,DataStore.filePaths.size()/8);
					copierThread.start();
			}
		}
		//If there is less than 8 files then a single thread is used to copy the files
		else
		{
			//Sending 0 to the thread to start from 0 to the last element of filePaths 
			CopierThread copierThread = new CopierThread(0,DataStore.filePaths.size());
			copierThread.start();
		}
		
	}
}
