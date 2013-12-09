# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table contact (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  telephone                 varchar(255),
  tel_href                  varchar(255),
  address                   varchar(255),
  city                      varchar(255),
  zipcode                   varchar(255),
  username                  varchar(255),
  password                  varchar(255),
  constraint pk_contact primary key (id))
;

create table product (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  brand                     varchar(255),
  model                     varchar(255),
  type                      varchar(255),
  description               varchar(2000),
  price                     float,
  size                      varchar(255),
  sex                       varchar(255),
  url                       varchar(255),
  shopping_cart_id          bigint,
  constraint pk_product primary key (id))
;

create table shopping_cart (
  id                        bigint auto_increment not null,
  contact_id                bigint,
  constraint pk_shopping_cart primary key (id))
;

alter table product add constraint fk_product_shoppingCart_1 foreign key (shopping_cart_id) references shopping_cart (id) on delete restrict on update restrict;
create index ix_product_shoppingCart_1 on product (shopping_cart_id);
alter table shopping_cart add constraint fk_shopping_cart_contact_2 foreign key (contact_id) references contact (id) on delete restrict on update restrict;
create index ix_shopping_cart_contact_2 on shopping_cart (contact_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table contact;

drop table product;

drop table shopping_cart;

SET FOREIGN_KEY_CHECKS=1;

