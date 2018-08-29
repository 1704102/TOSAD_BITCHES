-- drop tables if exists: https://stackoverflow.com/questions/1799128/oracle-if-table-exists
BEGIN
  EXECUTE IMMEDIATE 'drop table comparerule';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -942 THEN
      RAISE;
    END IF;
END;
BEGIN
  EXECUTE IMMEDIATE 'drop table attributerule';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -942 THEN
      RAISE;
    END IF;
END;
BEGIN
  EXECUTE IMMEDIATE 'drop table operatorrule';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -942 THEN
      RAISE;
    END IF;
END;
BEGIN
  EXECUTE IMMEDIATE 'drop table businessrule';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -942 THEN
      RAISE;
    END IF;
END;

create table businessrule(
    brcode varchar2(50) not null,
	targetDbTable varchar2(50) not null
)

create table attributeleaf(
    attributecolumn varchar2(50) not null
)

create table operatorleaf(
    operatorcolumn varchar2(1) not null
)

create table compareleaf(
    comparecolumn varchar2(50) not null
)

/*

*/

