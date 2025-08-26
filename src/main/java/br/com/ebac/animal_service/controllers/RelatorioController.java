package br.com.ebac.animal_service.controllers;

import br.com.ebac.animal_service.RelatorioService;
import br.com.ebac.animal_service.repositorios.AnimalRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/relatorios")
public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping("/resgates")
    public ResponseEntity<List<Map<String, Object>>> getRelatorioResgates(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {

        try {
            List<AnimalRepository.QuantidadeAnimaisPorFuncionario> resultados =
                    relatorioService.gerarRelatorio(dataInicio, dataFim);

            List<Map<String, Object>> response = resultados.stream()
                    .map(r -> {
                        Map<String, Object> map = new HashMap<>();
                        map.put("funcionario", r.getNomeFuncionario());
                        map.put("quantidadeAnimais", r.getQuantidade());
                        return map;
                    })
                    .collect(Collectors.toList());

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            // Correção aqui:
            Map<String, Object> erro = new HashMap<>();
            erro.put("erro", e.getMessage());
            return ResponseEntity.badRequest().body(List.of(erro));
        }
    }
}
