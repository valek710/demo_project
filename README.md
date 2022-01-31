# Demo project

## Prerequisites:

1. Docker
2. Docker Compose

## Installation (linux):

### SDKMAN
1. `curl -s "https://get.sdkman.io" | bash`
2. `source "$HOME/.sdkman/bin/sdkman-init.sh"`
3. `sdk version`

If all went well, the version should be displayed. Something like:

````
sdkman 5.13.1
````

### Docker and Docker Compose

1. `sudo apt-get update`
2. `sudo apt install apt-transport-https ca-certificates curl software-properties-common`
3. `curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -`
4. `sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable"`
5. `apt-cache policy docker-ce`
6. `sudo apt install docker-ce`
7. `sudo systemctl status docker`

The output should be similar to the following, showing that the service is active and running:

````
● docker.service - Docker Application Container Engine
     Loaded: loaded (/lib/systemd/system/docker.service; enabled; vendor preset: enabled)
     Active: active (running) since Tue 2020-05-19 17:00:41 UTC; 17s ago
TriggeredBy: ● docker.socket
       Docs: https://docs.docker.com
   Main PID: 24321 (dockerd)
      Tasks: 8
     Memory: 46.4M
     CGroup: /system.slice/docker.service
             └─24321 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock
````

8. `sudo usermod -aG docker ${USER}`
9. `su - ${USER}`
10. `groups`

Output:
````
sammy sudo docker
````

11. `sudo curl -L "https://github.com/docker/compose/releases/download/1.27.4/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose`
12. `sudo chmod +x /usr/local/bin/docker-compose`
13. `docker-compose --version`

You’ll see output similar to this:

````
docker-compose version 1.27.4, build 40524192
````

## Run application:

1.`docker-compose up -d`

## Resources:
- Swagger - http://localhost:8081/swagger-ui.html
- Grafana - http://localhost:3000/login (by default `admin:admin`)
- Prometheus - http://localhost:9090
- Postgres metrics - http://localhost:9187/metrics
- Java app metrics - http://localhost:8082/actuator


## Dashboards:

1. Click `Import`.
2. In field `Import via grafana.com` type id of dashboard and click load:
- [Spring Boot](https://grafana.com/grafana/dashboards/10280)
- [PostgreSQL](https://grafana.com/grafana/dashboards/9628)
3. Make choice in dropdown `Prometheus` and click `Import`.