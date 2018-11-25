package com.nitish.Threads;
import com.nitish.DataStorage.DataStore;
import com.nitish.MainProgram.CopyFunctions;

public class CopierThread extends Thread{
	//This is the total chunk of files given to a thread
	private int fileChunks;
	//The indicator is used to distinguish the two threads 
	//And which chunks of files to write
	private int indicator;
	private int start;
	private int end;
	private CopyFunctions copier = new CopyFunctions(DataStore.destination);
	public CopierThread() {
		
	}
	public CopierThread(int indicator, int fileChunks){
		this.fileChunks = fileChunks;
		this.indicator = indicator;
	}
	public void run() {
		if(indicator == 0)
		{
			start = 0;
			end = fileChunks;
			System.out.println("Thread:"+Thread.currentThread().getName()+" "+start+ "--"  + end);
			for(int i = start;i<=end; i++)
			{
				System.out.println(Thread.currentThread().getName()+" "+DataStore.filePaths.get(i));
				copier.copyFiles(DataStore.filePaths.get(i));
			}
		}
		else if(indicator == 7)
		{
			start = fileChunks*indicator+1;
			end  = DataStore.filePaths.size();
			System.out.println("Thread:"+Thread.currentThread().getName()+" "+start+ "--"  + end);
			for(int i = start;i<end; i++)
			{
				System.out.println(Thread.currentThread().getName()+" "+DataStore.filePaths.get(i));
				copier.copyFiles(DataStore.filePaths.get(i));
				
			}
		}
		else
		{
			start = fileChunks*indicator+1;
			end = (start-1) +fileChunks;
			System.out.println("Thread:"+Thread.currentThread().getName()+" "+start+ "--"  + end);
			for(int i = start;i<=end; i++)
			{
				System.out.println(Thread.currentThread().getName()+" "+DataStore.filePaths.get(i));
				copier.copyFiles(DataStore.filePaths.get(i));
				
			}
		}
	}
}
