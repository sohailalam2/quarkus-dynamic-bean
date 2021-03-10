package org.acme;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.acme.storage.StorageService;

import javax.inject.Inject;

@QuarkusMain
public class QuarkusDynamicBean implements QuarkusApplication {

    @Inject
    StorageService storageService;

    @Override
    public int run(String... args) throws Exception {
        String result = storageService.save("awesome.txt");
        System.out.println(result);
        return 0;
    }
}