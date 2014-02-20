/**
RUN THIS ONLY ONCE, TO INITIALIZE THE DATABASE
*/
INSERT INTO armband_colours(id, name, value) VALUES (1, 'blue', '#0000FF');
INSERT INTO armband_colours(id, name, value) VALUES (2, 'orange', '#FFA500');
INSERT INTO drink_types(id, name) VALUES (1, 'Alcoholic');
INSERT INTO drink_types(id, name) VALUES (2, 'Non-Alcoholic');
INSERT INTO staff_roles(id, name) VALUES (1, 'Manager');
INSERT INTO staff_roles(id, name) VALUES (2, 'Bartender');

INSERT INTO staff(id_real, name, password, hours, role_id) VALUES ('BTD10001','Justin Bog', 'defaultPass', '9-5', 2);
INSERT INTO staff(id_real, name, password, hours, role_id) VALUES ('MGR10001','John', '123456', '9-5', 1);
INSERT INTO staff(id_real, name, password, hours, role_id) VALUES ('MGR10002','Brandon', '123456', '9-5', 1);
INSERT INTO staff(id_real, name, password, hours, role_id) VALUES ('MGR10003','ReliQ', '123456', '9-5', 1);
