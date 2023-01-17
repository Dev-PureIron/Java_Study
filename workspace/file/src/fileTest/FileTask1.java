package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTask1 {
	public static void main(String[] args) throws IOException  {
		String [] laptops = {"�ƺ�", "�׷�", "�Ｚ", "hp", "���ֳ̹�Ʈ��","�ﺸ"};
		
//		���� 
//		��� ���� bufferwrite
//		�׸��� �Է� bufferreade
//		���嶧 ������� ���̳θ� ���� �ΰ��̾ƴҴ� ���� Ŭ�ο���
		
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
//			System.out.println("�߸��� ���");
//		}finally {
//			if(bufferedReader != null) {
//				bufferedReader.close();
//			}
//		}

//		�ﺸ�� �ƺ� ���η� ���� 
//		BufferedReader bufferedReader = null;
//		String line = null, temp = null;
//		final String Target = "�ﺸ";
//		
//		try {
//			bufferedReader = new BufferedReader(new FileReader("src/laptops.txt"));
//			while( (line = bufferedReader.readLine()) != null) {
//				if(line.equals(Target)) {
//					temp += "�ƺ�����\n";
//					continue;
//				}
//				temp += line + "\n";
//			}
//			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/laptops.txt"));
//			bufferedWriter.write(temp);
//			bufferedWriter.close();
//				
//		} catch (FileNotFoundException e) {
//			System.out.println("�߸��� ���");
//			e.printStackTrace();
//		} finally {
//			if(bufferedReader != null) {
//				bufferedReader.close();
//			}
//		}
		
		
		
//      ����2002 ����
		BufferedReader bufferedReader = null;
		String line = null, temp = null;
		final String Target = "�ƺ�����";
		
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
			System.out.println("�߸��� ���");
			e.printStackTrace();
		} finally {
			if(bufferedReader != null) {
				bufferedReader.close();
			}
		}
		
		
		
		
		}
	}
