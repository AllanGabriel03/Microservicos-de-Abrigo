package br.com.ebac.animal_service.repositorios;

import br.com.ebac.animal_service.entidades.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT a.recebedor.nome AS nomeFuncionario, COUNT(a.id) AS quantidade " +
            "FROM Animal a " +
            "WHERE a.dataEntrada BETWEEN :dataInicio AND :dataFim " +
            "GROUP BY a.recebedor.nome")
    List<QuantidadeAnimaisPorFuncionario> contarAnimaisPorFuncionario(
            @Param("dataInicio") LocalDate dataInicio,
            @Param("dataFim") LocalDate dataFim
    );

    interface QuantidadeAnimaisPorFuncionario {
        String getNomeFuncionario();
        Long getQuantidade();
    }

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada DESC")
    List<Animal> findNotAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL")
    List<Animal> findAdopted();
}
