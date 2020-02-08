import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import org.slf4j.Logger

@Plugin(id = "votlin", name = "Votlin", authors = arrayOf("STG_Allen"))
@Suppress("UNUSED_PARAMATER")
class Votlin @Inject constructor(val logger: Logger) {

    @Subscribe
    fun onPreInit(e: ProxyInitializeEvent) {
        logger.info("Votlin 1.0.0 by STG_Allen")
    }
}