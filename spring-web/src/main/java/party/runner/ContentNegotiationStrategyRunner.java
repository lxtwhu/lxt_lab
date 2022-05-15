//package party.runner;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.accept.ContentNegotiationManager;
//import org.springframework.web.accept.MappingMediaTypeFileExtensionResolver;
//import org.springframework.web.accept.MediaTypeFileExtensionResolver;
//import org.springframework.web.servlet.HandlerMapping;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.Map;
//
//@Slf4j
//@AutoConfigureBefore(HandlerMapping.class)
////@Component
//public class ContentNegotiationStrategyRunner{
//
//    @Autowired
//    ContentNegotiationManager contentNegotiationManager;
//
//    @PostConstruct
//    public void init() throws Exception {
//        Map<String, MediaType> mediaTypes = new HashMap<>();
//        mediaTypes.put("pac",new MediaType("application","x-ns-proxy-autoconfig"));
//        MediaTypeFileExtensionResolver mediaTypeFileExtensionResolver = new MappingMediaTypeFileExtensionResolver(mediaTypes);
//        contentNegotiationManager.addFileExtensionResolvers(mediaTypeFileExtensionResolver);
//        log.info("Supported MediaTypeMappings: "+contentNegotiationManager.getMediaTypeMappings().toString());
//    }
//}
