package dev.zevolution.pocquarkusjob.internal.repositories;

import dev.zevolution.pocquarkusjob.internal.entities.Author;
import dev.zevolution.pocquarkusjob.internal.entities.Software;

import java.util.List;

public interface SoftwareRepository {

    List<Software> getAllSoftwareByAuthor(Author author);
    void registerSoftwareToAuthor(Author author, List<Software> softwares);

}
