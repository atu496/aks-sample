DROP TABLE IF EXISTS billionaires;
 
CREATE TABLE billionaires (
  id INT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
);
 
INSERT INTO billionaires (first_name, last_name, career) VALUES
  ('Aliko'),
  ('Bill'),
  ('Folrunsho');