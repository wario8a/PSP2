package FileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class FileManager {
	
	public static LinkedList<String> ReadFile(String pathFile){
		
		LinkedList<String> _LinkedList = new LinkedList<String>();
		
		BufferedReader br = null;
		try {
			
		br = new BufferedReader(new FileReader(pathFile));

		    String line = br.readLine();

		    while (line != null) {
		        _LinkedList.add(line);
		        line = br.readLine();
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return _LinkedList;
	}
	
	public static LinkedList<String> SearchFileByExetension(String pathFile, String extension){
		
		LinkedList<String> linkedList = new LinkedList<String>();
		File dir = new File(pathFile);
		
		for (File file : dir.listFiles()) {
			if(file.isFile()){
				if (file.getName().endsWith((extension))) {
					linkedList.add(file.getPath());
				}
			}else if(file.isDirectory()){
				LinkedList<String> subFile = SearchFileByExetension(file.getAbsolutePath(),extension);
				
				for (String item : subFile)
					linkedList.add(item);
			}
		}
		
		return linkedList;
	}

	
}