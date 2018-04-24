package my;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

public class SInput {
	public static void main(String[] args) {
		FileInputStream fis = null;
		StringBuilder s;
		StringTokenizer st;
		
		try {
			fis = new FileInputStream("Student.txt");
			int data;
			try {
				while((data=fis.read()) != -1) {
					s = new StringBuilder(data);
					st = new StringTokenizer(s.toString(),"/");
					for(int i=0; st.hasMoreTokens()==true; i++) {

					}
				}
			} catch (IOException e) {
				System.out.println("파일없어!");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null) fis.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

//	private static void StringTokenizer(char student) {
//		// TODO Auto-generated method stub
//		
//	}

}
