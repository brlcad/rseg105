CREATE TABLE CATEGORY (
  ID INT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(100),
  PRIMARY KEY (ID)
);

CREATE TABLE BOOK (
  ID INT NOT NULL AUTO_INCREMENT,
  CATEGORY_ID INT(11),
  ISBN VARCHAR(14),
  TITLE VARCHAR(500),
  PRICE DECIMAL(5,2),
  PRIMARY KEY (ID)
);
