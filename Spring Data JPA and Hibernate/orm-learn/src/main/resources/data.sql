INSERT INTO country (co_code, co_name) VALUES ('IN', 'India');
INSERT INTO country (co_code, co_name) VALUES ('US', 'United States of America');
INSERT INTO country (co_code, co_name) VALUES ('BV', 'Bouvet Island');
INSERT INTO country (co_code, co_name) VALUES ('DJ', 'Djibouti');
INSERT INTO country (co_code, co_name) VALUES ('GP', 'Guadeloupe');
INSERT INTO country (co_code, co_name) VALUES ('GS', 'South Georgia and the South Sandwich Islands');
INSERT INTO country (co_code, co_name) VALUES ('LU', 'Luxembourg');
INSERT INTO country (co_code, co_name) VALUES ('SS', 'South Sudan');
INSERT INTO country (co_code, co_name) VALUES ('TF', 'French Southern Territories');
INSERT INTO country (co_code, co_name) VALUES ('UM', 'United States Minor Outlying Islands');
INSERT INTO country (co_code, co_name) VALUES ('ZA', 'South Africa');
INSERT INTO country (co_code, co_name) VALUES ('ZM', 'Zambia');
INSERT INTO country (co_code, co_name) VALUES ('ZW', 'Zimbabwe');

INSERT INTO stock (st_id, st_code, st_date, st_open, st_close, st_volume) VALUES (1, 'FB', '2019-09-03', 184.00, 182.39, 9779400);
INSERT INTO stock (st_id, st_code, st_date, st_open, st_close, st_volume) VALUES (2, 'FB', '2019-09-04', 184.65, 187.14, 11308000);
INSERT INTO stock (st_id, st_code, st_date, st_open, st_close, st_volume) VALUES (3, 'FB', '2019-01-31', 165.60, 166.69, 77233600);
INSERT INTO stock (st_id, st_code, st_date, st_open, st_close, st_volume) VALUES (4, 'FB', '2018-10-31', 155.00, 151.79, 60101300);
INSERT INTO stock (st_id, st_code, st_date, st_open, st_close, st_volume) VALUES (5, 'FB', '2018-12-19', 141.21, 133.24, 57404900);
INSERT INTO stock (st_id, st_code, st_date, st_open, st_close, st_volume) VALUES (6, 'GOOGL', '2019-04-22', 1236.67, 1253.76, 954200);
INSERT INTO stock (st_id, st_code, st_date, st_open, st_close, st_volume) VALUES (7, 'GOOGL', '2019-04-23', 1256.64, 1270.59, 1593400);
INSERT INTO stock (st_id, st_code, st_date, st_open, st_close, st_volume) VALUES (8, 'NFLX', '2018-12-24', 242.00, 233.88, 9547600);
INSERT INTO stock (st_id, st_code, st_date, st_open, st_close, st_volume) VALUES (9, 'NFLX', '2018-12-21', 263.83, 246.39, 21397600);
INSERT INTO stock (st_id, st_code, st_date, st_open, st_close, st_volume) VALUES (10, 'NFLX', '2018-12-26', 233.92, 253.67, 14402700);

INSERT INTO department (dp_id, dp_name) VALUES (1, 'Technology');
INSERT INTO department (dp_id, dp_name) VALUES (2, 'Finance');
INSERT INTO department (dp_id, dp_name) VALUES (3, 'Human Resources');

INSERT INTO skill (sk_id, sk_name) VALUES (1, 'Java');
INSERT INTO skill (sk_id, sk_name) VALUES (2, 'Spring Boot');
INSERT INTO skill (sk_id, sk_name) VALUES (3, 'SQL');

INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES (1, 'Alice Johnson', 80000, TRUE, '1990-05-15', 1);
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES (2, 'Bob Brown', 65000, TRUE, '1993-03-20', 1);
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES (3, 'Carol Smith', 58000, FALSE, '1995-07-10', 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 3);

INSERT INTO quiz_user (id, user_name) VALUES (1, 'admin');
INSERT INTO question (id, question_text, score) VALUES (1, 'What is the extension of the hyper text markup language file?', 1.0);
INSERT INTO question (id, question_text, score) VALUES (2, 'What is the maximum level of heading tag can be used in a HTML page?', 1.0);
INSERT INTO quiz_option (id, option_text, correct_answer, question_id) VALUES (1, '.xhtm', FALSE, 1);
INSERT INTO quiz_option (id, option_text, correct_answer, question_id) VALUES (2, '.ht', FALSE, 1);
INSERT INTO quiz_option (id, option_text, correct_answer, question_id) VALUES (3, '.html', TRUE, 1);
INSERT INTO quiz_option (id, option_text, correct_answer, question_id) VALUES (4, '.htmx', FALSE, 1);
INSERT INTO quiz_option (id, option_text, correct_answer, question_id) VALUES (5, '5', FALSE, 2);
INSERT INTO quiz_option (id, option_text, correct_answer, question_id) VALUES (6, '3', FALSE, 2);
INSERT INTO quiz_option (id, option_text, correct_answer, question_id) VALUES (7, '4', FALSE, 2);
INSERT INTO quiz_option (id, option_text, correct_answer, question_id) VALUES (8, '6', TRUE, 2);
INSERT INTO attempt (id, attempted_date, user_id) VALUES (1, '2019-10-17', 1);
INSERT INTO attempt_question (id, attempt_id, question_id) VALUES (1, 1, 1);
INSERT INTO attempt_question (id, attempt_id, question_id) VALUES (2, 1, 2);
INSERT INTO attempt_option (id, attempt_question_id, option_id, selected_answer) VALUES (1, 1, 1, FALSE);
INSERT INTO attempt_option (id, attempt_question_id, option_id, selected_answer) VALUES (2, 1, 2, FALSE);
INSERT INTO attempt_option (id, attempt_question_id, option_id, selected_answer) VALUES (3, 1, 3, TRUE);
INSERT INTO attempt_option (id, attempt_question_id, option_id, selected_answer) VALUES (4, 1, 4, FALSE);
INSERT INTO attempt_option (id, attempt_question_id, option_id, selected_answer) VALUES (5, 2, 5, FALSE);
INSERT INTO attempt_option (id, attempt_question_id, option_id, selected_answer) VALUES (6, 2, 6, TRUE);
INSERT INTO attempt_option (id, attempt_question_id, option_id, selected_answer) VALUES (7, 2, 7, FALSE);
INSERT INTO attempt_option (id, attempt_question_id, option_id, selected_answer) VALUES (8, 2, 8, FALSE);

INSERT INTO product (id, name, customer_review, hard_disk_size, ram_size, cpu_speed, operating_system, weight, cpu) VALUES (1, 'Office Laptop', 4, '512GB', '16GB', 3.2, 'Windows', 1.40, 'Intel i7');
INSERT INTO product (id, name, customer_review, hard_disk_size, ram_size, cpu_speed, operating_system, weight, cpu) VALUES (2, 'Developer Laptop', 5, '1TB', '32GB', 3.8, 'Linux', 1.80, 'AMD Ryzen 7');
INSERT INTO product (id, name, customer_review, hard_disk_size, ram_size, cpu_speed, operating_system, weight, cpu) VALUES (3, 'Student Laptop', 3, '256GB', '8GB', 2.8, 'Windows', 1.30, 'Intel i5');
