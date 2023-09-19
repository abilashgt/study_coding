## alter column ##

# add new column
ALTER TABLE `users` ADD `name` VARCHAR( 255 ) NOT NULL AFTER `userID`

# drop column
ALTER TABLE `users` DROP `name`

# modify column
ALTER TABLE `users` CHANGE `name` `firstName` VARCHAR(50) NOT NULL