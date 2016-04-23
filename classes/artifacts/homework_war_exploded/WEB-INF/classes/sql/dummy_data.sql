CREATE SCHEMA `loans` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `loans`.`client` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `first_name` VARCHAR(45) NOT NULL ,
  `last_name` VARCHAR(45) NOT NULL ,
  `username` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `state` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE (username)
);

CREATE TABLE `loans`.`user_profile` (
  id BIGINT NOT NULL AUTO_INCREMENT,
  type VARCHAR(30) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (type)
);

CREATE TABLE `loans`.`client_user_profile` (
  `client_id` BIGINT(20) NULL COMMENT '',
  `user_profile_id` BIGINT(20) NOT NULL COMMENT '',
  PRIMARY KEY (`client_id`, `user_profile_id`)  COMMENT '',
  INDEX `FK_USER_PROFILE_idx` (`user_profile_id` ASC)  COMMENT '',
  CONSTRAINT `FK_APP_USER`
  FOREIGN KEY (`client_id`)
  REFERENCES `loans`.`client` (`id`),
  CONSTRAINT `FK_USER_PROFILE`
  FOREIGN KEY (`user_profile_id`)
  REFERENCES `loans`.`user_profile` (`id`)
);

CREATE TABLE `loans`.`loan_application` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `amount` INT NOT NULL COMMENT '',
  `loan_date` DATE NOT NULL COMMENT '',
  `ip` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');

CREATE TABLE `loans`.`client_loan_application` (
  `client_id` BIGINT(20) NULL COMMENT '',
  `loan_application_id` INT(11) NULL COMMENT '',
  PRIMARY KEY (`client_id`, `loan_application_id`)  COMMENT '',
  INDEX `fk_loan_application_id` (`loan_application_id` ASC)  COMMENT '',
  CONSTRAINT `fk_client_id`
  FOREIGN KEY (`client_id`)
  REFERENCES `loans`.`client` (`id`),
  CONSTRAINT `fk_loan_application_id`
  FOREIGN KEY (`loan_application_id`)
  REFERENCES `loans`.`loan_application` (`id`)
);

CREATE TABLE `loans`.`client_loan_details` (
  `username` VARCHAR(45) NOT NULL COMMENT '',
  `ip` VARCHAR(45) NOT NULL COMMENT '',
  `loan_request_date` DATETIME NOT NULL COMMENT '',
  `request_count` INT NOT NULL COMMENT '',
  PRIMARY KEY (`username`)  COMMENT '');

ALTER TABLE `loans`.`client_loan_details`
ADD COLUMN `id` BIGINT(20) NOT NULL COMMENT '' AFTER `request_count`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`)  COMMENT '';

ALTER TABLE `loans`.`client_loan_details`
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '' ;


/* Populate USER_PROFILE Table */
INSERT INTO user_profile(type)
VALUES ('USER');

INSERT INTO user_profile(type)
VALUES ('ADMIN');

/* Populate APP_USER Table */
INSERT INTO client(first_name, last_name, username, password, state)
VALUES ('Bill','Watcher','bill','abc123', 'Active');

INSERT INTO client(first_name, last_name, username, password, state)
VALUES ('Danny','Theys','danny','abc124', 'Active');

INSERT INTO client(first_name, last_name, username, password, state)
VALUES ('Sam','Smith','sam','abc125', 'Active');

INSERT INTO client(first_name, last_name, username, password, state)
VALUES ('Nicole','Warner','nicole','abc126', 'Active');

INSERT INTO client(first_name, last_name, username, password, state)
VALUES ('Kenny','Roger','kenny','abc127', 'Active');

/* Populate JOIN Table */
INSERT INTO client_user_profile (client_id, user_profile_id)
  SELECT user.id, profile.id FROM client user, user_profile profile
  where user.username='bill' and profile.type='USER';

INSERT INTO client_user_profile (client_id, user_profile_id)
  SELECT user.id, profile.id FROM client user, user_profile profile
  where user.username='danny' and profile.type='USER';

INSERT INTO client_user_profile (client_id, user_profile_id)
  SELECT user.id, profile.id FROM client user, user_profile profile
  where user.username='sam' and profile.type='ADMIN';

INSERT INTO client_user_profile (client_id, user_profile_id)
  SELECT user.id, profile.id FROM client user, user_profile profile
  where user.username='nicole' and profile.type='USER';

INSERT INTO client_user_profile (client_id, user_profile_id)
  SELECT user.id, profile.id FROM client user, user_profile profile
  where user.username='kenny' and profile.type='ADMIN';
