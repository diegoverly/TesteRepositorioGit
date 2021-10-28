package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;





public class Conection {
	
	
	  public static Connection conector(){
	        
	        java.sql.Connection conexao = null;
	        
	        String driver = "org.firebirdsql.jdbc.FBDriver";
	        
	        Properties props = new Properties();
	        props.setProperty("user", "SYSDBA");
	        props.setProperty("password", "masterkey");
	        props.setProperty("encoding", "UTF8");
	               
	                
	        try {
	            
	            Class.forName(driver).newInstance(); //executa o arquivo do driver
	            
	            conexao = DriverManager.getConnection("jdbc:firebirdsql:localhost/3050:C:/database/DBINFOX.FDB",props);
	                                   
	            return conexao;             
	        } 
	        catch (Exception e) {
	            
	          return null;
	          
	        }
	                         
	        }
	        
	
	
	

}
