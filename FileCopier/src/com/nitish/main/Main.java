package com.nitish.main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.attribute.standard.Destination;

public class Main {
	static String source = "D:\\";
	static String destination = "C:\\Users\\Lenovo\\Desktop\\test.txt";
	static String seperateFilePattern = "['.'].*";
	static ArrayList<String> InitialFileName = new ArrayList<>();
	public static void main(String ...args)
	{
		
	
		System.out.println("Started");
		//Selecting the source file
		File Sourcefile = new File(source);
		//selecting the destination file
		File DestinationFile = new File(destination);
		//System.out.println(MatchFiles("D://asd"));
		getAllFileLocation(Sourcefile);
		Iterator<String> itr = InitialFileName.iterator();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(destination)));
			while(itr.hasNext())
			{
				writer.write(itr.next());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	//function for recursion
	//getting all the files in the directory, sub-directory and so on
	public static void getAllFileLocation(File Sourcefile) {
		for(File l : Sourcefile.listFiles())
		{
			if(!MatchFiles(l.getPath()))
			{
				System.out.println(l.getPath());
				InitialFileName.add(l.getPath());
			}
			try {
				getAllFileLocation(l);
			}catch(NullPointerException NulptrExc)
			{
				continue;
			}
		}
	}
	//function to copy the files
	public void copyFiles(File file) {
		try {
			InputStream is = new FileInputStream(file);
			OutputStream os = new FileOutputStream(new File(destination));
			byte[] bytechunk = new byte[1024];
			int length;
			while((length = is.read(bytechunk)) != -1) 
			{
				os.write(bytechunk, 0, length);
			}
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
	
	}	
	//function to match the pattern in the file location
	//Separating the folders and getting only the location of files with .pdf or .exe
	public static boolean MatchFiles(String StringToCheck) 
	{
		boolean isMatched = true;
		Pattern pattern = Pattern.compile(seperateFilePattern);
		Matcher matcher = pattern.matcher(StringToCheck);
		if(matcher.find()) {
			isMatched = false;
		}
		return isMatched;	
	}
}
