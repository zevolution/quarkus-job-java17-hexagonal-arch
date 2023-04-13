package dev.zevolution.pocquarkusjob.adapter.datasources.bitbucket.services.mappers;

import dev.zevolution.pocquarkusjob.adapter.datasources.bitbucket.services.data.response.BitbucketUserReposValueResponse;
import dev.zevolution.pocquarkusjob.internal.entities.Software;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SoftwareMapper {

    SoftwareMapper INSTANCE = Mappers.getMapper(SoftwareMapper.class);

    @Mapping(source = "project.name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "workspace.slug", target = "author.userName")
    @Mapping(source = "owner.nickname", target = "author.name")
    @Mapping(source = "owner.links.avatar.href", target = "author.avatarUrl")
    Software map(BitbucketUserReposValueResponse source);

}