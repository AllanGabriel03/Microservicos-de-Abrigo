-- Inserindo funcionários
INSERT INTO funcionario (nome) VALUES ('fantasma'); -- ID 1
INSERT INTO funcionario (nome) VALUES ('roberta');  -- ID 2
INSERT INTO funcionario (nome) VALUES ('spyke');    -- ID 3

-- Inserindo animais
INSERT INTO animal (
  especie, nome_provisorio, idade_estimada, raca,
  data_entrada, condicoes_chegada, funcionario_id, porte
)
VALUES (
  'cachorro', 'Cachorro louco', 5, 'SRD',
  current_date, 'pulguento', 3, 'grande'
);

INSERT INTO animal (
  especie, nome_provisorio, idade_estimada, raca,
  data_entrada, condicoes_chegada, funcionario_id, porte
)
VALUES (
  'cachorro', 'outro Cachorro louco', 5, 'husky',
  current_date, 'idoso', 1, 'pequeno' -- fantasma
);

INSERT INTO animal (
  especie, nome_provisorio, idade_estimada, raca,
  data_entrada, condicoes_chegada, funcionario_id, porte, data_adocao
)
VALUES (
  'cachorro', 'pitoca', 3, 'vira lata',
  current_date, 'medrosa', 2, 'pequeno', current_date -- roberta
);

INSERT INTO animal (
  especie, nome_provisorio, idade_estimada, raca,
  data_entrada, condicoes_chegada, funcionario_id, porte, data_adocao
)
VALUES (
  'gato', 'bichano', 6, 'Siamês',
  current_date, 'pulga', 2, 'médio', current_date -- roberta
);

INSERT INTO animal (
  especie, nome_provisorio, idade_estimada, raca,
  data_entrada, condicoes_chegada, funcionario_id, porte, data_adocao
)
VALUES (
  'Hamster', 'pork', 2, 'Sírio',
  current_date, 'pulga', 2, 'pequeno', current_date -- roberta
);
