FROM openjdk:21

COPY target/*.jar /srv
COPY docker/gateway-service.sh /srv

RUN chmod +x /srv/gateway-service.sh

EXPOSE 8100

VOLUME [ "/srv/logs" ]

WORKDIR /srv

ENTRYPOINT ["./gateway-service.sh"]