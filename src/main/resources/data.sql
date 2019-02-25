INSERT INTO AUTHOR (AUTHOR_ID, NAME, SURNAME) 
VALUES(20001,  'name_1', 'surname_1');
INSERT INTO AUTHOR (AUTHOR_ID, NAME, SURNAME)
VALUES(20002,  'name_2', 'surname_2');
INSERT INTO AUTHOR (AUTHOR_ID, NAME, SURNAME) 
VALUES(20003,  'name_3', 'surname_3');
INSERT INTO AUTHOR (AUTHOR_ID, NAME, SURNAME) 
VALUES(20004,  'name_4', 'surname_4');

-- INSERT INTO BOOK (ID, TITLE, description,author_author_id) 
-- VALUES(10001,  'title_1_jpa','a',20001);
-- INSERT INTO BOOK (ID, TITLE, description,author_author_id) 
-- VALUES(10002,  'title_2_jpa','b',20001);
-- INSERT INTO BOOK (ID, TITLE, description, author_author_id) 
-- VALUES(10003,  'title_3_jpa','c',20002);
-- INSERT INTO BOOK (ID, TITLE, description, author_author_id) 
-- VALUES(10004,  'title_4_jpa','d',20003);
-- INSERT INTO BOOK (ID, TITLE, description, author_author_id) 
-- VALUES(10005,  'title_5_jpa','e',20004);

INSERT INTO BOOK (ID,TITLE, description, author2_author_id) 
VALUES(10001,  'title_1_jpa','a', 20001);
INSERT INTO BOOK (ID, TITLE, description, author2_author_id) 
VALUES(10002,  'title_2_jpa','b',20001);
INSERT INTO BOOK (ID, TITLE, description, author2_author_id) 
VALUES(10003,  'title_3_jpa','c',20002);
INSERT INTO BOOK (ID, TITLE, description, author2_author_id) 
VALUES(10004,  'title_4_jpa','d',20003);
INSERT INTO BOOK (ID, TITLE, description, author2_author_id) 
VALUES(10005,  'title_5_jpa','e',20004);