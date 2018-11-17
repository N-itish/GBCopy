package com.nitish.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFunctions {
		//function to copy the files
		private String destination;
		public CopyFunctions(String destination) {
			this.destination = destination;
		}
		public void copyFiles(String fileName)  {
			File file = new File(fileName);
			if(file.exists())
			{
				try {
					
					System.out.println(file.getName());
					if(file.exists()) {
						InputStream is = new FileInputStream(file);
						OutputStream os = new FileOutputStream(new File(destination+"/"+file.getName()));
						byte[] bytechunk = new byte[1024];
						int length;
						while((length = is.read(bytechunk)) != -1) 
						{
							os.write(bytechunk, 0, length);
						}
					}
				} catch (Exception ioe) {
					// TODO Auto-generated catch block
					ioe.printStackTrace();
				}
			}
		}	
}
