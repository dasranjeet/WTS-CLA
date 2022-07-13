<html>
<head>
<title> Displaying Info in table and Insert Query</title
</head>
<center>
<body>
<table border="1">
<tr>
 <th>Emp No. </th>
 <th>Emp Name </th>
 <th>Emp Post</th>
 <th>Emp Salary</th>
</tr>

<?php
$conn = mysql_connect("localhost","root");
mysql_select_db("emp_mgmt",$conn);
$sql = "select * from employee";
$result = mysql_query($sql, $conn);
while ($row = mysql_fetch_array($result,MYSQL_ASSOC)) 
{
 $eno = $row['empno'];
 $name = $row['ename'];
 $epo = $row['post'];
 $esa = $row['salary']; 
?>
<tr>
 <td> <?php echo $eno; ?></td>
 <td> <?php echo $name; ?></td>
 <td> <?php echo $epo; ?></td>
 <td> <?php echo $esa; ?></td>
</tr>
<?php
}
mysql_close($conn);
?>
<table>
<br/>
<br/>
<form action="<?php $PHP_SELF ?>" method = "POST">
Employee No: <br/> <input type="text" name = "txtEno" size="50"><br/>
Employee Name: <br/> <input type="text" name = "txtEname" size="50"><br/>
Employee Post: <br/> <input type="text" name = "txtPost" size="50"><br/>
Employee Salary: <br/> <input type="text" name = "txtSalary" size="50"><br/>
<input type="submit" name = "btnInsert" value="Save Info">
</form>
<?php
if(isset($_POST['btnInsert']))
{ 
 $conn = mysql_connect("localhost","root");
 if ($conn)
 { 
  mysql_select_db("emp_mgmt",$conn);
  $eno = intval($_POST['txtEno']);
  $ename = strval($_POST['txtEname']);
  $epost = strval($_POST['txtPost']);
  $esal = intval($_POST['txtSalary']);
  $insert = "insert into employee values($eno, '$ename', '$epost', $esal)"; 
  if (mysql_query($insert, $conn))
      {
       echo "Employee Information saved successfully";          
             header("location:Display-Info-in-Table-Insert.php");         
      }
  mysql_close($conn);
 }
}
?>
</center>
</body>
</html>