USE db_springboot;

#Select clásicos
SELECT * FROM clientes;
SELECT * FROM comunas;
SELECT * FROM accesos;
SELECT * FROM transportista;

#Información de las tablas
SHOW CREATE TABLE clientes;
SHOW TABLE STATUS FROM db_springboot LIKE 'clientes';

# truncar y eliminar tablas
TRUNCATE TABLE accesos;
TRUNCATE TABLE clientes;
TRUNCATE TABLE comunas;
TRUNCATE TABLE transportista;

#Eliminar registros
DELETE FROM clientes WHERE id = 12;

#Actualizar registros
UPDATE transportista
SET email ='baraneda@gmail.com'
WHERE id = 8;

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
  
  
CREATE TABLE `db_springboot`.`transportista` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

  
#Insert para poblar tablas.  
INSERT INTO accesos (id,email,pass) VALUES (NULL,"cortizmardones@gmail.com","Mhunter.4");


INSERT INTO clientes (id, nombre, apellido, email, create_at, id_comuna) VALUES (NULL,'Carlos','Ortiz','cortiz@bbr.cl' , '22/03/1988' , 1);
INSERT INTO clientes (id, nombre, apellido, email, create_at, id_comuna) VALUES (NULL,'Marcelo','Veloso','mveloso@bbr.cl' , '16/01/1992' , 1);
INSERT INTO clientes (id, nombre, apellido, email, create_at, id_comuna) VALUES (NULL,'Gonzalo','Fernandez','gfernandez@bbr.cl' , '01/04/1985' , 13);
INSERT INTO clientes (id, nombre, apellido, email, create_at, id_comuna) VALUES (NULL,'Esteban','Bustos','ebustos@gmail.com' , '14/09/1998' ,3);
INSERT INTO clientes (id, nombre, apellido, email, create_at, id_comuna) VALUES (NULL,'Jose','Bernales','j.bernales@gmail.com' , '25/01/1989' , 3);
INSERT INTO clientes (id, nombre, apellido, email, create_at, id_comuna) VALUES (NULL,'Javier','Olivares','javier.olivares@gmail.com' , '16/02/1994' , 10);
INSERT INTO clientes (id, nombre, apellido, email, create_at, id_comuna) VALUES (NULL,'Roberto','Maturana','roberto.maturana@gmail.com' , '22/03/1988' ,3);
INSERT INTO clientes (id, nombre, apellido, email, create_at, id_comuna) VALUES (NULL,'Mirtha','Castro','mcastro@gmail.com' , '22/03/1988' , 3);
INSERT INTO clientes (id, nombre, apellido, email, create_at, id_comuna) VALUES (NULL,'Omar','Romero','omar.romero@gmail.com' , '22/03/1988' , 15);
INSERT INTO clientes (id, nombre, apellido, email, create_at, id_comuna) VALUES (NULL,'Katherine','Placencia','kat.placencia12@gmail.com' , '13/04/1992' , 8);


INSERT INTO comunas (id, nombre) VALUES (1,'Santiago');
INSERT INTO comunas (id, nombre) VALUES (2,'Puente Alto');
INSERT INTO comunas (id, nombre) VALUES (3,'San Bernardo');
INSERT INTO comunas (id, nombre) VALUES (4,'Las Condes');
INSERT INTO comunas (id, nombre) VALUES (5,'Renca');
INSERT INTO comunas (id, nombre) VALUES (6,'Maipu');
INSERT INTO comunas (id, nombre) VALUES (7,'Conchali');
INSERT INTO comunas (id, nombre) VALUES (8,'La Pintana');
INSERT INTO comunas (id, nombre) VALUES (9,'La Florida');
INSERT INTO comunas (id, nombre) VALUES (10,'Peñalolen');
INSERT INTO comunas (id, nombre) VALUES (11,'Vitacura');
INSERT INTO comunas (id, nombre) VALUES (12,'Estación Central');
INSERT INTO comunas (id, nombre) VALUES (13,'San Miguel');
INSERT INTO comunas (id, nombre) VALUES (14,'Providencia');
INSERT INTO comunas (id, nombre) VALUES (15,'La Granja');


INSERT INTO transportista (id, nombre ,apellido) VALUES (NULL,'Carlos','Ortiz','cortizmardones@gmail.com');
INSERT INTO transportista (id, nombre ,apellido) VALUES (NULL,'Marcelo','Veloso','mveloso@gmail.com');
INSERT INTO transportista (id, nombre ,apellido) VALUES (NULL,'Gonzalo','Fernandez','gfernandez@gmail.com');
INSERT INTO transportista (id, nombre ,apellido) VALUES (NULL,'Jose','Bernales','jbernales@gmail.com');
INSERT INTO transportista (id, nombre ,apellido) VALUES (NULL,'Esteban','Bustos','ebustos@gmail.com');
INSERT INTO transportista (id, nombre ,apellido) VALUES (NULL,'Omar','Romero','oromero@gmail.com');
INSERT INTO transportista (id, nombre ,apellido) VALUES (NULL,'Raúl','Pardo','rpardo@gmail.com');
INSERT INTO transportista (id, nombre ,apellido) VALUES (NULL,'Benjamin','Araneda','baraneda@gmail.com');

SELECT * FROM transportista;










