drop database if exists TinCode;
create database TinCode CHAR SET UTF8MB4 COLLATE utf8mb4_unicode_ci;
use TinCode;


CREATE TABLE `Users`
(
    `id`       INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(16)  NOT NULL UNIQUE,
    `password` VARCHAR(16)  NOT NULL
);

CREATE TABLE `Words`
(
    `id`          INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `word`        VARCHAR(255) NOT NULL,
    `definition`  VARCHAR(255) NOT NULL,
    `original`    VARCHAR(255) NOT NULL,
    `example` TEXT         NOT NULL
);

