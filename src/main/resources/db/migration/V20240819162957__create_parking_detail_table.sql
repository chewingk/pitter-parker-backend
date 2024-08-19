create table if not exists parking_detail (
    id int not null auto_increment primary key,
    license_plate varchar(20) not null,
    entry_time datetime not null
);