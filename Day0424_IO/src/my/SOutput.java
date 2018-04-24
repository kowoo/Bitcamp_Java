package my;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SOutput {
	public static void main(String[] args) {
		FileOutputStream fos=null;
		String msg = "newbie2/2/99";
		
		try {
			fos = new FileOutputStream("Student2.txt");
			byte[] bytes = msg.getBytes();
			fos.write(bytes);
		} catch(FileNotFoundException e) {
			System.out.println("파일없어!");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos!=null) fos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
