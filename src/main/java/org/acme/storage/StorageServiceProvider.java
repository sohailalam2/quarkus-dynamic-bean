package org.acme.storage;

import io.quarkus.runtime.configuration.ConfigurationException;
import org.acme.storage.local.FileSystemStorageService;
import org.acme.storage.remote.S3StorageService;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@Dependent
public class StorageServiceProvider {

    @ConfigProperty(name = "org.acme.storage-service-type")
    String storageServiceType;

    @Produces
    @Singleton
    StorageService get() {
        StorageServiceType type = StorageServiceType.getByName(storageServiceType);

        if (type == null) {
            throw new ConfigurationException("org.acme.storage-service-type should be of type local or remote");
        }

        switch (type) {
            default:
            case LOCAL:
                return new FileSystemStorageService();
            case REMOTE:
                return new S3StorageService();
        }
    }
}
