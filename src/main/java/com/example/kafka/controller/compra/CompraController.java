package com.example.kafka.controller.compra;


import com.example.kafka.application.compra.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final CompraService compraService;

    @Autowired
    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public CompraDto comprar(@RequestBody CompraDto dto) {
        return compraService.comprar(dto);
    }

    @GetMapping
    public List<CompraDto> listarCompras() {
        return compraService.listarCompras();
    }

}
