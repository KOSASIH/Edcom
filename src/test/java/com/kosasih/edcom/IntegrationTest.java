package com.kosasih.edcom;

import com.kosasih.edcom.EdcomApp;
import com.kosasih.edcom.config.AsyncSyncConfiguration;
import com.kosasih.edcom.config.EmbeddedElasticsearch;
import com.kosasih.edcom.config.EmbeddedKafka;
import com.kosasih.edcom.config.EmbeddedSQL;
import com.kosasih.edcom.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { EdcomApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedElasticsearch
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@EmbeddedKafka
public @interface IntegrationTest {
}
