CREATE TABLE user(
    id                  INT                 NOT NULL
  , firstName           VARCHAR(50)         NOT NULL
  , middleName          VARCHAR(50)         NULL
  , lastName            VARCHAR(50)         NOT NULL
  , mobile              CHAR(15)            NULL
  , email               VARCHAR(50)         NOT NULL
  , passwordHash        VARCHAR(32)         NOT NULL
  , registeredAt        DATETIME            NOT NULL
  , lastLogin           DATETIME            NULL
  , intro               TINYINT             NULL
  , profile             TEXT                NULL
  , PRIMARY KEY (id)
);
