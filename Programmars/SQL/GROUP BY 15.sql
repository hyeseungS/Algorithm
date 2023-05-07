WITH RECURSIVE cte AS ( SELECT 0 as n UNION ALL
                        SELECT n + 1 FROM cte WHERE n < 23
                      )
SELECT cte.n AS HOUR, COUNT(a.ANIMAL_ID) AS COUNT
FROM cte
LEFT JOIN ANIMAL_OUTS a ON cte.n = HOUR(a.DATETIME)
GROUP BY cte.n
ORDER BY cte.n;