Docker Selenium Grid

This project performs simple google search operation in chrome and firefox using Selenium Grid and Docker

Pre-requisites:
1. Docker should be installed in the machine.
2. VNC Server and Viewer should be installed to view the execution.
3. Start the Docker engine.
4. Save this below command in a bat file as 'DockerSeleniumGrid.BAT' and run it Powershell.

docker run -d -p 4444:4444 --name selenium-hub selenium/hub
docker run -d -p 5900:5900 --link selenium-hub:hub -v /dev/shm/dev/shm selenium/node-chrome-debug
docker run -d -p 5901:5900 --link selenium-hub:hub -v /dev/shm/dev/shm selenium/node-firefox-debug

5. Open VNC Viewer and enter IP address 127.0.0.1:5900 and enter 'secret' in Password field to connect to the Chrome container
6. Enter IP address 127.0.0.1:5901 and enter 'secret' in Password field to connect to the FireFox container

Run the testNG xml file to perform parallel testing using SeleniumGrid and Docker
