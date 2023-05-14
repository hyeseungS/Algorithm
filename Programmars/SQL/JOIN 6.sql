SELECT T2.ANIMAL_ID, T2.NAME
FROM ANIMAL_INS T1
RIGHT OUTER JOIN ANIMAL_OUTS T2 ON T1.ANIMAL_ID = T2.ANIMAL_ID
WHERE T1.ANIMAL_ID IS NULL
ORDER BY ANIMAL_ID, NAME;