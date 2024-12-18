### Przykładowa konfiguracja Kafka dla pojedynczego węzła w Spring Boot 3 

Przykład konfiguracji (z drobnymi zmianami) pochodzi ze strony:
https://medium.com/@caoyang1024/setup-local-kafka-cluster-with-kafka-ui-enabled-using-docker-desktop-9293f733cf28

Docker compose definiuje lokalny klaser Kafki, w skład którego wchodzą następujące serwisy:
- zookeeper (1 server utrzymuje swoją aktualną konfigurację np. listę brokerów, listę topików, ich rozlokowane między brokerami, informację o uprawnieniach (ACLs), itp)
- kafka (3 brokery)
- ui (interfejs użytkownika Kafka dostępny pod adresem [http://localhost:8081](hhtp://localhost:8081)
