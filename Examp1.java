// import java.io.File;
  
// public class Examp1
// {
//     public static void main(String[] args) {
//         // taking the file or directory as a input 
//         // from the command line argument (args)
//        // String fname ="";
//         // passing the file or directory name to File object
//         File f = new File("D:\\user\\Desktop");
//         // applying the methods of the File 
//         // class on the File object
//         System.out.println("File name - "+f.getName());
//         System.out.println("Path - "+f.getPath());
//         System.out.println("Absolute path - " +f.getAbsolutePath());
//         System.out.println("Parent - "+f.getParent());
//         System.out.println("Exists - "+f.exists());
          
//     if(f.exists())
//         {
//             System.out.println("Is writable - "+f.canWrite());
//             System.out.println("Is readable - "+f.canRead());
//             System.out.println("Is a directory - "+f.isDirectory());
//             System.out.println("File Size in bytes "+f.length());
//         }
//     }
// }
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

class Admin2 {
    private ArrayList<Map<String, String>> accountOpen = new ArrayList<>();
    private final String password = "12345";

    public void adminLoginProcedure() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <= 2; i++) {
            System.out.print("Enter the password: ");
            String adminPassword = sc.nextLine();
            if (password.equals(adminPassword)) {
                System.out.println("------------------------YOU ARE SUCCESSFULLY LOGIN---------------------------");
                return;
            } else if (i >= 1000) {
                System.out.println("|------------------------------------------------------------|");
                System.out.println("You've attempted multiple times. Please try again later.");
                System.out.println("|------------------------------------------------------------|");
                return;
            } else {
                System.out.println("WARNING: WRONG PASSWORD");
            }
        }
    }

    public void manageCustomerDetail() {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("|------------------------------------------------------------|");
            System.out
                    .println("PRESS : [1]  for account opening" + "\t\t" + "PRESS :   [3] REMOVE OR BLOCK ACCOUNT ");
            System.out.println("|------------------------------------------------------------|");
            System.out.println("PRESS : [2]  for VIEW PARTICULAR ACCOUNT INFO" + "\t\t"
                    + "PRESS :   [4]  VIEW ALL ACCOUNT LIST");
            System.out.println("|------------------------------------------------------------|");
            System.out.println("PRESS :   [5] FOR EXIT");
            System.out.println("|------------------------------------------------------------|");
            System.out.println("Select the following option:");
            System.out.println("--------------------------------------------------------------");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    Map<String, String> customerInfo = new HashMap<>();
                    //sc.nextLine(); // consume newline

                    System.out.println("Enter the customer name:");
                    customerInfo.put("Customer Name", sc.nextLine());
                     customerInfo.put("Customer Name", sc.nextLine());

                    System.out.println("Customer account number:");
                    customerInfo.put("Customer Account Number", sc.nextLine());

                    System.out.println("Enter the mobile number:");
                    customerInfo.put("Mobile Number", sc.nextLine());

                    System.out.println("Enter Customer GmailID:");
                    customerInfo.put("Gmail", sc.nextLine());

                    System.out.println("Enter the minimum account opening amount:");
                    customerInfo.put("Money", sc.nextLine());

                    String m="5000";
                    if (customerInfo.get("Money").equals(m)) {
                        accountOpen.add(customerInfo);
                    }else{
                        System.out.println("---------------- SORRY I DONT OPEN YOUR ACCOUNT PLESE DEPOSITE MINIMUM AMMOUNT ATLEST 5000-----------");
                    }

                    //accountOpen.add(customerInfo);
                    break;

                case 2:
                if(accountOpen.size()<=0){
                    System.out.println("No such account available");
                }
                    else{
                    System.out.println("Enter user account number: ");
                    String acNumber = sc.next();
                    boolean accountFound = false;
                    
                    for (Map<String, String> account : accountOpen) {
                        if (account.get("Customer Account Number").equals(acNumber)) {
                            System.out.println("Account details: " + account);
                            accountFound = true;
                            break;
                        }
                    }
                 
                    if (!accountFound) {
                        System.out.println("Wrong account number.");
                    }
                }
                    break;

                case 3:
                 System.out.println("which one account you will block");
                 String acnumber = sc.nextLine();
                 boolean accountFounD = false;
                 for (Map<String,String> block : accountOpen) {
                    if(block.get("Customer Account Number").equals(acnumber)){
                        System.out.println("BLOCK :"+block.remove("Customer Account Number"));
                        accountFounD = true;
                        System.out.println(" Re move succesfully ");
                    }
                 }
                 if (!accountFounD) {
                    System.out.println("block this perticular account number");
                 }
                 //accountOpen.remove("Customer Account Number");
                    System.out.println("account number successfully blocked");
                    break;
                case 4:
                    System.out.println("You have " + accountOpen.size() + " users");
                    for (int i = 0; i < accountOpen.size(); i++) {
                        System.out.println(i + " -> Account details: " + accountOpen.get(i));
                    }
                    break;

                case 5:
                System.out.println("SUCCESSFULLY EXIT");
                System.out.println("THANKS FOR VISIT");
                default:
                    break;
            }
        } while (option != 5);
        sc.close();
    }

    public static void main(String[] args) {
        Admin2 obj = new Admin2();
        System.out.println("--------------------USER-ADMIN----------------------");
        System.out.println("----------------------LOGIN-------------------------");
        obj.adminLoginProcedure();
        System.out.println("----------------------------------------------------");
        obj.manageCustomerDetail();
   }
}