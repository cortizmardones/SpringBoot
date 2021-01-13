use db_springboot;

#Select clásicos
select * from clientes;
select * from comunas;
select * from accesos;

#Información de las tablas
SHOW CREATE TABLE clientes;
SHOW TABLE STATUS FROM db_springboot LIKE 'clientes';

# truncar y eliminar tablas
TRUNCATE TABLE clientes;
TRUNCATE TABLE comunas;

#Eliminar registros
delete from clientes where id = 12;

#LLaves foraneas FK
ALTER TABLE clientes 
ADD CONSTRAINT fk_clientes_comunas 
FOREIGN KEY (id_comuna) 
REFERENCES comunas (id) 
ON DELETE NO ACTION 
ON UPDATE NO ACTION ;

#Restricción de registros unicos
ALTER TABLE `db_springboot`.`accesos` 
ADD UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE;

DROP INDEX `email_UNIQUE` ON `db_springboot`.`accesos` ;

##Crear campos autoincrementables
ALTER TABLE `db_springboot`.`clientes` 
CHANGE COLUMN `id` `id` INT NOT NULL AUTO_INCREMENT ;

ALTER TABLE `db_springboot`.`accesos` 
CHANGE COLUMN `id` `id` INT NOT NULL AUTO_INCREMENT ;




#Creación de tablas.
CREATE TABLE `db_springboot`.`accesos` (
  `id` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

#Insert para poblar tablas.  
insert into accesos (id,email,pass) values (null,"cortizmardones@gmail.com","Mhunter.4");

Insert into clientes (id, nombre, apellido, email, create_at, id_comuna) values (null,'Carlos','Ortiz','cortiz@bbr.cl' , '22/03/1988' , 1);
Insert into clientes (id, nombre, apellido, email, create_at, id_comuna) values (null,'Marcelo','Veloso','mveloso@bbr.cl' , '16/01/1992' , 1);
Insert into clientes (id, nombre, apellido, email, create_at, id_comuna) values (null,'Gonzalo','Fernandez','gfernandez@bbr.cl' , '01/04/1985' , 13);
Insert into clientes (id, nombre, apellido, email, create_at, id_comuna) values (null,'Esteban','Bustos','ebustos@gmail.com' , '14/09/1998' ,3);
Insert into clientes (id, nombre, apellido, email, create_at, id_comuna) values (null,'Jose','Bernales','j.bernales@gmail.com' , '25/01/1989' , 3);
Insert into clientes (id, nombre, apellido, email, create_at, id_comuna) values (null,'Javier','Olivares','javier.olivares@gmail.com' , '16/02/1994' , 10);
Insert into clientes (id, nombre, apellido, email, create_at, id_comuna) values (null,'Roberto','Maturana','roberto.maturana@gmail.com' , '22/03/1988' ,3);
Insert into clientes (id, nombre, apellido, email, create_at, id_comuna) values (null,'Mirtha','Castro','mcastro@gmail.com' , '22/03/1988' , 3);
Insert into clientes (id, nombre, apellido, email, create_at, id_comuna) values (null,'Omar','Romero','omar.romero@gmail.com' , '22/03/1988' , 15);
Insert into clientes (id, nombre, apellido, email, create_at, id_comuna) values (null,'Katherine','Placencia','kat.placencia12@gmail.com' , '13/04/1992' , 8);

insert into comunas (id, nombre) values (1,'Santiago');
insert into comunas (id, nombre) values (2,'Puente Alto');
insert into comunas (id, nombre) values (3,'San Bernardo');
insert into comunas (id, nombre) values (4,'Las Condes');
insert into comunas (id, nombre) values (5,'Renca');
insert into comunas (id, nombre) values (6,'Maipu');
insert into comunas (id, nombre) values (7,'Conchali');
insert into comunas (id, nombre) values (8,'La Pintana');
insert into comunas (id, nombre) values (9,'La Florida');
insert into comunas (id, nombre) values (10,'Peñalolen');
insert into comunas (id, nombre) values (11,'Vitacura');
insert into comunas (id, nombre) values (12,'Estación Central');
insert into comunas (id, nombre) values (13,'San Miguel');
insert into comunas (id, nombre) values (14,'Providencia');
insert into comunas (id, nombre) values (15,'La Granja');
