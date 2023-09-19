## TCL ##

#Transaction Control (TCL) statements are used to manage the changes made by DML statements. It allows statements to be grouped together into logical transactions.

#COMMIT - save work done
#SAVEPOINT - identify a point in a transaction to which you can later roll back
#ROLLBACK - restore database to original since the last COMMIT
#SET TRANSACTION - Change transaction options like isolation level and what rollback segment to use