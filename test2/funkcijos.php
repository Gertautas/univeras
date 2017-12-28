
      <?php
      $link = mysql_connect("localhost", "root", "");
      mysql_select_db("database", $link);
      
      $result = mysql_query("SELECT * FROM users", $link);
      $num_rows = mysql_num_rows($result);
      
      echo "$num_rows Rows\n";
      
      ?>