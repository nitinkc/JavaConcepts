package nitin.multithreading.asynchronousProgramming.completableFutureBasics;

import com.entity.crossRef.Item;
import com.entity.gutendex.Author;
import com.entity.gutendex.Gutendex;
import com.entity.gutendex.Result;
import com.entity.openLibrary.OpenLibDto;
import com.utilities.RestGETReadUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ECallMultipleService {
    /*  1. Gutendex search (Search the Author from book name) - https://gutendex.com/books/?search=Pride+and+Prejudice
            Book: Treasure Island
        2. Take ISBN from an author - https://api.crossref.org/works?query.author=Robert+Stevenson+Louis
        3. Find - https://openlibrary.org/api/books?bibkeys=ISBN:9781108074568&format=json&jscmd=data
    */
    public static void main(String[] args) {
        String bookName = "The+Christmas+Carol";

        // 1. Gutendex search (Search the Author from book name) - https://gutendex.com/books/?search=Pride+and+Prejudice
        Gutendex gutendex = RestGETReadUtility.getGutenbergResults(bookName);
        List<Result> results = gutendex.results.stream().collect(Collectors.toList());
        Author author = results.stream().findFirst().get().getAuthors().stream().findFirst().get();
        String authorName = author.getName().replace(",", "+").replace(" ", "");

        // 2. Take ISBN from an author - https://api.crossref.org/works?query.author=Austen+Jane
        List<Item> itemList = RestGETReadUtility.getCrossRef(authorName).getMessage().getItems();
        List<String> isbnList = new ArrayList<>();
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            isbnList.addAll(item.getIsbn().stream().filter(x -> x != null).collect(Collectors.toList()));
        }
        //String isbn = itemList.stream().findFirst().get().getIsbn().stream().findFirst().get();

        // 3. Find Book Details from ISBN - https://openlibrary.org/api/books?bibkeys=ISBN:9781108074568&format=json&jscmd=data
        String isbn = isbnList.stream().reduce("", (partialString, element) -> partialString + element + ",");

        List<OpenLibDto> openLibDto = RestGETReadUtility.getBookDetailsOpenLibrary(isbn).stream().collect(Collectors.toList());
        openLibDto.forEach(x -> System.out.println(x));
    }
}