package dev.zevolution.pocquarkusjob.internal.interactors;

import dev.zevolution.pocquarkusjob.internal.entities.Author;
import dev.zevolution.pocquarkusjob.internal.entities.Software;
import dev.zevolution.pocquarkusjob.internal.repositories.SoftwareRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class RegisterAuthorSoftwaresUseCase {

    private final SoftwareRepository mongoDBRepository;

    public RegisterAuthorSoftwaresUseCase(@Named("MongoDBDataSource") SoftwareRepository softwareRepository) {
        this.mongoDBRepository = softwareRepository;
    }

    public void execute(Author author, List<Software> softwaresFromAuthor) {
        var softwareAuthor = softwaresFromAuthor.stream()
                .map(Software::getAuthor)
                .filter(element -> Objects.equals(element, author))
                .findFirst();

        if (softwareAuthor.isEmpty()) throw new RuntimeException("Diff author");

        this.mongoDBRepository.registerSoftwareToAuthor(softwareAuthor.get(), softwaresFromAuthor);
    }

}
