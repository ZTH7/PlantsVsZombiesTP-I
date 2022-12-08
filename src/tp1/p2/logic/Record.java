package tp1.p2.logic;

import java.io.*;

import tp1.p2.control.Level;

import tp1.p2.control.exceptions.RecordException;

public class Record {
	private static String[] record;
	
	public static int ReadRecord(Level level) throws RecordException{
		int res = 0;
		try {
			FileReader reader = new FileReader("record.txt");
	 
	        StringBuffer sb = new StringBuffer();
	        while (reader.ready()) {
	            sb.append((char) reader.read());
	        }
	        record = sb.toString().split("\n");
	        
	        try {
		        for(String str : record) {
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
		    FileWriter writer = new FileWriter("record.txt");
	        boolean found = false;
	        for(String str : record) {
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
