package org.apache.pekko.serialization.jackson3

import org.apache.pekko.actor.ExtendedActorSystem
import org.apache.pekko.annotation.InternalApi
import org.apache.pekko.serialization.BaseSerializer.SerializationIdentifiers
import org.apache.pekko.serialization.{Serialization, Serializer}

/**
 * INTERNAL API - Grants access to package-private state in Pekko classes
 */
@InternalApi
object PekkoAccessUtil {
  def identifierFromConfig(bindingName: String, system: ExtendedActorSystem): Int =
    system.settings.config.getInt(s"""$SerializationIdentifiers."$bindingName"""")

  def getSerializationBindings(serialization: Serialization): Seq[(Class[_], Serializer)] = {
    serialization.bindings
  }
}
