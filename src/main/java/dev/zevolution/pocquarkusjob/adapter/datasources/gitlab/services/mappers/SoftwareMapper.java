package dev.zevolution.pocquarkusjob.adapter.datasources.gitlab.services.mappers;

import dev.zevolution.pocquarkusjob.adapter.datasources.gitlab.services.data.response.GitlabProjectResponse;
import dev.zevolution.pocquarkusjob.internal.entities.Software;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SoftwareMapper {

    SoftwareMapper INSTANCE = Mappers.getMapper(SoftwareMapper.class);

    @Mapping(source = "starCount", target = "score")
    @Mapping(source = "namespace.path", target = "author.userName")
    @Mapping(source = "namespace.name", target = "author.name")
    @Mapping(source = "namespace.avatarUrl", target = "author.avatarUrl")
    Software map(GitlabProjectResponse gitlabProject);

}