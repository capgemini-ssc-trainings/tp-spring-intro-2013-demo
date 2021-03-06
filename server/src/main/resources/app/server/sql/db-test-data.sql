DROP TABLE IF EXISTS READER;
DROP TABLE IF EXISTS BOOK;
CREATE TABLE READER  (ID BIGINT,FIRST_NAME VARCHAR(255), LAST_NAME VARCHAR(255), LOGIN VARCHAR(255) NOT NULL);
CREATE TABLE BOOK (ID BIGINT,AUTHOR VARCHAR(100) NOT NULL,PUBLICATION_YEAR INT NOT NULL,RENTAL_EXPIRY_DATE DATETIME,TITLE VARCHAR(30) NOT NULL,currentReader_ID BIGINT);
insert into BOOK (ID,AUTHOR,TITLE,PUBLICATION_YEAR) values(1,'G. King','Hibernate in Action',2007);
insert into BOOK (ID,AUTHOR,TITLE,PUBLICATION_YEAR) values(2,'Richard S. Hall,Karl Pauls,Stuart McCulloch,David Savage','OSGi in Action',2011);
insert into BOOK (ID,AUTHOR,TITLE,PUBLICATION_YEAR) values(3,'Craig Walls','Spring in Action',2011);