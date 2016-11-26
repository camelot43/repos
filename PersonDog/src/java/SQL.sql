/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  aanciaes
 * Created: Nov 19, 2016
 */

CREATE TABLE Person (
    id INT NOT NULL,
    name VARCHAR(200),
    age int,
    PRIMARY KEY (id));

INSERT INTO person (id, name, age) VALUES(1, 'Antonio', 55);
INSERT INTO person (id, name, age) VALUES(2, 'Manuel', 56);
INSERT INTO person (id, name, age) VALUES(3, 'Dias', 57);
INSERT INTO person (id, name, age) VALUES(4, 'Matos', 58);
INSERT INTO person (id, name, age) VALUES(5, 'Anciaes', 59);
