
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


import java.io.Serializable;

 class Customer implements Serializable{
 // private static final long SerialVersionUID = 10l;

  private int id;
  private String name;
  private int age;
  private String mobile;
  //private char gender;
    public Customer(int id, String name, int age, String mobile) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile = mobile;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
public class Examp2  {
  public static void main(String[] args) {
     try{
         File f = new File("D:\\user\\Desktop");

         if(!f.exists())
             f.createNewFile();

         FileOutputStream fos = new FileOutputStream(f);

         ObjectOutputStream oos = new ObjectOutputStream(fos);

         Customer c = new Customer(100, "Cheeku Singh", 21, "9009111222");

            oos.writeObject(c);

         System.out.println("Operation success...");

     }
     catch(IOException e){
         e.printStackTrace();
     }
  }
}