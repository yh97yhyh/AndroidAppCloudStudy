#!/bin/bash

# 1.패키지 소스 업데이트
apt-get -y update

#2 . NIGINX 설치
apt-get -y install nginx

# 3. 웹 콘텐츠 만들기
filename=/var/www/html/index.html
echo "Running JARVIS ENGIN from host $(hostname)!" > ${filename}
