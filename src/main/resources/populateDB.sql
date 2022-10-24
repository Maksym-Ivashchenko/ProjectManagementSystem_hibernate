INSERT INTO developers
	(id, developer_name, age, gender, different)
VALUES
	(1, 'Ivan', 30, 'men', 'ivan@mail.com'),
    (2, 'Bogdan', 24, 'men', 'bogdan@mail.com'),
    (3, 'Inna', 25, 'women', 'inna@mail.com'),
    (4, 'Kira', 33, 'women', 'kira@mail.com'),
	(5, 'Gus', 21, 'men', 'gus@mail.com'),
	(6, 'Irina', 22, 'women', 'irina@mail.com'),
	(7, 'Leonid', 23, 'men', 'leonid@mail.com'),
	(8, 'Igor', 30, 'men', 'igor@mail.com'),
	(9, 'Arkady', 34, 'men', 'arkadiy@mail.com'),
	(10, 'Vera', 20, 'women', 'vera@mail.com');

INSERT INTO skills
	(id, branch, skill_level)
VALUES
	(1, 'Java','Junior'),
	(2, 'Java','Middle'),
	(3, 'Java','Senior'),
	(4, 'C++','Junior'),
	(5, 'C++','Middle'),
	(6, 'C++','Senior'),
	(7, 'C#','Junior'),
	(8, 'C#','Middle'),
	(9, 'C#','Senior'),
	(10, 'JS','Junior'),
	(11, 'JS','Middle'),
	(12, 'JS','Senior');

INSERT INTO projects
	(id, project_name, project_type, comments)
VALUES
	(1, 'Project_1', 'Java', '1111111'),
    (2, 'Project_2', 'JavaScript', '222222'),
    (3, 'Project_3', 'C++', '3333333'),
    (4, 'Project_4', 'Java', '44444444'),
    (5, 'Project_5', 'C#', '5555555');

INSERT INTO companies
	(id, company_name, city, email)
VALUES
	(1, 'Company_1', 'Kyiv', 'company_1@mail.com'),
    (2, 'Company_2', 'Lviv', 'company_2@mail.com'),
    (3, 'Company_3', 'Dnipro', 'company_3@mail.com'),
    (4, 'Company_4', 'Kyiv', 'company_4@mail.com'),
    (5, 'Company_5', 'Kharkiv', 'company_5@mail.com');

INSERT INTO customers
	(id, customer_name, country, email)
VALUES
	(1, 'Customer_1', 'Ukraine', 'customer_1@mail.com'),
    (2, 'Customer_2', 'England', 'customer_2@mail.com'),
    (3, 'Customer_3', 'Germany', 'customer_3@mail.com'),
    (4, 'Customer_4', 'Ukraine', 'customer_4@mail.com'),
    (5, 'Customer_5', 'France', 'customer_5@mail.com');

INSERT INTO companies_projects VALUES
(1,1), (2,2), (3,3), (4,4), (5,5);

INSERT INTO customers_projects VALUES
(1,4), (2,2), (3,1), (4,5), (5,3);

INSERT INTO developers_skills VALUES
(1,12), (1,9), (2,4), (3,1), (3,6), (4, 10),
(5,7), (6,5), (7,2), (8,11), (9,8), (10,10), (1,3);

INSERT INTO developers_projects VALUES
(1,2), (3,1), (5,1), (2,3), (7,2), (10,3),
(8,3), (1,4), (7,4), (4,3), (9,5),(7,5), (1,5);
