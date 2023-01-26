#!/bin/sh
if [ -f /bin/podman ]; then
  CONATINER_RUNNER=podman
else
  CONATINER_RUNNER=docker
fi
echo "runner ${CONATINER_RUNNER}"
$CONATINER_RUNNER run --name postgres -d \
  -p 5432:5432 \
  -e POSTGRES_PASSWORD=pass \
  -e POSTGRES_USER=user \
  -e POSTGRES_DB=quarkus \
  postgres:13.9-alpine3.17

mvn clean package -Duser.timezone=Etc/GMT-1
mvn verify -DskipUnitTests=true
$CONATINER_RUNNER stop postgres
$CONATINER_RUNNER rm postgres
