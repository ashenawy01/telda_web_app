package com.smartsigma.telda.service;

import com.smartsigma.telda.entity.Client;
import com.smartsigma.telda.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ClientService {

    private ClientRepository clientRepository;

    public Client save(Client client) throws Exception {
        return clientRepository.save(client);
    }
    public Client findById(long id) {
        return clientRepository.findById(id).orElse(null);
    }
    public Client findByEmail(String email) throws Exception {
        return clientRepository.findByEmail(email);
    }
    public Client findByPhoneNo(String phoneNo) throws Exception {
        return clientRepository.findByPhoneNo(phoneNo);
    }
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
    public Client update(Client client) {
        Client oldClient = findById(client.getId());
        if (oldClient == null) {
            // throw Username not found
        }
        return clientRepository.save(client);
    }

    public boolean deleteById(long id) throws Exception {
        Client client = findById(id);
        if (client == null) {
            // throw Username not found
        }
        clientRepository.deleteById(id);
        return true;
    }
}
