package com.nitish.Threads;
import com.nitish.DataStorage.DataStore;
import com.nitish.MainProgram.CopyFunctions;

public class CopierThread extends Thread{
	//
	private int totalFileSize;
	//The indicator is used to distinguish the two threads 
	private int indicator;
	private CopyFunctions copier = new CopyFunctions(DataStore.destination);
	public CopierThread() {
		
	}
	public CopierThread(int indicator, int fileListNo){
		this.totalFileSize = fileListNo;
		this.indicator = indicator;
	}
	public void run() {
		//This is for thread 1
		if(indicator == 0)
		{
			System.out.println(Thread.currentThread().getName() + " has Started!!");
			for(int i = 0;i<totalFileSize;i++)
			{
				System.out.println(Thread.currentThread().getName() + " "+DataStore.filePaths.get(i));
				copier.copyFiles(DataStore.filePaths.get(i));
			}
			
		}
		//This is for thread 2
		else if(indicator == 1)				
		{
			System.out.println(Thread.currentThread().getName() + " has Started!!");
			for(int i = totalFileSize+1;i<DataStore.filePaths.size();i++)
			{
				System.out.println(Thread.currentThread().getName() + " "+DataStore.filePaths.get(i));
				copier.copyFiles(DataStore.filePaths.get(i));
				
			}
			
		}
	}
}
