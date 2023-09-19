<?php

$ch = curl_init();
$timeout = 5;
$url = 'http://abilashthomas.com';

curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, $timeout);
$data = curl_exec($ch);
curl_close($ch);

print_r($data); exit;

?>