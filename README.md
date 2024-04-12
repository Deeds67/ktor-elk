# Ktor-ELK

This is a playground for propagating logs to Logstash.
Here is a docker-compose to spin up the ELK stack with: https://github.com/Deeds67/docker-elk

The `Application.kt` file sends different logs every few seconds to provide some dummy data.
The logstash appender is configured in the `logback.xml` file.
