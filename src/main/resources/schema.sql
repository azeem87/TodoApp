DROP TABLE config_params;
CREATE TABLE IF NOT EXISTS config_params (
  config_id INT NOT NULL AUTO_INCREMENT,
  config_key VARCHAR(100) NULL,
  config_value VARCHAR(500) NULL,
  config_description VARCHAR(100) NULL,
  PRIMARY KEY (config_id));
 
--insert some sample values
 
insert into config_params(config_key, config_value, config_description)
values('con.key1', 'value1', 'description1'),
    ('con.key2', 'value2', 'description1');