package com.empresa.rest.AuthAPI.Repository;

import com.empresa.rest.AuthAPI.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

}
