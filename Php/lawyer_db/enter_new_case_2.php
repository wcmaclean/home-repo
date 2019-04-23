<html>
<head>
<title>Enter a New Case</title>
</head>

<body>
<h1>Enter a New Case</h1>

<?php


	$logFile = "lawyer_db_log.txt";
	$log = fopen($logFile, 'a') or die("can't open file");



	/* client */
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

	/* employer */
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

	/* insurance */
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

	/* opposing counsel */
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

/*
	if (!bird_name)
	{
		echo "You must enter a name. Please go back and try again.";
		exit;
	}


	str_replace("'", "&#39;", $bird_likes);
	str_replace("'", "&#39;", $bird_notes);
*/

/*
	@ $db = new mysqli('localhost', 'bird_db', 'bird_db', 'bird_db');
*/
	@ $db = new mysqli('localhost', 'lawyer_db_admin', 'password', 'lawyer_db');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}

	$query = "select max(case_number) as prev_case from case_numbers";

	/* get previous case number */
	$prev_case=null;
	$result = $db->query($query);
	$num_results = $result->num_rows;
	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();
		$prev_case = $row['prev_case'];
	}

	/* increment the case number, write it to case_numbers */
	$next_case = $prev_case + 1;  


	$query = "insert into case_numbers values(".$next_case.")";
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

	/* client */
	$query = "insert into client values(".$next_case." ,".
		"'".$client_first_name."', ".
		"'".$client_middle_name."', ".
		"'".$client_last_name."', ".
		"'".$street_address_1."', ".
		"'".$street_address_2."', ".
		"'".$city."', ".
		"'".$state."', ".
		"'".$zip."', ".
		"'".$phone_1."', ".
		"'".$phone_2."', ".
		"'".$phone_3."', ".
		"'".$email."', ".
		"'".$client_birth_year."-".$client_birth_month."-".$client_birth_day."', ".
		"'".$soc_sec_num."', ".
		"'".$accident_year."-".$accident_month."-".$accident_day."', ".
		"'".$location."', ".
		"'".$injury."', ".
		"'".$sign_up_year."-".$sign_up_month."-".$sign_up_day."', ".
		"'".$file_date_year."-".$file_date_month."-".$file_date_day."', ".
		"'".$statute_of_limitations_year."-".$statute_of_limitations_month."-".$statute_of_limitations_day."', ".
		"'".$referall_source."') ";

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


	/* employer */
	$query = "insert into employer values(".$next_case." ,".
		"'".$employer_name."', ".
		"'".$employer_street_address_1."', ".
		"'".$employer_street_address_2."', ".
		"'".$employer_city."', ".
		"'".$employer_state."', ".
		"'".$employer_zip."', ".
		"'".$average_wage."', ".
		"'".$ttd_rate."', ".
		"'".$ppd_rate."', ".
		"'".$position."', ".
		"'".$how_long_worked."', ".
		"'".$contact_name."', ".
		"'".$contact_phone."') ";

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


	/* insurance */
	$query = "insert into insurance values(".$next_case." ,".
		"'".$insurance_co_name."', ".
		"'".$adjuster_first_name."', ".
		"'".$adjuster_last_name."', ".
		"'".$insurance_street_address_1."', ".
		"'".$insurance_street_address_2."', ".
		"'".$insurance_city."', ".
		"'".$insurance_state."', ".
		"'".$insurance_zip."', ".
		"'".$insurance_phone_1."', ".
		"'".$insurance_phone_2."', ".
		"'".$insurance_fax."', ".
		"'".$insurance_email."', ".
		"'".$claim_number."') ";

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


	/* opposing counsel */
	$query = "insert into opposing_counsel values(".$next_case." ,".
		"'".$firm_name."', ".
		"'".$attorney_first_name."', ".
		"'".$attorney_last_name."', ".
		"'".$attorney_street_address_1."', ".
		"'".$attorney_street_address_2."', ".
		"'".$attorney_city."', ".
		"'".$attorney_state."', ".
		"'".$attorney_zip."', ".
		"'".$attorney_phone_1."', ".
		"'".$attorney_phone_2."', ".
		"'".$attorney_fax."', ".
		"'".$attorney_email."') ";

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
	echo "<input type='hidden' id='default_case' name='default_case' value='".$next_case."' />";
	echo "<input type='submit' value='Back to Main Screen' />";
	echo "</form>"; 

	fclose($log);
	$result->free();
	$db->close();


?>

</body>
</html>