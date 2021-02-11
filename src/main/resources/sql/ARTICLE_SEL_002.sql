SELECT
    a.id           AS id
  , a.authorId     AS authorId
  , a.parentId     AS parentId
  , a.title        AS title
  , a.summary      AS summary
  , a.banner       AS banner
  , a.published    AS published
  , a.createdAt    AS createdAt
  , a.updatedAt    AS updatedAt
  , c.id           AS categoryId
  , c.parentId     AS categoryParentId
  , c.name         AS categoryName
  , c.description  AS categoryDescription
FROM article a
LEFT JOIN article_category ac
       ON ac.articleId = a.id
LEFT JOIN category c
       ON c.id = ac.categoryId
WHERE a.id = ?
;
