package com.demo.slk.java7;

import java.io.IOException;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WathcherService {

	public static void main(String str[]){
		
		Path path=FileSystems.getDefault().getPath("/Users/ravi/Desktop/testFiles");
		try(WatchService watcher=FileSystems.getDefault().newWatchService()){
			WatchKey watchKey=path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE) ;
			System.out.println("Before for loop watch key "+watchKey);
			for(;;){
				WatchKey key=watcher.take();
				if(key.equals(watchKey)){
					for(WatchEvent event:key.pollEvents()){
						System.out.println("Path --> "+path +" Event count -> "+event.count()+" new files created - >"+event.context());
					}
				}
			}
		}
		catch(ClosedWatchServiceException | IOException ex){
			ex.printStackTrace();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
