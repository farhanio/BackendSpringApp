package com.omar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.omar.dao.ContactRepository;
import com.omar.entities.Contact;

@SpringBootApplication
public class ContactsApplication implements CommandLineRunner{

	@Autowired
	private ContactRepository contactRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("Omar", "Farhani", new Date() , "omar@farhani.com", 	50734889, ""));
		contactRepository.save(new Contact("Sonia", "Chikhoui", df.parse("01/01/1999") , "omalo@farhani.com", 	50734889, ""));
		contactRepository.save(new Contact("Elite", "Book", df.parse("01/01/2015") , "farha@farhani.com", 	12345678, ""));	
		contactRepository.save(new Contact("Elite", "yess", df.parse("01/01/2015") , "farha@farhani.com", 	12345678, ""));
		contactRepository.save(new Contact("okok", "lombock", df.parse("01/01/2015") , "farha@farhani.com", 	12345678, ""));
		contactRepository.save(new Contact("jijji", "rockstar", df.parse("01/01/2015") , "farha@farhani.com", 	12345678, ""));
		contactRepository.save(new Contact("dodo", "podstar", df.parse("01/01/2015") , "farha@farhani.com", 	12345678, ""));
		contactRepository.save(new Contact("cc cc", "ipod", df.parse("01/01/2015") , "farha@farhani.com", 	12345678, ""));
		contactRepository.save(new Contact("Heart", "disease", df.parse("01/01/2015") , "farha@farhani.com", 	12345678, ""));
 
		contactRepository.findAll().forEach(c->{
			
			System.out.println(c.getNom()+"  "+c.getPrenom()+"  "+c.getDateNaissance());

		});
	
	}
}
