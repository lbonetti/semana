DROP DATABASE IF EXISTS pesquisa;
CREATE DATABASE pesquisa;
USE pesquisa;
CREATE TABLE questionario (
	id INT NOT NULL PRIMARY KEY, 
	satisfeito BOOLEAN NOT NULL,
	nota INT NOT NULL,
	sugestao TEXT NULL,
	avaliacao TEXT NULL,
	publicar BOOLEAN NOT NULL,
	nome VARCHAR(60) NULL,
	publicado BOOLEAN NULL
);
