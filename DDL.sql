create schema armazem;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on armazem.* to user@'localhost';

use armazem;

create table pro_produto (
    pro_id bigint unsigned not null auto_increment,
    pro_nome varchar(100) not null,
    pro_peso int not null,
    pro_descricao varchar(200),
    primary key (pro_id),
    unique key uni_produto_nome (pro_nome)
); 

create table cat_categoria (
    cat_id bigint unsigned not null auto_increment,
    cat_nome varchar(100) not null,
    cat_descricao varchar(200),
    cat_ranking int,
    primary key (cat_id),
    unique key uni_categoria_nome (cat_nome)
);


create table pca_produto_categoria (
    pro_id bigint unsigned not null,
    cat_id bigint unsigned not null,
    primary key (pro_id, cat_id),
    foreign key pca_pro_fk (pro_id)
        references pro_produto (pro_id)
        on delete restrict on update cascade,
    foreign key pca_cat_fk (cat_id)
        references cat_categoria (cat_id)
        on delete restrict on update cascade
);

create table mov_movimentacao (
    mov_id bigint unsigned not null auto_increment,
    mov_data datetime not null,
    mov_quantidade int not null,
    mov_sentido varchar(7) not null,
    pro_id bigint unsigned not null,
    primary key (mov_id),
    foreign key mov_pro_fk (pro_id)
        references pro_produto (pro_id)
        on delete restrict on update cascade
);

create table usr_usuario (
    usr_id bigint unsigned not null auto_increment,
    usr_nome varchar(20) not null,
    usr_email varchar(100) not null,
    usr_senha varchar(100) not null,
    primary key (usr_id),
    unique key uni_usuario_nome (usr_nome),
    unique key uni_usuario_email (usr_email)
);

create table aut_autorizacao (
    aut_id bigint unsigned not null auto_increment,
    aut_nome varchar(20) not null,
    primary key (aut_id),
    unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
    usr_id bigint unsigned not null,
    aut_id bigint unsigned not null,
    primary key (usr_id, aut_id),
    foreign key uau_usr_fk (usr_id)
        references usr_usuario (usr_id)
        on delete restrict on update cascade,
    foreign key uau_aut_fk (aut_id)
        references aut_autorizacao (aut_id)
        on delete restrict on update cascade
);
create table adega(
    ad_cod bigint auto_increment,
    ad_produto varchar (200),
    ad_quantidade int not null,
    ad_marca varchar(20),
    ad_local varchar 20
);

insert into usr_usuario (usr_nome, usr_email, usr_senha)
    values ('admin','admin@gmail.com', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');
insert into aut_autorizacao (aut_nome)
    values ('ROLE_ADMIN');
insert into uau_usuario_autorizacao values (1, 1);