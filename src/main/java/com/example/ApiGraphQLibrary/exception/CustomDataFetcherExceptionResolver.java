package com.example.ApiGraphQLibrary.exception;

import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletionStage;

@Component
public class CustomDataFetcherExceptionResolver implements DataFetcherExceptionResolver  {

    @Override
    public Mono<List<GraphQLError>> resolveException(Throwable exception, DataFetchingEnvironment environment) {
        if (exception instanceof ResourceNotFoundException){
            GraphQLError error = GraphQLError.newError()
                    .message("El usuario con el ID proporcionado no fue encontrado.")
                    //.locations((List<SourceLocation>) environment.getField().getSourceLocation())
                    .path(environment.getExecutionStepInfo().getPath().toList())
                    .errorType(ErrorType.NOT_FOUND)
                    .build();
            return Mono.just(Collections.singletonList(error));
        }
        return Mono.empty();
    }
}
