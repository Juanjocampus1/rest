package com.empresa.rest.AuthAPI.Persistence;

import com.empresa.rest.AuthAPI.entity.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IContactDAO {

    List<Contact> findAll();
    Optional<Contact> save(Contact contact);
    Optional<Contact> findById(Long id);
    void deleteById(Long id);
}
