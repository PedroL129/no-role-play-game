wget https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/5.0.0/openapi-generator-cli-5.0.0.jar \
  -O openapi-generator-cli.jar

java -jar openapi-generator-cli.jar generate \
  -i ./map/src/main/resources/api.json \
  --api-package com.pedrol129.nrpg.mapclient.api \
  --model-package com.pedrol129.nrpg.mapclient.model \
  --invoker-package com.pedrol129.nrpg.mapclient.invoker \
  --group-id com.pedrol129.nrpg \
  --artifact-id map-api-client \
  --artifact-version 0.0.1-SNAPSHOT \
  -g java \
  --additional-properties useOptional=true,java8=true,hideGenerationTimestamp=true \
  --library native \
  -o tmp/map-api-client

mvn -f ./tmp/map-api-client/pom.xml install

java -jar openapi-generator-cli.jar generate \
  -i ./race/src/main/resources/api.json \
  --api-package com.pedrol129.nrpg.raceclient.api \
  --model-package com.pedrol129.nrpg.raceclient.model \
  --invoker-package com.pedrol129.nrpg.raceclient.invoker \
  --group-id com.pedrol129.nrpg \
  --artifact-id race-api-client \
  --artifact-version 0.0.1-SNAPSHOT \
  -g java \
  --additional-properties useOptional=true,java8=true,hideGenerationTimestamp=true \
  --library native \
  -o tmp/race-api-client

mvn -f ./tmp/race-api-client/pom.xml install

java -jar openapi-generator-cli.jar generate \
  -i ./hero/src/main/resources/api.json \
  --api-package com.pedrol129.nrpg.heroclient.api \
  --model-package com.pedrol129.nrpg.heroclient.model \
  --invoker-package com.pedrol129.nrpg.heroclient.invoker \
  --group-id com.pedrol129.nrpg \
  --artifact-id hero-api-client \
  --artifact-version 0.0.1-SNAPSHOT \
  -g java \
  --additional-properties useOptional=true,java8=true,hideGenerationTimestamp=true \
  --library native \
  -o tmp/hero-api-client

mvn -f ./tmp/hero-api-client/pom.xml install

java -jar openapi-generator-cli.jar generate \
  -i ./item/src/main/resources/api.json \
  --api-package com.pedrol129.nrpg.itemclient.api \
  --model-package com.pedrol129.nrpg.itemclient.model \
  --invoker-package com.pedrol129.nrpg.itemclient.invoker \
  --group-id com.pedrol129.nrpg \
  --artifact-id item-api-client \
  --artifact-version 0.0.1-SNAPSHOT \
  -g java \
  --additional-properties useOptional=true,java8=true,hideGenerationTimestamp=true \
  --library native \
  -o tmp/item-api-client

mvn -f ./tmp/item-api-client/pom.xml install

rm -r tmp