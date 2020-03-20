create table employee (
    id integer not null,
    name varchar(10);
    surname varchar(20) not null,
    phone varchar(15) not null,
    address varchar(50) not null,
    age smallint not null,
    salary double precision not null,
    position varchar(10) not null,
    primary key (id)
    );