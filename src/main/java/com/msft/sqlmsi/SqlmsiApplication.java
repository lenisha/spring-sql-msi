package com.msft.sqlmsi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SqlmsiApplication { //implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SqlmsiApplication.class, args);
	}

	
	@Bean
    public CommandLineRunner demo(DataSource ds) {
    return (args) -> {
        
		
		try (Connection connection = ds.getConnection(); 
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT SUSER_SNAME()")) {
            if (rs.next()) {
                System.out.println("You have successfully logged on as: " + rs.getString(1));
            }
        }
	 };
	} 

	/*@Bean
    public CommandLineRunner demo(CustomerRepository repository) {
    return (args) -> {
      // save a few customers
      repository.save(new Customer("Jack", "Bauer"));
      repository.save(new Customer("Chloe", "O'Brian"));
      repository.save(new Customer("Kim", "Bauer"));
      repository.save(new Customer("David", "Palmer"));
      repository.save(new Customer("Michelle", "Dessler"));

      // fetch all customers
       System.out.println("Customers found with findAll():");
       System.out.println("-------------------------------");
      for (Customer customer : repository.findAll()) {
         System.out.println(customer.toString());
      }
       System.out.println("");

     
      // fetch customers by last name
       System.out.println("Customer found with findByLastName('Bauer'):");
       System.out.println("--------------------------------------------");
       repository.findByLastName("Bauer").forEach(bauer -> {
         System.out.println(bauer.toString());
       });

	   System.out.println("Customers: deleted");
       System.out.println("--------------------------------------------");
       repository.deleteAll();
       System.out.println("");
    };
  }*/

}
