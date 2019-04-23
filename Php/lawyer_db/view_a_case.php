<html>
<head>
<title>View a Case</title>
</head>

<body>
<h1>View Case</h1>

<?php


	$logFile = "lawyer_db_log.txt";
	$log = fopen($logFile, 'a') or die("can't open file");


	@ $db = new mysqli('localhost', 'lawyer_db_admin', 'password', 'lawyer_db');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}


	/* default - check if we have another */
	$default_case='1';
	$default_case_in=$_POST['default_case'];
	if (default_case_in)
	{
		$default_case=$default_case_in;
	}
	else
	{
		$default_case="1";
	}

	echo "<form name='enter_new_case' action='enter_new_case_1.php' method='post'>";
	echo "<input type='submit' value='Enter a New Case' />";
	echo "</form>"; 

	echo "<form name='input' action='search_for_a_case.php' method='post'>";
	echo "<p>Search: <input type='text' name='search_string' /> </p>";
	echo "<input type='submit' value='Search for a Case' />";
	echo "</form>"; 



	echo "<table border='1'><tr><td>";

	echo "<form name='view_a_case.php' action='edit_a_case.php' method='post'>";
	echo "<input type='hidden' id='case' name='case' value='".$default_case."' />";

	$query="select * from client where client_id=".$default_case;
	$result = $db->query($query);
	$num_results = $result->num_rows;

	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();	
		$client_first_name=$row['client_first_name'];
		$client_middle_name=$row['client_middle_name'];
		$client_last_name=$row['client_last_name'];
		$street_address_1=$row['street_address_1'];
		$street_address_2=$row['street_address_2'];
		$city=$row['city'];
		$state=$row['state'];
		$zip=$row['zip'];
		$phone_1=$row['phone_1'];
		$phone_2=$row['phone_2'];
		$phone_3=$row['phone_3'];
		$email=$row['email'];
		$date_of_birth=$row['date_of_birth'];
		$soc_sec_num=$row['soc_sec_num'];
		$accident_date=$row['accident_date'];
		$location=$row['location'];		
		$injury=$row['injury'];	
		$sign_up_date=$row['sign_up_date'];	
		$date_filed=$row['date_filed'];	
		$statute_of_limitations_date=$row['statute_of_limitations_date'];	
		$referall_source=$row['referall_source'];	
	}

	echo "<h2>Client</h2>";
	echo "First name:<input type='text' name='client_first_name' value='".$client_first_name."' /><br/>";
	echo "Middle name:<input type='text' name='client_middle_name' value='".$client_middle_name."' /><br/>";
	echo "Last name:<input type='text' name='client_last_name' value='".$client_last_name."' /><br/>";
	echo "Street address 1:<input type='text' name='street_address_1' value='".$street_address_1."' /><br/>";
	echo "Street address 2:<input type='text' name='street_address_2' value='".$street_address_2."' /><br/>";
	echo "City:<input type='text' name='city' value='".$city."' /><br/>";
	echo "State:<input type='text' name='state' maxlength=2 value='".$state."' /><br/>";
	echo "Zip:<input type='text' name='zip' maxlength=5 value='".$zip."' /><br/>";
	echo "Phone 1:<input type='text' name='phone_1' maxlength=12 value='".$phone_1."' /><br/>";
	echo "Phone 2:<input type='text' name='phone_2' maxlength=12 value='".$phone_2."' /><br/>";
	echo "Phone 3:<input type='text' name='phone_3' maxlength=12 value='".$phone_3."' /><br/>";
	echo "Email:<input type='text' name='email' value='".$email."' /><br/>";
	$client_birth_date_array = split("-", $date_of_birth);
	echo "Birth Date - Year:<select name='client_birth_year'>";
	echo "<option>".$client_birth_date_array[0]."</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='client_birth_month'>";
	echo "<option>".$client_birth_date_array[1]."</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='client_birth_day'>";
	echo "<option>".$client_birth_date_array[2]."</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";
	echo "SSR:<input type='text' name='soc_sec_num' maxlength=11 value='".$soc_sec_num."' /><br/>";

	$accident_date_array = split("-", $accident_date);

	echo "Accident Date - Year:<select name='accident_year'>";
	echo "<option>".$accident_date_array[0]."</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='accident_month'>";
	echo "<option>".$accident_date_array[1]."</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='accident_day'>";
	echo "<option>".$accident_date_array[2]."</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";
	echo "Location:<input type='text' name='location' value='".$location."' /><br/>";
	echo "Injury:<input type='text' name='injury' value='".$injury."' /><br/>";
	$sign_up_date_array = split("-", $sign_up_date);
	echo "Sign Up Date - Year:<select name='sign_up_year'>";
	echo "<option>".$sign_up_date_array[0]."</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='sign_up_month'>";
	echo "<option>".$sign_up_date_array[1]."</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='sign_up_day'>";
	echo "<option>".$sign_up_date_array[2]."</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";

	$date_filed_array = split("-", $date_filed);

	echo "Filed Date - Year:<select name='file_date_year'>";
	echo "<option>".$date_filed_array[0]."</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='file_date_month'>";
	echo "<option>".$date_filed_array[1]."</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='file_date_day'>";
	echo "<option>".$date_filed_array[2]."</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";

	$statute_of_limitations_date_array = split("-", $statute_of_limitations_date);
	echo "Statute of Limitations Date - Year:<select name='statute_of_limitations_year'>";
	echo "<option>".$statute_of_limitations_date_array[0]."</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='statute_of_limitations_month'>";
	echo "<option>".$statute_of_limitations_date_array[1]."</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='statute_of_limitations_day'>";
	echo "<option>".$statute_of_limitations_date_array[2]."</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";
	echo "Referall source:<input type='text' name='referall_source' value='".$referall_source."' /><br/>";


	$query="select * from employer where employer_id=".$default_case;
	$result = $db->query($query);
	$num_results = $result->num_rows;

	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();	
		$employer_name=$row['employer_name'];
		$employer_street_address_1=$row['street_address_1'];
		$employer_street_address_2=$row['street_address_2'];
		$employer_city=$row['city'];
		$employer_state=$row['state'];
		$employer_zip=$row['zip'];
		$average_wage=$row['average_wage'];
		$ttd_rate=$row['ttd_rate'];
		$ppd_rate=$row['ppd_rate'];
		$position=$row['position'];
		$how_long_worked=$row['how_long_worked'];
		$contact_name=$row['contact_name'];
		$contact_phone=$row['contact_phone'];
	}

	echo "<h2>Employer</h2>";
	echo "Employer name:<input type='text' name='employer_name' value='".$employer_name."' /><br/>";
	echo "Street address 1:<input type='text' name='employer_street_address_1' value='".$employer_street_address_1."' /><br/>";
	echo "Street address 2:<input type='text' name='employer_street_address_2' value='".$employer_street_address_2."' /><br/>";
	echo "City:<input type='text' name='employer_city' value='".$employer_city."' /><br/>";
	echo "State:<input type='text' name='employer_state' maxlength=2 value='".$employer_state."' /><br/>";
	echo "Zip:<input type='text' name='employer_zip' maxlength=5 value='".$employer_zip."' /><br/>";
	echo "Average wage:<input type='text' name='average_wage' value='".$average_wage."' /><br/>";
	echo "TTD Rate:<input type='text' name='ttd_rate' value='".$ttd_rate."' /><br/>";
	echo "PPD Rate:<input type='text' name='ppd_rate' value='".$ppd_rate."' /><br/>";
	echo "Position:<input type='text' name='position' value='".$position."' /><br/>";
	echo "How long worked:<input type='text' name='how_long_worked' value='".$how_long_worked."' /><br/>";
	echo "Contact name:<input type='text' name='contact_name' value='".$contact_name."' /><br/>";
	echo "Contact phone:<input type='text' name='contact_phone' maxlength=12 value='".$contact_phone."' /><br/>";


	$query="select * from insurance where insurance_co_id=".$default_case;
	$result = $db->query($query);
	$num_results = $result->num_rows;

	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();	
		$insurance_co_name=$row['insurance_co_name'];
		$adjuster_first_name=$row['adjuster_first_name'];
		$adjuster_last_name=$row['adjuster_last_name'];
		$insurance_street_address_1=$row['street_address_1'];
		$insurance_street_address_2=$row['street_address_2'];
		$insurance_city=$row['city'];
		$insurance_state=$row['state'];
		$insurance_zip=$row['zip'];
		$insurance_phone_1=$row['phone_1'];
		$insurance_phone_2=$row['phone_2'];
		$insurance_fax=$row['fax'];
		$insurance_email=$row['email'];
		$claim_number=$row['claim_number'];	
	}

	echo "<h2>Insurance Company</h2>";
	echo "Name:<input type='text' name='insurance_co_name' value='".$insurance_co_name."' /><br/>";
	echo "Adjuster First name:<input type='text' name='adjuster_first_name' value='".$adjuster_first_name."' /><br/>";
	echo "Adjuster Last name:<input type='text' name='adjuster_last_name' value='".$adjuster_last_name."' /><br/>";
	echo "Street address 1:<input type='text' name='insurance_street_address_1' value='".$insurance_street_address_1."' /><br/>";
	echo "Street address 2:<input type='text' name='insurance_street_address_2' value='".$insurance_street_address_2."' /><br/>";
	echo "City:<input type='text' name='insurance_city' value='".$insurance_city."' /><br/>";
	echo "State:<input type='text' name='insurance_state' maxlength=2 value='".$insurance_state."' /><br/>";
	echo "Zip:<input type='text' name='insurance_zip' maxlength=5 value='".$insurance_zip."' /><br/>";
	echo "Phone 1:<input type='text' name='insurance_phone_1' maxlength=12 value='".$insurance_phone_1."' /><br/>";
	echo "Phone 2:<input type='text' name='insurance_phone_2' maxlength=12 value='".$insurance_phone_2."' /><br/>";
	echo "Fax:<input type='text' name='insurance_fax' maxlength=10 value='".$insurance_fax."' /><br/>";
	echo "Email:<input type='text' name='insurance_email' maxlength=10 value='".$insurance_email."' /><br/>";
	echo "Claim Number:<input type='text' name='claim_number' maxlength=10 value='".$claim_number."' /><br/>";

	$query="select * from opposing_counsel where attorney_id=".$default_case;
	$result = $db->query($query);
	$num_results = $result->num_rows;


	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();	
		$firm_name=$row['firm_name'];
		$attorney_first_name=$row['attorney_first_name'];
		$attorney_last_name=$row['attorney_last_name'];
		$attorney_street_address_1=$row['street_address_1'];
		$attorney_street_address_2=$row['street_address_2'];
		$attorney_city=$row['city'];
		$attorney_state=$row['state'];
		$attorney_zip=$row['zip'];
		$attorney_phone_1=$row['phone_1'];
		$attorney_phone_2=$row['phone_2'];
		$attorney_fax=$row['fax'];
		$attorney_email=$row['email'];
	}

	echo "<h2>Opposing Counsel</h2>";
	echo "Firm Name:<input type='text' name='firm_name' value='".$firm_name."' /><br/>";
	echo "Attorney First name:<input type='text' name='attorney_first_name' value='".$attorney_first_name."' /><br/>";
	echo "Attorney Last name:<input type='text' name='attorney_last_name' value='".$attorney_last_name."' /><br/>";
	echo "Street address 1:<input type='text' name='attorney_street_address_1' value='".$attorney_street_address_1."' /><br/>";
	echo "Street address 2:<input type='text' name='attorney_street_address_2' value='".$attorney_street_address_2."' /><br/>";
	echo "City:<input type='text' name='attorney_city' value='".$attorney_city."' /><br/>";
	echo "State:<input type='text' name='attorney_state' maxlength=2 value='".$attorney_state."' /><br/>";
	echo "Zip:<input type='text' name='attorney_zip' maxlength=5 value='".$attorney_zip."' /><br/>";
	echo "Phone 1:<input type='text' name='attorney_phone_1' maxlength=12 value='".$attorney_phone_1."' /><br/>";
	echo "Phone 2:<input type='text' name='attorney_phone_2' maxlength=12 value='".$attorney_phone_2."' /><br/>";
	echo "Fax:<input type='text' name='attorney_fax' maxlength=10 value='".$attorney_fax."' /><br/>";
	echo "Email:<input type='text' name='attorney_email' maxlength=10 value='".$attorney_email."' /><br/>";



	echo "<br/><input type='submit' value='Submit the Change' />";

	echo "</form>";


	echo "</td><td>";


	echo "<h2>Other</h2>";

	echo "<form name='create_other' action='create_other_1.php' method='post'>";
	echo "<input type='hidden' id='case' name='case' value='".$default_case."' />";
	echo "<input type='submit' value='Create an Other Entry' />";
	echo "</form>";

	echo "<form name='edit_other' action='edit_an_other_1.php' method='post'>";
	echo "<input type='hidden' id='case' name='case' value='".$default_case."' />";
	$query="select * from other where client_id=".$default_case;
	$result = $db->query($query);
	$num_results = $result->num_rows;

	echo "<select name='other_id' size='6'>";
	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();
		echo "<option>".$row['other_id']."-".$row['file_number'].", ".$row['fee_petition_name'].", ".$row['fee_petition_amount']."</option>";
	}
	echo "</select><br/>";

	echo "<br/><input type='submit' value='Select Other' />";
	echo "</form>";

	echo "<h2>Liens</h2>";

	echo "<form name='create_lien' action='create_lien_1.php' method='post'>";
	echo "<input type='hidden' id='case' name='case' value='".$default_case."' />";
	echo "<input type='submit' value='Create a Lien' />";
	echo "</form>";

	echo "<form name='edit_lien' action='edit_lien_1.php' method='post'>";
	echo "<input type='hidden' id='case' name='case' value='".$default_case."' />";
	$query="select * from lien where client_id=".$default_case;
	$result = $db->query($query);
	$num_results = $result->num_rows;

	echo "<select name='lien_stuff' size='6'>";
	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();
		echo "<option >".$row['lien_id']."-".$row['lien_name'].", ".$row['lien_amount'].", ".$row['lien_comment']."</option>";
	}
	echo "</select><br/>";

	echo "<br/><input type='submit' value='Select Lien' />";
	echo "</form>";



	echo "<h2>Notes</h2>";

	echo "<form name='create_note' action='create_note_1.php' method='post'>";
	echo "<input type='hidden' id='case' name='case' value='".$default_case."' />";
	echo "<input type='submit' value='Create a Note' />";
	echo "</form>";

	echo "<form name='notes' action='edit_note_1.php' method='post'>";
	echo "<input type='hidden' id='case' name='case' value='".$default_case."' />";
	$query="select * from notes where client_id=".$default_case;
	$result = $db->query($query);
	$num_results = $result->num_rows;

	echo "<select name='note_stuff' size='6'>";
	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();
		echo "<option>".$row['note_id']."-".$row['note']."</option>";
	}
	echo "</select><br/>";
	echo "<br/><input type='submit' value='Select Note' />";
	echo "</form>";

	echo "<h2>Events</h2>";

	echo "<form name='create_event' action='create_event_1.php' method='post'>";
	echo "<input type='hidden' id='case' name='case' value='".$default_case."' />";
	echo "<input type='submit' value='Create an Event' />";
	echo "</form>";

	echo "<form name='edit_event' action='edit_event_1.php' method='post'>";
	echo "<input type='hidden' id='case' name='case' value='".$default_case."' />";
	$query="select * from events where client_id=".$default_case;
	$result = $db->query($query);
	$num_results = $result->num_rows;

	echo "<select name='event_stuff' size='6'>";
	for ($i=0; $i < $num_results; $i++)
	{
		$row = $result->fetch_assoc();
		echo "<option>".$row['event_id']."-".$row['event'].", ".$row['location']."</option>";
	}
	echo "</select><br/>";
	echo "<br/><input type='submit' value='Select Event' />";
	echo "</form>";

	echo "</tr></table>";

	$result->free();
	$db->close();


?>

</body>
</html>