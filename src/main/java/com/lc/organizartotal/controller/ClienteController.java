package com.lc.organizartotal.controller;

import java.util.List;

import com.lc.organizartotal.model.Cliente;
import com.lc.organizartotal.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    @GetMapping("/listadecliente")
    public String listaDeCliente(Model model) {
        return findPaginated(1, "codigo", "asc", model);
    }

    @GetMapping("/cadastrocliente")
    public String cadastroDeCliente(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "cadastro/cadastrocliente";
    }

    @PostMapping("/saveCliente")
    public String saveCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/listadecliente";
    }

    @GetMapping("/editarcliente/{id}")
    public String editarCliente(@PathVariable ( value = "id") long id, Model model) {
        Cliente cliente = clienteService.getClienteById(id);
        model.addAttribute("cliente", cliente);
        return "cadastro/editarcliente";
    }

    @GetMapping("/deletarcliente/{id}")
    public String deletarCliente(@PathVariable (value = "id") long id) {
        this.clienteService.deletarClienteById(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Cliente> page = clienteService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Cliente> listadeclientes = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listadeclientes", listadeclientes);
        return "cadastro/listadecliente";
    }
}
