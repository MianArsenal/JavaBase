delete from Taco_Order_Tacos;
delete from Taco_Ingredients;
delete from Taco;
delete from Taco_Order;
delete from Ingredient;

insert into Ingredient (id, name, type) values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into Ingredient (id, name, type) values ('COTO', 'Corn Tortilla', 'WRAP');
insert into Ingredient (id, name, type) values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into Ingredient (id, name, type) values ('CARN', 'Carnitas', 'PROTEIN');
insert into Ingredient (id, name, type) values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type) values ('LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient (id, name, type) values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type) values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into Ingredient (id, name, type) values ('SLSA', 'Salsa', 'SAUCE');
insert into Ingredient (id, name, type) values ('SRCR', 'Sour Cream', 'SAUCE');

insert into Users (username, password, enabled) values ('Henry', '$2a$10$StPey95Ohc48G1i1kHoq4.S0qnPAM6qv2ZAynE47gLvrQC5cNShEm', 1);
insert into Users (username, password, enabled) values ('MiAn', '$2a$10$StPey95Ohc48G1i1kHoq4.S0qnPAM6qv2ZAynE47gLvrQC5cNShEm', 1);
insert into UserAuthorities (username, authority) values ('Henry', 'ROLE_USER');
insert into UserAuthorities (username, authority) values ('MiAn', 'ROLE_ADMIN');