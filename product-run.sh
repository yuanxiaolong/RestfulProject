#!/bin/bash

ID=`ps -ef | grep 'garen-0.0.1-SNAPSHOT.jar' | awk '{print $2}'`
for id in $ID
do
        echo "kill process $id"
        kill -9 $id
done

nohup java -jar garen-0.0.1-SNAPSHOT.jar >> garenRun.log 2>&1 &
