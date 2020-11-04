package dk.sds.nsp.maternity.lexicon.service;

import dk.sds.nsp.maternity.lexicon.exceptions.IllegalParameterValueException;
import dk.sds.nsp.maternity.lexicon.exceptions.NoConnectionToServiceException;
import dk.sds.nsp.maternity.lexicon.model.Catalogue;
import dk.sds.nsp.maternity.lexicon.model.Category;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class LexiconServiceImpl implements LexiconService {
    @Override
    public Catalogue query(Integer pageNumber, String orderBy, List<String> tags, List<String> categories, String query) throws NoConnectionToServiceException, IllegalParameterValueException {
        throw new NotImplementedException();
    }

    @Override
    public List<Category> getCategories() {
        throw new NotImplementedException();
    }
}
