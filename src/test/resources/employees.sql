drop table employees if exists;
drop table departments if exists;


create table departments (
 id integer	/* id */ ,
 dept_name varchar(100) not null	/* name */ 
);
alter table departments add constraint pk_departments primary key (id);
drop sequence seq_department if exists;
create sequence seq_department start with 100;
create table employees (
 id_department integer	/* id.idDepartment */ ,
 dni varchar(100)	/* id.dni */ ,
 le_name varchar(100) not null	/* name */ ,
 salary decimal not null	/* salary */ ,
 birth_date timestamp not null	/* birthDate */ ,
 sex varchar(20) not null	/* sex */ 
);
alter table employees add constraint pk_employees primary key (id_department,dni);
alter table employees add foreign key (id_department) references departments(id);
