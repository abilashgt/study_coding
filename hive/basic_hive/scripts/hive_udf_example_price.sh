#!/usr/bin/env bash

hive -e "
ADD JAR basic-hive.jar;
CREATE TEMPORARY FUNCTION PRICE_UPDATER AS 'com.abilashthomas.hive.PriceUpdaterUdf';
select PRICE_UPDATER(1.2, 3.0)
"