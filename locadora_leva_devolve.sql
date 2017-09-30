drop table if exists emprestimos_items;
drop table if exists livros;
drop table if exists categorias_livros;
drop table if exists emprestimos;
drop table if exists clientes;
drop table if exists funcionarios;

create table funcionarios (
	profissional_id serial,
	nome varchar(100) not null,
	login varchar(45) not null,
	senha varchar(10) not null,
	permissao varchar(20) check (permissao in('gerente', 'locador')) not null default 'locador',
	primary key(profissional_id),
	unique(login)
);

create table categorias_livros (
	categoria_id serial,
	nome varchar(30) not null,
	descricao text,
	preco float not null,
	primary key(categoria_id)
);

create table livros (
	livro_id serial,
	categoria_id integer,
	nome varchar(45) not null,
	primary key(livro_id),
	foreign key(categoria_id) references categorias_livros(categoria_id)
);

create table clientes (
	cliente_id serial,
	nome varchar(100) not null,
	telefone varchar(15),
	primary key(cliente_id)
);

create table emprestimos (
	emprestimo_id serial,
	cliente_id integer,
	data_emprestimo date not null,
	data_devolucao date,
	status varchar(15) check (status in('andamento', 'concluido')) not null default 'andamento',
	primary key(emprestimo_id),
	foreign key(cliente_id) references clientes(cliente_id)
);

create table emprestimos_items (
	livro_id integer,
	emprestimo_id integer,
	preco_livro float not null,
	primary key(livro_id, emprestimo_id),
	foreign key(livro_id) references livros(livro_id),
	foreign key(emprestimo_id) references emprestimos(emprestimo_id)
);
