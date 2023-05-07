SELECT a.CATEGORY, a.price AS MAX_PRICE, a.PRODUCT_NAME 
FROM FOOD_PRODUCT a, (SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE FROM FOOD_PRODUCT GROUP BY CATEGORY HAVING CATEGORY IN ('과자', '국', '김치', '식용유')) b
WHERE a.CATEGORY = b.CATEGORY AND a.PRICE = b.MAX_PRICE
ORDER BY MAX_PRICE DESC;