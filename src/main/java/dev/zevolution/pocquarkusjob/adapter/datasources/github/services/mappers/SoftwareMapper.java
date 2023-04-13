package dev.zevolution.pocquarkusjob.adapter.datasources.github.services.mappers;

import dev.zevolution.pocquarkusjob.adapter.datasources.github.services.data.response.GithubRepoResponse;
import dev.zevolution.pocquarkusjob.internal.entities.Software;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SoftwareMapper {

    SoftwareMapper INSTANCE = Mappers.getMapper(SoftwareMapper.class);

    @Mapping(source = "stargazersCount", target = "score")
    @Mapping(source = "owner.login", target = "author.userName")
    Software map(GithubRepoResponse githubRepo);

}