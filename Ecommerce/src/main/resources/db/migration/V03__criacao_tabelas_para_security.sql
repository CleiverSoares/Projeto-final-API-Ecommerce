CREATE TABLE usuario (
   id serial PRIMARY key,
   nome varchar(60),
   email varchar(60),
   senha varchar(255)
);

CREATE TABLE perfil (
   id_perfil serial PRIMARY KEY,
   nome varchar(40)
);

CREATE TABLE usuario_perfil (
	id_usuario int REFERENCES usuario(id),
	id_perfil int REFERENCES perfil(id_perfil),
	data_criacao date,
	CONSTRAINT pk_usuario_perfil PRIMARY KEY (id_usuario, id_perfil)
);

INSERT INTO usuario (nome, email, senha) VALUES
('Alice Tatiane Agatha', 'alice@email.com', '$2a$12$jsrZJHW98FVfmcva2sUnBujYr80A1SeUrt91bK2kfBRlz3Ghw9/ym'),
('Enzo Davi Renato Moura', 'enzo@email.com', '$2a$12$ZpivUhJndDBoo3r2dbQXKu.N2J/KZVp1P9jqBPAQ4IKk8HUD1aYwC');

INSERT INTO perfil (nome) VALUES
('ADMIN'),
('USER');

INSERT INTO usuario_perfil (id_usuario, id_perfil) VALUES
( (SELECT id FROM usuario WHERE email='alice@email.com'),
  (SELECT id_perfil FROM perfil WHERE nome='ADMIN') ),
( (SELECT id FROM usuario WHERE email='alice@email.com'),
  (SELECT id_perfil FROM perfil WHERE nome='USER') ),

( (SELECT id FROM usuario WHERE email='enzo@email.com'),
  (SELECT id_perfil FROM perfil WHERE nome='USER') );
  