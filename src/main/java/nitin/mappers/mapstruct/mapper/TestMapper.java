package nitin.mappers.mapstruct.mapper;

import nitin.mappers.mapstruct.dto.TesterDto;
import nitin.mappers.mapstruct.model.Tester;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "default")
public interface TestMapper {
    @Mapping(target="test", source="tester.test", numberFormat = "₹#.00")
    TesterDto testMapper(Tester tester);


    @Mapping(target = "test", source = "tester")
    List<String> listPrices(Tester.);
}