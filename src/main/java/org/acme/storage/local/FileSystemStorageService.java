package org.acme.storage.local;

import org.acme.storage.StorageService;

import javax.enterprise.inject.Vetoed;

@Vetoed
public class FileSystemStorageService implements StorageService {
    @Override
    public String save(String filename) {
        return String.format("Saving file %s to Local FileSystem", filename);
    }
}
