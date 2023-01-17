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
	
//  readallBytes 경로에 있는 바이트를 읽어준다.

	
//   추가
//				SalatyVO타입의 salaryVO 변수를 생성.
   public void insert(MySalaryVO salaryVO) throws IOException{
//	   버퍼를 사용한 출력클래스와 DB커넥터를 이어 사용한다.
      BufferedWriter bufferedWriter = DBConnecter.getAppend();
//      문자열 content에 문자열을 새롭게 메모리에 올린다. 파일의 경로에 있는 바이트를 읽어준다. 읽어주는 경로는 DB커넥터의 PATH를 읽는다.
      String content = new String(Files.readAllBytes(Paths.get(DBConnecter.PATH)));
//      문자열 temp를 초기화한다.
      String temp = null;
//      초기화한 temp에  content의 문자열 길이만큼 한글자씩 가져와 char타입으로 변환해 -1을 하여 줄을 바꿔 맞다면 ""을 해주고 틀리다면 "\n"을 하여 줄을 바꿔준다.
      temp = content.charAt(content.length() - 1) == '\n' ? "" : "\n";
//      temp에 salaryVO.toStriong을 더해준다.
      temp += salaryVO.toString();
//      버퍼 객체.write를 하여 temp를 작성한다.
      bufferedWriter.write(temp);
//     문을 닫아준다.
      bufferedWriter.close();
   }
   
//   수정(소득세)
   public void update(MySalaryVO salaryVO) throws IOException {
//	   버퍼를 사용한 입력클래스와 DB커넥터를 연결해 getreader를 사용해 입력한다.
      BufferedReader bufferedReader = DBConnecter.getReader();
//      문자열 라인은 null값, temp에는 빈 문자열을 초기화한다. temp에는 문자열을 더해줘야하기에 빈문자열로 초기화한다.
      String line = null, temp = "";
      
//      언제까지 반복을 해야할지 모르기에 와일문 작성. 버퍼 객체에서 한줄씩 출력해와 널값이 아니라면 
      while((line = bufferedReader.readLine()) != null) {
//    	  문자열 line에 스플릿메소드를 사용해 "   "기준점을 통해 인설트컴마와 salaryVO의 샐러리 값을 가져와 +만원을 비교한다.
         if(line.split("   ")[0].equals(insertComma(salaryVO.getSalary()) + "만원")) {
//         문자열 data객체를 생성해 line의 substring 0부터 line의 마지막 인덱스 
            String data = line.substring(0, line.lastIndexOf("   "));
            
//        temp에 data의 substring 0부터 data의 마지막 인덱스에 빈문자열(스페이스바x3) + 인설트콤마의 salaryVO의 소득세와 지방세를 더해준다.
            temp += data.substring(0, data.lastIndexOf("   ")) + "   " 
                  + insertComma(salaryVO.getIncomeTax()) + "   "
                  + insertComma(salaryVO.getLocalTax()) + "\n";
//            탈출 다음 반복 실행
            continue;
         }
//         temp에 line + 줄바꿈을 더해준다.
         temp += line + "\n";
      }
//      버퍼 출력클래스의 버퍼 객체를 DB커넥터에 덮어쓴다.
      BufferedWriter bufferedWriter = DBConnecter.getWriter();
//      버퍼 입력객체에 temp를 입력해준다.
      bufferedWriter.write(temp);
//      버퍼 입력객체를 닫아준다.
      bufferedWriter.close();
//      버퍼 출력객체를 닫아준다.
      bufferedReader.close();
   }
//   삭제
//   샐러리 클래스를 삭제해주기 때문에 샐러리 클래스 타입의 변수르 받는다.
   public void delete(MySalaryVO salaryVO) throws IOException {
//	   	버퍼 출력 클래스의 버퍼 출력객체를 DB커넥터 입력한다.
	      BufferedReader bufferedReader = DBConnecter.getReader();
//	      문자열 line 객체는 넑값, temp 에는 빈문자열을 초기화한다. temp에는 문자열에 더해줄 거기 때문에 빈문자열로 초기화
	      String line = null, temp = "";
//	      while문을 통해 반복. line은 버퍼입력객체에서 한줄씩 받아와 널값이 아니면 조건 ++
	      while((line = bufferedReader.readLine()) != null) {
//	    	만약 line 스플릿메소드의 "   "기준점을 통해 배열의 인덱스의 값을 비교해 인설트컴마","의 샐러리 값 +"만원"을 비교한다.
	         if(line.split("   ")[0].equals(insertComma(salaryVO.getSalary()) + "만원")) {
//	        	 문자열 data 값을 비교해 line substring 0부터 마지막 인덱스 "   "까지 넣어준다.
	            String data = line.substring(0, line.lastIndexOf("   "));
//	            탈출 후 다음 반복 진행
	            continue;
	         }
//	         tmep에 line + 줄바꿈을 더해준다.
	         temp += line + "\n";
	      }
//	      버퍼 입력 클래스의 입력객체를 생성해 DB커넥터 덮어쓴다.
	      BufferedWriter bufferedWriter = DBConnecter.getWriter();
//	      버퍼 입력객체에 temp를 입력한다.
	      bufferedWriter.write(temp);
	      
//	      버퍼 출력객체를 닫아준다.
	      bufferedWriter.close();
//	      버퍼 입력객체를 닫아준다.
	      bufferedReader.close();
	   }
   
//   조회
   	public String select(int salary) throws IOException {
//   		버퍼입력 클래스의 버퍼 입력 객체를 생성해 DB커넥터를 가져온다.
	      BufferedReader bufferedReader = DBConnecter.getReader();
//	      문자열 라인에 널값을 초기화 한다.
	      String line = null;
//	      while line에 버퍼 입력객체의 한줄씩 가져와 널값과 비교한다
	      while((line = bufferedReader.readLine()) != null) {
//	    	  만약 line값의 스플릿 메소드 "   "기준점을 통해 배열 0번방의 값을 insertcomma의 샐러리 값과 비교한다.
	    	  if(line.split("   ")[0].equals(insertComma(salary) + "만원")) {
//	    		  data = line의 substring 0부터 마지막인덱스 "   "까지 넣어준다.
		            String data = line.substring(0, line.lastIndexOf("   "));
//		            line을 리턴해준다.
		            return line;
		         }  
	      }
//	      널값을 리턴해준다.
   		return null;
   	}
   
//   목록
   public/*ArrayList<String>*/  String selectAll() throws IOException {
//	   	버퍼 입력 클래스의 입력객체를 생성해 DB커넥터를 연결한다.
	      BufferedReader bufferedReader = DBConnecter.getReader();
//	      ArrayList<String> arString = new ArrayList<String>();
//	      문자열 line에는 널값, temp에는 빈문자열을 초기화한다.
	      String line = null, temp = "";
//	      while문을 반복해 line에 버퍼 입력객체의 한줄씩 받아와 널값과 비교한다. --> 다음 줄이 널값이 나올 때 까지 반복하여 넣어준다.
	      while((line = bufferedReader.readLine()) != null) {
//	    	  arString.add(line +"\n");
//	    	  temp에 라인값과 줄바꿈을 더해준다.
	    	  temp += line +"\n";
	      }
//	      temp를 리턴한다.
	       return temp;
   	}
   	
//   	public void selectAll() throws IOException{
////   readallBytes 경로에 있는 바이트를 읽어준다.
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








