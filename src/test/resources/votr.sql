
drop table usuaris if exists;
drop table opcions if exists;
drop table votacions if exists;


create table votacions (
 hash_votacio varchar(100)	/* hashVotacio */ ,
 nom varchar(100)	/* nom */ ,
 descripcio varchar(100)	/* descripcio */ ,
 data_inici timestamp	/* dataInici */ ,
 data_fi timestamp	/* dataFi */ 
);
alter table votacions add constraint pk_votacions primary key (hash_votacio);
create table opcions (
 id_opcio integer unique	/* id.idOpcio */ ,
 hash_votacio varchar(100)	/* id.hashVotacio */ ,
 nom varchar(100)	/* nom */ ,
 descripcio varchar(100)	/* descripcio */ 
);
alter table opcions add constraint pk_opcions primary key (id_opcio,hash_votacio);
alter table opcions alter column id_opcio integer generated by default as identity(start with 100);
create table usuaris (
 hash_usuari varchar(100)	/* id.hashUsuari */ ,
 hash_votacio varchar(100)	/* id.hashVotacio */ ,
 email varchar(100)	/* email */ ,
 alias varchar(100)	/* alias */ ,
 id_opcio_votada integer	/* idOpcioVotada */ ,
 data_votacio timestamp	/* dataVotacio */ 
);
alter table usuaris add constraint pk_usuaris primary key (hash_usuari,hash_votacio);


alter table opcions add foreign key (hash_votacio) references votacions (hash_votacio);
alter table usuaris add foreign key (hash_votacio) references votacions (hash_votacio);
alter table usuaris add foreign key (id_opcio_votada) references opcions (id_opcio);
