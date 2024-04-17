package com.empresa.rest.AuthAPI.Controller;

import com.empresa.rest.AuthAPI.DTO.ContactDTO;
import com.empresa.rest.AuthAPI.Service.IContactService;
import com.empresa.rest.AuthAPI.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private IContactService contactService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Contact> contactOptional = contactService.findById(id);
        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();

            ContactDTO contactDTO = ContactDTO.builder()
                    .id(contact.getId())
                    .correo(contact.getCorreo())
                    .ciudad(contact.getCiudad())
                    .fechaAlta(contact.getFechaAlta())
                    .unidades(contact.getUnidades())
                    .build();
            return ResponseEntity.ok(contactDTO);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ContactDTO>contactList = contactService.findAll()
                .stream()
                .map(contact -> ContactDTO.builder()
                        .id(contact.getId())
                        .correo(contact.getCorreo())
                        .ciudad(contact.getCiudad())
                        .fechaAlta(contact.getFechaAlta())
                        .unidades(contact.getUnidades())
                        .build())
                .toList();
        return ResponseEntity.ok(contactList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ContactDTO contactDTO) throws URISyntaxException {
        if (contactDTO.getCorreo().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        else {
            contactService.save(Contact.builder()
                    .correo(contactDTO.getCorreo())
                    .ciudad(contactDTO.getCiudad())
                    .fechaAlta(contactDTO.getFechaAlta())
                    .unidades(contactDTO.getUnidades())
                    .build());

            return ResponseEntity.created(new URI("/api/contact/save")).build();
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ContactDTO contactDTO) {

        Optional<Contact> contactOptional = contactService.findById(id);

        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            contact.setCorreo(contactDTO.getCorreo());
            contact.setCiudad(contactDTO.getCiudad());
            contact.setFechaAlta(contactDTO.getFechaAlta());
            contact.setUnidades(contactDTO.getUnidades());
            contactService.save(contact);
            return ResponseEntity.ok("Registro actualizado");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if (id != null) {
            contactService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }
}