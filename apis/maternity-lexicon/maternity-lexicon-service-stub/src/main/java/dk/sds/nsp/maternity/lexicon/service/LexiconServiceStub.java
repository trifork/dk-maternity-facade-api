package dk.sds.nsp.maternity.lexicon.service;

import dk.sds.nsp.maternity.lexicon.exceptions.IllegalParameterValueException;
import dk.sds.nsp.maternity.lexicon.exceptions.NoConnectionToServiceException;
import dk.sds.nsp.maternity.lexicon.model.Catalogue;
import dk.sds.nsp.maternity.lexicon.model.Category;
import dk.sds.nsp.maternity.lexicon.model.Post;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

public class LexiconServiceStub implements LexiconService {
    List<Post> database = new ArrayList<>();
    List<Category> categories = new ArrayList<>();

    private static final int PAGE_SIZE = 10;

    public LexiconServiceStub() {
        categories.addAll(Arrays.asList(
                new Category()
                    .id(UUID.randomUUID().toString())
                    .count(4)
                    .imageUrl("https://upload.wikimedia.org/wikipedia/en/9/9a/Trollface_non-free.png")
                    .name("Amning"),
                new Category()
                        .id(UUID.randomUUID().toString())
                        .count(4)
                        .imageUrl("https://upload.wikimedia.org/wikipedia/en/9/9a/Trollface_non-free.png")
                        .name("Fødsel"),
                new Category()
                        .id(UUID.randomUUID().toString())
                        .count(4)
                        .imageUrl("https://upload.wikimedia.org/wikipedia/en/9/9a/Trollface_non-free.png")
                        .name("Uro")

        ));
        List<String> tags = Arrays.asList("Bækken", "Mavemuskler", "Amning", "Information", "Fis og ballade", "Tag");
        for (int i = 0; i <=50; i++) {
            database.add(randomPost(
                    tags.stream().sorted(Comparator.comparingInt(a -> new Random().nextInt()))
                        .collect(Collectors.toList())
                        .subList(0, i % 3 + 1),
                    categories.stream().sorted(Comparator.comparingInt(a -> new Random().nextInt()))
                            .collect(Collectors.toList())
                            .subList(0, i % 2 + 1)
            ));
        }
    }

    @Override
    public Catalogue query(Integer pageNumber, String orderBy, List<String> tags, List<String> categories, String query) throws NoConnectionToServiceException, IllegalParameterValueException {
        int page = Optional.ofNullable(pageNumber).orElse(0);

        List<Post> entries = database.stream()
                .filter(x -> tags.isEmpty() || tags.stream().anyMatch(queryTag -> x.getTags().contains(queryTag)))
                .filter(x -> categories.isEmpty() || categories.stream().anyMatch(queryCategory -> x.getCategories().contains(queryCategory)))
                .filter(x -> query == null || x.getContent().contains(query))
                .collect(Collectors.toList());


        if (orderBy != null) {
            Collections.sort(entries, Comparator.comparingInt(a -> new Random().nextInt())); // I don't want to implement ordering for all possible keys in the stub... This changes the order so app-guys can see something happening
        }
        List<Post> pageContent = entries.size() > PAGE_SIZE ? entries.subList(page*PAGE_SIZE, Math.min(entries.size(), page*PAGE_SIZE + PAGE_SIZE)) : entries;
        return new Catalogue()
                .content(pageContent)
                .curretPage(page)
                .numberOfPages((int) Math.ceil((double) entries.size()/ (double) PAGE_SIZE));
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    private static Post randomPost(List<String> tags, List<Category> categories) {
        return new Post()
                .tags(tags)
                .categories(categories.stream().map(Category::getId).collect(Collectors.toList()))
                .title(randomString(10))
                .content(randomString(100))
                .excerpt(randomString(15))
                .id(UUID.randomUUID().toString())
                .lastUpdateDate(new Date())
                .publicationDate(new Date());
    }

    private static String randomString(int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
