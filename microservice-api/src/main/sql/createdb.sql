USE microserviceDB01;
SELECT DATABASE();

CREATE TABLE rate_type
(
  rate_type_id INT PRIMARY KEY AUTO_INCREMENT,
  rate_type_des VARCHAR(250)
);
INSERT INTO rate_type(rate_type_des) VALUES('Excellent');
INSERT INTO rate_type(rate_type_des) VALUES('Moderate');
INSERT INTO rate_type(rate_type_des) VALUES('Needs Improvement');

CREATE TABLE review
(
    r_id INT PRIMARY KEY AUTO_INCREMENT,
    rate_type_id INT NOT NULL,
    r_comment VARCHAR(250),
    CONSTRAINT review_rate_type_FK FOREIGN KEY (rate_type_id)
    REFERENCES rate_type(rate_type_id)
);

 INSERT INTO review(rate_type_id, r_comment) VALUES(1, 'very good');
 INSERT INTO review(rate_type_id, r_comment) VALUES(2, 'so so');
 INSERT INTO review(rate_type_id, r_comment) VALUES(3, 'very bad bad');