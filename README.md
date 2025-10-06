# pekko-serialization-jackson3

Jackson 3 equivalent of [pekko-serialization-jackson](https://pekko.apache.org/docs/pekko/current/serialization-jackson.html) which uses Jackson 2.x.

The package name in Jackson3 is `tools.jackson` instead of `com.fasterxml.jackson`.
The default configuration has changed a lot compared with Jackson2.

## sbt

```
libraryDependencies += "com.github.pjfanning" %% "pekko-serialization-jackson3" % "1.0.0"
```
