-- This will create some database objects as well some data on server init,
-- Springboot will execute all DML/DDL commands it gets on data.sql
-- more: https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html (78.3 Initialize a database)

--Clean all objects
DROP ALL OBJECTS;

--Create a new table 'batata'
CREATE TABLE batata (
  id   INTEGER AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  type VARCHAR(50)
);

--Create a new table 'batata'
CREATE TABLE mimimi (
  id   INTEGER AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(50),
  description_mimimi VARCHAR(50)
);

--Insert some batata's  data
INSERT INTO batata(name, type) VALUES ('potato',   'English batata');
INSERT INTO batata(name, type) VALUES ('batata',   'Batata');
INSERT INTO batata(name, type) VALUES ('patatas',  'Patata española');
INSERT INTO batata(name, type) VALUES ('kartofel', 'Rossiyskiy kartofel');

--Insert some batata's  data
INSERT INTO mimimi(type, description_mimimi) VALUES ('chorar', 'mi mi mi mi');
INSERT INTO mimimi(type, description_mimimi) VALUES ('reclamar', 'mimimimi');
INSERT INTO mimimi(type, description_mimimi) VALUES ('meh', 'meh');
