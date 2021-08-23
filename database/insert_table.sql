insert into role(name, code) values ('administration', 'admin');
insert into role(name, code) values ('guest account', 'user');

insert into user(fullname, username, password, status, roleid) values ('administration', 'admin', 'admin123', 1, 1);
insert into user(fullname, username, password, status, roleid) values ('guest account', 'user', 'admin123', 1, 2);

insert into category(code, name) values ('the-thao', 'Thể thao');
insert into category(code, name) values ('the-giới', 'Thế giới');
insert into category(code, name) values ('chinh-tri', 'Chính trị');
insert into category(code, name) values ('thoi-su', 'Thời sự');
insert into category(code, name) values ('goc-nhin', 'Góc nhìn');

insert into news(title, categoryid, shortdescription) values ('bài viết 1', 1, 'bài viết số 1');
insert into news(title, categoryid, shortdescription) values ('bài viết 2', 1, 'bài viết số 2');
insert into news(title, categoryid, shortdescription) values ('bài viết 3', 2, 'bài viết số 3');
insert into news(title, categoryid, shortdescription) values ('bài viết 4', 1, 'bài viết số 4');