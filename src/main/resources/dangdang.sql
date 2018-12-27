/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     2018/7/6 16:08:29                            */
/*==============================================================*/

delete from dd_address;
delete from dd_item;
delete from dd_order;
delete from dd_user;

/*==============================================================*/
/* Table: dd_address                                            */
/*==============================================================*/

drop sequence dd_address_seq;
drop table dd_address cascade constraints;

create table dd_address  (
   id                   INTEGER              primary key           not null,
   receive_name         VARCHAR2(20),
   full_address         VARCHAR2(200),
   zipcode              VARCHAR2(6),
   receive_tel          VARCHAR2(11),
   receive_phone        VARCHAR2(11),
   user_id              INTEGER
);

create sequence dd_address_seq;

/*dd_category_seq.nextval,姓名,详细地址,邮政编码,电话,手机,用户id*/

insert into dd_address values(dd_address_seq.nextval,'小黑','北京昌平','100000','13222222222',null,1);
insert into dd_address values(dd_address_seq.nextval,'小黑','北京海淀','100000','13222222222',null,1);

select * from dd_address;

/*==============================================================*/
/* Table: dd_category                                           */
/*==============================================================*/

drop sequence dd_category_seq;
drop table dd_category cascade constraints;

create table dd_category  (
   id                   INTEGER            primary key             not null,
   name                 VARCHAR2(20),
   category_level       VARCHAR2(20),
   goods_count          NUMBER(5),
   parentId          INTEGER
);

create sequence dd_category_seq;

/*dd_category_seq.nextval,类型名称,分类级别,分类数量,父级id*/

insert into dd_category values(dd_category_seq.nextval,'小说','一级分类',23,null);
insert into dd_category values(dd_category_seq.nextval,'当代小说','二级分类',10,1);
insert into dd_category values(dd_category_seq.nextval,'近现代小说','二级分类',13,1);
insert into dd_category values(dd_category_seq.nextval,'古典小说','二级分类',0,1);
insert into dd_category values(dd_category_seq.nextval,'四大名著','二级分类',0,1);
insert into dd_category values(dd_category_seq.nextval,'世界名著','二级分类',0,1);

insert into dd_category values(dd_category_seq.nextval,'青春','一级分类',0,null);
insert into dd_category values(dd_category_seq.nextval,'校园','二级分类',0,7);
insert into dd_category values(dd_category_seq.nextval,'爱情/情感','二级分类',0,7);
insert into dd_category values(dd_category_seq.nextval,'叛逆/成长','二级分类',0,7);
insert into dd_category values(dd_category_seq.nextval,'玄幻','二级分类',0,7);
insert into dd_category values(dd_category_seq.nextval,'原创','二级分类',0,7);

insert into dd_category values(dd_category_seq.nextval,'人文社科','一级分类',0,null);
insert into dd_category values(dd_category_seq.nextval,'政治','二级分类',0,13);
insert into dd_category values(dd_category_seq.nextval,'经济','二级分类',0,13);
insert into dd_category values(dd_category_seq.nextval,'法律','二级分类',0,13);
insert into dd_category values(dd_category_seq.nextval,'哲学','二级分类',0,13);
insert into dd_category values(dd_category_seq.nextval,'历史','二级分类',0,13);

insert into dd_category values(dd_category_seq.nextval,'管理','一级分类',0,null);
insert into dd_category values(dd_category_seq.nextval,'管理学','二级分类',0,19);
insert into dd_category values(dd_category_seq.nextval,'战略管理','二级分类',0,19);
insert into dd_category values(dd_category_seq.nextval,'市场营销','二级分类',0,19);
insert into dd_category values(dd_category_seq.nextval,'商业史传','二级分类',0,19);
insert into dd_category values(dd_category_seq.nextval,'电子商务','二级分类',0,19);

