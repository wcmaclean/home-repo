class db_manager
{
	public $db;

	function __construct()
	{
		@ $db = new mysqli('localhost', 'lawyer_db_admin', 'password', 'lawyer_db');

		if (mysqli_connect_errno())
		{
			echo 'Could not connect to db - try again.';
			exit;
		}
	}

	function __destruct()
	{
		$db->close();
	}

	update($update_string)
	{

	}

	get_values($query)
	{

	}

/* how to use?
$my_db = new db_manager();
$my_db->update($update_string);

*/


}