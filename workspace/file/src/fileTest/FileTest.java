package fileTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException{
		
		
//		���� ��� : ��𿡼� �ۼ��ص� ã�ư� �� �ִ� ���, C:/a/b 
//		��� ��� : ���� ��ġ�� ���� ����Ǵ� ���, ../a/b

//      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test.txt", true));
//      bufferedWriter.write("�ȳ�");
//      bufferedWriter.close();
      
      BufferedReader bufferedReader = null; 
      try {
         bufferedReader = new BufferedReader(new FileReader("src/test.txt"));
         String line = null;
         while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
         }
      } catch (FileNotFoundException e) {
         System.out.println("�߸��� ���");
      } finally {
         if(bufferedReader != null) {
            bufferedReader.close();
         }
      }
      
//      ���� ���� �� �پ��� ������ �߻��Ͽ�, 9���� ���� ���ʹ� ������� ���� close()�� ����!
//      System.gc();
//      System.runFinalization();
      
//      ���ϻ���
//      File file = new File("src/test.txt");
//      if (file.exists()) {
//         file.delete();
//      }

		
  }
	}
