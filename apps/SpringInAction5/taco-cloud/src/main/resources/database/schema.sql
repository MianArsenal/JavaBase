-- select * from Ingredient;
-- select * from taco;
-- select * from Taco_Ingredients;
-- select * from Taco_Order;
-- select * from Taco_Order_Tacos;
-- select * from users;
-- select * from UserAuthorities;
-- select * from Custom_Users;

create table if not exists Ingredient (
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null
);

create table if not exists Taco (
    id identity,
    name varchar(50) not null,
    createdAt timestamp not null
);

create table if not exists Taco_Ingredients (
    taco bigint not null,
    ingredient varchar(4) not null
);

alter table Taco_ingredients
    add foreign key (taco) references Taco(id);

alter table Taco_Ingredients
    add foreign key (ingredient) references Ingredient(id);

create table if not exists Taco_Order (
    id identity,
    orderName varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state varchar(50) not null,
    zip varchar(10) not null,
    ccNumber varchar(16) not null,
    ccCvv varchar(3) not null,
    placedAt timestamp not null
);

create table if not exists Taco_Order_Tacos (
    tacoOrder bigint not null,
    taco bigint not null
);

alter table Taco_Order_Tacos
    add foreign key (tacoOrder) references Taco_Order(id);

alter table Taco_Order_Tacos
    add foreign key (taco) references Taco(id);

create table if not exists Users (
    username varchar(50),
    password varchar(60),
    enabled tinyint(4)
);

create table if not exists UserAuthorities (
    username varchar(50),
    authority varchar(20)
);

create table if not exists Custom_Users (
    id identity,
    username varchar(50) not null,
    password varchar(60) not null,
    fullName varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state varchar(50) not null,
    zip varchar(10) not null,
    phoneNumber varchar(20) not null,
    createDt timestamp
)