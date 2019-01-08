package com.paras.pankki.version;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Rule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VersionResourceTest {
    /*
    @Rule
    public final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new VersionResource(new VersionRepository(new Version("local build"))))
            .build();

    @Test
    public void should_get_local_build_version() {
        Version actual = resources
                .target("/version")
                .request()
                .get(Version.class);

        assertThat(actual.getVersion()).isEqualTo("local build");
    }
    */
}