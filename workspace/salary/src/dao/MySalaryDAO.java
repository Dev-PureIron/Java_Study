package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import domain.MySalaryVO;

public class MySalaryDAO {
	
//  readallBytes ��ο� �ִ� ����Ʈ�� �о��ش�.

	
//   �߰�
//				SalatyVOŸ���� salaryVO ������ ����.
   public void insert(MySalaryVO salaryVO) throws IOException{
//	   ���۸� ����� ���Ŭ������ DBĿ���͸� �̾� ����Ѵ�.
      BufferedWriter bufferedWriter = DBConnecter.getAppend();
//      ���ڿ� content�� ���ڿ��� ���Ӱ� �޸𸮿� �ø���. ������ ��ο� �ִ� ����Ʈ�� �о��ش�. �о��ִ� ��δ� DBĿ������ PATH�� �д´�.
      String content = new String(Files.readAllBytes(Paths.get(DBConnecter.PATH)));
//      ���ڿ� temp�� �ʱ�ȭ�Ѵ�.
      String temp = null;
//      �ʱ�ȭ�� temp��  content�� ���ڿ� ���̸�ŭ �ѱ��ھ� ������ charŸ������ ��ȯ�� -1�� �Ͽ� ���� �ٲ� �´ٸ� ""�� ���ְ� Ʋ���ٸ� "\n"�� �Ͽ� ���� �ٲ��ش�.
      temp = content.charAt(content.length() - 1) == '\n' ? "" : "\n";
//      temp�� salaryVO.toStriong�� �����ش�.
      temp += salaryVO.toString();
//      ���� ��ü.write�� �Ͽ� temp�� �ۼ��Ѵ�.
      bufferedWriter.write(temp);
//     ���� �ݾ��ش�.
      bufferedWriter.close();
   }
   
//   ����(�ҵ漼)
   public void update(MySalaryVO salaryVO) throws IOException {
//	   ���۸� ����� �Է�Ŭ������ DBĿ���͸� ������ getreader�� ����� �Է��Ѵ�.
      BufferedReader bufferedReader = DBConnecter.getReader();
//      ���ڿ� ������ null��, temp���� �� ���ڿ��� �ʱ�ȭ�Ѵ�. temp���� ���ڿ��� ��������ϱ⿡ ���ڿ��� �ʱ�ȭ�Ѵ�.
      String line = null, temp = "";
      
//      �������� �ݺ��� �ؾ����� �𸣱⿡ ���Ϲ� �ۼ�. ���� ��ü���� ���پ� ����ؿ� �ΰ��� �ƴ϶�� 
      while((line = bufferedReader.readLine()) != null) {
//    	  ���ڿ� line�� ���ø��޼ҵ带 ����� "   "�������� ���� �μ�Ʈ�ĸ��� salaryVO�� ������ ���� ������ +������ ���Ѵ�.
         if(line.split("   ")[0].equals(insertComma(salaryVO.getSalary()) + "����")) {
//         ���ڿ� data��ü�� ������ line�� substring 0���� line�� ������ �ε��� 
            String data = line.substring(0, line.lastIndexOf("   "));
            
//        temp�� data�� substring 0���� data�� ������ �ε����� ���ڿ�(�����̽���x3) + �μ�Ʈ�޸��� salaryVO�� �ҵ漼�� ���漼�� �����ش�.
            temp += data.substring(0, data.lastIndexOf("   ")) + "   " 
                  + insertComma(salaryVO.getIncomeTax()) + "   "
                  + insertComma(salaryVO.getLocalTax()) + "\n";
//            Ż�� ���� �ݺ� ����
            continue;
         }
//         temp�� line + �ٹٲ��� �����ش�.
         temp += line + "\n";
      }
//      ���� ���Ŭ������ ���� ��ü�� DBĿ���Ϳ� �����.
      BufferedWriter bufferedWriter = DBConnecter.getWriter();
//      ���� �Է°�ü�� temp�� �Է����ش�.
      bufferedWriter.write(temp);
//      ���� �Է°�ü�� �ݾ��ش�.
      bufferedWriter.close();
//      ���� ��°�ü�� �ݾ��ش�.
      bufferedReader.close();
   }
//   ����
//   ������ Ŭ������ �������ֱ� ������ ������ Ŭ���� Ÿ���� ������ �޴´�.
   public void delete(MySalaryVO salaryVO) throws IOException {
//	   	���� ��� Ŭ������ ���� ��°�ü�� DBĿ���� �Է��Ѵ�.
	      BufferedReader bufferedReader = DBConnecter.getReader();
//	      ���ڿ� line ��ü�� ����, temp ���� ���ڿ��� �ʱ�ȭ�Ѵ�. temp���� ���ڿ��� ������ �ű� ������ ���ڿ��� �ʱ�ȭ
	      String line = null, temp = "";
//	      while���� ���� �ݺ�. line�� �����Է°�ü���� ���پ� �޾ƿ� �ΰ��� �ƴϸ� ���� ++
	      while((line = bufferedReader.readLine()) != null) {
//	    	���� line ���ø��޼ҵ��� "   "�������� ���� �迭�� �ε����� ���� ���� �μ�Ʈ�ĸ�","�� ������ �� +"����"�� ���Ѵ�.
	         if(line.split("   ")[0].equals(insertComma(salaryVO.getSalary()) + "����")) {
//	        	 ���ڿ� data ���� ���� line substring 0���� ������ �ε��� "   "���� �־��ش�.
	            String data = line.substring(0, line.lastIndexOf("   "));
//	            Ż�� �� ���� �ݺ� ����
	            continue;
	         }
//	         tmep�� line + �ٹٲ��� �����ش�.
	         temp += line + "\n";
	      }
//	      ���� �Է� Ŭ������ �Է°�ü�� ������ DBĿ���� �����.
	      BufferedWriter bufferedWriter = DBConnecter.getWriter();
//	      ���� �Է°�ü�� temp�� �Է��Ѵ�.
	      bufferedWriter.write(temp);
	      
//	      ���� ��°�ü�� �ݾ��ش�.
	      bufferedWriter.close();
//	      ���� �Է°�ü�� �ݾ��ش�.
	      bufferedReader.close();
	   }
   
//   ��ȸ
   	public String select(int salary) throws IOException {
//   		�����Է� Ŭ������ ���� �Է� ��ü�� ������ DBĿ���͸� �����´�.
	      BufferedReader bufferedReader = DBConnecter.getReader();
//	      ���ڿ� ���ο� �ΰ��� �ʱ�ȭ �Ѵ�.
	      String line = null;
//	      while line�� ���� �Է°�ü�� ���پ� ������ �ΰ��� ���Ѵ�
	      while((line = bufferedReader.readLine()) != null) {
//	    	  ���� line���� ���ø� �޼ҵ� "   "�������� ���� �迭 0������ ���� insertcomma�� ������ ���� ���Ѵ�.
	    	  if(line.split("   ")[0].equals(insertComma(salary) + "����")) {
//	    		  data = line�� substring 0���� �������ε��� "   "���� �־��ش�.
		            String data = line.substring(0, line.lastIndexOf("   "));
//		            line�� �������ش�.
		            return line;
		         }  
	      }
//	      �ΰ��� �������ش�.
   		return null;
   	}
   
//   ���
   public/*ArrayList<String>*/  String selectAll() throws IOException {
//	   	���� �Է� Ŭ������ �Է°�ü�� ������ DBĿ���͸� �����Ѵ�.
	      BufferedReader bufferedReader = DBConnecter.getReader();
//	      ArrayList<String> arString = new ArrayList<String>();
//	      ���ڿ� line���� �ΰ�, temp���� ���ڿ��� �ʱ�ȭ�Ѵ�.
	      String line = null, temp = "";
//	      while���� �ݺ��� line�� ���� �Է°�ü�� ���پ� �޾ƿ� �ΰ��� ���Ѵ�. --> ���� ���� �ΰ��� ���� �� ���� �ݺ��Ͽ� �־��ش�.
	      while((line = bufferedReader.readLine()) != null) {
//	    	  arString.add(line +"\n");
//	    	  temp�� ���ΰ��� �ٹٲ��� �����ش�.
	    	  temp += line +"\n";
	      }
//	      temp�� �����Ѵ�.
	       return temp;
   	}
   	
//   	public void selectAll() throws IOException{
////   readallBytes ��ο� �ִ� ����Ʈ�� �о��ش�.
//	System.out.println(new String(Files.readAllBytes(Paths.get(DBConnecter.PATH))));
//   	}
   	
   public static String insertComma(int number) {
      String temp = String.valueOf(number);
      String result = "";
      
      for (int i = 0; i < temp.length(); i++) {
         if(i != 0 && i % 3 == 0) {
            result = "," + result;
         }
         result = temp.charAt(temp.length() - 1 - i) + result;
      }
      return result;
   }
   
}








