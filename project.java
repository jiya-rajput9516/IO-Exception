//*************BANK*********************
import java.util.Scanner; 
class BankProj {
  private static final String RESET = "\u001B[0m";
  private static final String YELLOW = "\u001B[33m";
  private static final String RED = "\u001B[31m";
  private static final String GREEN = "\u001B[32m";
  private static final String BLUE = "\u001B[34m"; 
  private String cName,accNum,mobNum,gmlId;
  private double amt;
  
  private static int index=-1;
  public BankProj(){
    
  }
  //obj[index]=new BankProj(cN,cAN,mobN,gM,amt);
  public BankProj(String cName,String accNum,String mobNum,String gmlId,double amt){
	  this.cName=cName;
	  this.accNum=accNum;
	  this.mobNum=mobNum;
	  this.gmlId=gmlId;
	  this.amt=amt;
  }
  
  public void setCName(String cName){
	  this.cName=cName;
  }
  public void setMobNo(String mobNum){
	  this.mobNum=mobNum;
  }
   public void setCG(String gmlId){
	  this.gmlId=gmlId;
  }
  
   public void setCAll(String cName,String mobNum,String gmlId){
	  this.cName=cName;
	  this.mobNum=mobNum;
	  this.gmlId=gmlId;
  }
  
  //1 Application
  private static final String password = "Abc123";

