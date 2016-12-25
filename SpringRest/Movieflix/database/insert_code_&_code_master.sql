/*
inser data into schema
*/

/*
1. code table populating
*/

insert into code(value) values('genre');
insert into code(value) values('country');
insert into code(value) values('language');
insert into code(value) values('title_rating');
insert into code(value) values('title_type');
insert into code(value) values('gender');
insert into code(value) values('role');


/*
2. code master populating
*/
/*
code : genre
Action, Adventure, Sci-Fi, Thriller,Crime, Drama, Fantasy, Comedy, History, 
Biography, Mystery, Romance, Animation, Western, Family, Horror, Documentary, 
News, Talk-Show, War
*/
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Action');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Adventure');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Sci-Fi');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Thriller');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Crime');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Drama');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Fantasy');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Comedy');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'History');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Biography');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Mystery');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Romance');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Animation');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Western');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Family');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Horror');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Documentary');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'News');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'Talk-Show');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='genre'),'War');

/*
code : country
USA, Germany, UK, Canada, Australia, Ireland, India, New Zealand 
*/
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='country'),'USA');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='country'),'Germany');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='country'),'UK');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='country'),'Canada');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='country'),'Australia');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='country'),'Ireland');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='country'),'India');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='country'),'New Zealand');

/*
code : language
English, Russian, Urdu, Mandarin, French, Pawnee, Hindi, Spanish, Italian, German,
Latin, Japanese, Hebrew, Polish, Quenya, Old English, Sindarin, Swahili, Xhosa, Zulu,
Scottish Gaelic, Klingon, Portuguese, Arabic, Korean
*/
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'English');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Russian');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Urdu');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Mandarin');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'French');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Pawnee');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Hindi');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Spanish');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Italian');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'German');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Japanese');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Hebrew');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Polish');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Quenya');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Old English');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Sindarin');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Swahili');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Xhosa');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Zulu');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Scottish Gaelic');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Klingon');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Portuguese');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Arabic');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='language'),'Korean');

/*
code : title_rating
R, PG, TV-MA, TV-14, TV-PG, PG-13, G
*/
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='title_rating'),'R');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='title_rating'),'PG');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='title_rating'),'TV-MA');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='title_rating'),'TV-14');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='title_rating'),'TV-PG');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='title_rating'),'PG-13');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='title_rating'),'G');

/*
code : title_type
Movie, Series
*/
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='title_type'),'Movie');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='title_type'),'Series');

/*
code : gender
Male, Female
*/
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='gender'),'Male');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='gender'),'Female');

/*
code : role
User, Admin
*/
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='role'),'User');
Insert into code_master(code_id_fk,value) values((select c.code_id_pk from code c where c.value='role'),'Admin');



