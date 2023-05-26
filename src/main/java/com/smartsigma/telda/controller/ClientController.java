package com.smartsigma.telda.controller;

import com.smartsigma.telda.entity.Client;
import com.smartsigma.telda.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/telda-home")
public class ClientController {

    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientService.findAll();
    }
    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable long id) {
        return clientService.findById(id);
    }
    @GetMapping("/clients/email/{email}")
    public Client getClient(@PathVariable String email) throws Exception {
        return clientService.findByEmail(email);
    }
    @GetMapping("/clients/phoneNo/{phoneNo}")
    public Client getClientByEmail(@PathVariable String phoneNo) throws Exception {
        return clientService.findByPhoneNo(phoneNo);
    }
    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client) throws Exception {
        return clientService.save(client);
    }

    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable long id,
                             @RequestBody Client newClient) throws Exception {
        Client client = clientService.findById(id);
        if (client == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client bot found!");
        }
        return clientService.update(newClient);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable long id) throws Exception {
        Client client = clientService.findById(id);
        if (client == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client bot found!");
        }
        clientService.deleteById(id);
    }


}
