package spring.graphql.tutorial.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(BookController.class)
public class BookControllerTests {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void shouldGetFirstBook() {
        Book res = this.graphQlTester
                .documentName("bookDetails")
                .variable("id", "book-1")
                .execute()
                .path("bookById")
                .entity(Book.class)
                .get();

        Assertions.assertNotNull(res);
        Assertions.assertNotNull(res.id());

    }
}
