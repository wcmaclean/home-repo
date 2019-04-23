<html>
<head>
<title>Edit a Case</title>
</head>

<body>
<h1>Edit a Case</h1>

<?php

	$logFile = "lawyer_db_log.txt";
	$log = fopen($logFile, 'a') or die("can't open file");

	$case=$_POST['case'];


	$client_first_name=$_POST['client_first_name'];
	$client_middle_name=$_POST['client_middle_name'];
	$client_last_name=$_POST['client_last_name'];
	$street_address_1=$_POST['street_address_1'];
	$street_address_2=$_POST['street_address_2'];
	$city=$_POST['city'];
	$state=$_POST['state'];
	$zip=$_POST['zip'];
	$phone_1=$_POST['phone_1'];
	$phone_2=$_POST['phone_2'];
	$phone_3=$_POST['phone_3'];
	$email=$_POST['email'];
	$client_birth_year=$_POST['client_birth_year'];
	$client_birth_month=$_POST['client_birth_month'];
	$client_birth_day=$_POST['client_birth_day'];
	$soc_sec_num=$_POST['soc_sec_num'];
	$accident_year=$_POST['accident_year'];
	$accident_month=$_POST['accident_month'];
	$accident_day=$_POST['accident_day'];
	$location=$_POST['location'];
	$injury=$_POST['injury'];
	$sign_up_year=$_POST['sign_up_year'];
	$sign_up_month=$_POST['sign_up_month'];
	$sign_up_day=$_POST['sign_up_day'];
	$file_date_year=$_POST['file_date_year'];
	$file_date_month=$_POST['file_date_month'];
	$file_date_day=$_POST['file_date_day'];
	$statute_of_limitations_year=$_POST['statute_of_limitations_year'];
	$statute_of_limitations_month=$_POST['statute_of_limitations_month'];
	$statute_of_limitations_day=$_POST['statute_of_limitations_day'];
	$referall_source=$_POST['referall_source'];


	$employer_name=$_POST['employer_name'];
	$employer_street_address_1=$_POST['employer_street_address_1'];
	$employer_street_address_2=$_POST['employer_street_address_2'];
	$employer_city=$_POST['employer_city'];
	$employer_state=$_POST['employer_state'];
	$employer_zip=$_POST['employer_zip'];
	$average_wage=$_POST['average_wage'];
	$ttd_rate=$_POST['ttd_rate'];
	$ppd_rate=$_POST['ppd_rate'];
	$position=$_POST['position'];
	$how_long_worked=$_POST['how_long_worked'];
	$contact_name=$_POST['contact_name'];
	$contact_phone=$_POST['contact_phone'];


	$insurance_co_name=$_POST['insurance_co_name'];
	$adjuster_first_name=$_POST['adjuster_first_name'];
	$adjuster_last_name=$_POST['adjuster_last_name'];
	$insurance_street_address_1 =$_POST['insurance_street_address_1'];
	$insurance_street_address_2 =$_POST['insurance_street_address_2'];
	$insurance_city =$_POST['insurance_city'];
	$insurance_state =$_POST['insurance_state'];
	$insurance_zip =$_POST['insurance_zip'];
	$insurance_phone_1 =$_POST['insurance_phone_1'];
	$insurance_phone_2 =$_POST['insurance_phone_2'];
	$insurance_fax =$_POST['insurance_fax'];
	$insurance_email =$_POST['insurance_email'];
	$claim_number =$_POST['claim_number'];


	$firm_name =$_POST['firm_name'];
	$attorney_first_name =$_POST['attorney_first_name'];
	$attorney_last_name =$_POST['attorney_last_name'];
	$attorney_street_address_1 =$_POST['attorney_street_address_1'];
	$attorney_street_address_2 =$_POST['attorney_street_address_2'];
	$attorney_city =$_POST['attorney_city'];
	$attorney_state =$_POST['attorney_state'];
	$attorney_zip =$_POST['attorney_zip'];
	$attorney_phone_1 =$_POST['attorney_phone_1'];
	$attorney_phone_2 =$_POST['attorney_phone_2'];
	$attorney_fax =$_POST['attorney_fax'];
	$attorney_email =$_POST['attorney_email'];


	@ $db = new mysqli('localhost', 'lawyer_db_admin', 'password', 'lawyer_db');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}


	$query = "update client set client_first_name='".$client_first_name."' where client_id='".$case."' ";
	echo $query;


	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update client set client_middle_name='".$client_middle_name."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}


	$query = "update client set client_last_name='".$client_last_name."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}


	$query = "update client set street_address_1='".$street_address_1."' where client_id='".$case."' ";	
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}


	$query = "update client set street_address_2='".$street_address_2."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}


	$query = "update client set city='".$city."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update client set state='".$state."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update client set zip='".$zip."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update client set phone_1='".$phone_1."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}



	$query = "update client set phone_2='".$phone_2."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}


	$query = "update client set phone_3='".$phone_3."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}


	$query = "update client set email='".$email."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update client set date_of_birth='".$client_birth_year."-".$client_birth_month."-".$client_birth_day."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update client set soc_Sec_num='".$soc_sec_num."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update client set accident_date='".$accident_year."-".$accident_month."-".$accident_day."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update client set location='".$location."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update client set injury='".$injury."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update client set sign_up_date='".$sign_up_year."-".$sign_up_month."-".$sign_up_day."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update client set date_filed='".$file_date_year."-".$file_date_month."-".$file_date_day."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update client set statute_of_limitations_date='".$statute_of_limitations_year."-".$statute_of_limitations_month."-".$statute_of_limitations_day."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update client set referall_source='".$referall_source."' where client_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}



	$query = "update employer set employer_name='".$employer_name."' where employer_id='".$case."' ";
	echo $query;
	$result = $db->query($query);

	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update employer set street_address_1='".$employer_street_address_1."' where employer_id='".$case."' ";
	echo $query;
	$result = $db->query($query);

	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update employer set street_address_2='".$employer_street_address_2."' where employer_id='".$case."' ";
	echo $query;
	$result = $db->query($query);

	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update employer set city='".$employer_city."' where employer_id='".$case."' ";
	echo $query;
	$result = $db->query($query);

	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update employer set state='".$employer_state."' where employer_id='".$case."' ";
	echo $query;
	$result = $db->query($query);

	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update employer set zip='".$employer_zip."' where employer_id='".$case."' ";
	echo $query;
	$result = $db->query($query);

	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update employer set average_wage='".$average_wage."' where employer_id='".$case."' ";
	echo $query;
	$result = $db->query($query);

	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update employer set ttd_rate='".$ttd_rate."' where employer_id='".$case."' ";
	echo $query;
	$result = $db->query($query);

	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update employer set ppd_rate='".$ppd_rate."' where employer_id='".$case."' ";
	echo $query;
	$result = $db->query($query);

	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update employer set position='".$position."' where employer_id='".$case."' ";
	echo $query;
	$result = $db->query($query);

	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update employer set how_long_worked='".$how_long_worked."' where employer_id='".$case."' ";
	echo $query;
	$result = $db->query($query);

	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update employer set contact_name='".$contact_name."' where employer_id='".$case."' ";
	echo $query;
	$result = $db->query($query);

	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update employer set contact_phone='".$contact_phone."' where employer_id='".$case."' ";
	echo $query;
	$result = $db->query($query);

	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	




	$query = "update insurance set insurance_co_name='".$insurance_co_name."' where insurance_co_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	

	$query = "update insurance set adjuster_first_name='".$adjuster_first_name."' where insurance_co_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	

	$query = "update insurance set adjuster_last_name='".$adjuster_last_name."' where insurance_co_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	

	$query = "update insurance set street_address_1='".$insurance_street_address_1."' where insurance_co_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	

	$query = "update insurance set street_address_2='".$insurance_street_address_2."' where insurance_co_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	

	$query = "update insurance set city='".$insurance_city."' where insurance_co_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	

	$query = "update insurance set state='".$insurance_state."' where insurance_co_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	

	$query = "update insurance set zip='".$insurance_zip."' where insurance_co_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	

	$query = "update insurance set phone_1='".$insurance_phone_1."' where insurance_co_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	

	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	

	$query = "update insurance set phone_2='".$insurance_phone_2."' where insurance_co_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	

	$query = "update insurance set fax='".$insurance_fax."' where insurance_co_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	

	$query = "update insurance set email='".$insurance_email."' where insurance_co_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	

	$query = "update insurance set claim_number='".$claim_number."' where insurance_co_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	





	$query = "update opposing_counsel set firm_name='".$firm_name."' where attorney_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	

	$query = "update opposing_counsel set attorney_first_name='".$attorney_first_name."' where attorney_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	

	$query = "update opposing_counsel set attorney_last_name='".$attorney_last_name."' where attorney_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update opposing_counsel set street_address_1='".$attorney_street_address_1."' where attorney_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update opposing_counsel set street_address_2='".$attorney_street_address_2."' where attorney_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update opposing_counsel set city='".$attorney_city."' where attorney_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update opposing_counsel set state='".$attorney_state."' where attorney_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update opposing_counsel set zip='".$attorney_zip."' where attorney_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update opposing_counsel set phone_1='".$attorney_phone_1."' where attorney_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update opposing_counsel set phone_2='".$attorney_phone_2."' where attorney_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update opposing_counsel set fax='".$attorney_fax."' where attorney_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}

	$query = "update opposing_counsel set email='".$attorney_email."' where attorney_id='".$case."' ";
	echo $query;
	$result = $db->query($query);
	if ($result)
	{
		echo $db->affected_rows." - The data has been entered into the database.";
	}
	else
	{
		fwrite($log, "\r\n");
		fwrite($log, $query);
		echo "An error has occurred, and the data was not entered into the database. See log for info.";
	}	


	echo "<form name='back_to_main_screen' action='view_a_case.php' method='post'>";
	echo "<input type='hidden' id='default_case' name='default_case' value='".$case."' />";
	echo "<input type='submit' value='Back to the Case' />";
	echo "</form>";



	fclose($log);
	$result->free();
	$db->close();



?>

</body>
</html>