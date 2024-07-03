package es.inmolab.demo.utilities;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                   .setSkipNullEnabled(true)
                   .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
