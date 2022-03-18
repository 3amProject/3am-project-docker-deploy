FROM node:10-alpine as builder

WORKDIR /react

COPY ./front-end ./

RUN yarn && yarn build


FROM nginx:alpine
#!/bin/sh

WORKDIR /app

RUN mkdir -p /app/logs && \
    mkdir -p /var/log/nginx && \
    mkdir -p /var/cache/nginx && \
    mkdir -p /var/run

RUN chmod 777 /var/cache/nginx && \
    chmod 777 /var/run && \
    chmod 777 /app/logs && \
    chmod 777 /var/log/nginx && \
    rm -rf /var/log/nginx/* && \
    rm -rf /var/cache/nginx/*

COPY ./.docker/nginx/nginx.conf /etc/nginx/nginx.conf
COPY ./.docker/nginx/default.conf /etc/nginx/conf.d/default.conf
#COPY --from=builder /react/build /usr/share/nginx/html
COPY --from=builder /react/build /app/build

EXPOSE 8080

ENTRYPOINT ["nginx", "-g", "daemon off;"]
