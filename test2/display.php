<?php
include("connection.php");
mysqli_select_db($con,"database");
$result=mysqli_query($con,"Select username,statusas,email from users");
echo "<table border='1' >
<tr>
<td align=left> <b>Name </b></td>
<td align=center><b>Status </b></td>
<td align=left><b>Email </b></td>";

while($data = mysqli_fetch_row($result))
{   
    echo "<tr>";
    echo "<td align=center>$data[0]</td>";
    echo "<td align=center>$data[1]</td>";
    echo "<td align=right>$data[2]</td>";
    echo "</tr>";
}
echo "</table>";

?>