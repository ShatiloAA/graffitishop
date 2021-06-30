insert into CUSTOMERS (FULL_NAME, PHONE, EMAIL, ADDRESS) VALUES ('John Doe', '79119119191', 'jdoe@gmail.com', 'СПб, ул. Пушкина 15, кв. 99');
insert into CUSTOMERS (FULL_NAME, PHONE, EMAIL, ADDRESS) VALUES ('Patrick Star', '79311234567', 'patrickstar@mail.ru', 'СПб, ул. Дно Океана 1, кв. 1');

insert into TYPES (TYPE_NAME, SPECIFICATIONS) VALUES ('краска','400 мл');
insert into TYPES (TYPE_NAME, SPECIFICATIONS) VALUES ('краска','600 мл');
insert into TYPES (TYPE_NAME, SPECIFICATIONS) VALUES ('маркер','ширина пера 15 мм');
insert into TYPES (TYPE_NAME, SPECIFICATIONS) VALUES ('сквайзер','ширина пера 20 мм');

insert into COLORS (COLOR_HEX, COLOR) VALUES ('#FFFF00','желтый');
insert into COLORS (COLOR_HEX, COLOR) VALUES ('#0000FF','голубой');
insert into COLORS (COLOR_HEX, COLOR) VALUES ('#008000','зеленый');
insert into COLORS (COLOR_HEX, COLOR) VALUES ('#FF0000','красный');
insert into COLORS (COLOR_HEX, COLOR) VALUES ('#000000','черный');
insert into COLORS (COLOR_HEX, COLOR) VALUES ('#C0C0C0','серебряный');

insert into BRANDS (NAME, DESCRIPTION) VALUES ('MTN','Старый и популярный бренд');
insert into BRANDS (NAME, DESCRIPTION) VALUES ('MOLOTOW','Еще один старый и популярный бренд');

insert into ITEMS (BRAND_ID, TYPE_ID, COLOR_ID, PRICE, QUANTITY) VALUES ('1','1','1','400','1000');
insert into ITEMS (BRAND_ID, TYPE_ID, COLOR_ID, PRICE, QUANTITY) VALUES ('1','2','2','600','1000');
insert into ITEMS (BRAND_ID, TYPE_ID, COLOR_ID, PRICE, QUANTITY) VALUES ('1','3','5','200','1000');
insert into ITEMS (BRAND_ID, TYPE_ID, COLOR_ID, PRICE, QUANTITY) VALUES ('1','4','6','300','1000');
insert into ITEMS (BRAND_ID, TYPE_ID, COLOR_ID, PRICE, QUANTITY) VALUES ('2','1','3','400','1000');
insert into ITEMS (BRAND_ID, TYPE_ID, COLOR_ID, PRICE, QUANTITY) VALUES ('2','2','4','600','1000');
insert into ITEMS (BRAND_ID, TYPE_ID, COLOR_ID, PRICE, QUANTITY) VALUES ('2','3','1','250','1000');
insert into ITEMS (BRAND_ID, TYPE_ID, COLOR_ID, PRICE, QUANTITY) VALUES ('2','4','5','350','1000');

insert into ORDERS (CUSTOMER_ID) VALUES ('1');
insert into ORDERS (CUSTOMER_ID) VALUES ('2');

insert into ORDER_ITEMS (ORDER_ID, ITEM_ID, QUANTITY) VALUES ('1','1','2');
insert into ORDER_ITEMS (ORDER_ID, ITEM_ID, QUANTITY) VALUES ('1','3','1');
insert into ORDER_ITEMS (ORDER_ID, ITEM_ID, QUANTITY) VALUES ('1','4','1');
insert into ORDER_ITEMS (ORDER_ID, ITEM_ID, QUANTITY) VALUES ('2','5','1');
insert into ORDER_ITEMS (ORDER_ID, ITEM_ID, QUANTITY) VALUES ('2','6','1');
insert into ORDER_ITEMS (ORDER_ID, ITEM_ID, QUANTITY) VALUES ('2','8','1');