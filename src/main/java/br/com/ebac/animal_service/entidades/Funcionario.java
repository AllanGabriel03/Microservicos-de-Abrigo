package br.com.ebac.animal_service.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "recebedor")
    private List<Animal> animaisRecebidos;
}
