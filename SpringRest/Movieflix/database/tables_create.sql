/*
Schema creation script
*/

/*
1. Code
*/
create table code(
code_id_pk integer not null primary key auto_increment,
value varchar(30) not null
);

/*
2.
*/
create table code_master(
code_master_id_pk integer not null primary key auto_increment,
code_id_fk integer,
value varchar(30) not null,
foreign key(code_id_fk) references code(code_id_pk)
);

/*
3.
*/
create table title(
title_id_pk integer not null primary key auto_increment,
title varchar(50) not null,
title_type_id_fk integer,
year varchar(20) not null,
rating_id_fk integer,
release_date date not null,
runtime varchar(30) not null,
director varchar(30) not null,
writer varchar(30) not null,
actors varchar(100) not null,
plot varchar(200) not null,
awards varchar(100) default 'N/A',
user_rating float,
poster varchar(100) default 'N/A',
metascore varchar(100) default 'N/A',
imdb_rating integer,
imdb_votes varchar(100) default 'N/A',
imdb_id varchar(100) not null,
create_date date not null,
delete_flag integer not null,
foreign key(title_type_id_fk) references code_master(code_master_id_pk),
foreign key(rating_id_fk) references code_master(code_master_id_pk)
);

/*
4.
*/
create table title_language(
title_language_id_pk integer not null primary key auto_increment,
title_id_fk integer,
language_id_fk integer,
foreign key(title_id_fk) references title(title_id_pk),
foreign key(language_id_fk) references code_master(code_master_id_pk)
);

/*
5.
*/
create table title_country(
title_country_id_pk integer not null primary key auto_increment,
title_id_fk integer,
country_id_fk integer,
foreign key(title_id_fk) references title(title_id_pk),
foreign key(country_id_fk) references code_master(code_master_id_pk)
);

/*
6.
*/
create table title_genre(
title_genre_id_pk integer not null primary key auto_increment,
title_id_fk integer,
genre_id_fk integer,
foreign key(title_id_fk) references title(title_id_pk),
foreign key(genre_id_fk) references code_master(code_master_id_pk)
);

/*
7.
*/
create table user_details(
user_details_id_pk integer not null primary key auto_increment,
address varchar(70) not null,
phone_number varchar(20) not null
);

/*
8.
*/
create table account(
account_id_pk integer not null primary key auto_increment,
first_name varchar(30) not null,
last_name varchar(30) not null,
user_name varchar(30) not null,
password varchar(30) not null,
user_details_id_fk integer,
gender_id_fk integer,
email varchar(40) not null,
account_role_id_fk integer,
create_date date not null,
foreign key(gender_id_fk) references code_master(code_master_id_pk),
foreign key(account_role_id_fk) references code_master(code_master_id_pk),
foreign key(user_details_id_fk) references user_details(user_details_id_pk)

);

/*
9.
*/
create table user_fav_movie_genre(
user_fav_movie_genre_id_pk integer not null primary key auto_increment,
account_id_fk integer,
genre_id_fk integer,
foreign key(account_id_fk) references account(account_id_pk),
foreign key(genre_id_fk) references code_master(code_master_id_pk)
);

/*
10.
*/
create table user_title_rating(
user_title_rating_id_pk integer not null primary key auto_increment,
title_id_fk integer,
account_id_fk integer,
rating integer,
foreign key(account_id_fk) references account(account_id_pk),
foreign key(title_id_fk) references title(title_id_pk)
);

/*
11.
*/
create table user_title_comment(
user_title_comment_id_pk integer not null primary key auto_increment,
title_id_fk integer,
account_id_fk integer,
comment varchar(300),
create_date date not null,
foreign key(account_id_fk) references account(account_id_pk),
foreign key(title_id_fk) references title(title_id_pk)
);
