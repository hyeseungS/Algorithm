SELECT YEAR(b.SALES_DATE) AS YEAR, MONTH(b.SALES_DATE) AS MONTH, a.GENDER, COUNT(DISTINCT b.USER_ID) AS USERS
FROM USER_INFO a, ONLINE_SALE b
WHERE a.USER_ID = b.USER_ID AND a.GENDER IS NOT NULL
GROUP BY YEAR(b.SALES_DATE), MONTH(b.SALES_DATE), a.GENDER
ORDER BY YEAR, MONTH, GENDER