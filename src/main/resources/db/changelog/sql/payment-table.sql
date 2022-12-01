--liquibase formatted sql

CREATE TABLE IF NOT EXISTS payment (
  id         SERIAL PRIMARY KEY,
  first_name VARCHAR(60) NOT NULL,
  last_name  VARCHAR(60) NOT NULL,
  sum        DOUBLE NOT NULL,
  status     VARCHAR(60) NOT NULL
);