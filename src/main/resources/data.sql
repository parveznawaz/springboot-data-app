create table person
(
	id integer not null,
	name varchar(255),
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);


insert into person
(id, name, location, birth_date)
values(10001,'Parvez','Toronto',sysdate());


insert into person
(id, name, location, birth_date)
values(10002,'Tiri','Ajax',sysdate());

insert into person
(id, name, location, birth_date)
values(10003,'Nashid','Ajax',sysdate());