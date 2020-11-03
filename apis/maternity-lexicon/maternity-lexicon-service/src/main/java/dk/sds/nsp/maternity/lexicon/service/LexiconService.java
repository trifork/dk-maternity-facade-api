package dk.sds.nsp.maternity.lexicon.service;


import dk.sds.nsp.maternity.lexicon.exceptions.IllegalParameterValueException;
import dk.sds.nsp.maternity.lexicon.exceptions.NoConnectionToServiceException;
import dk.sds.nsp.maternity.lexicon.model.Catalogue;
import dk.sds.nsp.maternity.lexicon.model.Category;
import org.springframework.lang.Nullable;

import java.util.List;

public interface LexiconService {
    Catalogue query(
            @Nullable Integer pageNumber,
            @Nullable String orderBy,
            @Nullable List<String> tags,
            @Nullable List<String> categories,
            @Nullable String query
    ) throws NoConnectionToServiceException, IllegalParameterValueException;

    List<Category> getCategories();
}
