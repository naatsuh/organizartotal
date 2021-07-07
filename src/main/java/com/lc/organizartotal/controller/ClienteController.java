package com.lc.organizartotal.controller;


import com.lc.organizartotal.model.Cliente;
import com.lc.organizartotal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/cadastrocliente")
    public String cadastro () {
        return "cadastro/cadastrocliente";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listadecliente")
    public String listadecliente () {
        return "cadastro/listadecliente";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/salvarcliente")
    public String save (Cliente cliente){
        clienteRepository.save(cliente);
        return "cadastro/cadastrocliente";
    }
}
