CREATE TABLE article (
    id                  INT                 NOT NULL
  , authorId            INT                 NOT NULL
  , categoryId          INT                 NOT NULL
  , title               VARCHAR(75)         NOT NULL
  , summary             TINYTEXT            NOT NULL
  , published           CHAR(1)             NOT NULL
  , createDate          DATE                NOT NULL
  , PRIMARY KEY (id)
)
