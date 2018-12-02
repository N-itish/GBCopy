package com.nitish.MainProgram;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nitish.DataStorage.DataStore;

public class GetFileLocations   {
	
	private String seperateFilePattern = ".*";
	
	//Recursive function that gets all the folder directories
	//as well as the sub directories
	public void getAllFileLocation(File Sourcefile) throws IOException {
			for(File l : Sourcefile.listFiles())
			{
					if(!MatchFiles(l.getPath()))
					{
						System.out.println(l.getPath());
						CreateDirectory(l.getPath());
						DataStore.filePaths.add(l.getPath());
						
					}
					try
					{
						getAllFileLocation(l);
					}
					catch(NullPointerException NulptrExc)
					{
						continue;
					}
			}
	}
	private void CreateDirectory(String filepath) {
		
		String newPath = filepath.replaceAll("^[a-zA-Z]:","");
		//System.out.println(newPath);
		File file = new File(DataStore.destination+newPath);
		System.out.println(file.getParentFile());
		if(!file.getParentFile().exists())
		{
			file.mkdirs();
		}
		
	}
	private boolean MatchFiles(String StringToCheck) 
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
