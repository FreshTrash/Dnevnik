 CREATE SEQUENCE excel_seq;
CREATE TABLE excel (
  id integer PRIMARY KEY DEFAULT nextval('excel_seq'),
  name varchar(255) NOT NULL,
  path varchar(255) NOT NULL  

);

CREATE SEQUENCE rows_seq;
CREATE TABLE rows (
  id integer PRIMARY KEY DEFAULT nextval('rows_seq'),
  key integer NOT NULL,
  title varchar(255) NOT NULL,
  price double PRECISION NOT NULL,
  date timestamp NOT NULL,
  excel_id integer REFERENCES excel ON DELETE RESTRICT ON UPDATE CASCADE
);
