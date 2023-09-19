#!/bin/bash

# use predefined variables to access passed arguments
echo Passed arguments in predefined variables: $1 $2 $3

# We can also store arguments from bash command line in special array
echo 'Arguments in special array $@:'
args=("$@")
echo ${args[0]} ${args[1]} ${args[2]}

echo 'Number of arguments passed $#:' $#
