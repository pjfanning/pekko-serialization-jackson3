# pekko-serialization-jackson3

Jackson 2.16 equivalent of [pekko-serialization-jackson](https://pekko.apache.org/docs/pekko/current/serialization-jackson.html) which uses Jackson 3.

See also https://github.com/pjfanning/pekko-serialization-jackson216

Jackson 3 is still in RC and not yet released. The package name in Jackson3 is `tools.jackson` instead of `com.fasterxml.jackson`.
The default configuration has changed a lot compared with Jackson2.

## sbt

```
libraryDependencies += "com.github.pjfanning" %% "pekko-serialization-jackson3" % "<version>"
```
