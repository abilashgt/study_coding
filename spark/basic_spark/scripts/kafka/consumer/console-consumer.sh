#!/usr/bin/env bash

kafka-console-consumer.sh --zookeeper localhost:2181 --topic test-topic-name --from-beginning
