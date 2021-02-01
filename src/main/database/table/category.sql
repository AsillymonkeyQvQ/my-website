/************************************************************
 * Table Name : category
 * Description: Store category information of articles
 ************************************************************/

CREATE TABLE category (
    id                  SMALLINT            NOT NULL
  , name                CHAR(18)            NOT NULL
  , description         VARCHAR(255)            NULL
  , parent_id           SMALLINT            NOT NULL
  , PRIMARY KEY(id)
);
