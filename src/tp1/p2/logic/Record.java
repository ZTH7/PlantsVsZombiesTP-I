package tp1.p2.logic;

import java.io.*;

import tp1.p2.control.Level;

import tp1.p2.control.exceptions.RecordException;

public class Record {
	
	public static int ReadRecord(Level level) throws RecordException{
		int res = 0;
		try {
			FileReader reader = new FileReader("record.txt");
	 
	        StringBuffer sb = new StringBuffer();
	        while (reader.ready()) {
	            sb.append((char) reader.read());
	        }
	        String[] strs = sb.toString().split("\n");
	        
	        try {
		        for(String str : strs) {
		        	if(level.name().equalsIgnoreCase(str.split(":")[0])) res = Integer.parseInt(str.split(":")[1]);
		        }
	        } catch(NumberFormatException nfe) {
	        	throw new RecordException(nfe);
	        } finally {
		        reader.close();     	
	        }
	        
		} catch(IOException e) {
			throw new RecordException(e);
		}
		return res;
	}
	
	public static void WriteRecord(String level, int score) throws RecordException{
		try {
			FileReader reader = new FileReader("record.txt");
		 
		    StringBuffer sb = new StringBuffer();
	        while (reader.ready()) {
	            sb.append((char) reader.read());
	        }
	        String[] strs = sb.toString().split("\n");
		    reader.close();

		    FileWriter writer = new FileWriter("record.txt");
	        boolean found = false;
	        for(String str : strs) {
			    if(!found && level.equalsIgnoreCase(str.split(":")[0])) {
			    	found = true;
			    	writer.append(level + ":" + score + "\n");
			    }
			    else writer.append(str + "\n");
	        }
	        if(!found) writer.append(level + ":" + score + "\n");
		    writer.close();
		}catch(IOException e) {
			throw new RecordException(e);
		}
	}
}
