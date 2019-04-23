---------------------------------------------------------------
-- Congress Database; Create, Populate, Tiggers, and Checks
-- COMP 251
-- Project 2
-- Will MacLean
---------------------------------------------------------------
drop table STATE cascade constraints;
create table STATE (
	statename     	varchar2(30),
	region		Varchar2(30),
  	primary key 	(statename)
);

drop table CONGRESSPERSON cascade constraints;
create table CONGRESSPERSON (
	name		varchar2(30), 
	party		varchar2(30),
	startdate	date,
	primary key	(name)
);

drop table BILL cascade constraints;
create table BILL (
	billname	varchar2(30),
	sponsor		varchar2(30),
	passorfail	char(1),
	dateofvote	date,
	foreign key	(sponsor) references CONGRESSPERSON(name),
	primary key	(billname)
);

drop table REPRESENTEDBY cascade constraints;
create table REPRESENTEDBY (
	repstatename   	varchar2(30),
	district	varchar2(30),
	personname	varchar2(30),
	foreign key	(repstatename) references STATE(statename),
	foreign key 	(personname) references CONGRESSPERSON(name),
	primary key	(personname)
);

drop table VOTESON cascade constraints;
create table VOTESON (
	billname	varchar2(30),
	personname	varchar2(30),
	yesorno		char(1),
	foreign key	(billname) references BILL(billname),
	foreign key 	(personname) references CONGRESSPERSON(name),
	primary key	(billname)
);

drop table PROPOSES cascade constraints;
create table PROPOSES (
	billname	varchar2(30),
	personname	varchar2(30),
	foreign key	(billname) references BILL(billname),
	foreign key 	(personname) references CONGRESSPERSON(name),
	primary key	(personname)
);


-----------------------------
-Populate DB
-----------------------------

insert into STATE values
	('illinois','north');
insert into STATE values
  	('indiana','south');
insert into STATE values
  	('wisconsin','east');
insert into STATE values
  	('kentucky','west');
insert into STATE values
  	('california','south');

insert into CONGRESSPERSON values
	('Charlie', 'Democrat', '01-JAN-94');
insert into CONGRESSPERSON values
	('Julia', 'Republican', '01-JAN-00');
insert into CONGRESSPERSON values
	('Steve', 'Democrat', '01-JAN-96');
insert into CONGRESSPERSON values
	('Arbuthnot', 'Libertarian', '01-JAN-02');
insert into CONGRESSPERSON values
	('Yardbird', 'Green', '01-JAN-02');

insert into BILL values
	('Tax bill 1', 'Charlie', 'P', '04-MAR-04');
insert into BILL values
	('Donation bill', 'Steve', 'F', '16-JUN-02');
insert into BILL values
	('Garbage bill', 'Yardbird', 'P', '22-AUG-03');
insert into BILL values
	('Duck bill', 'Yardbird', 'F', '27-FEB-03');
insert into BILL values
	('Patriot Act', 'Charlie', 'F', '04-MAR-02');

insert into REPRESENTEDBY values
	('illinois', 'north', 'Charlie');
insert into REPRESENTEDBY values
	('indiana', 'south', 'Julia');
insert into REPRESENTEDBY values
	('wisconsin', 'east', 'Steve');
insert into REPRESENTEDBY values
	('kentucky', 'west', 'Arbuthnot');
insert into REPRESENTEDBY values
	('california', 'south', 'Yardbird');

insert into VOTESON values
	('Tax bill 1', 'Charlie', 'y');
insert into VOTESON values
	('Donation bill', 'Julia', 'n');
insert into VOTESON values
	('Garbage bill', 'Yardbird', 'y');
insert into VOTESON values
	('Duck bill', 'Arbuthnot', 'n');
insert into VOTESON values
	('Patriot Act', 'Arbuthnot', 'n');

insert into PROPOSES values
	('Tax bill 1', 'Charlie');
insert into PROPOSES values
	('Donation bill', 'Steve');
insert into PROPOSES values
	('Garbage bill', 'Yardbird');
insert into PROPOSES values
	('Duck bill', 'Yardbird');
insert into PROPOSES values
	('Patriot Act', 'Charlie');


---------------------------------
-insert trigger
---------------------------------

drop trigger CONGRESSPERSON_ADD;
create tigger CONGRESSPERSON_ADD
	before insert on CONGRESSPERSON
		for each row
			declare
				cnt number;
			begin
				select count(*) into cnt 







----------------------------------
-Check DB Contents
----------------------------------
select * from *;

