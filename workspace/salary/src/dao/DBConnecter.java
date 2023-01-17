package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DBConnecter {
//	상수 PATH를 선언해 PATH를 salary.txt를 연결한다.
   public static final String PATH = "salary.txt";
   
   public static BufferedWriter getWriter() throws IOException {
      return new BufferedWriter(new FileWriter(PATH));
   }
   
   public static BufferedWriter getAppend() throws IOException {
      return new BufferedWriter(new FileWriter(PATH, true));
   }
   
   public static BufferedReader getReader() throws IOException {
      return new BufferedReader(new FileReader(PATH));
   }
}




















