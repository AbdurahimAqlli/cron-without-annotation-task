drop table if exists task;
CREATE TABLE task
(
    id                 BIGINT      NOT NULL ,
    name               VARCHAR(255),
    sql                VARCHAR(255),
    status             VARCHAR(255),
    expression         VARCHAR(255),
    CONSTRAINT pk_task PRIMARY KEY (id)
);
INSERT INTO task(id,name,sql,status,expression) VALUES (1,'task0', 'select * from task', 'ACTIVE', '1/10 * * * * *');
INSERT INTO task(id,name,sql,status,expression) VALUES (2,'task1', 'select * from task', 'ACTIVE', '1/20 * * * * *');
INSERT INTO task(id,name,sql,status,expression) VALUES (3,'task2', 'select * from task', 'ACTIVE', '1/30 * * * * *');
INSERT INTO task(id,name,sql,status,expression) VALUES (4,'task3', 'select * from task', 'ACTIVE', '1/40 * * * * *');
INSERT INTO task(id,name,sql,status,expression) VALUES (5,'task4', 'select * from task', 'ACTIVE', '1/50 * * * * *');
INSERT INTO task(id,name,sql,status,expression) VALUES (6,'task5', 'select * from task', 'ACTIVE', '1/51 * * * * *');
INSERT INTO task(id,name,sql,status,expression) VALUES (7,'task6', 'select * from task', 'ACTIVE', '1/52 * * * * *');
INSERT INTO task(id,name,sql,status,expression) VALUES (8,'task7', 'select * from task', 'ACTIVE', '1/53 * * * * *');
INSERT INTO task(id,name,sql,status,expression) VALUES (9,'task8', 'select * from task', 'ACTIVE', '1/54 * * * * *');
INSERT INTO task(id,name,sql,status,expression) VALUES (10,'task9', 'select * from task', 'ACTIVE', '1/55 * * * * *');
INSERT INTO task(id,name,sql,status,expression) VALUES (11,'task10', 'select * from task', 'ACTIVE', '1/56 * * * * *');
