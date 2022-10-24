ALTER TABLE developers ADD COLUMN salary INT;

UPDATE developers
SET salary = 1000
WHERE id = 1;

UPDATE developers
SET salary = 1500
WHERE id = 2;

UPDATE developers
SET salary = 2000
WHERE id = 3;

UPDATE developers
SET salary = 1000
WHERE id = 4;

UPDATE developers
SET salary = 1500
WHERE id = 5;

UPDATE developers
SET salary = 2000
WHERE id = 6;

UPDATE developers
SET salary = 1000
WHERE id = 7;

UPDATE developers
SET salary = 1500
WHERE id = 8;

UPDATE developers
SET salary = 2000
WHERE id = 9;

UPDATE developers
SET salary = 1000
WHERE id = 10;

ALTER TABLE projects ADD COLUMN cost INT;

UPDATE projects SET cost = 27000 WHERE id = 1;

UPDATE projects SET cost = 15000 WHERE id = 2;

UPDATE projects SET cost = 30000 WHERE id = 3;

UPDATE projects SET cost = 10000 WHERE id = 4;

UPDATE projects SET cost = 20000 WHERE id = 5;
