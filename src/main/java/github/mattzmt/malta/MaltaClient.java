package github.mattzmt.malta;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaltaClient implements ClientModInitializer {
    public static final String MOD_ID = "malta";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("Malta mod initialised on the client");
    }
}