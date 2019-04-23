<html>
<head>
<title>Enter a New Case</title>
</head>

<body>
<h1>Enter a New Case</h1>
<?php

/*
	@ $db = new mysqli('localhost', 'bird_db', 'bird_db', 'bird_db');
*/
	@ $db = new mysqli('localhost', 'lawyer_db_admin', 'password', 'lawyer_db');

	if (mysqli_connect_errno())
	{
		echo 'Could not connect to db - try again.';
		exit;
	}

	echo "<form name='enter_new_case_1' action='enter_new_case_2.php' method='post'>";

	echo "<h2>Client</h2>";
	echo "First name:<input type='text' name='client_first_name' /><br/>";
	echo "Middle name:<input type='text' name='client_middle_name' /><br/>";
	echo "Last name:<input type='text' name='client_last_name' /><br/>";
	echo "Street address 1:<input type='text' name='street_address_1' /><br/>";
	echo "Street address 2:<input type='text' name='street_address_2' /><br/>";
	echo "City:<input type='text' name='city' /><br/>";
	echo "State:<input type='text' name='state' maxlength=2 /><br/>";
	echo "Zip:<input type='text' name='zip' maxlength=5 /><br/>";
	echo "Phone 1:<input type='text' name='phone_1' maxlength=12 /><br/>";
	echo "Phone 2:<input type='text' name='phone_2' maxlength=12 /><br/>";
	echo "Phone 3:<input type='text' name='phone_3' maxlength=12 /><br/>";
	echo "Email:<input type='text' name='email' /><br/>";
	echo "Birth Date - Year:<select name='client_birth_year'>";
	echo "<option>0000</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='client_birth_month'>";
	echo "<option>00</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='client_birth_day'>";
	echo "<option>00</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";
	echo "SSR:<input type='text' name='soc_sec_num' maxlength=11 /><br/>";
	echo "Accident Date - Year:<select name='accident_year'>";
	echo "<option>0000</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='accident_month'>";
	echo "<option>00</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='accident_day'>";
	echo "<option>00</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";
	echo "Location:<input type='text' name='location' /><br/>";
	echo "Injury:<input type='text' name='injury' /><br/>";
	echo "Sign Up Date - Year:<select name='sign_up_year'>";
	echo "<option>0000</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='sign_up_month'>";
	echo "<option>00</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='sign_up_day'>";
	echo "<option>00</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";
	echo "Filed Date - Year:<select name='file_date_year'>";
	echo "<option>0000</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='file_date_month'>";
	echo "<option>00</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='file_date_day'>";
	echo "<option>00</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";
	echo "Statute of Limitations Date - Year:<select name='statute_of_limitations_year'>";
	echo "<option>0000</option>";
	for ($i=1970; $i < 2100; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Month:<select name='statute_of_limitations_month'>";
	echo "<option>00</option>";
	for ($i=1; $i < 12; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select>";
	echo " Day:<select name='statute_of_limitations_day'>";
	echo "<option>00</option>";
	for ($i=1; $i < 31; $i++)
	{
		echo "<option>".$i."</option>";
	}
	echo "</select><br/>";
	echo "Referall source:<input type='text' name='referall_source' /><br/>";


	echo "<h2>Employer</h2>";
	echo "Employer name:<input type='text' name='employer_name' /><br/>";
	echo "Street address 1:<input type='text' name='employer_street_address_1' /><br/>";
	echo "Street address 2:<input type='text' name='employer_street_address_2' /><br/>";
	echo "City:<input type='text' name='employer_city' /><br/>";
	echo "State:<input type='text' name='employer_state' maxlength=2 /><br/>";
	echo "Zip:<input type='text' name='employer_zip' maxlength=5 /><br/>";
	echo "Average wage:<input type='text' name='average_wage' /><br/>";
	echo "TTD Rate:<input type='text' name='ttd_rate' /><br/>";
	echo "PPD Rate:<input type='text' name='ppd_rate' /><br/>";
	echo "Position:<input type='text' name='position' /><br/>";
	echo "How long worked:<input type='text' name='how_long_worked' /><br/>";
	echo "Contact name:<input type='text' name='contact_name' /><br/>";
	echo "Contact phone:<input type='text' name='contact_phone' maxlength=12 /><br/>";

	echo "<h2>Insurance Company</h2>";
	echo "Name:<input type='text' name='insurance_co_name' /><br/>";
	echo "Adjuster First name:<input type='text' name='adjuster_first_name' /><br/>";
	echo "Adjuster Last name:<input type='text' name='adjuster_last_name' /><br/>";
	echo "Street address 1:<input type='text' name='insurance_street_address_1' /><br/>";
	echo "Street address 2:<input type='text' name='insurance_street_address_2' /><br/>";
	echo "City:<input type='text' name='insurance_city' /><br/>";
	echo "State:<input type='text' name='insurance_state' maxlength=2 /><br/>";
	echo "Zip:<input type='text' name='insurance_zip' maxlength=5 /><br/>";
	echo "Phone 1:<input type='text' name='insurance_phone_1' maxlength=12 /><br/>";
	echo "Phone 2:<input type='text' name='insurance_phone_2' maxlength=12 /><br/>";
	echo "Fax:<input type='text' name='insurance_fax' maxlength=10 /><br/>";
	echo "Email:<input type='text' name='insurance_email' maxlength=10 /><br/>";
	echo "Claim Number:<input type='text' name='claim_number' maxlength=10 /><br/>";


	echo "<h2>Opposing Counsel</h2>";
	echo "Firm Name:<input type='text' name='firm_name' /><br/>";
	echo "Attorney First name:<input type='text' name='attorney_first_name' /><br/>";
	echo "Attorney Last name:<input type='text' name='attorney_last_name' /><br/>";
	echo "Street address 1:<input type='text' name='attorney_street_address_1' /><br/>";
	echo "Street address 2:<input type='text' name='attorney_street_address_2' /><br/>";
	echo "City:<input type='text' name='attorney_city' /><br/>";
	echo "State:<input type='text' name='attorney_state' maxlength=2 /><br/>";
	echo "Zip:<input type='text' name='attorney_zip' maxlength=5 /><br/>";
	echo "Phone 1:<input type='text' name='attorney_phone_1' maxlength=12 /><br/>";
	echo "Phone 2:<input type='text' name='attorney_phone_2' maxlength=12 /><br/>";
	echo "Fax:<input type='text' name='attorney_fax' maxlength=10 /><br/>";
	echo "Email:<input type='text' name='attorney_email' maxlength=10 /><br/>";



	echo "<br/><input type='submit' value='Enter the case' />";
	echo "</form>";




	$result->free();
	$db->close();
?>


</body>
</html>