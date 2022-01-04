package nitin.iO.fileOperations.csvDataReadOperations.blogs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Created by nichaurasia
 * Created on Thursday, October/01/2020 at 1:24 AM
 */

// https://github.com/eugenp/tutorials/blob/master/core-java-modules/core-java-8/src/test/java/com/baeldung/java_8_features/groupingby/Java8GroupingByCollectorUnitTest.java
// https://www.baeldung.com/java-groupingby-collector

public class Runner {
    public static void main(String[] args) {
        final List<BlogPost> posts = Arrays.asList(
                new BlogPost("News item 1", "Author 1", BlogPostType.NEWS, 15),
                new BlogPost("Tech review 1", "Author 2", BlogPostType.REVIEW, 5),
                new BlogPost("Programming guide", "Author 1", BlogPostType.GUIDE, 20),
                new BlogPost("News item 2", "Author 2", BlogPostType.NEWS, 35),
                new BlogPost("Tech review 2", "Author 1", BlogPostType.REVIEW, 15));

        System.out.println("********************************************************************");
        System.out.println("getPostsByType");
        getPostsByType(posts);

        System.out.println("********************************************************************");
        System.out.println("getPostTitleByType");
        getPostTitleByType(posts);


        /*posts.stream()
                .collect(groupingBy(BlogPost::getType, summingInt(BlogPost::getLikes)))

        EnumMap<BlogPostType, List<BlogPost>> postsPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType, () -> new EnumMap<>(BlogPostType.class), toList()));

        Map<BlogPostType, Set<BlogPost>> postsPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType, toSet()));

        Map<String, Map<BlogPostType, List<BlogPost>>> map = posts.stream()
                .collect(groupingBy(BlogPost::getAuthor, groupingBy(BlogPost::getType)));*/

    }

    private static void getPostTitleByType(List<BlogPost> posts) {
        posts.stream()
                // BlogPostType : BlogPost
                .collect(Collectors
                                .groupingBy(BlogPost::getAuthor,
                                                Collectors.mapping(BlogPost::getTitle,
                                                //Create a stream consisting the Title,Like tuple
                                                Collectors.joining("|| ", "Post titles: [", "]")
                                                )
                                )
                ).entrySet()
                .stream()
                .forEach(System.out::println);
    }

    private static void getPostsByType(List<BlogPost> posts) {
        posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType))
                .entrySet().stream().forEach(System.out::println);
    }

}
