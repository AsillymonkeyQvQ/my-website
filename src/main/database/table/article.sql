CREATE TABLE article (
    id CHAR(11) NOT NULL
  , title CHAR(128) NOT NULL
  , category CHAR(30) NOT NULL
  , description TEXT NULL
  , stars INTEGER NULL
  , create_date_time DATETIME NOT NULL
);
