package dbFinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Factor_food {

	int factor_number;
	int totalCost=0;
	String address=null;
	String deliveryNational_code=null;
	int address_id=0;
	String cName=null;
	
	public Factor_food(int factor_number, String address,int address_id, 
			String deliveryNational_code ,int totalCost,String cName ) 
	{
		super();
		this.factor_number = factor_number;
		this.address = address;
		this.deliveryNational_code = deliveryNational_code;
		this.totalCost = totalCost;
		this.address_id = address_id;
		this.cName=cName;
	}



	public  void  register_factor() {
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

	    String b = "تت";
	    String m = "32000";
	     int n = 11;
	     int n1 = 4;
	     int t = 4000;
	    statement.execute("insert into factor_food values('"+n+"' ,'2019-10-27 18:55:00','"+n1+"','"+t+"','"+b+"' ,'kkjlj','"+m+"')");
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
	


