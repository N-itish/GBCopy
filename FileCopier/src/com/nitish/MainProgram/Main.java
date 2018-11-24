package com.nitish.MainProgram;
import java.io.File;
import com.nitish.DataStorage.DataStore;
import com.nitish.Threads.CopierThread;


public class Main {
	private static String source;
	private static String Logdestination = "C:\\Users\\Lenovo\\Desktop\\test.txt";
	private static String ERRORLOG = "C:\\Users\\Lenovo\\Desktop\\ErrorLog.txt";
//	private static long StartTime;
//	private static long StopTime;
	public static void main(String ...args)
	{  
		source = DataStore.source;
		GetFileLocations fileLocations = new GetFileLocations();
		System.out.println("Copying");
		//Selecting the source file
		File Sourcefile = new File(source);
		fileLocations.getAllFileLocation(Sourcefile);
//		for(int i = 0;i < DataStore.filePaths.size();i++)
//		{
//			System.out.println(DataStore.filePaths.get(i));
//		}
		//Creating the Threads - for now only two threads will be used
		for(int i = 0;i<2;i++)
		{
				CopierThread copierThread = new CopierThread(i,DataStore.filePaths.size()/2);
				copierThread.start();
		}
		
	}
}
