package com.empresa.rest.AuthAPI.Service.IMPL;

import com.empresa.rest.AuthAPI.Persistence.ContactDAOImpl;
import com.empresa.rest.AuthAPI.Service.IContactService;
import com.empresa.rest.AuthAPI.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContacServiceImpl implements IContactService {

    @Autowired
    private ContactDAOImpl contactDAOImpl;

    @Override
    public List<Contact> findAll() {
        return contactDAOImpl.findAll();
    }

    @Override
    public Optional<Contact> save(Contact contact) {
        return contactDAOImpl.save(contact);
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return contactDAOImpl.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        contactDAOImpl.deleteById(id);
    }
}
