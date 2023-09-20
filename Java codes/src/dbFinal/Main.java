package dbFinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome :");
		System.out.println("choos what do you wanna do :");
		System.out.println("***************************************");
		System.out.println("to register food input **rf**:");
		System.out.println("to get information about user bought input **iu**:");
		System.out.println("to get information about user bought input **im**:");
		System.out.println("to Edit User input **eu**:");
		System.out.println("to Edit Menu input **mu**:");
		System.out.println("to Edit Store input **su**:");
		System.out.println("to Edit Delivery input **du**:");
		System.out.println("For record ingridients input **reg_in** :");
		System.out.println("***************************************");
		System.out.println("Choos what do you want from above :");
		String choice = sc.nextLine();		
		/*if(choice.equals("r"));
		registerFactor_ingredients();*/
	    Date d = new Date();
	    LocalDateTime now = LocalDateTime.now();

	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
	    String currentDateTime = format.format(d);
	    System.out.println(d);
	    //reportManager();
	    //reportUser();		
	    
	    switch(choice) {
	    
	    case "rf":
	    	registerFactor_food();
	    	break;
	    case "iu":
	    	reportUser();
	    	break;
	    case "im" :
	    	reportManager();
	    	break;
	    case "eu":
	    	editUser();
	    	break;
	    case "mu":
	    	editMenu();
	    	break;
	    case "su":
	    	editStore();
	    	break;
	    case "du":
	    	editDelivery();
	    	break;
	    case "reg_in":
	    	showStores();
	    	registerFactor_ingredients();
	    	break;
	    	
	    	
	    
	    
	    }
		
	}
	
	public static void registerFactor_ingredients()
	{
		Connection conn = null;
	       Statement statement;
	       Scanner sc = new Scanner(System.in);
	       String c = "e";
	   	int factor_number;
		String address;
		String deliveryNational_code;
		int address_id=0;
		String cName=null;
		int []price = new int[10]; 
		int []num = new int[10]; 
		String foodName;
		int total=0;
		Order_food[] o = new Order_food[10];
		
		int number;
		int i =0;
		String h;
		String storeName;
		ArrayList<String> oName = new ArrayList<String>();
		  int fact_num=3 ;
		//while(c.equals("e")) {

		  	//show stores and names
			showStores();
			
			System.out.println("Order Ingridients :");
			//System.out.println("to EXIT press m :");
			//c = sc.nextLine();
		//	if(c.equals("e"))break;
			System.out.println("factor_number :");
			factor_number = sc.nextInt();
			System.out.print(factor_number);
			/*System.out.println("address :");
			h = sc.next();
			address = sc.nextLine();*/
			
			System.out.println("Stor Name :");
			h = sc.nextLine();
			 storeName= sc.nextLine();
			 
				System.out.printf("%d--------%s",factor_number,storeName);
			/*System.out.println("Stor Name :");
			 h = sc.next();
			deliveryNational_code= sc.nextLine();
			System.out.println("address_id= :");
			 address_id= sc.nextInt();
			 System.out.println("cName :");
			  h = sc.nextLine();
			 cName = sc.next();/*
			 
			/*while(c.equals("e")) {

				System.out.println("to EXIT press e :");
				c = sc.nextLine();
				if(c.equals("e"))break;
				System.out.println("Food_name :");
				foodName= sc.nextLine();
				
				System.out.println("Number :");
				number = sc.nextInt();
				total += number;
				System.out.println("Price :");
				price = sc.nextInt();
				
				o[i]= new Order_food(price,foodName,number,factor_number);	
				
				
			}*/
				for(int i1=0;i1<num.length;i1++ ) {

				System.out.println("to EXIT press e :");
				c = sc.nextLine();
				if(c.equals("e"))break;
				System.out.println("Ingridient_name :");
				oName.add(sc.nextLine());
				
				System.out.println("Number :");
				num[i1] = sc.nextInt();
				System.out.println("Ingridient Price :");
				price[i1] = sc.nextInt();
				c = sc.nextLine();
				total += price[i1]*num[i1];
				
				
			}
				// h = sc.nextLine();
				//System.out.println(total);
				 
				for(int i1=0;i1<oName.size();i1++ )
			  insertIngredientsOrder( factor_number ,oName.get(i1),price[i1] ,num[i1]);
			 Factor_food f = new Factor_food(11,"scscc",5, null ,4000,"nima" );
				System.out.println(factor_number);
			 register_factor(factor_number,storeName,total);
			/* for(int j=0;j<o.length;j++) {
				 o[j].register_factor();
			 }*/
			 
			
		
	}
	
	
	public static void  register_factor(int factor_number  , String storeName, int totalCost ) {

		 Connection conn = null;
	       Statement statement;
	    	db();
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    

	     statement = conn.createStatement();

	   /* String b = "تت";
	    String n = "32000";*/
	    Date d = new Date();
	    LocalDateTime now = LocalDateTime.now();
	    System.out.println(d);
	     
	    statement.executeUpdate("insert into factor_ingredients "+"(factor_number,total_cost,storeStore_name)"+"values"+"('"+factor_number+"','"+totalCost+"','"+storeName+"')");
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }
	
	 public static void db(){
	      Connection conn = null;
	       Statement statement;
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     System.out.print("\naaaaa");
	    ResultSet rset = statement.executeQuery("select address_id,customer_name from address");
	    while(rset.next()){
	        System.out.println(rset.getInt("address_id")+"\t"+rset.getString("customer_name") );
	    }
	    String b = "تت";
	    String n = "32000";
	    //statement.executeUpdate("Update address set customer_name='"+b+"' where address_id=9 ");
	    statement.execute("insert into menu values('"+b+"' ,'"+n+"' )");
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }

	 public static void insertIngredientsOrder(int fact_num , String oName, int price , int num) {
		 
		 Connection conn = null;
	       Statement statement;
	    	//db();
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    

	     statement = conn.createStatement();

	   /* String b = "تت";
	    String n = "32000";*/
	    Date d = new Date();
	    LocalDateTime now = LocalDateTime.now();
	    System.out.println(d);
	     
	    statement.executeUpdate("insert into include_ingredients "+"(factor_ingredientsFactor_num,order_ingridientIngridient_name,order_ingridientIngridient_price,numberOfOrder)" + "values" +"(3,'"+oName+"','"+price+"','"+num+"')");
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }
	 
	 public static void showStores(){
	      Connection conn = null;
	       Statement statement;
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     //System.out.print("\naaaaa");
	        System.out.println("name\tStatus");
	        //System.out.print("\n");
	    ResultSet rset = statement.executeQuery("select store_name,status from store");
	    while(rset.next()){
	        System.out.println(rset.getString("store_name")+"\t"+rset.getString("status") );
	        //System.out.printf("%s%10s%n",rset.getString("store_name"),rset.getString("status") );
	    }
	    String b = "تت";
	    String n = "32000";
	    //statement.executeUpdate("Update address set customer_name='"+b+"' where address_id=9 ");
	    //statement.execute("insert into menu values('"+b+"' ,'"+n+"' )");
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	          /// System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }

	 public static void reportManager() {
	      Connection conn = null;
	       Statement statement,st;
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     st = conn.createStatement();
	     int sum=0;
	     int sum1=0;
	     int c;
	     ResultSet rset1;
	        System.out.println("Food selling Report Report :");
	    ResultSet rset = statement.executeQuery("select factor_number,total_cost from factor_food_withname where date(`date`)=curdate()");
	    while(rset.next()){
	    	
	    	c= rset.getInt("factor_number");
	    	//System.out.println(c);
	        System.out.println("Factor number : " + c);
		    rset1 = st.executeQuery("select order_FoodFood_name,order_FoodFood_price from contains where factor_FoodFactor_number = '"+c+"' ");
		    while(rset1.next()) {
	        System.out.println(rset1.getString("order_FoodFood_name")+"\t"+rset1.getInt("order_FoodFood_price") );
	        System.out.println();
	        }
		    sum += rset.getInt("total_cost");
	        System.out.println("-------------------------");
	    }
	    System.out.println( "Daily income :" + sum);
        System.out.println("-------------------------");
       System.out.println("Factor Report :\n");
	    
	    rset = statement.executeQuery("select factor_number,total_cost from factor_ingredients where date(`date`)=curdate()");
	    while(rset.next()){
	    	
	    	c= rset.getInt("factor_number");
	    	//System.out.println(c);
	    	 System.out.println("Factor number : " + c);
		    rset1 = st.executeQuery("select order_ingridientIngridient_name,order_ingridientIngridient_price from include_ingredients where factor_ingredientsFactor_num = '"+c+"' ");
		    while(rset1.next()) {
	        System.out.println(rset1.getString("order_ingridientIngridient_name")+"\t"+rset1.getInt("order_ingridientIngridient_price") );
	        System.out.println("-------------------------");
		    }
		    sum1 += rset.getInt("total_cost");
	    }
	       System.out.println("How much You spent  :");
	    System.out.println(sum1);
       System.out.println();
       System.out.println("-------------------------");
	    System.out.println("How much You profit :");
	    System.out.println((sum-sum1));
	  /*  rset = statement.executeQuery("select factor_ingredients,total_cost from factor_food");
	    while(rset.next()){
	        System.out.println(rset.getInt("factor_number")+"\t"+rset.getInt("total_cost") );
	        sum += rset.getInt("total_cost");
	        System.out.println(sum);
	    }*/

	    //statement.executeUpdate("Update address set customer_name='"+b+"' where address_id=9 ");
	    //statement.execute("insert into menu values('"+b+"' ,'"+n+"' )");
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           //System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }

	 
	 public static void reportUser(){
	      Connection conn = null;
	       Statement statement,st;
	       String user_id;
	       System.out.println("Enter your national_code :");
	       Scanner sc = new Scanner(System.in);
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     st = conn.createStatement();
	     int sum=0;
	     int sum1=0;
	     int c;
	     int ff=0;
	     String favoriteFood = null;
	     user_id = sc.nextLine();
	    	System.out.println("All Of foods you have Order :");
	     ResultSet rset1;
	     
	    ResultSet rset = statement.executeQuery("select factor_number from factor_food_withname where customerNational_code = '"+user_id+"' ");
	    while(rset.next()){
	    	
	    	c= rset.getInt("factor_number");
	    	//System.out.println(c);
	    	//System.out.println(user_id);
	        System.out.println("Factor number : " + c);
		    rset1 = st.executeQuery("select order_FoodFood_name,order_FoodFood_price from contains where factor_FoodFactor_number = '"+c+"' ");
		    while(rset1.next()) {
	        System.out.println(rset1.getString("order_FoodFood_name")+"\t"+rset1.getInt("order_FoodFood_price") );
	        System.out.println();
	        }
	    }
	    
	    rset = statement.executeQuery("select factor_number from factor_food_withname where customerNational_code = '"+user_id+"' ");

	    while(rset.next()){
	    	c= rset.getInt("factor_number");
	        rset1 = st.executeQuery("select count(*)as num,order_FoodFood_name  \r\n" + 
	        		"from `contains`,factor_food_withname,customer \r\n" + 
	        		"where factor_FoodFactor_number=factor_number and customerNational_code=national_code and national_code='0021563600'\r\n" + 
	        		" group by order_FoodFood_name ");
		  
		    while(rset1.next()) {
		    	
		    	if(ff<rset1.getInt("num")) {
		    		favoriteFood = rset1.getString("order_FoodFood_name");
		    		ff = rset1.getInt("num");
		    	}

			   /*System.out.print(rset1.getInt("num"));
			   System.out.println(rset1.getString("order_FoodFood_name"));*/
	        }
	    }
	    System.out.println("Your favorite food is : "+favoriteFood);
	    
	   
	  /*  rset = statement.executeQuery("select factor_ingredients,total_cost from factor_food");
	    while(rset.next()){	0021563600
	        System.out.println(rset.getInt("factor_number")+"\t"+rset.getInt("total_cost") );
	        sum += rset.getInt("total_cost");
	        System.out.println(sum);
	    }*/

	    //statement.executeUpdate("Update address set customer_name='"+b+"' where address_id=9 ");
	    //statement.execute("insert into menu values('"+b+"' ,'"+n+"' )");
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           //System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }

	 
	 public static Object editUser() {
		 
		 System.out.println("Editing user !!!");
		 System.out.println("if you wanna stay her Enter c | for Exit Enter e");
	      Scanner sc = new Scanner(System.in);
			 String c = sc.nextLine();
			 if(c.equals("e")) return null;
			 
		  System.out.println("for creating user Enter i | for updating user Enter u | for updating user Enter d");
	      String choice = sc.nextLine();
	      switch(choice) {
	      
	      case "i":
	    	  userCreate();
	    	  break;
	      case "u":
	    	  userUpdate();
	    	  break;
	    	  
	      case "d":
	    	  userDelete();
	    	  break;
	      
	      }

		  return editUser();
	 }
	 
	 
	 public static void userCreate(){
	      Connection conn = null;
	       Statement statement,st;
	       String user_id;
	       Scanner sc = new Scanner(System.in);
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     st = conn.createStatement();

	     String favoriteFood = null;

	     ResultSet rset1;
	     
	    ResultSet rset = statement.executeQuery("select * from customer ");
	    System.out.println("national_code\tname\tmobile_phone\tage");
	    while(rset.next()){
	    	
	        System.out.println(rset.getString("national_code")+"\t"+rset.getString("name")+
	        		"\t"+rset.getString("Lname")+"\t"+rset.getString("mobile_phone")+rset.getInt("age"));

	        }
	    System.out.print("----------------------------\n");
	    System.out.println("Add User :");
	    
	    System.out.println("Input Name  :");
	     String n  = sc.nextLine();
	     System.out.println("Input Last Name  :");
	     String ln  = sc.nextLine();
		 System.out.println("Input National Code  :");
	     String nc  = sc.nextLine();
		 System.out.println("Input Mobile Phone  :");
	     String mp  = sc.nextLine();
	     System.out.println("Input Age  :");
	     int age= sc.nextInt();
	     
	    
	   // statement.executeUpdate("insert address set customer_name='"+b+"' where address_id=9 ");
	    statement.executeUpdate("insert into customer "+
	    "(national_code,name,Lname,mobile_phone,age)" 
	    +"values" +"('"+nc+"','"+n+"','"+ln+"','"+mp+"','"+age+"')");	
	    
	    System.out.println("----Insert was Successful----");
	    
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           //System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }

	 public static void userUpdate(){
	      Connection conn = null;
	       Statement statement,st;
	       String user_id;
	       Scanner sc = new Scanner(System.in);
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     st = conn.createStatement();

	     String favoriteFood = null;

	     ResultSet rset1;
	     
	    ResultSet rset = statement.executeQuery("select * from customer ");
	    System.out.println("national_code\tname\tmobile_phone\tage");
	    while(rset.next()){
	    	
	        System.out.println(rset.getString("national_code")+"\t"+rset.getString("name")+
	        		"\t"+rset.getString("Lname")+"\t"+rset.getString("mobile_phone")+rset.getInt("age"));

	        }
	    System.out.print("----------------------------\n");

	   /* System.out.println("Input User National Code For Update  :");
	     String nc  = sc.nextLine();*/
	     Boolean t = true;
	    
	     while(t) {
	 	   
	    	 
	    	 System.out.println("To Exit Enter e | to continue Enter c :");
	    	 String choice1  = sc.nextLine();
	    	 if(choice1.equals("e")) break;
	 	    System.out.println("which item do you want to Update :");
	 	   System.out.println("name\t| Lname\t| mobile_phone\t| age");
	    	 System.out.println("Input column Name to change it :");
		     String choice  = sc.nextLine();
		     String nc;

		     switch(choice) {
		     	
		     case "name":
	     			System.out.println("Input User National Code For Update  :");
	     		      nc  = sc.nextLine();
	     			System.out.println("Input Name  :");
	     			String n  = sc.nextLine();    			
	     		    statement.executeUpdate("Update customer set name='"+n+"' where national_code='"+nc+"'");
	     		    break;
	     		    
		     case "Lname":
	     			System.out.println("Input User National Code For Update  :");
	     		     nc  = sc.nextLine();
	     			System.out.println("Input Last Name  :");
	     			String ln  = sc.nextLine();	
	     			statement.executeUpdate("Update customer set Lname='"+ln+"' where national_code='"+nc+"'");	
				    	 break;
				    	 
		     case "mobile_phone":		    	 
	     			System.out.println("Input User National Code For Update  :");
	     		    	nc  = sc.nextLine();
	     			System.out.println("Input Mobile Phone  :");
	     			String mp  = sc.nextLine();	
	     			statement.executeUpdate("Update customer set mobile_phone='"+mp+"' where national_code='"+nc+"'");
	     			break;
	     			
		     case "age":     			
	     			System.out.println("Input User National Code For Update  :");
	     		   		nc  = sc.nextLine();
	     			System.out.println("Input Age  :");
	     			int age= sc.nextInt();
	     			statement.executeUpdate("Update customer set age='"+age+"' where national_code='"+nc+"'");
	     			String h  = sc.nextLine();
	     			break;
	     			
		     case "national_code":
    			 System.out.println("Input User National Code For Update  :");
    			 	nc  = sc.nextLine();
    			 System.out.println("Input National Code  :");
    		     String nc1  = sc.nextLine();
    		     statement.executeUpdate("Update customer set national_code='"+nc1+"' where national_code='"+nc+"'");
   		     break;
   		     
   		default :
   			System.out.println("Wrong input!! Pleas try again");
		     
		     }

	    	 
	    	/* System.out.println("To Exit Enter e | to continue Enter c :");
	    	 String choice1  = sc.nextLine();
	    	 if(choice1.equals("e")) break;
	 	    System.out.println("which item do you want to Update :");
	 	   System.out.println("name\t| lname\t| mobile_phone\t| age");
	    	 System.out.println("Input column Name to change it :");
		     String choice  = sc.nextLine();
		     
		     		if(choice.equals("name")) {
		     			
		     			System.out.println("Input User National Code For Update  :");
		     		     String nc  = sc.nextLine();
		     			System.out.println("Input Name  :");
		     			String n  = sc.nextLine();    			
		     		    statement.executeUpdate("Update customer set name='"+n+"' where national_code='"+nc+"'");
		     		}
		     			
		     		if(choice.equals("Lname")) {
		     			
		     			System.out.println("Input User National Code For Update  :");
		     		    String nc  = sc.nextLine();
		     			System.out.println("Input Last Name  :");
		     			String ln  = sc.nextLine();	
		     			statement.executeUpdate("Update customer set Lname='"+ln+"' where national_code='"+nc+"'");	
		     		}
		     		
		     		if(choice.equals("mobile_phone")) {
		     			
		     			System.out.println("Input User National Code For Update  :");
		     		    String nc  = sc.nextLine();
		     			System.out.println("Input Mobile Phone  :");
		     			String mp  = sc.nextLine();	
		     			statement.executeUpdate("Update customer set mobile_phone='"+mp+"' where national_code='"+nc+"'");
		     		}
		     		
		     		if(choice.equals("age")) {
		     			
		     			System.out.println("Input User National Code For Update  :");
		     		    String nc  = sc.nextLine();
		     			System.out.println("Input Age  :");
		     			int age= sc.nextInt();
		     			statement.executeUpdate("Update customer set age='"+age+"' where national_code='"+nc+"'");
		     		}
		     		
		    		if(choice.equals("national_code")) {
		    			
		    			 System.out.println("Input User National Code For Update  :");
		    		     String nc  = sc.nextLine();
		    			 System.out.println("Input National Code  :");
		    		     String nc1  = sc.nextLine();
		    		     statement.executeUpdate("Update customer set national_code='"+nc1+"' where national_code='"+nc+"'");
		    		}*/
	    	 
	    	 
	     }
	    
	   // statement.executeUpdate("insert address set customer_name='"+b+"' where address_id=9 ");

	    

	    System.out.println("----Update was Successful----");
	    sc.close();
	    
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	          // System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }

	 public static void userDelete(){
	      Connection conn = null;
	       Statement statement,st;
	       String user_id;
	       Scanner sc = new Scanner(System.in);
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     st = conn.createStatement();


	     
	    ResultSet rset = statement.executeQuery("select * from customer ");
	    System.out.println("national_code\tname\tmobile_phone\tage");
	    while(rset.next()){
	    	
	        System.out.println(rset.getString("national_code")+"\t"+rset.getString("name")+
	        		"\t"+rset.getString("Lname")+"\t"+rset.getString("mobile_phone")+rset.getInt("age"));

	        }
	    System.out.print("----------------------------\n");

	    
	   /* System.out.println("Input User National Code For Update  :");
	     String nc  = sc.nextLine();*/
	     Boolean t = true;
	     
	     
	    
	     while(t) {
	 	   
	    	 System.out.println("To Exit Enter e | to continue Enter c :");
	    	 String choice1  = sc.nextLine();
	    	 if(choice1.equals("e")) break;
	 	    System.out.println("which item do you want to Delete :");
	 	   System.out.println("name\t| Lname\t| mobile_phone\t| age\t| national_code");
	    	 System.out.println("Input column Name to Delete row(s) :");
		     String choice  = sc.nextLine();
		     
		     switch(choice) {
		     	
		     case "name":
	     			System.out.println("Input Name to Delete  :");
	     			String n  = sc.nextLine();    			
	     		    statement.executeUpdate("Delete from customer where name='"+n+"' ");
	     		    break;
	     		    
		     case "Lname":
		     			System.out.println("Input Last Name to Delete :");
		     			String ln  = sc.nextLine();	
		     			statement.executeUpdate("Delete from customer where Lname='"+ln+"'");
				    	 break;
		     case "mobile_phone":
	     			System.out.println("Input Mobile Phone to Delete :");
	     			String mp  = sc.nextLine();	
	     			statement.executeUpdate("Delete customer  where mobile_phone='"+mp+"'");
	     			break;
		     case "age":
	     			System.out.println("Input Age to Delete :");
	     			int age= sc.nextInt();
	     			statement.executeUpdate("Deletefrom customer where age='"+age+"'");
	     			String h  = sc.nextLine();
	     			break;
		     case "national_code":
   			 System.out.println("Input User National Code to Delete  :");
   		     String nc  = sc.nextLine();
   		     statement.executeUpdate("Delete from customer where national_code='"+nc+"'");
   		     break;
   		default :
   			System.out.println("Wrong input!! Pleas try again");
		     
		     }

		     
		     	/*	if(choice.equals("name")) {
		     			
		     			System.out.println("Input Name  :");
		     			String n  = sc.nextLine();    			
		     		    statement.executeUpdate("Delete from customer where name='"+n+"' ");
		     		}
		     			
		     		if(choice.equals("Lname")) {

		     			System.out.println("Input Last Name  :");
		     			String ln  = sc.nextLine();	
		     			statement.executeUpdate("delete from customer where Lname='"+ln+"'");	
		     		}
		     		
		     		if(choice.equals("mobile_phone")) {
		     			
		     			System.out.println("Input Mobile Phone  :");
		     			String mp  = sc.nextLine();	
		     			statement.executeUpdate("Update customer set mobile_phone='"+mp+"' where mobile_phone='"+mp+"'");
		     		}
		     		
		     		if(choice.equals("age")) {
		     			
		     			System.out.println("Input Age  :");
		     			int age= sc.nextInt();
		     			statement.executeUpdate("Deletefrom customer where age='"+age+"'");
		     		}
		     		
		    		if(choice.equals("national_code")) {
		    			
		    			 System.out.println("Input User National Code For Update  :");
		    		     String nc  = sc.nextLine();
		    		     statement.executeUpdate("Delete from customer where national_code='"+nc+"'");
		    		}*/
	    	 
	    	 
	     }
	    
	   // statement.executeUpdate("insert address set customer_name='"+b+"' where address_id=9 ");

	    

	    System.out.println("----Deletion was Successful----");
	    sc.close();
	    
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           //System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }
	 
	 
	 public static Object editMenu() {
		 
		 System.out.println("Editing user !!!");
		 System.out.println("if you wanna stay her Enter c | for Exit Enter e");
	      Scanner sc = new Scanner(System.in);
			 String c = sc.nextLine();
			 if(c.equals("e")) return null;
			 
		  System.out.println("for creating user Enter i | for updating user Enter u | for updating user Enter d");
	      String choice = sc.nextLine();
	      switch(choice) {
	      
	      case "i":
	    	 createMenu();
	    	  break;
	      case "u":
	    	  updateMenu();
	    	  break;
	    	  
	      case "d":
	    	  deleteMenu();
	    	  break;
	      
	      }

		  return editMenu();
	 }
	 
	 
	 public static void createMenu(){
	      Connection conn = null;
	       Statement statement,st;
	       String user_id;
	       Scanner sc = new Scanner(System.in);
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     st = conn.createStatement();

	     String favoriteFood = null;

	     ResultSet rset1;
	     
	    ResultSet rset = statement.executeQuery("select * from menu ");
	    System.out.println("food name\tprice");
	    while(rset.next()){
	    	
	        System.out.println(rset.getString("food_name")+"\t"+"\t"+rset.getInt("price"));

	        }
	    System.out.print("----------------------------\n");
	    System.out.println("Add New Food :");
	    
	    System.out.println("Input Food Name  :");
	     String n  = sc.nextLine();
	     System.out.println("Input Food price :");
	     int p = sc.nextInt();
	     
	    
	   // statement.executeUpdate("insert address set customer_name='"+b+"' where address_id=9 ");
	    statement.executeUpdate("insert into menu "+
	    "(food_name,price)"+"values" +"('"+n+"','"+p+"')");	
	    
	    System.out.println("----Insert was Successful----");
	    
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }

	 public static void updateMenu(){
	      Connection conn = null;
	       Statement statement,st;
	       String user_id;
	       Scanner sc = new Scanner(System.in);
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     st = conn.createStatement();

	     String favoriteFood = null;

	     ResultSet rset1;
	     
	     
	    ResultSet rset = statement.executeQuery("select * from menu ");
	    System.out.println("food name\tprice");
	    while(rset.next()){
	    	
	        System.out.println(rset.getString("food_name")+"\t"+"\t"+rset.getInt("price"));

	        }
	    System.out.print("----------------------------\n");

	    
	   /* System.out.println("Input User National Code For Update  :");
	     String nc  = sc.nextLine();*/
	     Boolean t = true;
	    
	     while(t) {
	 	   
	    	 System.out.println("To Exit Enter e | to continue Enter c :");
	    	 String choice1  = sc.nextLine();
	    	 if(choice1.equals("e")) break;
	 	    System.out.println("which item do you want to Update :");
	 	   System.out.println("food_name\t| price");
	    	 System.out.println("Input column Name to change it :");
		     String choice  = sc.nextLine();
		     
		     switch(choice) {
		    
		     case "food_name":
	     			System.out.println("Input Older Food name For Update  :");
	     		     String nc  = sc.nextLine();
	     			System.out.println("Input New Food Name  :");
	     			String n  = sc.nextLine();    			
	     		    statement.executeUpdate("Update menu set food_name='"+n+"' where food_name='"+nc+"'");
	     		    break;
	     		    
		     case "price":
	     			System.out.println("Input New Food Name For Update  :");
	     		      nc  = sc.nextLine();
	     			System.out.println("Input New Food Price  :");
	     			int p   = sc.nextInt();    			
	     		    statement.executeUpdate("Update menu set price='"+p+"' where food_name='"+nc+"'");
	     		    String h  = sc.nextLine();
	     		    break;
	     		    

	     		    
	     		    default : System.out.println("Wrong inuput!! Try again");
		    
		     }
	     }
	    
	   // statement.executeUpdate("insert address set customer_name='"+b+"' where address_id=9 ");

	    

	    System.out.println("----Update was Successful----");
	    
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }

	 public static void deleteMenu(){
	      Connection conn = null;
	       Statement statement,st;
	       String user_id;
	       Scanner sc = new Scanner(System.in);
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     st = conn.createStatement();

	     
	    ResultSet rset = statement.executeQuery("select * from menu ");
	    System.out.println("food name\tprice");
	    while(rset.next()){
	    	
	        System.out.println(rset.getString("food_name")+"\t"+"\t"+rset.getInt("price"));

	        }
	    System.out.print("----------------------------\n");

	    
	   /* System.out.println("Input User National Code For Update  :");
	     String nc  = sc.nextLine();*/
	     Boolean t = true;
	     
	     
	     while(t) {
		 	   
	    	 System.out.println("To Exit Enter e | to continue Enter c :");
	    	 String choice1  = sc.nextLine();
	    	 if(choice1.equals("e")) break;
	 	    System.out.println("which item do you want to Delete :");
	 	   System.out.println("food_name\t| price");
	    	 System.out.println("Input column Name to Delete it :");
		     String choice  = sc.nextLine();
		     
		     switch(choice) {
		    
		     case "food_name":
	     			System.out.println("Input Food name to Delete  :");
	     		     String n  = sc.nextLine();
	     		    statement.executeUpdate("Delete from menu  where food_name='"+n+"'");
	     		    break;
	     		    
		     case "price":
	     			System.out.println("Input  Food Price to Delete  :");
	     		      int p  = sc.nextInt(); 			
	     		    statement.executeUpdate("Delete from menu where price='"+p+"'");
	     		   String h  = sc.nextLine();
	     		    break;
	     		    
	     		    default : System.out.println("Wrong inuput!! Try again");
		     }
		     
	     }
	    
	   // statement.executeUpdate("insert address set customer_name='"+b+"' where address_id=9 ");

	    

	    System.out.println("----Deletion was Successful----");
	    
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }

	 
	 public static Object editStore() {
		 
		 System.out.println("Editing Store !!!");
		 System.out.println("if you wanna stay her Enter c | for Exit Enter e");
	      Scanner sc = new Scanner(System.in);
			 String c = sc.nextLine();
			 if(c.equals("e")) return null;
			 
		  System.out.println("for creating user Enter i | for updating user Enter u | for updating user Enter d");
	      String choice = sc.nextLine();
	      switch(choice) {
	      
	      case "i":
	    	 addStore();
	    	  break;
	      case "u":
	    	  updateStore();
	    	  break;
	    	  
	      case "d":
	    	  deleteStore();
	    	  break;
	      
	      }

		  return editStore();
	 }
	 
	 
	 public static void addStore(){
	      Connection conn = null;
	       Statement statement,st;
	       String user_id;
	       Scanner sc = new Scanner(System.in);
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     st = conn.createStatement();

	     String favoriteFood = null;

	     ResultSet rset1;
	     
	    ResultSet rset = statement.executeQuery("select * from store ");
	    System.out.println("Store name\tStatus");
	    while(rset.next()){
	    	
	        System.out.println(rset.getString("store_name")+"\t"+"\t"+rset.getString("status"));

	        }
	    System.out.print("----------------------------\n");
	    System.out.println("Add New Store :");
	    
	    System.out.println("Input Store Name  :");
	     String n  = sc.nextLine();
	     System.out.println("Input Store status :");
	     String s = sc.nextLine();
	     
	    
	   // statement.executeUpdate("insert address set customer_name='"+b+"' where address_id=9 ");
	    statement.executeUpdate("insert into store "+
	    "(store_name,status)"+"values" +"('"+n+"','"+s+"')");	
	    
	    System.out.println("----Insert was Successful----");
	    
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }

	 public static void updateStore(){
	      Connection conn = null;
	       Statement statement,st;
	       String user_id;
	       Scanner sc = new Scanner(System.in);
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     st = conn.createStatement();

	     String favoriteFood = null;

	     ResultSet rset1;
	     
	     
		    ResultSet rset = statement.executeQuery("select * from store ");
		    System.out.println("Store name\tStatus");
		    while(rset.next()){
		    	
		        System.out.println(rset.getString("store_name")+"\t"+"\t"+rset.getString("status"));
		    }
	    System.out.print("----------------------------\n");

	    
	   /* System.out.println("Input User National Code For Update  :");
	     String nc  = sc.nextLine();*/
	     Boolean t = true;
	    
	     while(t) {
	 	   
	    	 System.out.println("To Exit Enter e | to continue Enter c :");
	    	 String choice1  = sc.nextLine();
	    	 if(choice1.equals("e")) break;
	 	    System.out.println("which item do you want to Update :");
	 	   System.out.println("store_name\t| status");
	    	 System.out.println("Input column Name to change it :");
		     String choice  = sc.nextLine();
		     
		     switch(choice) {
		    
		     case "store_name":
	     			System.out.println("Input Older Store Name For Update  :");
	     		     String nc  = sc.nextLine();
	     			System.out.println("Input New Store Name  :");
	     			String n  = sc.nextLine();    			
	     		    statement.executeUpdate("Update store set store_name='"+n+"' where store_name='"+nc+"'");
	     		    break;
	     		    
		     case "status":
	     			System.out.println("Input Older Store Name For Update  :");
	     		      nc  = sc.nextLine();
	     			System.out.println("Input New Store status  :");
	     			String s   = sc.nextLine();    			
	     		    statement.executeUpdate("Update store set status='"+s+"' where store_name='"+nc+"'");
	     		    break;

	     		    default : System.out.println("Wrong inuput!! Try again");
		    
		     }
	     }
	    
	   // statement.executeUpdate("insert address set customer_name='"+b+"' where address_id=9 ");

	    

	    System.out.println("----Update was Successful----");
	    
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }

	 public static void deleteStore(){
	      Connection conn = null;
	       Statement statement,st;
	       String user_id;
	       Scanner sc = new Scanner(System.in);
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     st = conn.createStatement();

		    ResultSet rset = statement.executeQuery("select * from store ");
		    System.out.println("Store name\tStatus");
		    while(rset.next()){
		    	
		        System.out.println(rset.getString("store_name")+"\t"+"\t"+rset.getString("status"));
		    }
	    System.out.print("----------------------------\n");

	    
	   /* System.out.println("Input User National Code For Update  :");
	     String nc  = sc.nextLine();*/
	     Boolean t = true;
	     
	     
	     while(t) {
		 	   
	    	 System.out.println("To Exit Enter e | to continue Enter c :");
	    	 String choice1  = sc.nextLine();
	    	 if(choice1.equals("e")) break;
	 	    System.out.println("which item do you want to Delete :");
	 	   System.out.println("store_name\t| status");
	    	 System.out.println("Input column Name to Delete it (how you want to delete) :");
		     String choice  = sc.nextLine();
		     
		     switch(choice) {
		    
		     case "store_name":
	     			System.out.println("Input Store name to Delete  :");
	     		     String n  = sc.nextLine();
	     		    statement.executeUpdate("Delete from store  where store_name='"+n+"'");
	     		    break;
	     		    
		     case "status":
	     			System.out.println("Input Store status to Delete  :");
	     		      String s  = sc.nextLine(); 			
	     		    statement.executeUpdate("Delete from store where status='"+s+"'");
	     		   
	     		    break;
	     		    
	     		    default : System.out.println("Wrong inuput!! Try again");
		     }
		     
	     }
	    
	   // statement.executeUpdate("insert address set customer_name='"+b+"' where address_id=9 ");

	    

	    System.out.println("----Deletion was Successful----");
	    
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }
	 
	 
	 public static void editDelivery() {
		 
	     //Scanner sc = new Scanner(System.in);
		 
		 while(true) {
			 try {
				// String h = sc.nextLine();
			 }catch(NoSuchElementException e) {
				 e.getMessage();
			 }
			  Scanner sc = new Scanner(System.in);
			 System.out.println("Editing user !!!");
			 System.out.println("if you wanna stay her Enter c | for Exit Enter e");
			 
				 String c = sc.nextLine();
			      if(c.equals("e"))break;
				 
			  System.out.println("for creating user Enter i | for updating user Enter u | for updating user Enter d");
		      String choice = sc.nextLine();
		      switch(choice) {
		      
		      case "i":
		    	  createDelivery();
		    	  break;
		      case "u":
		    	  updateDelivery();
		    	  break;
		    	  
		      case "d":
		    	  deleteDelivery();
		    	  break; 
		    	  
		      }
		      sc.close();
		 }   

			  
		 }

		 
		public static void createDelivery(){
		      Connection conn = null;
		       Statement statement,st;
		       String user_id;
		       Scanner sc = new Scanner(System.in);
		try {
		    // db parameters
		    String url       = "jdbc:mysql://localhost:3306/db_final_project";
		    String user      = "root";
		    String password  = "emma1998";
		    
		    // create a connection to the database
		    conn = DriverManager.getConnection(url, user, password);
		    // more processing here
		    // ...    
		     statement = conn.createStatement();
		     st = conn.createStatement();

		     String favoriteFood = null;

		     ResultSet rset1;
		     
		    ResultSet rset = statement.executeQuery("select * from delivery ");
		    System.out.println("national_code\tname\t\tLast name\tmobile_phone");
		    while(rset.next()){
		    	
		        System.out.println(rset.getString("national_code")+"\t"+rset.getString("name")+
		        		"\t"+rset.getString("Lname")+"\t"+rset.getString("mobile_phone"));

		        }
		    System.out.print("----------------------------\n");
		    
		    while(true) {
		    System.out.println("Add Delivery :");
		    System.out.println("To Exit input e :");
		    String e  = sc.nextLine();
		    if(e.equals("e"))break;
		    System.out.println("Input Name  :");
		     String n  = sc.nextLine();
		     System.out.println("Input Last Name  :");
		     String ln  = sc.nextLine();
			 System.out.println("Input National Code  :");
		     String nc  = sc.nextLine();
			 System.out.println("Input Mobile Phone  :");
		     String mp  = sc.nextLine();

		     
		    
		   // statement.executeUpdate("insert address set customer_name='"+b+"' where address_id=9 ");
		    statement.executeUpdate("insert into delivery "+
		    "(national_code,name,Lname,mobile_phone)" 
		    +"values" +"('"+nc+"','"+n+"','"+ln+"','"+mp+"')");	
		    System.out.println("----Insert was Successful----");
		    
		    }
		    
		    
		} catch(SQLException e) {
		   System.out.println(e.getMessage());
		    System.out.print("\ndkcsjcksjckjsdd");
		} finally {
		    try{
		           if(conn != null){
		            conn.close();
		           System.out.print("\nddd");
		           }

		    }catch(SQLException ex){
		           System.out.println(ex.getMessage());
		            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
		    }
		}

		    }

		 public static void updateDelivery(){
		      Connection conn = null;
		       Statement statement,st;
		       String user_id;
		       Scanner sc = new Scanner(System.in);
		try {
		    // db parameters
		    String url       = "jdbc:mysql://localhost:3306/db_final_project";
		    String user      = "root";
		    String password  = "emma1998";
		    
		    // create a connection to the database
		    conn = DriverManager.getConnection(url, user, password);
		    // more processing here
		    // ...    
		     statement = conn.createStatement();
		     st = conn.createStatement();

		     String favoriteFood = null;

		     ResultSet rset1;
		     
		    ResultSet rset = statement.executeQuery("select * from delivery ");
		    System.out.println("national_code\tname\tmobile_phone");
		    while(rset.next()){
		    	
		        System.out.println(rset.getString("national_code")+"\t"+rset.getString("name")+
		        		"\t"+rset.getString("Lname")+"\t"+rset.getString("mobile_phone"));

		        }
		    System.out.print("----------------------------\n");

		   /* System.out.println("Input User National Code For Update  :");
		     String nc  = sc.nextLine();*/
		     Boolean t = true;
		    
		     while(t) {
		 	   
		    	 
		    	 System.out.println("To Exit Enter e | to continue Enter c :");
		    	 String choice1  = sc.nextLine();
		    	 if(choice1.equals("e")) t=false;
		 	    System.out.println("which item do you want to Update :");
		 	   System.out.println("name\t| Lname\t| mobile_phone\t| national_code");
		    	 System.out.println("Input column Name to change it :");
			     String choice  = sc.nextLine();
			     String nc;
			     if(!choice1.equals("e")) {
			     switch(choice) {
			     	
			     case "name":
		     			System.out.println("Input Delivery National Code For Update  :");
		     		      nc  = sc.nextLine();
		     			System.out.println("Input New Name  :");
		     			String n  = sc.nextLine();    			
		     		    statement.executeUpdate("Update delivery set name='"+n+"' where national_code='"+nc+"'");
		     		    break;
		     		    
			     case "Lname":
		     			System.out.println("Input Delivery National Code For Update  :");
		     		     nc  = sc.nextLine();
		     			System.out.println("Input NEW Last Name  :");
		     			String ln  = sc.nextLine();	
		     			statement.executeUpdate("Update delivery set Lname='"+ln+"' where national_code='"+nc+"'");	
					    	 break;
					    	 
			     case "mobile_phone":		    	 
		     			System.out.println("Input Delivery National Code For Update  :");
		     		    	nc  = sc.nextLine();
		     			System.out.println("Input NEW Mobile Phone  :");
		     			String mp  = sc.nextLine();	
		     			statement.executeUpdate("Update delivery set mobile_phone='"+mp+"' where national_code='"+nc+"'");
		     			break;
		     			
			     case "national_code":
	    			 System.out.println("Input delivery National Code For Update  :");
	    			 	nc  = sc.nextLine();
	    			 System.out.println("Input NEW National Code  :");
	    		     String nc1  = sc.nextLine();
	    		     statement.executeUpdate("Update delivery set national_code='"+nc1+"' where national_code='"+nc+"'");
	   		     break;
	   		     
	   		default :
	   			System.out.println("Wrong input!! Pleas try again");
			     
			     }

		    	 
		    	/* System.out.println("To Exit Enter e | to continue Enter c :");
		    	 String choice1  = sc.nextLine();
		    	 if(choice1.equals("e")) break;
		 	    System.out.println("which item do you want to Update :");
		 	   System.out.println("name\t| lname\t| mobile_phone\t| age");
		    	 System.out.println("Input column Name to change it :");
			     String choice  = sc.nextLine();
			     
			     		if(choice.equals("name")) {
			     			
			     			System.out.println("Input User National Code For Update  :");
			     		     String nc  = sc.nextLine();
			     			System.out.println("Input Name  :");
			     			String n  = sc.nextLine();    			
			     		    statement.executeUpdate("Update customer set name='"+n+"' where national_code='"+nc+"'");
			     		}
			     			
			     		if(choice.equals("Lname")) {
			     			
			     			System.out.println("Input User National Code For Update  :");
			     		    String nc  = sc.nextLine();
			     			System.out.println("Input Last Name  :");
			     			String ln  = sc.nextLine();	
			     			statement.executeUpdate("Update customer set Lname='"+ln+"' where national_code='"+nc+"'");	
			     		}
			     		
			     		if(choice.equals("mobile_phone")) {
			     			
			     			System.out.println("Input User National Code For Update  :");
			     		    String nc  = sc.nextLine();
			     			System.out.println("Input Mobile Phone  :");
			     			String mp  = sc.nextLine();	
			     			statement.executeUpdate("Update customer set mobile_phone='"+mp+"' where national_code='"+nc+"'");
			     		}
			     		
			     		if(choice.equals("age")) {
			     			
			     			System.out.println("Input User National Code For Update  :");
			     		    String nc  = sc.nextLine();
			     			System.out.println("Input Age  :");
			     			int age= sc.nextInt();
			     			statement.executeUpdate("Update customer set age='"+age+"' where national_code='"+nc+"'");
			     		}
			     		
			    		if(choice.equals("national_code")) {
			    			
			    			 System.out.println("Input User National Code For Update  :");
			    		     String nc  = sc.nextLine();
			    			 System.out.println("Input National Code  :");
			    		     String nc1  = sc.nextLine();
			    		     statement.executeUpdate("Update customer set national_code='"+nc1+"' where national_code='"+nc+"'");
			    		}*/
		    	 
		    	 
		     }
		     }
		   // statement.executeUpdate("insert address set customer_name='"+b+"' where address_id=9 ");

		    

		    System.out.println("----Update was Successful----");
		    sc.close();
		    
		} catch(SQLException e) {
		   System.out.println(e.getMessage());
		    System.out.print("\ndkcsjcksjckjsdd");
		} finally {
		    try{
		           if(conn != null){
		            conn.close();
		           System.out.print("\nddd");
		           }

		    }catch(SQLException ex){
		           System.out.println(ex.getMessage());
		            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
		    }
		}

		    }

		 public static void deleteDelivery(){
		      Connection conn = null;
		       Statement statement,st;
		       String user_id;
		       Scanner sc = new Scanner(System.in);
		try {
		    // db parameters
		    String url       = "jdbc:mysql://localhost:3306/db_final_project";
		    String user      = "root";
		    String password  = "emma1998";
		    
		    // create a connection to the database
		    conn = DriverManager.getConnection(url, user, password);
		    // more processing here
		    // ...    
		     statement = conn.createStatement();
		     st = conn.createStatement();


		     
		    ResultSet rset = statement.executeQuery("select * from delivery ");
		    System.out.println("national_code\tname\tmobile_phone");
		    while(rset.next()){
		    	
		        System.out.println(rset.getString("national_code")+"\t"+rset.getString("name")+
		        		"\t"+rset.getString("Lname")+"\t"+rset.getString("mobile_phone"));

		        }
		    System.out.print("----------------------------\n");

		    
		   /* System.out.println("Input User National Code For Update  :");
		     String nc  = sc.nextLine();*/
		     Boolean t = true;
		     
		     
		    
		     while(t) {
		 	   
		    	 System.out.println("To Exit Enter e | to continue Enter c :");
		    	 String choice1  = sc.nextLine();
		    	 if(choice1.equals("e")) break;
		 	    System.out.println("which item do you want to Delete :");
		 	   System.out.println("name\t| Lname\t| mobile_phone\t| age\t| national_code");
		    	 System.out.println("Input column Name to Delete row(s) :");
			     String choice  = sc.nextLine();
			     
			     switch(choice) {
			     	
			     case "name":
		     			System.out.println("Input Name to Delete  :");
		     			String n  = sc.nextLine();    			
		     		    statement.executeUpdate("Delete from delivery where name='"+n+"' ");
		     		    break;
		     		    
			     case "Lname":
			     			System.out.println("Input Last Name to Delete :");
			     			String ln  = sc.nextLine();	
			     			statement.executeUpdate("Delete from delivery where Lname='"+ln+"'");
					    	 break;
			     case "mobile_phone":
		     			System.out.println("Input Mobile Phone to Delete :");
		     			String mp  = sc.nextLine();	
		     			statement.executeUpdate("Delete delivery  where mobile_phone='"+mp+"'");
		     			break;
		     			
			     case "national_code":
	  			 System.out.println("Input User National Code to Delete  :");
	  		     String nc  = sc.nextLine();
	  		     statement.executeUpdate("Delete from delivery where national_code='"+nc+"'");
	  		     break;
	  		default :
	  			System.out.println("Wrong input!! Pleas try again");
			     
			     }

		    	 
		     }
		    
		   // statement.executeUpdate("insert address set customer_name='"+b+"' where address_id=9 ");

		    

		    System.out.println("----Deletion was Successful----");
		    //sc.close();
		    
		} catch(SQLException e) {
		   System.out.println(e.getMessage());
		    System.out.print("\ndkcsjcksjckjsdd");
		} finally {
		    try{
		           if(conn != null){
		            conn.close();
		           System.out.print("\nddd");
		           }

		    }catch(SQLException ex){
		           System.out.println(ex.getMessage());
		            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
		    }
		}

		    }
		 
		 
		 public static void insertFactor(int factor_number, int add_id , int tCost , String cName ,
				 String cNCode , String address, String dNCode){
		      Connection conn = null;
		       Statement statement,st;
		       String user_id;
		       Scanner sc = new Scanner(System.in);
		try {
		    // db parameters
		    String url       = "jdbc:mysql://localhost:3306/db_final_project";
		    String user      = "root";
		    String password  = "emma1998";
		    
		    // create a connection to the database
		    conn = DriverManager.getConnection(url, user, password);
		    // more processing here
		    // ...    
		     statement = conn.createStatement();
		     st = conn.createStatement();

		     String favoriteFood = null;

		     ResultSet rset1;
		     //System.out.println("Customer Name\t address_id :");
			   /* ResultSet rset = statement.executeQuery("select address_id,customer_name from address");
			    rset1 = st.executeQuery("select national_code from delivery");
			    while(rset.next()){
			        System.out.println(rset.getString("customer_name") +"\t"+"\t"+"\t"+rset.getInt("address_id"));
			    }
			    
			     System.out.println("Delivery id  :");
				    rset1 = statement.executeQuery("select national_code from delivery");
				    while(rset1.next()){
				    	System.out.println(rset1.getString("national_code"));
				    }
			    
		   /* System.out.print("----------------------------\n");
		    statement.executeUpdate("insert into factor_food_withname "+
		    "(factor_number,address_id,total_cost,storeStore_name)"+
		    "values"+"('"+factor_number+"','"+totalCost+"','"+storeName+"')");*/
			    
			    System.out.print("----------------------------\n");
			    
			    if(address.equals("0")) {
			    	
			    	if(cName.equals("0")) {
			    		
					    statement.executeUpdate("insert into factor_food_withname "+
							    "(factor_number,total_cost)"+
							    "values"+"('"+factor_number+"','"+tCost+"')");
			    		
			    	}
			    	else {
			    		
			   		 statement.executeUpdate("insert into factor_food_withname "+
			   				 "(factor_number,total_cost,customer_name,customerNational_code)"+
			   				  "values"+"('"+factor_number+"','"+tCost+"','"+cName+"','"+cNCode+"')");
			    	}
			    	
			    }else {
			    	
			    	if(cName.equals("0")) {
			    		
			   		 statement.executeUpdate("insert into factor_food_withname "+
			   			  "(factor_number,total_cost,address,deliveryNational_code)"+
			   			  "values"+"('"+factor_number+"','"+tCost+"','"+address+"','"+dNCode+"')");	
			    	}else {
			    		
			   		 statement.executeUpdate("insert into factor_food_withname "+
			   			    "(factor_number,address_id,total_cost,customer_name,customerNational_code,address,deliveryNational_code)"+
			   			    "values"+"('"+factor_number+"','"+add_id+"''"+tCost+"','"+cName+"','"+cNCode+"','"+address+"','"+dNCode+"')");
			    	}
			    	
			    }
			    
			   /* statement.executeUpdate("insert into factor_food_withname "+
			    "(factor_number,total_cost)"+
			    "values"+"('"+factor_number+"','"+tCost+"')");
			    
			 statement.executeUpdate("insert into factor_food_withname "+
			    "(factor_number,address_id,total_cost,customer_name,customerNational_code,address,deliveryNational_code)"+
			    "values"+"('"+factor_number+"','"+add_id+"''"+tCost+"','"+cName+"','"+cNCode+"','"+address+"','"+dNCode+"')");
			 statement.executeUpdate("insert into factor_food_withname "+
				  "(factor_number,total_cost,address,deliveryNational_code)"+
				  "values"+"('"+factor_number+"','"+tCost+"','"+address+"','"+dNCode+"')");	
			 
			 statement.executeUpdate("insert into factor_food_withname "+
				 "(factor_number,total_cost,customer_name,customerNational_code)"+
				  "values"+"('"+factor_number+"','"+tCost+"','"+cName+"','"+cNCode+"')");
			    
			    
			    
		    System.out.println("Add Order Food :");
		   /* System.out.println("To Exit input e :");
		    String e  = sc.nextLine();
		    if(e.equals("e"))break;*/
		   /* System.out.println("Input Factor Number  :");
		     int fNUm  = sc.nextInt();
			 System.out.println("Input Customer Name  :");
		     String cName  = sc.nextLine();
			 System.out.println("Input Customer Name  :");
		     String cNCode  = sc.nextLine();
			 System.out.println("Input Delivery national Code  :");
		     String dNCode  = sc.nextLine();
		     System.out.println("Input Mobile Phone  :");
		     int add_id  = sc.nextInt();
		     String address  = sc.nextLine();*/
		     
		    
		   // statement.executeUpdate("insert address set customer_name='"+b+"' where address_id=9 ");
		    
		    
		} catch(SQLException e) {
		   System.out.println(e.getMessage());
		    System.out.print("\ndkcsjcksjckjsdd");
		} finally {
		    try{
		           if(conn != null){
		            conn.close();
		           System.out.print("\nddd");
		           }

		    }catch(SQLException ex){
		           System.out.println(ex.getMessage());
		            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
		    }
		}

		    }

		 public static void insertfoodOrder(int fact_num , String foodName, int price , int num) {
			 
			 Connection conn = null;
		       Statement statement;
		    	//db();
		try {
		    // db parameters
		    String url       = "jdbc:mysql://localhost:3306/db_final_project";
		    String user      = "root";
		    String password  = "emma1998";
		    
		    // create a connection to the database
		    conn = DriverManager.getConnection(url, user, password);
		    // more processing here
		    // ...    

		     statement = conn.createStatement();

		   /* String b = "تت";
		    String n = "32000";*/
		    Date d = new Date();
		    LocalDateTime now = LocalDateTime.now();
		    System.out.println(d);
		     
		    statement.executeUpdate("insert into contains "+"(factor_FoodFactor_number,order_FoodFood_name,order_FoodFood_price,numberOfOrder)" + "values" +"('"+fact_num+"','"+foodName+"','"+price+"','"+num+"')");
		} catch(SQLException e) {
		   System.out.println(e.getMessage());
		    System.out.print("\ndkcsjcksjckjsdd");
		} finally {
		    try{
		           if(conn != null){
		            conn.close();
		           System.out.print("\nddd");
		           }

		    }catch(SQLException ex){
		           System.out.println(ex.getMessage());
		            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
		    }
		}

		    }
		 
		 public static void registerFactor_food()
			{
				Connection conn = null;
			       Statement statement,st;
			       Scanner sc = new Scanner(System.in);
			       String c = "e";
			   	int factor_number;
			   		
				int address_id=0;
				//String cName=null;
				int []price = new int[10]; 
				int []num = new int[10]; 
				String foodName;
				int total=0;
				int number;
				int i =0;
				String h;
				String storeName;
				ArrayList<String> oName = new ArrayList<String>();
				  int fact_num=3 ;
				  
			       String user_id;

			try {
			    // db parameters
			    String url       = "jdbc:mysql://localhost:3306/db_final_project";
			    String user      = "root";
			    String password  = "emma1998";
			    
			    // create a connection to the database
			    conn = DriverManager.getConnection(url, user, password);
			    // more processing here
			    // ...    
			     statement = conn.createStatement();
			     st = conn.createStatement();

			     String favoriteFood = null;

			     ResultSet rset1;
			     System.out.println("Customer Name\t address_id :");
				    ResultSet rset = statement.executeQuery("select address_id,customer_name from address");
				    rset1 = st.executeQuery("select national_code from delivery");
				    while(rset.next()){
				        System.out.println(rset.getString("customer_name") +"\t"+"\t"+"\t"+rset.getInt("address_id"));
				    }
				    
				     System.out.println("Delivery id  :");
					    rset1 = statement.executeQuery("select national_code from delivery");
					    while(rset1.next()){
					    	System.out.println(rset1.getString("national_code"));
					    }

				  
				//while(c.equals("e")) {

				  	//show stores and names
					//showStores();
					System.out.println("Registering Ordered food:");
					System.out.println("Order Food :");
					System.out.println("!! Any Item You want to put it null Enter 0 for it !! :");
					//System.out.println("to EXIT press m :");
					//c = sc.nextLine();
				//	if(c.equals("e"))break;
					System.out.println("factor_number :");
					factor_number = sc.nextInt();
					//System.out.print(factor_number);
					 System.out.println("Input Customer Name  :");
					 String h1 = sc.nextLine();
				     String cName  = sc.nextLine();
					 System.out.println("Input Customer National Code  :");
				     String cNCode  = sc.nextLine();
					 System.out.println("Input Delivery national Code  :");
				     String dNCode  = sc.nextLine();
				     System.out.println("Input Address Id  :");
				     int add_id  = sc.nextInt();
				     System.out.println("Input Address   :");
				     h1 = sc.nextLine();
				     String address  = sc.nextLine();
					
					

				     System.out.println("Registering Ordered food:");
						System.out.printf("%d--------",factor_number);

						for(int i1=0;i1<num.length;i1++ ) {

						System.out.println("to EXIT press e :");
						
						c = sc.nextLine();
						if(c.equals("e"))break;
						System.out.println("Food_name :");
						oName.add(sc.nextLine());
						
						System.out.println("Number :");
						num[i1] = sc.nextInt();
						System.out.println("Food Price :");
						price[i1] = sc.nextInt();
						c = sc.nextLine();
						total += price[i1]*num[i1];
						
						
					}
						// h = sc.nextLine();
						System.out.println(total);
						 //register_factor(factor_number,storeName,total);
						insertFactor(factor_number,add_id,total,cName,cNCode,address,dNCode);
						for(int i1=0;i1<oName.size();i1++ )
					  insertfoodOrder( factor_number ,oName.get(i1),price[i1] ,num[i1]);

						
					/* Factor_food f = new Factor_food(11,"scscc",5, null ,4000,"nima" );
						System.out.println(factor_number);
					 register_factor(factor_number,storeName,total);
					/* for(int j=0;j<o.length;j++) {
						 o[j].register_factor();
					 }*/
				
			} catch(SQLException e) {
				   System.out.println(e.getMessage());
				    System.out.print("\ndkcsjcksjckjsdd");
				} finally {
				    try{
				           if(conn != null){
				            conn.close();
				           System.out.print("\nddd");
				           }

				    }catch(SQLException ex){
				           System.out.println(ex.getMessage());
				            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
				    }
				}

					
				
			}
			
		 
	 
	 
	

}
