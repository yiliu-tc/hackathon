DROP TABLE rate_type;
CREATE TABLE rate_type
(
  rate_type_id INT PRIMARY KEY AUTO_INCREMENT,
  rate_type_des VARCHAR(250)
);
INSERT INTO rate_type(rate_type_des) VALUES('Excellent');
INSERT INTO rate_type(rate_type_des) VALUES('Moderate');
INSERT INTO rate_type(rate_type_des) VALUES('Needs Improvement');

DROP TABLE review;
CREATE TABLE review
(
  r_id INT PRIMARY KEY AUTO_INCREMENT,
  rate_type_id INT NOT NULL,
  r_comment VARCHAR(250),
  r_date DATE,
  CONSTRAINT review_rate_type_FK FOREIGN KEY (rate_type_id)
  REFERENCES rate_type(rate_type_id)
);

DROP TABLE IF EXISTS oauth_client_details;
CREATE TABLE oauth_client_details
(
  client_id INT PRIMARY KEY AUTO_INCREMENT,
  client_secret VARCHAR(255),
  user_name VARCHAR(255),
  authorized_grant_types VARCHAR(255)
);

INSERT INTO oauth_client_details(client_secret, user_name, authorized_grant_types) VALUES('123', 'test', 'USER');
INSERT INTO oauth_client_details(client_secret, user_name, authorized_grant_types) VALUES('pass1234', 'user', 'ADMIN');