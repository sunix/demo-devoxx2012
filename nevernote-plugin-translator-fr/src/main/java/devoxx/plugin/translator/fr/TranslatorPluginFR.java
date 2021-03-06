package devoxx.plugin.translator.fr;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
import javax.enterprise.context.ApplicationScoped;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import devoxx.api.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.osgi.api.annotation.Publish;
import org.jboss.weld.environment.osgi.api.events.BundleContainerEvents;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import devoxx.core.fwk.Constants;

@Lang(Lang.Language.FR)
@Publish
@ApplicationScoped
public class TranslatorPluginFR implements Plugin {

    @Inject BundleContext context;
    
    @Inject TranslatorService service;
    
    public String apply(String content) {
        return service.translate(content, Language.FRENCH);
    }
    
    /***************************************/
    /** Plugin management related methods **/
    /***************************************/
    
    public String pluginId() {
        return "french-translator";
    }
    
    public String name() {
        return "French translator";
    }
    
    public String desc() {
        return "A french translator"; 
    }
    
    public Map<String, File> resources() {
        return Collections.emptyMap();
    }
    
    public void start(@Observes BundleContainerEvents.BundleContainerInitialized evt) {
        devoxx.core.fwk.SimpleLogger.info("Starting ...");
    }
    
    @Override
    public String icon() {
        return "icon-comment";
    }

    @Override
    public Long bundleId() {
        return context.getBundle().getBundleId();
    }

    @Override
    public Bundle bundle() {
        return context.getBundle();
    }

    @Override
    public boolean modifyContent() {
        return true;
    }
}
