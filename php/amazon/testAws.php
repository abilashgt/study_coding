<?php
require 'vendor/autoload.php';

use Aws\S3\S3Client;

$client = S3Client::factory(array(
			'key'  => 'AKIAIMABIR47B3IBWAJQ',
			'secret' => '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',
			'request.options' => array(
				'proxy' => '172.17.1.1:3128'
			),
		));

$client->createBucket(array('Bucket' => 'tagbondbeta/abilash2'));

?>