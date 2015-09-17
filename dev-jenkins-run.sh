#!/usr/bin/env bash

ID=`ps -ef | grep 'garen-0.0.1-SNAPSHOT.jar' | awk '{print $2}'`
for id in $ID
do
        echo "kill process $id"
        kill -9 $id
done


cp /data/jenkins/workspace/Garen/target/garen-0.0.1-SNAPSHOT.jar /data/workspace/garen/

nohup java -jar /data/workspace/garen/garen-0.0.1-SNAPSHOT.jar &
