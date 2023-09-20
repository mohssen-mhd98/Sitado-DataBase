package dbFinal;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Order_food {

		int price;
		String foodName;
		int factor_number;
		int number;
		
		public Order_food(int price, String foodName,int number,int factor_number) {
			super();
			this.price = price;
			this.foodName = foodName;
			this.factor_number = factor_number;
			this.number = number;
		}


		public void  register_factor() {

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

		   /* String b = "تت";
		    String n = "32000";*/
		    Date d = new Date();
		    LocalDateTime now = LocalDateTime.now();
		    SimpleDateFormat format = new SimpleDateFormat("now") ;
		    String currentDateTime = format.format(d);
		    System.out.println(d);
		    statement.executeUpdate("insert into factor_ingredients "+"(factor_number,total_cost,storeStore_name)"+"values"+"(11,20000,'jam')");
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
