//Write a java program to read/write data into the file.(Use File Output Stream, File InputStream).

//  import java.io.File;
//  import java.io.FileOutputStream;
//  import java.util.Scanner;

// import javax.xml.transform.Source;
//  public class Assig1 {
//   public static void main(String[] args) {
    
//      try{
//        Scanner sc=new Scanner(System.in);
//   File f = new File("D:\\user\\Desktop\\IOFilehandlig\\abc.txt");
//   if(!f.exists()){
//    f.createNewFile();
        
//    String s = "\nJava is robust programming language";
//  FileOutputStream fout = new FileOutputStream(f, true);

//    byte data[] = s.getBytes();

//     fout.write(data);
//       System.out.println("Operation Success...");
//      }
//       }catch(Exception e){
//           System.out.println(e);
// } }}
// import java.io.File;
// import java.io.FileInputStream;

// public class Assig1 {
//   public static void main(String[] args) {
//      try{
//          File f = new File("D:\\user\\Desktop\\IOFilehandlig\\abc.txt");
//          FileInputStream fin = new FileInputStream(f);

//          String data = "";
//          while(true){
//             int x =  fin.read();
//             if(x == -1)
//                 break;
//             data = data + (char)x;
//          }
//          System.out.println(data);
//      }   
//      catch(Exception e){
//          e.printStackTrace();
//      }
//   }


// }

import java.io.FileInputStream;
import java.util.Scanner;
class Assig1{
    public static void main(String[] args) {
        try{
            FileInputStream f=new FileInputStream("D:\\user\\Desktop\\IOFilehandlig\\abc.txt");
            int n;
            Scanner sc=new Scanner(f);
           //  System.out.println("")
           String s="";
          // while ((n=f.read())!=-1){
            while(sc.hasNextLine()){
             System.out.println(sc.nextLine()y);

           }
           
        }
         catch(Exception e){
            
         }
    }
}

















