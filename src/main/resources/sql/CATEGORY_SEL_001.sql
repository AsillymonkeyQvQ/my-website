SELECT
    id
  , parentId
  , name
  , description
FROM category
WHERE parentId = 0
;
