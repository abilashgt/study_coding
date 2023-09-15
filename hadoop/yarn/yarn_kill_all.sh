echo "Kill script started"
for ((n=0;n<50;n++))
do
  for x in $(yarn application -list -appStates RUNNING | awk 'NR > 2 { print $1 }'); do yarn application -kill $x; done
done
echo "Kill script finished"
