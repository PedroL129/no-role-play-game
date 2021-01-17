#!/bin/sh

mkdir .tmp

cd .tmp

printf "Download JAR OpenApi Generator"

#wget https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/5.0.0/openapi-generator-cli-5.0.0.jar \
#  -O ./openapi-generator-cli.jar

# Download current stable 3.x.x branch (OpenAPI version 3)
wget https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli/3.0.24/swagger-codegen-cli-3.0.24.jar -O swagger-codegen-cli.jar


ports=(8081 8082 8083 8084 8085)
clients=("hero" "race" "map" "item" "enemy")

for i in "${!clients[@]}"; do 
  printf "Generate client for %s" "${clients[$i]}"

 java -jar swagger-codegen-cli.jar generate \
  -i http://localhost:${ports[$i]}/v3/api-docs \
  --api-package com.pedrol129.nrpg.${clients[$i]}client.api \
  --model-package com.pedrol129.nrpg.${clients[$i]}client.model \
  --invoker-package com.pedrol129.nrpg.${clients[$i]}client.invoker \
  --group-id com.pedrol129.nrpg \
  --artifact-id ${clients[$i]}-api-client \
  -l java \
  --additional-properties useOptional=true,java8=true,hideGenerationTimestamp=true \
  --library resttemplate \
  -o ./${clients[$i]}-api-client


mvn -f ./${clients[$i]}-api-client/pom.xml install -DskipTests
done

cd ..
rm -rf .tmp