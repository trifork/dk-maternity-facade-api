package dk.sds.nsp.maternity.lexicon.spring;


import dk.sds.nsp.maternity.lexicon.service.LexiconService;

public final class DependencyResolver {
    static LexiconService lexiconService;

    public static LexiconService getLexiconService() {
        return lexiconService;
    }

    private DependencyResolver(){}
}
