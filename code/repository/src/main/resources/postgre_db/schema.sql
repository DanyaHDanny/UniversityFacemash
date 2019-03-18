DROP TABLE IF EXISTS study_group CASCADE;

-- -----------------------------
-- Create table 'study_group'
-- -----------------------------
CREATE TABLE IF NOT EXISTS study_group
(
  id     BIGSERIAL PRIMARY KEY NOT NULL,
  name   CHARACTER VARYING(10) NOT NULL UNIQUE,
  active BOOLEAN               NOT NULL DEFAULT ('true')
);