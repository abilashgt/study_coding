<?php
$string = file_get_contents("example.json");
$json_a=json_decode($string,true);
print_r($json_a);
?>