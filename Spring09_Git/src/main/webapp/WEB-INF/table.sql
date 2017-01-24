CREATE TABLE client_account
(id varchar2(100) PRIMARY KEY,
balance Number CHECK(balance >= 0 ),
bonusPoint Number CHECK(bonusPoint >=0));


-- sample 데이터

INSERT INTO client_account VALUES('index', 0,0)