package com.empresa.rest.AuthAPI.Persistence;

import com.empresa.rest.AuthAPI.Repository.ContactRepository;
import com.empresa.rest.AuthAPI.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ContactDAOImpl implements IContactDAO{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return (List<Contact>) contactRepository.findAll();
    }

    @Override
    public Optional<Contact> save(Contact contact) {
        return Optional.of(contactRepository.save(contact));
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}