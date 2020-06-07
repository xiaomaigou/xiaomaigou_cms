#!/bin/bash

APP_NAME=xiaomaigou_cms_service   # APP_NAME为应用名
JAR_NAME=xiaomaigou_cms_service-1.2.3.jar # jar包的名字
APP_PORT=9999          # 应用端口
JAVA_OUT=logs/${APP_NAME}.log  # 应用日志
APP_DEPLOY_SCRIPT_NAME=deploy.sh

mkdir -p logs

usage() {
    echo "Usage: $PROG_NAME {start|stop|restart}"
    exit 2
}

start_application() {
    echo "starting java process"
    nohup java -jar ${JAR_NAME} >> ${JAVA_OUT} 2>&1 &
    echo "started java process"
}

stop_application() {
   checkjavapid=`ps -ef | grep java | grep ${APP_NAME} | grep -v grep |grep -v ${APP_DEPLOY_SCRIPT_NAME} | awk '{print$2}'`

   if [[ ! $checkjavapid ]];then
      echo -e "\rno java process"
      return
   fi

   echo "stop java process"
   times=60
   for e in $(seq 60)
   do
        sleep 1
        COSTTIME=$(($times - $e ))
        checkjavapid=`ps -ef | grep java | grep ${APP_NAME} | grep -v grep |grep -v ${APP_DEPLOY_SCRIPT_NAME} | awk '{print$2}'`
        if [[ $checkjavapid ]];then
            kill -9 $checkjavapid
            echo -e  "\r        -- stopping java lasts `expr $COSTTIME` seconds."
        else
            echo -e "\rjava process has exited"
            break;
        fi
   done
   echo ""
}
start() {
    start_application
}
stop() {
    stop_application
}
case "$1" in
    start)
        start
    ;;
    stop)
        stop
    ;;
    restart)
        stop
        start
    ;;
    *)
        usage
    ;;
esac

