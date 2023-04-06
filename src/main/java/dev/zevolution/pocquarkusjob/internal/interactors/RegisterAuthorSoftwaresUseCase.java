package dev.zevolution.pocquarkusjob.internal.interactors;

import dev.zevolution.pocquarkusjob.internal.annotations.MongoDBRepository;
import dev.zevolution.pocquarkusjob.internal.entities.Author;
import dev.zevolution.pocquarkusjob.internal.entities.Software;
import dev.zevolution.pocquarkusjob.internal.repositories.SoftwareRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class RegisterAuthorSoftwaresUseCase {

    private final SoftwareRepository mongoDBRepository;

    public RegisterAuthorSoftwaresUseCase(@Any Instance<SoftwareRepository> softwareRepository) {
        this.mongoDBRepository = softwareRepository.stream()
                .filter(this::isMongoDBRepository)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Mongo data source wasn't found"));
    }

    public void execute(Author author, List<Software> softwaresFromAuthor) {
        var softwareAuthor = softwaresFromAuthor.stream()
                .map(Software::getAuthor)
                .filter(element -> Objects.equals(element, author))
                .findFirst();

        if (softwareAuthor.isEmpty()) throw new RuntimeException("Diff author");

        this.mongoDBRepository.registerSoftwareToAuthor(softwareAuthor.get(), softwaresFromAuthor);
    }

    private boolean isMongoDBRepository(SoftwareRepository softwareRepository) {
        return softwareRepository.getClass().getSuperclass().getDeclaredAnnotation(MongoDBRepository.class) != null;
    }

}
