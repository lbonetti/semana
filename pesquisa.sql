DROP DATABASE IF EXISTS pesquisa;
CREATE DATABASE pesquisa;
USE pesquisa;
CREATE TABLE questionario (
	id INT NOT NULL PRIMARY KEY, 
	satisfeito BOOLEAN NOT NULL,
	nota INT NOT NULL,
	sugestao VARCHAR(255) NULL,
	avaliacao VARCHAR(255) NULL,
	publicar BOOLEAN NOT NULL,
	nome VARCHAR(60) NULL
);
