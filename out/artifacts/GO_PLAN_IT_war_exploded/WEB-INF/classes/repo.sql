create table ACCOUNT(ID number, USERNAME varchar2(50), PASSWORD varchar2(50));
create table DATABASE(ID number, URL varchar2(120), PORT varchar2(30), USERNAME varchar2(120), PASSWORD varchar2(120), SERVICE varchar2(80), ACCOUNT_ID number);
create table BUSINESSRULE(ID number, NAME varchar2(50), STATUS varchar2(20));
create table BUSINESSRULE_COMPOSITE (RULE_ID number, ARR_ID number, ACR_ID number, ALR_ID number, AOR_ID number, TCR_ID number, TOR_ID number, IECR_ID number, EOR_ID number, MR_ID number);
create table ATTRIBUTERANGE (ID number, TABLE1 varchar2(40), COLUMN1 varchar(40), VALUE1 number, VALUE2 number);
create table ATTRIBUTECOMPARE (ID number, TABLE1 varchar2(40), COLUMN1 varchar(40), VALUE1 number, OPERATOR varchar2(4));
create table ATTRIBUTELIST (ID number, TABLE1 varchar2(40), COLUMN1 varchar(40), VALUE1 varchar2(200));
create table TupleCompare (ID number, TABLE1 varchar2(40), COLUMN1 varchar(40), COLUMN2 varchar2(40), OPERATOR varchar2(4));

select * from account;
select * from businessrule;
select * from businessrule_composite;
select * from attributerange;
select * from attributecompare;
select * from attributelist;
select * from tuplecompare;

truncate table businessrule;
truncate table businessrule_composite;
truncate table attributerange;
truncate table attributecompare;
truncate table attributelist;
truncate table tuplecompare;

select max(id) as max from businessrule;

alter table businessrule add database_id number;
-- volgorde: AttributeRange, Compare, List, TupleCompare
select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.value1, c.value2 from businessrule a left join businessrule_composite b on a.id = b.rule_id left join attributerange c on b.arr_id = c.id where b.arr_id is not null;
select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.value1, c.operator from businessrule a left join businessrule_composite b on a.id = b.rule_id left join attributecompare c on b.acr_id = c.id where b.acr_id is not null;
select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.value1 from businessrule a left join businessrule_composite b on a.id = b.rule_id left join attributelist c on b.alr_id = c.id where b.alr_id is not null;
select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.column2, c.operator from businessrule a left join businessrule_composite b on a.id = b.rule_id left join tuplecompare c on b.tcr_id = c.id where b.tcr_id is not null;

insert into ACCOUNT values (1, 'martijn', '0000');
insert into database values (1, 'ondora02.hu.nl', '8521', 'tosad_2017_her_team1_target', 'tosad_2017_her_team1_target', 'cursus02.hu.nl', 1);

select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.value1, c.operator from businessrule a left join businessrule_composite b on a.id = b.rule_id left join attributecompare c on b.acr_id = c.id where b.acr_id is not null and a.database_id = 1;