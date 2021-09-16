package org.anvilpowered.votlin

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import org.slf4j.Logger

@Plugin(
  id = "votlin",
  name = "Votlin",
  version = "1.5.30",
  authors = ["AnvilPowered"],
)
class Votlin @Inject constructor(private val logger: Logger) {

  @Subscribe
  fun onPreInit(e: ProxyInitializeEvent) {
    logger.info("Running Votlin v1.5.30")
  }
}
