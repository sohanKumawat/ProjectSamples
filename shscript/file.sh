#!/bin/sh
pwd

for val in {21,32,43}
do
  echo sohan $val
done

while getopts ":abc" option
do
	case $option in
		a )
            echo this is a option $option
			;;
		b )
            echo this is a option $option
			;;
		* )
            echo this is a option $option
			;;	
	esac
	echo sohan in switch case loop
done

echo "what is your name"
read name
echo "how do you do $name"

echo file name is $0
echo file argument $1
echo script name is $$
echo second arguments $2

if (( "$#"=="0" )); then
       echo pass at least one parameter
	exit 1
fi



while (( $# ));
do
	echo paramters is $1
	shift
done
echo enter your age
read vage

if [ "$vage" -ge 18 ]; then 
	echo you are eligible voting $vage
else 
	echo you are younger $vage
fi	



