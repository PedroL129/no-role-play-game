wget https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/5.0.0/openapi-generator-cli-5.0.0.jar \
  -O openapi-generator-cli.jar

java -jar openapi-generator-cli.jar generate \
  -i ./map/src/main/resources/swagger.json \
  --api-package com.pedrol129.nrpg.mapclient.api \
  --model-package com.pedrol129.nrpg.mapclient.model \
  --invoker-package com.pedrol129.nrpg.mapclient.invoker \
  --group-id com.pedrol129.nrpg \
  --artifact-id map-api-client \
  --artifact-version 0.0.1-SNAPSHOT \
  -g java \
  --additional-properties useOptional=true,java8=true \
  --hideGenerationTimestamp true \
  --library native \
  -o tmp/map-api-client

mvn -f ./tmp/map-api-client/pom.xml install