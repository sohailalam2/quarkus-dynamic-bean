package org.acme.storage;

public enum StorageServiceType {
    REMOTE, LOCAL;

    static StorageServiceType getByName(String name) {
        try {
            return valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}
