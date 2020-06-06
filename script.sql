CREATE database ipc_user;
CREATE TABLE user
(
  id INT AUTO_INCREMENT PRIMARY KEY,
  login VARCHAR(45) NOT NULL,
  password VARCHAR(55) NOT NULL,
  email TEXT NOT NULL,
  birthday INT
);