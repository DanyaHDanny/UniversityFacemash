DROP TABLE IF EXISTS estimate CASCADE;
DROP TABLE IF EXISTS laboratory_work CASCADE;
DROP TABLE IF EXISTS lab_comment CASCADE;
DROP TABLE IF EXISTS subject CASCADE;
DROP TABLE IF EXISTS university_user CASCADE;
DROP TABLE IF EXISTS study_group CASCADE;
DROP TABLE IF EXISTS speciality CASCADE;
DROP TABLE IF EXISTS faculty CASCADE;

-- -------------------------
-- Create table 'faculty'
-- -------------------------
CREATE TABLE IF NOT EXISTS faculty
(
  id     BIGSERIAL PRIMARY KEY  NOT NULL,
  name   CHARACTER VARYING(256) NOT NULL UNIQUE,
  active BOOLEAN                NOT NULL
);

CREATE TABLE IF NOT EXISTS speciality
(
  id         BIGSERIAL PRIMARY KEY  NOT NULL,
  name       CHARACTER VARYING(256) NOT NULL UNIQUE,
  active     BOOLEAN                NOT NULL,
  faculty_id BIGINT                 NOT NULL REFERENCES faculty (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- -----------------------------
-- Create table 'study_group'
-- -----------------------------
CREATE TABLE IF NOT EXISTS study_group
(
  id            BIGSERIAL PRIMARY KEY  NOT NULL,
  name          CHARACTER VARYING(256) NOT NULL UNIQUE,
  course        SMALLINT               NOT NULL,
  active        BOOLEAN                NOT NULL,
  speciality_id BIGINT                 NOT NULL REFERENCES speciality (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- --------------------------------
-- Create table 'university_user'
-- --------------------------------
CREATE TABLE IF NOT EXISTS university_user
(
  id         BIGSERIAL PRIMARY KEY  NOT NULL,
  login      CHARACTER VARYING(20)  NOT NULL UNIQUE,
  password   CHARACTER VARYING(64)  NOT NULL,
  user_role  CHARACTER VARYING(14)  NOT NULL,
  first_name CHARACTER VARYING(256) NOT NULL,
  last_name  CHARACTER VARYING(256) NOT NULL,
  active     BOOLEAN                NOT NULL,
  group_id   BIGINT REFERENCES study_group (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- -----------------------
-- Create table 'subject'
-- -----------------------
CREATE TABLE IF NOT EXISTS subject
(
  id   BIGSERIAL PRIMARY KEY  NOT NULL,
  name CHARACTER VARYING(256) NOT NULL UNIQUE
);

-- --------------------------
-- Create table 'lab_comment'
-- --------------------------
CREATE TABLE IF NOT EXISTS lab_comment
(
  id 		      BIGSERIAL PRIMARY KEY  NOT NULL,
  description CHARACTER VARYING(500) NOT NULL
);

-- -----------------------------
-- Create table 'estimate'
-- -----------------------------
CREATE TABLE IF NOT EXISTS estimate
(
  id             BIGSERIAL PRIMARY KEY NOT NULL,
  mark           SMALLINT              NOT NULL,
  date_lab_work  TIMESTAMP             NOT NULL
);

-- -------------------------------
-- Create table 'laboratory_work'
-- -------------------------------
CREATE TABLE IF NOT EXISTS laboratory_work
(
  id                    BIGSERIAL PRIMARY KEY  NOT NULL,
  description           CHARACTER VARYING(500) NOT NULL,
  subject_id            BIGINT                 NOT NULL REFERENCES subject (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  university_user_id    BIGINT                 NOT NULL REFERENCES university_user (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  lab_comment_id        BIGINT                 NOT NULL REFERENCES lab_comment (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  estimate_id           BIGINT                 NOT NULL REFERENCES estimate (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);