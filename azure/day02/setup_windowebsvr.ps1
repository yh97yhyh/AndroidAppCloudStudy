# 1. 웹 서버 설치
Install-WindowsFeature -Name Web-Server -IncludeManagementTools

# 2. 웹 콘텐츠 생성
Set-Content -Path "C:\inetpub\wwwroot\Default.htm" -Value "Running JARVIS Web Service from host $($env:computername)!"