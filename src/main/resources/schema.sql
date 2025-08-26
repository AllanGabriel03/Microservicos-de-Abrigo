CREATE TABLE funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255)
);

CREATE TABLE animal(
 id INT AUTO_INCREMENT PRIMARY KEY,
  especie VARCHAR(255) NOT NULL,
  nome_provisorio VARCHAR(255) NOT NULL,
  idade_estimada INT NOT NULL,
  raca VARCHAR(255) NOT NULL,
  data_entrada date NOT NULL,
  data_adocao date,
  condicoes_chegada VARCHAR(255) NOT NULL,
  funcionario_id BIGINT,
      FOREIGN KEY (funcionario_id) REFERENCES funcionario(id),
  data_obito date,
  porte VARCHAR(255) NOT NULL,
  CONSTRAINT pk_animal PRIMARY KEY (id)
);