/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * license agreements; and to You under the Apache License, version 2.0:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * This file is part of the Apache Pekko project, which was derived from Akka.
 */

/*
 * Copyright (C) 2019-2022 Lightbend Inc. <https://www.lightbend.com>
 */

package com.github.pjfanning.pekko.serialization.jackson3

/**
 * Complete module with support for all custom serializers.
 */
class PekkoJacksonModule extends SerializationModule with ActorRefModule with AddressModule with FiniteDurationModule {
  override def getModuleName = "PekkoJacksonModule"
}

object PekkoJacksonModule extends PekkoJacksonModule

class PekkoTypedJacksonModule extends SerializationModule with TypedActorRefModule {
  override def getModuleName = "PekkoTypedJacksonModule"
}

object PekkoTypedJacksonModule extends PekkoJacksonModule

class PekkoStreamJacksonModule extends SerializationModule with StreamRefModule {
  override def getModuleName = "PekkoStreamJacksonModule"
}

object PekkoStreamJacksonModule extends PekkoJacksonModule
