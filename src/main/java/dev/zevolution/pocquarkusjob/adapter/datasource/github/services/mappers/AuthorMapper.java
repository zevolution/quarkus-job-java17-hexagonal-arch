package dev.zevolution.pocquarkusjob.adapter.datasource.github.services.mappers;

import dev.zevolution.pocquarkusjob.adapter.datasource.github.services.data.response.GithubUserDetailResponse;
import dev.zevolution.pocquarkusjob.internal.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    @Mapping(source = "login", target = "userName")
    Author map(GithubUserDetailResponse githubUserDetail);

}