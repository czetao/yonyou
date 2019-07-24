insert into agent (code, name, person) values ('1111', 'a01','aaaa');
insert into bill (code, name, department,agent_id) values ('1111', 'a01','aaaa',1);
insert into bill (code, name, department,agent_id) values ('1112', 'a02','bbbb',1);
insert into bill_item (code, name, material, bill_id) values ('111111', 'a0101','abc123',1);
insert into bill_item (code, name, material, bill_id) values ('111112', 'a0102','abc231',1);
insert into bill_item (code, name, material, bill_id) values ('111211', 'a0201','abc231',2);