package com.empresa.rest.AuthAPI.Service;

import com.empresa.rest.AuthAPI.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface IContactService {

    List<Contact> findAll();
    Optional<Contact> save(Contact contact);
    Optional<Contact> findById(Long id);
    void deleteById(Long id);
}
