CREATE DATABASE IF NOT EXISTS silly;USE silly;CREATE TABLE IF NOT EXISTS users(	USER_ID BIGINT PRIMARY KEY AUTO_INCREMENT,    USER_NAME VARCHAR(32) NOT NULL,    USER_PASSWORD BINARY(32) NOT NULL,    FIRST_NAME VARCHAR(128),    LAST_NAME VARCHAR(128),    EMAIL VARCHAR(128) NOT NULL,    BIRTHDAY DATE,    LICENSE_DATE DATE,    OCCUPATION VARCHAR(64),    ADDRESS VARCHAR(256),    CREDIT_RECORD ENUM('A','B','C','D','E'),    CAR_ACCIDENT_RECORD ENUM('A','B','C','D','E'),    UNIQUE(USER_NAME));CREATE TABLE IF NOT EXISTS cars(	CAR_ID BIGINT PRIMARY KEY AUTO_INCREMENT,    BASE_PRICE DOUBLE NOT NULL,	BRAND VARCHAR(128),    CAR_TYPE VARCHAR(128),    MODEL VARCHAR(128),    CAR_YEAR YEAR,    MILES INT,    CAR_USAGE ENUM ('HIGH','MID','LOW') NOT NULL);CREATE TABLE IF NOT EXISTS car_user_master(	CUID BIGINT PRIMARY KEY AUTO_INCREMENT,    CAR_ID BIGINT NOT NULL,    USER_ID BIGINT NOT NULL,    FOREIGN KEY (CAR_ID) REFERENCES  cars(CAR_ID) ON DELETE CASCADE,    FOREIGN KEY (USER_ID) REFERENCES users(USER_ID) ON DELETE CASCADE);CREATE TABLE IF NOT EXISTS car_user_servant(    CAR_ID BIGINT NOT NULL,    USER_ID BIGINT NOT NULL,	PRIMARY KEY (CAR_ID, USER_ID),    FOREIGN KEY (CAR_ID) REFERENCES  cars(CAR_ID) ON DELETE CASCADE,    FOREIGN KEY (USER_ID) REFERENCES users(USER_ID) ON DELETE CASCADE);CREATE TABLE IF NOT EXISTS insurances(	INSURANCE_ID BIGINT PRIMARY KEY AUTO_INCREMENT,    INSURANCE_TYPE ENUM ('CI', 'TPO', 'TPFT'),    INSURANCE_DURATION INT NOT NULL,    PRICE DOUBLE,	CUID BIGINT ,	FOREIGN KEY (CUID) REFERENCES car_user_master(CUID) ON DELETE CASCADE);create table IF NOT EXISTS claims(	CLAIM_ID BIGINT PRIMARY KEY AUTO_INCREMENT,    INSURANCE_ID BIGINT,    TITLE VARCHAR(128) NOT NULL,    CONTENT VARCHAR(2048) NOT NULL,    FOREIGN KEY(INSURANCE_ID) REFERENCES INSURANCES(INSURANCE_ID) ON DELETE CASCADE);