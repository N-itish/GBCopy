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

import javax.print.attribute.standard.Destination;

public class Main {
	static String source = "D:\\";
	static String destination = "C:\\Users\\Lenovo\\Desktop\\test.txt";
	static ArrayList<String> InitialFileName = new ArrayList<>();
	public static void main(String ...args)
	{
		
	
		System.out.println("Started");
		//Selecting the source file
		File Sourcefile = new File(source);
		//selecting the destination file
		File DestinationFile = new File(destination);
		
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
	public static void getAllFileLocation(File Sourcefile) {
		for(File l : Sourcefile.listFiles())
		{
			if(l.getPath().contains("."))
			{
				InitialFileName.add(l.getPath());
			}
			try {
				getAllFileLocation(l);
				System.out.println("added: " + l.getPath());
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
}
