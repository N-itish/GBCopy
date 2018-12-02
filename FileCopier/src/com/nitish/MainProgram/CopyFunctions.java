package com.nitish.MainProgram;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFunctions {
		//function to copy the files
		private String destination = null;
		public CopyFunctions(String destination) {
			this.destination = destination;
		}
		public void copyFiles(String fileName)  {
			File file = new File(fileName);
			if(file.exists())
			{
				try {
					if(file.exists()) {
						String newDestinationDirectory = fileName.replaceAll("^[a-zA-Z]:","");
						System.out.println(destination+newDestinationDirectory);
						InputStream is = new FileInputStream(file);
						OutputStream os = new FileOutputStream(new File(destination+newDestinationDirectory));
						byte[] bytechunk = new byte[2048];
						int length;
						while((length = is.read(bytechunk)) != -1) 
						{
							os.write(bytechunk, 0, length);
						}
						os.close();
						is.close();
					}
				} catch (Exception ioe) {
					// TODO Auto-generated catch block
					ioe.printStackTrace();
				}
			}
		}	
}