insert into dd_category values(dd_category_seq.nextval,'少儿','一级分类',0,null);
insert into dd_category values(dd_category_seq.nextval,'0-2岁','二级分类',0,25);
insert into dd_category values(dd_category_seq.nextval,'3-6岁','二级分类',0,25);
insert into dd_category values(dd_category_seq.nextval,'7-10岁','二级分类',0,25);
insert into dd_category values(dd_category_seq.nextval,'11-14岁','二级分类',0,25);
insert into dd_category values(dd_category_seq.nextval,'儿童文学','二级分类',0,25);

insert into dd_category values(dd_category_seq.nextval,'外语','一级分类',0,null);
insert into dd_category values(dd_category_seq.nextval,'英语','二级分类',0,31);
insert into dd_category values(dd_category_seq.nextval,'日语','二级分类',0,31);
insert into dd_category values(dd_category_seq.nextval,'韩语','二级分类',0,31);
insert into dd_category values(dd_category_seq.nextval,'俄语','二级分类',0,31);
insert into dd_category values(dd_category_seq.nextval,'德语','二级分类',0,31);

insert into dd_category values(dd_category_seq.nextval,'计算机','一级分类',0,null);
insert into dd_category values(dd_category_seq.nextval,'计算机理论','二级分类',0,37);
insert into dd_category values(dd_category_seq.nextval,'数据库','二级分类',0,37);
insert into dd_category values(dd_category_seq.nextval,'程序设计','二级分类',0,37);
insert into dd_category values(dd_category_seq.nextval,'人工智能','二级分类',0,37);
insert into dd_category values(dd_category_seq.nextval,'计算机考试','二级分类',0,37);

select * from dd_category;

/*==============================================================*/
/* Table: dd_item                                               */
/*==============================================================*/

drop sequence dd_item_seq;
drop table dd_item cascade constraints;

create table dd_item  (
   id                   INTEGER            primary key             not null,
   order_id             INTEGER,
   product_id           INTEGER,
   product_name         VARCHAR2(50),
   dang_price           NUMBER(11,2),
   product_num          NUMBER(5),
   amount               NUMBER(11,2)
);

create sequence dd_item_seq;

select * from dd_item;

/*==============================================================*/
/* Table: dd_order                                              */
/*==============================================================*/

drop sequence dd_order_seq;
drop table dd_order cascade constraints;

create table dd_order  (
   id                   INTEGER             primary key            not null,
   total_price          NUMBER(11,2),
   status               NUMBER(2),
   create_time          DATE,
   user_id              INTEGER,
   address_id           INTEGER
);

create sequence dd_order_seq;

select * from dd_order;

/*==============================================================*/
/* Table: dd_product                                            */
/*==============================================================*/

drop sequence dd_product_seq;
drop table dd_product cascade constraints;

create table dd_product  (
   id                   INTEGER             primary key            not null,
   book_name            VARCHAR(35),
   img_name            VARCHAR(20),
   author               VARCHAR(20),
   publishing           VARCHAR2(20),
   publish_time         DATE,
   which_edtion         NUMBER(3),
   print_time           DATE,
   print_number         NUMBER(3),
   isbn                 VARCHAR2(20),
   word_number          NUMBER(5),
   total_page           NUMBER(5),
   format               VARCHAR2(20),
   paper                VARCHAR2(20),
   packing              VARCHAR2(20),
   price                NUMBER(11,2),
   dang_price           NUMBER(11,2),
   recommend            VARCHAR2(500),
   content_introduct    VARCHAR2(500),
   author_summary       VARCHAR2(500),
   catalog              VARCHAR2(500),
   media_comment        VARCHAR2(500),
   excerpt              VARCHAR2(500),
   click_rate           NUMBER(5),
   sales_volumn         NUMBER(5),
   shelf_time           DATE,
   category_id          INTEGER
);

create sequence dd_product_seq;

/*dd_product_seq.nextval,书名,图片名,作者,出版社,出版时间,版次,印刷时间,印次,ISBN,字数,页数,
开本,纸张,包装,定价,当当价,编辑推荐,内容简介,作者简介,目录,媒体评论,书摘插图,点击量,销量,上架时间,分类编号*/

