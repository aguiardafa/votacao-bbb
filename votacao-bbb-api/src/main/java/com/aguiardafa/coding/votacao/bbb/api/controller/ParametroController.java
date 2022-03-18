package com.aguiardafa.coding.votacao.bbb.api.controller;

import com.aguiardafa.coding.votacao.bbb.api.model.ParametroModel;
import com.aguiardafa.coding.votacao.bbb.api.repository.ParametroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/parametros")
public class ParametroController {

    private final ParametroRepository parametroRepository;

    public ParametroController(ParametroRepository parametroRepository) {
        this.parametroRepository = parametroRepository;
    }

    @PostMapping("/salvar")
    public ResponseEntity<ParametroModel> salvar(@RequestBody ParametroModel parametroRecebido){
        ParametroModel parametroSalvo = parametroRepository.save(parametroRecebido);
        return ResponseEntity.ok(parametroSalvo);
    }

    @GetMapping("/consultar")
    public ResponseEntity<ParametroModel> consultar(@RequestParam String chave){
        Optional<ParametroModel> optParametro = parametroRepository.findById(chave);
        if(optParametro.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optParametro.get());
    }

}
