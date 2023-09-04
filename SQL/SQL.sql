show tables;

use accountapp_db;

select * from account_tb;
select * from user_tb;

describe account_tb;
describe user_tb;

drop table account_tb;
drop table user_tb;

use productapp_db;

select * from person_tb;
select * from key_tb;

select * from tb_product;
select * from tb_storage;
select * from tb_storage_tb_product;

describe person_tb;
describe key_tb;

describe tb_product;
describe tb_storage;
describe tb_storage_tb_product;

drop table person_tb;
drop table key_tb;

drop table tb_product;
drop table tb_storage;
drop table tb_storage_tb_product;