<?php
/*
curl -X POST -u "6zSwOuPXQMWRGjQIvhrlVw:foiQxXvFQfaZ6-1O9_GvuQ" \
   -H "Content-Type: application/json" \
   -H "Accept: application/vnd.urbanairship+json; version=3;" \
   --data '{"audience": "all", "notification": {"alert": "Hello!"}, "device_types": ["ios"]}' \
   https://go.urbanairship.com/api/push/
*/

 define('APPKEY','6zSwOuPXQMWRGjQIvhrlVw'); // Your App Key
 define('PUSHSECRET', 'foiQxXvFQfaZ6-1O9_GvuQ'); // Your Master Secret
 define('PUSHURL', 'https://go.urbanairship.com/api/push/');

 $contents = array();
 $contents['badge'] = "+1";
 $contents['alert'] = "PHP script test";
 $contents['sound'] = "cat.caf";
 $notification = array();
 $notification['ios'] = $contents;
 $platform = array();
 array_push($platform, "ios");

 $push = array("audience"=>"all", "notification"=>$notification, "device_types"=>$platform);

 $json = json_encode($push);

 $session = curl_init(PUSHURL);
 curl_setopt($session, CURLOPT_USERPWD, APPKEY . ':' . PUSHSECRET);
 curl_setopt($session, CURLOPT_POST, True);
 curl_setopt($session, CURLOPT_POSTFIELDS, $json);
 curl_setopt($session, CURLOPT_HEADER, False);
 curl_setopt($session, CURLOPT_RETURNTRANSFER, True);
 curl_setopt($session, CURLOPT_HTTPHEADER, array('Content-Type:application/json', 'Accept: application/vnd.urbanairship+json; version=3;'));
 $content = curl_exec($session);
 echo $content; // just for testing what was sent

 // Check if any error occured
 $response = curl_getinfo($session);
 if($response['http_code'] != 202) {
     echo "Got negative response from server, http code: ".
     $response['http_code'] . "\n";
 } else {

     echo "Wow, it worked!\n";
 }

 curl_close($session);
?>