insert into dd_product values
(dd_product_seq.nextval,'窗边的小豆豆','1.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20180525','yyyy-MM-dd'),2);
insert into dd_product values
(dd_product_seq.nextval,'童年 在人间 我的大学','2.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20180525','yyyy-MM-dd'),2);
insert into dd_product values
(dd_product_seq.nextval,'海水观赏鱼','3.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20180525','yyyy-MM-dd'),2);
insert into dd_product values
(dd_product_seq.nextval,'小妇人','4.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20180525','yyyy-MM-dd'),2);
insert into dd_product values
(dd_product_seq.nextval,'双螺旋','5.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20180525','yyyy-MM-dd'),2);
insert into dd_product values
(dd_product_seq.nextval,'简·爱','6.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20180525','yyyy-MM-dd'),2);
insert into dd_product values
(dd_product_seq.nextval,'Java就业指导','7.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20180525','yyyy-MM-dd'),2);
insert into dd_product values
(dd_product_seq.nextval,'茶花女','8.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20180525','yyyy-MM-dd'),2);
insert into dd_product values
(dd_product_seq.nextval,'雪莱精选','9.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20180525','yyyy-MM-dd'),2);
insert into dd_product values
(dd_product_seq.nextval,'在人间','10.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20180525','yyyy-MM-dd'),2);
insert into dd_product values
(dd_product_seq.nextval,'关键管理问题','12.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20160525','yyyy-MM-dd'),3);
insert into dd_product values
(dd_product_seq.nextval,'孩子我们一路同行	','13.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20160525','yyyy-MM-dd'),3);
insert into dd_product values
(dd_product_seq.nextval,'傲慢与偏见','14.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20160525','yyyy-MM-dd'),3);
insert into dd_product values
(dd_product_seq.nextval,'童年','15.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20160525','yyyy-MM-dd'),3);
insert into dd_product values
(dd_product_seq.nextval,'一个陌生女人的来信','16.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20160525','yyyy-MM-dd'),3);
insert into dd_product values
(dd_product_seq.nextval,'鲁滨逊漂流记','17.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20160525','yyyy-MM-dd'),3);
insert into dd_product values
(dd_product_seq.nextval,'老子说','18.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20160525','yyyy-MM-dd'),3);
insert into dd_product values
(dd_product_seq.nextval,'达·芬奇密码','19.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20160525','yyyy-MM-dd'),3);
insert into dd_product values
(dd_product_seq.nextval,'淘气包马小跳','20.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20160525','yyyy-MM-dd'),3);
insert into dd_product values
(dd_product_seq.nextval,'夏洛的网','21.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20160525','yyyy-MM-dd'),3);
insert into dd_product values
(dd_product_seq.nextval,'Servlet和Jsp核心编程思想','22.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20160525','yyyy-MM-dd'),3);
insert into dd_product values
(dd_product_seq.nextval,'庐隐','23.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20160525','yyyy-MM-dd'),3);
insert into dd_product values
(dd_product_seq.nextval,'门口野蛮人','24.jpg','我写的','地球出版社',sysdate,1,sysdate,1,'13579',
10000,30,'16开','完美纸张','完美包装',200,180,'编辑推荐','这书很好','作者简介','目录','媒体评论',
'书摘插图',0,0,to_date('20160525','yyyy-MM-dd'),3);

select * from dd_product;

/*==============================================================*/
/* Table: dd_user                                               */
/*==============================================================*/

drop sequence dd_user_seq;
drop table dd_user cascade constraints;

create table dd_user  (
   id                   INTEGER            primary key             not null,
   email                VARCHAR2(32),
   nickname             VARCHAR2(20),
   password             VARCHAR2(32),
   salt             VARCHAR2(8),
   status               NUMBER(2),
   create_time          DATE
);

create sequence dd_user_seq;

/*dd_user_seq.nextval,'邮箱','昵称','密码',状态,注册时间*/

insert into dd_user values(dd_user_seq.nextval,'xiaohie@qq.com','sos','123456',null,1,sysdate);

select * from dd_user;
