package dev.zevolution.pocquarkusjob.adapter.datasources.mongodb.services.mappers;

import dev.zevolution.pocquarkusjob.adapter.datasources.mongodb.services.models.SoftwaresByAuthorModel;
import dev.zevolution.pocquarkusjob.internal.entities.Author;
import dev.zevolution.pocquarkusjob.internal.entities.Software;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SoftwareMapper {

    SoftwareMapper INSTANCE = Mappers.getMapper(SoftwareMapper.class);

    @Mapping(source = "author", target = "author")
    @Mapping(source = "softwares", target = "softwares")
    SoftwaresByAuthorModel map(Author author, List<Software> softwares);

}