  static void application( BankProj obj[]){
    Scanner sc = new Scanner(System.in);
    while(true){
    System.out.println("\n\n\t\t\t\t\t***WELCOME TO BANK APPLICATION***\n\n");
    System.out.println("\t-----------------\t\t\t-----------------\t\t\t-----------------");
    System.out.println(YELLOW+"\t 1) Admin Login   \t\t\t 2) User Login   \t\t\t   0) Exit  "+RESET);
    System.out.println("\t-----------------\t\t\t-----------------\t\t\t-----------------\n");
    System.out.print("\t\tEnter the choice: ");
    int ch=sc.nextInt();
    switch(ch){
      case 1:
      for (int i = 0; i <= 5; i++) {
       System.out.print("\t\tEnter the password: ");
       String adminPassword = sc.next();
       if (password.equals(adminPassword)) {
         System.out.println("\t\t------------------------YOU ARE SUCCESSFULLY LOGIN---------------------------");
         break;
      } 
      else if (i>=5) {       System.out.println("\t\t---------------------------------------------------------");
        System.out.println("\t\tYou've attempted multiple times. Please try again later.");
        System.out.println("---------------------------------------------------------");
         break;
      } 
      else{
        System.out.println(RED+"\t\tWARNING: WRONG PASSWORD"+RESET);
      }
     } 
      admin(obj);
     break;
      
      case 2:
       customer(obj); 
      break;
      
      case 0:
        System.out.println(GREEN+"\t\t---SUCCESSFULLY EXIT---"+RESET);
        System.out.println(GREEN+"\t\t---THANKS FOR VISIT---"+RESET);
        System.exit(0);
      break;
      
      default:
        System.out.println(RED+"\t\t---Invalid choise---"+RESET);
    }
   }
  }
  //2------------------- Admin page------------------------
  static void admin( BankProj obj[]){
    Scanner sc = new Scanner(System.in);
    while(true){
     System.out.println("\n\n\t\t\t\t\t***WELCOME TO ADMIN PAGE***\n\n");
     System.out.println("\t-----------------\t-----------------\t-----------------\t-----------------\t-----------------");
     System.out.println(YELLOW+"\t1)Create Customer\t2)View Account\t\t3)Remove/Block\t\t4)View ALL \t\t0)Exit/Logout"+RESET);
     System.out.println("\t-----------------\t-----------------\t-----------------\t-----------------\t-----------------");
     System.out.print("\t\tEnter the choice: ");
     int ch=sc.nextInt();
     switch(ch){
      case 1:
	   System.out.println("\t---------------------------------------------------");
       System.out.println(YELLOW+"\tOpening blance is 5000"+RESET);
       System.out.println("\t---------------------------------------------------");
       
       System.out.print("\tEnter the customer name: ");
	     sc.nextLine();
       //String cn=sc.nextLine();
	     String cN=sc.nextLine();
       System.out.println(YELLOW+"\t---------------------------------------------------"+RESET);
      System.out.print("\tCustomer account number: ");
      String cAN=sc.nextLine();
       System.out.println(YELLOW+"\t---------------------------------------------------"+RESET);
      System.out.print("\tEnter the mobile number: ");
      String mobN=sc.nextLine();
       System.out.println(YELLOW+"\t---------------------------------------------------"+RESET);
      System.out.print("\tEnter Customer GmailID: ");
      String gM=sc.nextLine();
       System.out.println(YELLOW+"\t---------------------------------------------------"+RESET);
      System.out.print("\tEnter the minimum account opening amount: ");
      double amt=sc.nextDouble();
       System.out.println(YELLOW+"\t---------------------------------------------------"+RESET);      
	  if(amt<5000){
		   System.out.println(RED+"\t---------------- SORRY I DONT OPEN YOUR ACCOUNT PLEASE DEPOSITE MINIMUM AMMOUNT ATLEST 5000----------------"+RESET);
           continue;
	   }
	  else{
		 // System.out.println(index);
		  ++index;
		 // System.out.println(index);
         obj[index]=new BankProj(cN,cAN,mobN,gM,amt);
		 System.out.println(YELLOW+"\t----------------SUCCESSFULLY  YOUR ACCOUNT IS----------------"+RESET);
	  }
	  
       break;
      case 2:
       System.out.println("\n");
	   System.out.println("\t   View Account ");
       System.out.println(YELLOW+"\t-----------------------------------------------------------------"+RESET);
       System.out.print("\tenter account number: ");
	   sc.nextLine();
	   String acc=sc.nextLine();
	   boolean flag=true;
	   for(int i=0;i<=index;i++){
		  if(acc.equals(obj[i].accNum)){
	   	   flag=false;
		   System.out.println("\n\n\tCustomer Name\t    AccNo.\t\t  MobileNo.     \t Gmail\t\t     Amount    ");
           System.out.println(YELLOW+"\t------------------------------------------------------------------------------------------------------------------"+RESET);
		   System.out.printf("\t%-20s %-20s %-20s %-20s %f\n ",obj[i].cName,obj[i].accNum,obj[i].mobNum,obj[i].gmlId,obj[i].amt);
            break;
	   }
	   }
	   if(flag)
		    System.out.println(RED+"\tNot Found"+RESET);
        break;
      
	  case 3:
	   flag=true;
	   int pos=0;
	   if(index==-1){
		   System.out.println("\tNo Account Present");
		   break;
	   }
	   else{
		System.out.print("\tenter account number: ");
	    sc.nextLine();
	    acc=sc.nextLine();
	    for(int i=0;i<=index;i++){
		   if(acc.equals(obj[i].accNum)){
	   	    flag=false;
           // System.out.println(YELLOW+"\t----Found----\n"+RESET);
		    pos=i;
		    break;
	      }
	   }
		if(flag)
		    System.out.println(RED+"\tNot Found"+RESET);
		else{
		  for(int i=pos;i<index;i++)
			  obj[i]=obj[i+1];
		  index=index-1;
		  System.out.println(YELLOW+"\t----Account Removed /Block----\n"+RESET);	
		}
	   }
       break;
     
	 case 4:
	  System.out.println("\n");
	  System.out.println("\tCustomer Name\t    AccNo.\t\t  MobileNo.     \t Gmail\t\t     Amount    ");
         System.out.println(YELLOW+"\t------------------------------------------------------------------------------------------------------------------"+RESET);
      for(int i=0;i<=index;i++){
		  System.out.printf("\t%-20s %-20s %-20s %-20s %f\n ",obj[i].cName,obj[i].accNum,obj[i].mobNum,obj[i].gmlId,obj[i].amt);
         System.out.println(YELLOW+"\t------------------------------------------------------------------------------------------------------------------"+RESET);
	   }
        break;
      case 0:
        System.out.println(GREEN+"\t\t---SUCCESSFULLY EXIT ADMIN PAGE---"+RESET);
        System.out.println(GREEN+"\t\t---THANKS FOR VISIT---"+RESET);
      break;
      
      default:
        System.out.println(RED+"\t\t---Invalid choise---"+RESET);
    }
    if(ch==0)
      break;
   }
  }
  //3------------------- Customer page---------------------------
  static void customer( BankProj obj[]){
    Scanner sc = new Scanner(System.in);
    while(true){
     System.out.println("\n\n\t\t\t\t\t***WELCOME TO CUSTOMER PAGE***\n\n");
     System.out.println("\t-----------------\t-----------------\t-----------------\t---------------------");
     System.out.println(YELLOW+"\t1)View Details\t\t2)Update Details\t3)Apply for loan\t4)View loan statement"+RESET);
     System.out.println("\t-----------------\t-----------------\t-----------------\t---------------------");
     System.out.println("\n\n\t\t-----------------\t----------------------\t\t-----------------");
     System.out.println(YELLOW+"\t\t5)Transfer Money\t6)Transaction History\t\t0)Exist/Logout"+RESET);
     System.out.println("\t\t-----------------\t----------------------\t\t-----------------");
     System.out.print("\n\n\t\tEnter the choice: ");
     int ch=sc.nextInt();
     switch(ch){
      case 1:
        System.out.println("\n");
	   System.out.println("\t   View Details ");
       System.out.println(YELLOW+"\t-----------------------------------------------------------------"+RESET);
       System.out.print("\tenter account number: ");
	   sc.nextLine();
	   String acc=sc.nextLine();
	   boolean flag=true;
	   for(int i=0;i<=index;i++){
		  if(acc.equals(obj[i].accNum)){
	   	   flag=false;
		   System.out.println("\n\n\tCustomer Name\t    AccNo.\t\t  MobileNo.     \t Gmail\t\t     Amount    ");
           System.out.println(YELLOW+"\t------------------------------------------------------------------------------------------------------------------"+RESET);
		   System.out.printf("\t%-20s %-20s %-20s %-20s %f\n ",obj[i].cName,obj[i].accNum,obj[i].mobNum,obj[i].gmlId,obj[i].amt);
            break;
	   }
	   }
	   if(index==-1)
		    System.out.println(RED+"\tNo Account Present"+RESET);
	   else if(flag)
		    System.out.println(RED+"\tNot Found"+RESET);
       break;
     
	 case 2:
	 if(index==-1)
		   System.out.println(RED+"\tNo Account Present"+RESET);
	 else{
	  while(true){
       System.out.println("\n\n\t\t----------Update Details----------");
	   System.out.print("\tenter account number: ");
	   acc=sc.next();
	    flag=true;
	   for(int i=0;i<=index;i++){
		  if(acc.equals(obj[i].accNum)){
	   	   flag=false;
	   System.out.println("\t-----------------\t-----------------\t-----------------\t-----------------\t-----------------");
       System.out.println(YELLOW+"\t1)Customer Name\t\t2)MobileNo.\t\t3)Gmail    \t\t4)Update All \t\t0)No Change"+RESET);
       System.out.println("\t-----------------\t-----------------\t-----------------\t-----------------\t-----------------");
       System.out.print("\t\tEnter the choice: ");
        ch=sc.nextInt();
	  switch(ch){
		case 1:
		   System.out.print("\tEnter the customer name: ");
	       sc.nextLine();
	       String cN=sc.nextLine();
           System.out.println(YELLOW+"\t---------------------------------------------------"+RESET);
		   obj[i].setCName(cN);
		   System.out.println(GREEN+"\t\t---Customer Name Updation---"+RESET);
            break;
      
          case 2:
			 System.out.print("\tEnter the mobile number: ");
             String mobN=sc.next();
             System.out.println(YELLOW+"\t---------------------------------------------------"+RESET);
			 obj[i].setMobNo(mobN);
             System.out.println(GREEN+"\t\t---MobileNo. Updation---"+RESET);
			 break;
		   
		  case 3:
           System.out.print("\tEnter Customer GmailID: ");
           String gM=sc.next();
           System.out.println(YELLOW+"\t---------------------------------------------------"+RESET);           
		   System.out.println(GREEN+"\t\t---Gmail Updation---"+RESET);      
           obj[i].setCG(gM)	;	   
			break;
		   
		  case 4:
		  System.out.print("\tEnter the customer name: ");
	       sc.nextLine();
	      cN=sc.nextLine();
           System.out.println(YELLOW+"\t---------------------------------------------------"+RESET);
		   System.out.print("\tEnter the mobile number: ");
           mobN=sc.next();
           System.out.println(YELLOW+"\t---------------------------------------------------"+RESET);
		   System.out.print("\tEnter Customer GmailID: ");
           gM=sc.next();
           System.out.println(YELLOW+"\t---------------------------------------------------"+RESET);  
		   obj[i].setCAll(cN, mobN,gM);
           System.out.println(GREEN+"\t\t---Update All Updation---"+RESET);          
		    break;
      
         case 0:
		 System.out.println(GREEN+"\t\t---No Updation ---"+RESET);
         System.out.println(GREEN+"\t\t---THANKS U---"+RESET);
         break;
      
         default:
          System.out.println(RED+"\t\t---Invalid choise---"+RESET);
        }
		break;
	  }
	 }
		if(ch==0 )
           break;
	    if(flag){
		    System.out.println(RED+"\tNot Found"+RESET);
	       break;_
	   }
	  }
	 }
	 break;
    
	case 3:
      System.out.println("case 3");
       break;
    
	case 4:
      System.out.println("case 4");
        break;
     
	 case 5:
      System.out.println("case 5");
       break;
    
	case 6:
      System.out.println("case 6");
        break;
     
	 case 0:
        System.out.println(GREEN+"\t\t---SUCCESSFULLY EXIT CUSTOMER PAGE---"+RESET);
        System.out.println(GREEN+"\t\t---THANKS FOR VISIT---"+RESET);
      break;
      
      default:
        System.out.println(RED+"\t\t---Invalid choise---"+RESET);
    }
    if(ch==0 )
      break;
   }
  }
  //4 Main function
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    BankProj obj[]=new BankProj[50];   
     application(obj);
    }
}