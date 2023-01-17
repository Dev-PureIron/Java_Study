package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTask1 {
	public static void main(String[] args) throws IOException  {
		String [] laptops = {"맥북", "그램", "삼성", "hp", "게이밍노트북","삼보"};
		
//		순서 
//		출력 부터 bufferwrite
//		그리고 입력 bufferreade
//		리드때 오류잡고 파이널리 버퍼 널값이아닐대 버퍼 클로우즈
		
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/laptops.txt",true));
//		for (String laptop : laptops) {
//			bufferedWriter.write(laptop + "\n");
//		}
//		bufferedWriter.close();
		
		
//		BufferedReader bufferedReader = null;
//		String line = null;
//				
//		try {
//			bufferedReader = new BufferedReader(new FileReader("src/laptops.txt"));
//			while( (line =bufferedReader.readLine()) != null) {
//				System.out.println(line);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("잘못된 경로");
//		}finally {
//			if(bufferedReader != null) {
//				bufferedReader.close();
//			}
//		}

//		삼보를 맥북 프로로 변경 
//		BufferedReader bufferedReader = null;
//		String line = null, temp = null;
//		final String Target = "삼보";
//		
//		try {
//			bufferedReader = new BufferedReader(new FileReader("src/laptops.txt"));
//			while( (line = bufferedReader.readLine()) != null) {
//				if(line.equals(Target)) {
//					temp += "맥북프로\n";
//					continue;
//				}
//				temp += line + "\n";
//			}
//			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/laptops.txt"));
//			bufferedWriter.write(temp);
//			bufferedWriter.close();
//				
//		} catch (FileNotFoundException e) {
//			System.out.println("잘못된 경로");
//			e.printStackTrace();
//		} finally {
//			if(bufferedReader != null) {
//				bufferedReader.close();
//			}
//		}
		
		
		
//      피파2002 삭제
		BufferedReader bufferedReader = null;
		String line = null, temp = null;
		final String Target = "맥북프로";
		
		try {
			bufferedReader = new BufferedReader(new FileReader("src/laptops.txt"));
			while( (line = bufferedReader.readLine()) != null) {
				if(line.equals(Target)) {
					continue;
				}
				temp += line + "\n";
			}
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/laptops.txt"));
			bufferedWriter.write(temp);
			bufferedWriter.close();
				
		} catch (FileNotFoundException e) {
			System.out.println("잘못된 경로");
			e.printStackTrace();
		} finally {
			if(bufferedReader != null) {
				bufferedReader.close();
			}
		}
		
		
		
		
		}
	}
