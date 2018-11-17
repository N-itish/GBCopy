package com.nitish.main;
import java.io.File;
import java.util.ArrayList;

import com.nitish.DataStorage.DataStore;
import com.nitish.main.CopyFunctions;

public class Main {
	private static String source = "E:\\";
	private static String destination = "C:\\Users\\Lenovo\\Desktop\\test\\";
	private static String Logdestination = "C:\\Users\\Lenovo\\Desktop\\test.txt";
	private static String ERRORLOG = "C:\\Users\\Lenovo\\Desktop\\ErrorLog.txt";
	
	public static void main(String ...args)
	{
		CopyFunctions copier  = new CopyFunctions(destination);
		GetFileLocations fileLocations = new GetFileLocations(destination);
		System.out.println("Started");
		//Selecting the source file
		File Sourcefile = new File(source);
		fileLocations.getAllFileLocation(Sourcefile);
		for(String filePath: new ArrayList<>(DataStore.FilePaths))
		{
			copier.copyFiles(filePath);
		}
	}
}
