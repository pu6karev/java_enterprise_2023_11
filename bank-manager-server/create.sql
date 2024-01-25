create table accounts (account_id serial not null, balance integer, customer_id integer, currency varchar(255), iban varchar(255), primary key (account_id));
create table customers (customer_id serial not null, email varchar(255), name varchar(255), primary key (customer_id));
alter table if exists accounts add constraint FKn6x8pdp50os8bq5rbb792upse foreign key (customer_id) references customers;
create table accounts (account_id serial not null, balance integer, customer_id integer, currency varchar(255) not null, iban varchar(255) unique, primary key (account_id));
create table customers (customer_id serial not null, email varchar(255), name varchar(255), primary key (customer_id));
alter table if exists accounts add constraint FKn6x8pdp50os8bq5rbb792upse foreign key (customer_id) references customers;
create table accounts (account_id serial not null, balance integer, customer_id integer, currency varchar(255) not null, iban varchar(255) unique, primary key (account_id));
create table customers (customer_id serial not null, email varchar(255), name varchar(255), primary key (customer_id));
alter table if exists accounts add constraint FKn6x8pdp50os8bq5rbb792upse foreign key (customer_id) references customers;
