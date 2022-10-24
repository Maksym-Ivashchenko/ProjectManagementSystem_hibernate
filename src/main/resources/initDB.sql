CREATE TABLE developers(
	id SERIAL PRIMARY KEY,
	developer_name VARCHAR(45) NOT NULL,
	age INT NOT NULL,
    gender VARCHAR(45) NOT NULL,
	different VARCHAR(200)
);

CREATE TABLE skills(
	id SERIAL PRIMARY KEY,
	branch VARCHAR(45) NOT NULL,
	skill_level VARCHAR(45) NOT NULL
);

CREATE TABLE projects(
	id SERIAL PRIMARY KEY,
	project_name VARCHAR(45) NOT NULL,
	project_type VARCHAR(45) NOT NULL,
	comments VARCHAR(45) NOT NULL
);

CREATE TABLE companies(
	id SERIAL PRIMARY KEY,
	company_name VARCHAR(45) NOT NULL,
	city VARCHAR(45) NOT NULL,
	email VARCHAR(45) NOT NULL
);

CREATE TABLE customers(
	id SERIAL PRIMARY KEY,
	customer_name VARCHAR(45) NOT NULL,
	country VARCHAR(45) NOT NULL,
	email VARCHAR(45) NOT NULL
);

CREATE TABLE companies_projects(
	company_id INT NOT NULL,
    project_id INT NOT NULL,
    FOREIGN KEY (company_id) REFERENCES companies (id),
    FOREIGN KEY (project_id) REFERENCES projects (id)
);

CREATE TABLE customers_projects(
	customer_id INT NOT NULL,
    project_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers (id),
    FOREIGN KEY (project_id) REFERENCES projects (id)
);

CREATE TABLE developers_skills(
	developer_id INT NOT NULL,
    skill_id INT NOT NULL,
    FOREIGN KEY (developer_id) REFERENCES developers (id),
    FOREIGN KEY (skill_id) REFERENCES skills (id)
);

CREATE TABLE developers_projects(
	developer_id INT NOT NULL,
    project_id INT NOT NULL,
    FOREIGN KEY (developer_id) REFERENCES developers (id),
    FOREIGN KEY (project_id) REFERENCES projects (id)
);
