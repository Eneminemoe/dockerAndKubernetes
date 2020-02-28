if [ $# != 2 ];
    then echo "Illegal number of arguments. Must supply ip and version. example: xx.xx.xx.xx 1 or xx.xx.xx.xx 2"
    exit 2
fi
echo $#
URL="http://$1/v$2/welcome"
echo $URL
for i in {0..250}
do
echo ""
echo "count $i"
#resp=$(curl -f "$URL")
curl -f $URL
#sleep 0.1
done