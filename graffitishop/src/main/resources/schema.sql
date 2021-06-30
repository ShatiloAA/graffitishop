DROP ALL OBJECTS;

create table BRANDS
(
  ID BIGINT auto_increment
    primary key,
  NAME VARCHAR(20),
  DESCRIPTION VARCHAR(256)
)
;

create table COLORS
(
  ID BIGINT auto_increment
    primary key,
  COLOR_HEX VARCHAR(7),
  COLOR VARCHAR(50)
)
;

create table TYPES
(
  ID BIGINT auto_increment
    primary key,
  TYPE_NAME VARCHAR(50),
  SPECIFICATIONS VARCHAR(50)
)
;

create table ITEMS
(
  ID BIGINT auto_increment
    primary key,
  BRAND_ID INTEGER,
  TYPE_ID INTEGER,
  COLOR_ID INTEGER,
  PRICE INTEGER,
  QUANTITY INTEGER,
  constraint ITEMS_BRANDS_ID_FK
  foreign key (BRAND_ID) references BRANDS,
  constraint ITEMS_COLORS_ID_FK
  foreign key (COLOR_ID) references COLORS,
  constraint ITEMS_TYPES_ID_FK
  foreign key (TYPE_ID) references TYPES
)
;

create table CUSTOMERS
(
  ID BIGINT auto_increment
    primary key,
  FULL_NAME VARCHAR(100),
  PHONE BIGINT(11),
  EMAIL VARCHAR(50),
  ADDRESS VARCHAR(250)
)
;

create table ORDERS
(
  ID INTEGER auto_increment,
  CUSTOMER_ID INTEGER not null,
  constraint ORDERS_PK
  primary key (ID),
  constraint ORDERS_USERS_ID_FK
  foreign key (CUSTOMER_ID) references CUSTOMERS
)
;

create table ORDER_ITEMS
(
  ID INTEGER auto_increment,
  ORDER_ID INTEGER not null,
  ITEM_ID INTEGER not null,
  QUANTITY INTEGER,
  constraint ORDER_ITEMS_ITEMS_ID_FK
  foreign key (ITEM_ID) references ITEMS,
  constraint ORDER_ITEMS_ORDERS_ID_FK
  foreign key (ORDER_ID) references ORDERS
)
;

create unique index ORDER_ITEMS_ID_UINDEX
  on ORDER_ITEMS (ID)
;

create unique index PRIMARY_KEY_82
  on ORDER_ITEMS (ID)
;

alter table ORDER_ITEMS
  add constraint ORDER_ITEMS_PK
primary key (ID)
;
