package com.github.pjfanning.pekko.serialization.jackson3

import com.typesafe.config.ConfigFactory
import org.apache.pekko.actor.ActorSystem
import org.apache.pekko.testkit.TestKit
import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class JacksonObjectMapperProviderDefaultSpec extends TestKit(
  ActorSystem(
    "JacksonObjectMapperProviderConfigSpec",
    ConfigFactory.parseString(JacksonSerializerSpec.baseConfig("jackson-json"))))
  with AnyWordSpecLike
  with Matchers
  with BeforeAndAfterAll {

  override def afterAll(): Unit = {
    shutdown()
  }

  "JacksonObjectMapperProvider" should {
    "pick up stream constraints" in {
      val objectMapper = JacksonObjectMapperProvider(system).create("test", None)
      val src = objectMapper._deserializationContext().streamReadConstraints()
      val swc = objectMapper.rebuild().streamFactory().streamWriteConstraints()
      src.getMaxNestingDepth shouldEqual 1000
      src.getMaxNumberLength shouldEqual 1000
      src.getMaxNameLength shouldEqual 50000
      src.getMaxStringLength shouldEqual 20000000
      src.getMaxDocumentLength shouldEqual -1

      swc.getMaxNestingDepth shouldEqual 1000
    }
    "pick up recycler pool config" in {
      val objectMapper = JacksonObjectMapperProvider(system).create("test", None)
      val recyclerPool = objectMapper.rebuild().streamFactory()._getRecyclerPool()
      recyclerPool.getClass.getSimpleName shouldEqual "ThreadLocalPool"
    }
  }

}
