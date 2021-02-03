CREATE TABLE comment(
    id                  INT                 NOT NULL
  , articleId           INT                 NOT NULL
  , parentId            INT                 NOT NULL
  , published           CHAR(1)             NOT NULL
  , createdAt           DATETIME            NOT NULL
  , content             TEXT                NOT NULL
);
