ALTER TABLE projects ADD COLUMN date_created DATE;

UPDATE goit_dev.projects
SET date_created = '2012-02-10'
WHERE project_name = 'Project_1';

UPDATE goit_dev.projects
SET date_created = '2013-03-08'
WHERE project_name = 'Project_2';

UPDATE goit_dev.projects
SET date_created = '2014-04-01'
WHERE project_name = 'Project_3';

UPDATE goit_dev.projects
SET date_created = '2015-05-09'
WHERE project_name = 'Project_4';

UPDATE goit_dev.projects
SET date_created = '2016-06-16'
WHERE project_name = 'Project_5';
