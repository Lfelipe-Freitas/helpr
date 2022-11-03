package org.soulcodeacademy.helpr.controller;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CargoController {
    @GetMapping("/oi") //com base em localhost:8080/oi retorna a String. END POINT -> endereço acessado no back end
    public String dizola(){
        return "Batata!";
    }

    @GetMapping("/batata")
    public Integer valor(){
        return 1000;
    }

    @Autowired
    private CargoService cargoService;

    @GetMapping("/cargos")
    public List<Cargo> listar(){
        // Requisição -> Controller -> service -> repository -> SELECT * FROM cargo
        return cargoService.listar(); // JSON
    }

    @GetMapping("/cargos/{idCargo}")
    public Cargo getCargo(@PathVariable Integer idCargo){
        // @PathVariable => extrai do endpoint o valor dinamico
        return this.cargoService.getCargo(idCargo); // JSON
    }
}
