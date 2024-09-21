-- 코드를 입력하세요
SELECT DATETIME FROM ANIMAL_INS
Where DATETIME = (select max(datetime) from animal_ins);