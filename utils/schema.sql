CREATE DATABASE IF NOT EXISTS javaee;
USE javaee;

DROP TABLE IF EXISTS Meals;
DROP TABLE IF EXISTS Foods;

CREATE TABLE Meals(
	Id                    INT              PRIMARY KEY AUTO_INCREMENT,
	date                  DATETIME NOT NULL,
	foodCompositionIdList TEXT     NOT NULL
);

CREATE TABLE Foods(
    Id          INT                 PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(20) NOT NULL,
    description TEXT            NULL
);
