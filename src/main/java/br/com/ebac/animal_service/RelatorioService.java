package br.com.ebac.animal_service;

import br.com.ebac.animal_service.repositorios.AnimalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class RelatorioService {

    private final AnimalRepository animalRepository;

    public RelatorioService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<AnimalRepository.QuantidadeAnimaisPorFuncionario> gerarRelatorio(LocalDate dataInicio, LocalDate dataFim) {
        if (dataInicio == null || dataFim == null) {
            throw new IllegalArgumentException("As datas não podem ser nulas.");
        }

        if (dataInicio.isAfter(dataFim)) {
            throw new IllegalArgumentException("Data de início deve ser anterior à data final.");
        }

        if (ChronoUnit.DAYS.between(dataInicio, dataFim) > 365) {
            throw new IllegalArgumentException("O intervalo de datas não pode ultrapassar 1 ano.");
        }

        return animalRepository.contarAnimaisPorFuncionario(dataInicio, dataFim);
    }
}
