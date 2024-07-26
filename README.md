# jMatcher: Dating Service

**jMatcher** is a dating service built as a project using Java & Spring Boot.

---
## Setup project

## Build and run
```
./gradlew build
cd build/libs
java -jar jmatcherapi-ROLLING.jar
```

## Swagger
```
http://localhost:8080/api-docs
```

## Run PostgreSQL in Docker

```
docker run --name postgresdocker -p 5430:5432 -e POSTGRES_PASSWORD=postgres -d postgres
```

## Run Minio in Docker
```
docker run -d -p 9000:9000 -p 9001:9001 \\n  quay.io/minio/minio server /data --console-address ":9001"
```

