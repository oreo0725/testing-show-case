create table book
(
   id integer not null,
   title varchar(255) not null,
   author varchar(255),
   published_date TIMESTAMP,
   index_date_time TIMESTAMP not null,
   isbn varchar(255),

   primary key(id)
);