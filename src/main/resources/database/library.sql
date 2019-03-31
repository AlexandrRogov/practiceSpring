create  schema if not exists book_library default CHARACTER set utf8;

create table book_library.author
(
  id            int auto_increment
    primary key,
  name          char(30) not null,
  date_of_birth date     null
);

create table book_library.genre
(
  id   int auto_increment
    primary key,
  name char(30) not null
);

create table book_library.book
(
  id            int auto_increment
    primary key,
  name          char(60) not null,
  creation_year date     not null,
  genre_id      int      not null,
  author_id     int      not null,
  constraint book_author_id_fk
  foreign key (author_id) references author (id),
  constraint book_genre_id_fk
  foreign key (genre_id) references genre (id)
);

insert into book_library.author(name,date_of_birth) values
('Пушкин','1799.06.06'),
('Лермонтов','1814.10.015'),
('Колос','1882.11.03');

insert into book_library.genre(name) values
('Проза'),
('Пьесы'),
('Поэма'),
('Роман');


insert into book_library.book(name,creation_year,genre_id,author_id) values
('Песні-жальбы','1910.0.0',(select id from book_library.genre where name='Проза'),
(select id from book_library.author where name='Колос')),

('Апавяданні','1912.0.0',(select id from book_library.genre where name='Проза'),
(select id from book_library.author where name='Колос')),

('Антось Лата','1912.0.0',(select id from book_library.genre where name='Пьесы'),
(select id from book_library.author where name='Колос')),

('Руслан и Людмила','1820.0.0',(select id from book_library.genre where name='Поэма'),
(select id from book_library.author where name='Пушкин')),

('Кавказский пленник','1821.0.0',(select id from book_library.genre where name='Поэма'),
(select id from book_library.author where name='Пушкин')),

('Арап Петра Великого','1827.0.0',(select id from book_library.genre where name='Пьесы'),
(select id from book_library.author where name='Пушкин')),

('Мцыри','1839.0.0',(select id from book_library.genre where name='Поэма'),
(select id from book_library.author where name='Лермонтов')),

('Демон','1839.0.0',(select id from book_library.genre where name='Поэма'),
(select id from book_library.author where name='Лермонтов')),

('Герой нашего времени','1827.0.0',(select id from book_library.genre where name='Роман'),
(select id from book_library.author where name='Лермонтов'));