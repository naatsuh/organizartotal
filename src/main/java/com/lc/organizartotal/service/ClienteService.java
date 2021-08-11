package com.lc.organizartotal.service;

import com.lc.organizartotal.model.Cliente;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ClienteService {
    List<Cliente> getAllClientes();
    void saveCliente(Cliente cliente);
    Cliente getClienteById(long id);
    void deletarClienteById(long id);
    Page<Cliente> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
