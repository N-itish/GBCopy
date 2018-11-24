package com.nitish.Threads;

import java.io.File;

import com.nitish.DataStorage.DataStore;

public class DeleteThread extends Thread{
	private String destination;
	private File toDeleteFile;
	public DeleteThread(){
		destination  = DataStore.destination;
	}
	public void run()
	{
		delete();
	}
	public void delete() {
		//TODO :need to add logic for the file location array
		while(true) {
			toDeleteFile = new File(destination);
			if(toDeleteFile.delete()) {
				System.out.println(toDeleteFile.getName() + " "+ "File deleted!!!");
			}
		}
	}
}
