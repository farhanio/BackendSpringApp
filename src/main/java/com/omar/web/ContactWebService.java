package com.omar.web;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omar.dao.ContactRepository;
import com.omar.entities.Contact;

@RestController
@CrossOrigin("*")
public class ContactWebService {

	@Autowired
	private ContactRepository contactRepository;
	
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public List<Contact> getContacts(){
		return contactRepository.findAll();
	}
	
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.GET)
	public Contact getContact(@PathVariable Long id){
		return contactRepository.findOne(id);
	}
	
	@RequestMapping(value="/contacts", method=RequestMethod.POST)
	public Contact saveContact(@RequestBody Contact contact){
		return contactRepository.save(contact);
	}
	
	@RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
	public void deleteContact(@PathVariable Long id) {
		contactRepository.delete(id);
	}
	
	@RequestMapping(value="/contacts", method=RequestMethod.PUT)
	public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact){
		contact.setId(id);
		return contactRepository. save(contact);
	}
	
	@RequestMapping(value="/chercherContacts", method=RequestMethod.GET)
	public Page<Contact> chercher(@RequestParam(name="mc", defaultValue= "") String mc,
			@RequestParam(name="page", defaultValue= "0") int page,
			@RequestParam(name="size", defaultValue= "1") int size){
		return contactRepository.chercher("%"+mc+"%", new PageRequest(page, size)) ;
	}
	
}
