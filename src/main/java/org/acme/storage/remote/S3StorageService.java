package org.acme.storage.remote;

import org.acme.storage.StorageService;

import javax.enterprise.inject.Vetoed;

@Vetoed
public class S3StorageService implements StorageService {
    @Override
    public String save(String filename) {
        return String.format("Saving file %s to AWS S3 storgae", filename);
    }
}
