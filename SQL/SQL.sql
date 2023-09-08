show tables;

use accountapp_db;

select * from account_tb;
select * from user_tb;

describe account_tb;
describe user_tb;

drop table account_tb;
drop table user_tb;


use productapp_db;

select * from product_tb;
select * from storage_tb;

select * from person_tb;
select * from key_tb;

select * from job_tb;
select * from job_tb_personaljob;

describe product_tb;
describe storage_tb;

describe person_tb;
describe key_tb;

describe job_tb;
describe job_tb_person_tb;

drop table product_tb;
drop table storage_tb;

drop table key_tb;
drop table person_tb;

drop table job_tb;
drop table personaljob;
drop table job_tb_personaljob;
