SELECT T1.NAME, T1.DATETIME
FROM ANIMAL_INS T1
LEFT OUTER JOIN ANIMAL_OUTS T2 ON T1.ANIMAL_ID = T2.ANIMAL_ID
WHERE T2.ANIMAL_ID IS NULL
ORDER BY T1.DATETIME
LIMIT 3;