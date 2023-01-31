create table app_currency(
  code varchar(50) primary key,
  symbol varchar(50),
  name varchar(50) not null,
  symbol_native varchar(50),
  decimal_digits int,
  rounding int,
  name_plural varchar(50)
);