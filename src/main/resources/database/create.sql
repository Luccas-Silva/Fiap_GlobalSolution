INSERT INTO AREA_RISCO (ID_AREA_RISCO, NOME_AREA, TIPO_RISCO, LATITUDE, LONGITUDE, DESCRICAO, STATUS_AREA) VALUES
  (1, 'Zona Leste', 'Incêndio', -23.55, -46.60, 'Área industrial com risco de incêndio', 'Ativo'),
  (2, 'Zona Norte', 'Inundação', -23.50, -46.62, 'Área residencial sujeita a enchentes', 'Ativo'),
  (3, 'Centro Antigo', 'Desabamento', -23.54, -46.63, 'Prédios antigos com risco estrutural', 'Ativo');

INSERT INTO USUARIO (ID_USUARIO, NOME, EMAIL, TELEFONE, CARGO, SENHA, ATIVO) VALUES
  (1, 'João Silva',   'joao.silva@email.com',   '11999990001', 'Coordenador', 'senha1', 'S'),
  (2, 'Maria Souza',  'maria.souza@email.com',  '11999990002', 'Técnica',     'senha2', 'S'),
  (3, 'Carlos Pereira','carlos.pereira@email.com','11999990003','Supervisor',  'senha3', 'S');

INSERT INTO EQUIPE_RESPOSTA (ID_EQUIPE, NOME_EQUIPE, AREA_ATUACAO, CONTATO) VALUES
  (1, 'Alfa', 'Zona Leste', '11988880001');

INSERT INTO EQUIPE_RESPOSTA_USUARIO (ID_EQUIPE, ID_USUARIO) VALUES
  (1, 1),
  (1, 2);

INSERT INTO SENSOR (ID_SENSOR, TIPO_SENSOR, MARCA, LOCALIZACAO, UNIDADE_MEDIDA, DATA_INSTALACAO, STATUS_SENSOR, VALOR_LIDO_SENSOR, DATA_HORA_LEITURA_SENSOR, ID_AREA_RISCO) VALUES
  (1, 'Temperatura',   'Acme', 'Galpãos',      'Celsius',        CURRENT_DATE, 'Ativo', 25.0, CURRENT_TIMESTAMP, 1),
  (2, 'Umidade',       'Acme', 'Cobertura',    'Percentual',     CURRENT_DATE, 'Ativo', 80.0, CURRENT_TIMESTAMP, 2),
  (3, 'Movimentação',  'Acme', 'Subterrâneo',  'Movimentos/min', CURRENT_DATE, 'Ativo',  2.0, CURRENT_TIMESTAMP, 3);

INSERT INTO ALERTA (ID_ALERTA, NOME_TIPO_ALERTA, DESCRICAO_TIPO_ALERTA, NIVEL_GRAVIDADE_ALERTA, DATA_GERACAO, MENSAGEM, STATUS_ALERTA, VALOR_GATILHO, DATA_INICIO_ATUACAO, DATA_FIM_ATUACAO, OBSERVACAO_ATUACAO, ID_AREA_RISCO, ID_EQUIPE) VALUES
  (1, 'Temperatura Alta', 'Detectada temperatura acima do permitido', 3, CURRENT_DATE, 'Temperatura perigosa no galpão!', 'Ativo', 60.0, CURRENT_TIMESTAMP, NULL, 'Aguardando vistoria.', 1, 1),
  (2, 'Alagamento', 'Umidade excessiva detectada', 2, CURRENT_DATE, 'Risco de alagamento identificado!', 'Ativo', 90.0, CURRENT_TIMESTAMP, NULL, 'Monitorar nível de água.', 2, 1),
  (3, 'Risco de Desabamento', 'Estrutura comprometida detectada por sensores.', 4, CURRENT_DATE, 'Atenção: Estrutura do prédio pode ceder. Evacuação recomendada!', 'Ativo', 1.0, CURRENT_TIMESTAMP, NULL, 'Isolar o local e acionar Defesa Civil.', 3, 1);