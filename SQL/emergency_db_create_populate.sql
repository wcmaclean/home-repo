create table dispatcher
(
	dID 	varchar(4) 	not null,
	dfName 	varchar(30) 	not null,
	dlName 	varchar(30) 	not null,
	dPhone 	varchar(12) 	not null,

	primary key(dID),

	foreign key(dPhone) references phone(phNumber)
)

create table officer
(
	oID 	varchar(4) 	not null,
	ofName 	varchar(30) 	not null,
	olName 	varchar(30) 	not null,

	primary key(oID)
)

create table person
(
	pID 	varchar(10) 	not null,
	pfName 	varchar(30) 	not null,
	plName 	varchar(30) 	not null,

	primary key(pID)
)

create table emergencyCall
(
	ecID  		varchar(10) 	not null,

	ecPersonID 	varchar(10) 	not null,
	ecDispatcher 	varchar(4) 	not null,
	ecLocation 	varchar(10) 	not null,
	ecRadioTen 	varchar(5) 	not null,

	ecHandling 	varchar(2),
	ecAction 	char(1),

	ecDescription 	varchar(30),

	ecDate 		datetime 	not null,
	
	primary key(ecID),

	foreign key(ecPersonID) references person(pID),
	foreign key(ecDispatcher) references dispatcher(dID),
	foreign key(ecLocation) references location(lID),
	foreign key(ecRadioTen) references radioTenCode(rtID),
	foreign key(ecHandling) references handlingCode(hcID),
	foreign key(ecAction) references actionCode(acID)
)

create table officerEmergencyCall
(
	oecOfficer 	varchar(4) 	not null,	
	oecEmergency  	varchar(10) 	not null,

	foreign key(oecOfficer) references officer(oID),
	foreign key(oecEmergency) references emergencyCall(ecID)
)

create table location
(
	lID 		varchar(10) 	not null,
	lAddress 	varchar(30) 	not null,
	lPhone 		varchar(12),

	primary key(lID),
	foreign key(lPhone) references phone(phNumber)
)

create table phone
(
	phNumber 	varchar(12) 	not null,
	phAddress 	varchar(30),

	primary key(phNumber),
	foreign key(phAddress) references location(lID)
)

create table personPhone
(
	ppPerson 	varchar(10) 	not null,	
	ppPhone 	varchar(12) 	not null,

	foreign key(ppPerson) references person(pID),
	foreign key(ppPhone) references phone(phNumber)
)

create table radioTenCode
(
	rtID 	varchar(6) 	not null,
	rtDesc 	varchar(60) 	not null,

	primary key(rtID)
)

create table handlingCode
(
	hcID 	varchar(2) 	not null,
	hcDesc 	varchar(60) 	not null,

	primary key(hcID)
)

create table actionCode
(
	acID 	char(1) 	not null,
	acDesc 	varchar(60) 	not null,

	primary key(acID)
)

create table vehicle
(
	vVIN 	varchar(30) 	not null,
	vMake 	varchar(30) 	not null,
	vModel 	varchar(30) 	not null,
	vYear 	varchar(4) 	not null,
	vColor 	varchar(30),

	primary key(vVIN)
)

create table licensePlate
(
	lpLicense 	varchar(10) 	not null,
	lpPerson 	varchar(10) 	not null,	
	lpVehicle 	varchar(30) 	not null,

	primary key(lpLicense),
	foreign key(lpPerson) references person(pID),
	foreign key(lpVehicle) references vehicle(vVIN)
)

create table registerVehicle
(
	rvNumber 	varchar(10) 	not null,
	rvPerson 	varchar(10) 	not null,	
	rvVehicle 	varchar(30) 	not null,

	primary key(rvLicense),
	foreign key(rvPerson) references person(pID),
	foreign key(rvVehicle) references vehicle(vVIN)
)

create table trafficTicket
(
	ttTicket 	varchar(10)	not null,
	ttViolation 	varchar(30)	not null,
	ttLicense 	varchar(10) 	not null,
	ttPerson 	varchar(10) 	not null,	

	primary key(ttTicket),
	foreign key(ttPerson) references person(pID),
	foreign key(ttLicense) references licensePlate(lpLicense)	
)


