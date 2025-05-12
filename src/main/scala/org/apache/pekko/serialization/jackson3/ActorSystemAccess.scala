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

package org.apache.pekko.serialization.jackson3

import org.apache.pekko.actor.ExtendedActorSystem
import org.apache.pekko.annotation.InternalApi
import org.apache.pekko.serialization.Serialization

/**
 * INTERNAL API - needs to be in an `org.apache.pekko` to access package-private pekko state
 */
@InternalApi trait ActorSystemAccess {
  def currentSystem(): ExtendedActorSystem = {
    Serialization.currentTransportInformation.value match {
      case null =>
        throw new IllegalStateException(
          "Can't access current ActorSystem, Serialization.currentTransportInformation was not set.")
      case Serialization.Information(_, system) => system.asInstanceOf[ExtendedActorSystem]
    }
  }
}

/**
 * INTERNAL API
 */
@InternalApi private[pekko] object ActorSystemAccess extends ActorSystemAccess
