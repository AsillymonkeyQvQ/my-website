CREATE TABLE category (
    id                  INT                 NOT NULL
  , parentId            INT                 NOT NULL
  , name                CHAR(18)            NOT NULL
  , description         TINYTEXT                NULL
  , PRIMARY KEY (id)
);
