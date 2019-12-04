create schema busca_letras;

create table busca_letras.usuarios (
	id serial primary key,
	email varchar,
	senha varchar,
	nome varchar
);

create table busca_letras.artistas(
	id serial primary key,
	nome varchar
);

create table busca_letras.albuns(
	id serial primary key,
	id_artista integer references busca_letras.artistas(id),
	nome varchar
);

create table busca_letras.letras(
	id serial primary key,
	nome varchar,
	texto text,
	id_album integer references busca_letras.albuns(id)
);
