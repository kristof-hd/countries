set names utf8mb4;
set charset utf8mb4;
drop database if exists countries;
create database countries charset utf8mb4;
use countries;

CREATE TABLE countries (
  id int unsigned NOT NULL AUTO_INCREMENT primary key,
  code varchar(2) NOT NULL,
  name varchar(50) NOT NULL,
  capital varchar(50) NOT NULL
);

INSERT INTO countries(code, name, capital) VALUES
('BE', 'Belgium', 'Brussels'),
('NL', 'Netherlands', 'Amsterdam'),
('FR', 'France', 'Paris'),
('UK', 'United Kingdom', 'London')
;

create user if not exists cursist identified by 'cursist';
grant select on countries to cursist;