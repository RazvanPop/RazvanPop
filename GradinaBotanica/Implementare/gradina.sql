CREATE DATABASE IF NOT EXISTS gradina;

USE gradina;

CREATE TABLE IF NOT EXISTS PLANTA
(
denumire VARCHAR(30) NOT NULL unique,
tip VARCHAR(30) not null,
specie VARCHAR(20) not null ,
carnivor varchar(20) not null,
zona varchar(25) not null );


CREATE TABLE IF NOT EXISTS ANGAJAT
(
nume VARCHAR(30) NOT NULL unique,
username VARCHAR(30) not null,
parola VARCHAR(30) NOT NULL unique);


CREATE TABLE IF NOT EXISTS ADMINISTRATOR
(
nume VARCHAR(30) not null unique,
username VARCHAR(30) not null,
parola VARCHAR(30) not null);



insert into PLANTA (denumire, tip, specie,carnivor,zona) values
("Crizantema","asteraceae","plantae","nu","vest"),
("Lalea","liliacee","plantae","nu","vest"),
("Trandafir","rosaceae","plantae","nu","vest"),
("Drosera-Rotundifolia","droseraceae","plantae","da","nord"),
("Stylidium-Graminifolium","stylidiaceae","plantae","da","nord"),
("Cobra-Crin","sarraceniaceae","plantae","da","nord"),
("Lotus","nymphaea","plantae","nu","est"),
("Orhidee","monocotiledonate","plantae","nu","est"),
("Cactus","caryophyllales","plantae","nu","est"),
("Mar","rosaceae","plantae","nu","sud"),
("Cires","rosaceae","plantae","nu","sud"),
("Prun","rosaceae","plantae","nu","sud");

insert into ANGAJAT (nume, username, parola) values
("Doru","doru","doru"),
("Alexandru","alex","alex"),
("Delia","delia","delia");

insert into ADMINISTRATOR (nume, username, parola) values
("Razvan","razvan","razvan"),
("Georgiana","georgiana","georgiana");

select * from planta;

select * from angajat;