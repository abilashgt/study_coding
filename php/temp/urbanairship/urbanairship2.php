<?php
/*
curl -X POST -u "6zSwOuPXQMWRGjQIvhrlVw:foiQxXvFQfaZ6-1O9_GvuQ" \
   -H "Content-Type: application/json" \
   -H "Accept: application/vnd.urbanairship+json; version=3;" \
   --data '{"audience": "all", "notification": {"alert": "Hello!"}, "device_types": ["ios"]}' \
   https://go.urbanairship.com/api/push/
*/

 define('APPKEY','0kwsn0abSz2PrD84jPBf7Q'); // Your App Key
 define('PUSHSECRET', 'DRi6AU9FRaqrUdc4JtDsaA'); // Your Master Secret
 define('PUSHURL', 'https://go.urbanairship.com/api/push/');

 $contents = array();
 //$contents['badge'] = "+1";
 $contents['alert'] = "PHP script test";
 //$contents['sound'] = "cat.caf";
 $notification = array();
 $notification['android'] = $contents;
 $platform = array();
 $audience = array(
 	'apid'=>array(
 		'f80e1a1e-acd0-4c9f-b4fb-f68a987cb317',
 		'f6083502-e104-4e35-971f-670902052ea5'
 		)
 	);
 array_push($platform, "android");

 $push = array("audience"=>$audience, "notification"=>$notification, "device_types"=>$platform);

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