insert into radioTenCode values("10-1", "UNABLE TO COPY")
insert into radioTenCode values("10-2", "SIGNAL'S GOOD")
insert into radioTenCode values("10-3", "STOP TRANSMITTING")
insert into radioTenCode values("10-4", "ACKNOWLEDGEMENT")
insert into radioTenCode values("10-5", "RELAY")
insert into radioTenCode values("10-6", "BUSY, STANDBY")
insert into radioTenCode values("10-7", "OUT OF SERVICE")
insert into radioTenCode values("10-8", "IN SERVICE")
insert into radioTenCode values("10-9", "REPEAT")
insert into radioTenCode values("10-10", "FIGHT IN PROGRESS")
insert into radioTenCode values("10-11", "DOG CHASE")
insert into radioTenCode values("10-12", "STANDBY")
insert into radioTenCode values("10-13", "WEATHER & ROAD REPORT")
insert into radioTenCode values("10-14", "REPORT OF PROWLER")
insert into radioTenCode values("10-15", "CIVIL DISTURBANCE")
insert into radioTenCode values("10-16", "DOMESTIC TROUBLE")
insert into radioTenCode values("10-17", "MEET COMPLAINANT")
insert into radioTenCode values("10-18", "COMPLETE ASSIGNMENT")
insert into radioTenCode values("10-19", "RETURN TO ___________")
insert into radioTenCode values("10-20", "LOCATION")
insert into radioTenCode values("10-21", "CALL BYPHONE")
insert into radioTenCode values("10-22", "DISREGARD")
insert into radioTenCode values("10-23", "ARRIVED AT SCENE")
insert into radioTenCode values("10-24", "ASSIGNMENT COMPLETED")
insert into radioTenCode values("10-25", "REPORT IN PERSON TO")
insert into radioTenCode values("10-26", "DETAINING SUBJECT")
insert into radioTenCode values("10-27", "DRIVERS LICENSE INFO.")
insert into radioTenCode values("10-28", "VEHICLE REG. INFOR.")
insert into radioTenCode values("10-29", "CHECK FOR WANTED")
insert into radioTenCode values("10-30", "ILLEGAL USE OF RADIO")
insert into radioTenCode values("10-31", "CRIME IN PROGRESS")
insert into radioTenCode values("10-32", "MAN WITH GUN")
insert into radioTenCode values("10-33", "EMERGENCY")
insert into radioTenCode values("10-34", "RIOT")
insert into radioTenCode values("10-35", "MAJOR CRIME ALERT")
insert into radioTenCode values("10-36", "CORRECT TIME")
insert into radioTenCode values("10-37", "INVESTIGATE VEHICLE")
insert into radioTenCode values("10-38", "STOPPING VEHICLE")
insert into radioTenCode values("10-39", "URGENT")
insert into radioTenCode values("10-40", "SILENT RUN")
insert into radioTenCode values("10-41", "BEGINNING DUTY")
insert into radioTenCode values("10-42", "ENDING DUTY")
insert into radioTenCode values("10-43", "INFORMATION")
insert into radioTenCode values("10-44", "REQUEST PERMISSION TO, LEAVE PATROL FOR")
insert into radioTenCode values("10-45", "ANIMAL CARCASS IN LANE AT")
insert into radioTenCode values("10-46", "ASSIST MOTORIST")
insert into radioTenCode values("10-47", "EMERGENCY ROAD REPAIR")
insert into radioTenCode values("10-48", "TRAFFIC STANDARD REPAIR")
insert into radioTenCode values("10-49", "TRAFFIC LIGHT OUT")
insert into radioTenCode values("10-50", "ACCIDENT")
insert into radioTenCode values("10-51", "WRECKER NEEDED")
insert into radioTenCode values("10-52", "AMBULANCE NEEDED")
insert into radioTenCode values("10-53", "ROADBLOCKED")
insert into radioTenCode values("10-54", "LIVESTOCK ON HIGHWAY")
insert into radioTenCode values("10-55", "INTOXICATED DRIVER")
insert into radioTenCode values("10-56", "INTOXICATED PEDESTRIAN")
insert into radioTenCode values("10-57", "HIT AND RUN")
insert into radioTenCode values("10-58", "DIRECT TRAFFIC")
insert into radioTenCode values("10-59", "CONVOY/ESCORT/SHUTTLE")
insert into radioTenCode values("10-60", "SQUAD IN VICINITY")
insert into radioTenCode values("10-61", "PERSONNEL IN AREA")
insert into radioTenCode values("10-62", "REPLY TO MESSAGE")
insert into radioTenCode values("10-63", "MAKE A WRITTEN COPY")
insert into radioTenCode values("10-64", "MESSAGE FOR LOCAL DELIVER")
insert into radioTenCode values("10-65", "MESSAGE ASSIGNMENT")
insert into radioTenCode values("10-66", "MESSAGE CANCELLATION")
insert into radioTenCode values("10-67", "CLEAR TO READ MESSAGE")
insert into radioTenCode values("10-68", "DISPATCH INFORMATION")
insert into radioTenCode values("10-69", "MESSAGE RECEIVED")
insert into radioTenCode values("10-70", "FIRE ALARM")
insert into radioTenCode values("10-71", "ADVISE NATURE OF FIRE")
insert into radioTenCode values("10-72", "REPORT PROGRESS ON FIRE")
insert into radioTenCode values("10-73", "SMOKE REPORT")
insert into radioTenCode values("10-74", "NEGATIVE")
insert into radioTenCode values("10-75", "IN CONTACT WITH")
insert into radioTenCode values("10-76", "EN ROUTE")
insert into radioTenCode values("10-77", "ESTIMATED TIME OF ARRIVAL")
insert into radioTenCode values("10-78", "NEED ASSISTANCE")
insert into radioTenCode values("10-79", "NOTIFY CORONER")
insert into radioTenCode values("10-80", "CHASE IN PROGRESS")
insert into radioTenCode values("10-82", "RESERVE LODGING")
insert into radioTenCode values("10-84", "ARE YOU GOING TO MEET")
insert into radioTenCode values("10-85", "WILL BE LATE")
insert into radioTenCode values("10-86", "OFFICER ON DUTY")
insert into radioTenCode values("10-87", "PICK UP CHECKS")
insert into radioTenCode values("10-88", "ADVISE PHONE# TO CONTACT")
insert into radioTenCode values("10-89", "BOMB THREAT")
insert into radioTenCode values("10-90", "BANK ALARM")
insert into radioTenCode values("10-91", "UNNECESSARY USE OF RADIO")
insert into radioTenCode values("10-92", "IMPROPERLY PARKED VEHICLE")
insert into radioTenCode values("10-93", "BLOCKAGE")
insert into radioTenCode values("10-94", "DRAG RACING")
insert into radioTenCode values("10-96", "MENTAL SUBJECT")
insert into radioTenCode values("10-97", "RADIO CHECK")
insert into radioTenCode values("10-98", "PRISON OR JAIL BREAK")
insert into radioTenCode values("10-99", "EMERGENCY SECURE")
insert into radioTenCode values("10-100", "WANTED INDIVIDUAL")
insert into handlingCode values("1", "Disturbance, Domestic")
insert into handlingCode values("2", "Disturbance, Teenagers")
insert into handlingCode values("3", "Disturbance, Drunk")
insert into handlingCode values("4", "Disturbance, Noise")
insert into handlingCode values("5", "Disturbance, Other")
insert into handlingCode values("6", "Illegal Parking")
insert into handlingCode values("7", "Sick Removal/Confinement")
insert into handlingCode values("8", "Injured Person")
insert into handlingCode values("9", "Man or Woman Down")
insert into handlingCode values("10", "Animal Bite")
insert into handlingCode values("11", "Suspicious Person(s)/Auto")
insert into handlingCode values("12", "Citizen Calling for Help")
insert into handlingCode values("13", "Lost Person Found")
insert into handlingCode values("14", "Auto, Burglar or Holdup Alarm")
insert into handlingCode values("15", "Inhalator")
insert into handlingCode values("16", "Fire")
insert into handlingCode values("17", "Escort")
insert into handlingCode values("18", "Traffic Accident")
insert into handlingCode values("19", "Other Miscellaneous")
insert into actionCode values("A", "Adam: Not Bona Fide Incident.")
insert into actionCode values("B", "Boy: No Such Person can be found.")
insert into actionCode values("C", "Charles: No Such Address.")
insert into actionCode values("D", "David: No Police Service Necessary.")
insert into actionCode values("E", "Edward: Perpetrator Gone on Arrival.")
insert into actionCode values("F", "Frank: Peace Restored.")
insert into actionCode values("G", "George: Advise Warrent.")
insert into actionCode values("H", "Henry: Advised to Recontact Police.")
insert into actionCode values("I", "Ida: Removed to Hospital or Detox. Facility.")
insert into actionCode values("J", "John: Return to Family / Home.")
insert into actionCode values("K", "King: Taken to District Station.")
insert into actionCode values("L", "Lincoln: Information Report Submitted.")
insert into actionCode values("M", "Mary: Issued Traffic Citation.")
insert into actionCode values("N", "Nora: Issued Ordinance Complaint.")
insert into actionCode values("O", "Ocean: Advised Legal Help.")
insert into actionCode values("P", "Paul: Other Police Service.")
insert into actionCode values("R", "Robert: Arrest Made.")
insert into actionCode values("X", "X Ray: Misc. Incident Exception Report.")
insert into actionCode values("Y", "Young: Animal Bite Information Report.")