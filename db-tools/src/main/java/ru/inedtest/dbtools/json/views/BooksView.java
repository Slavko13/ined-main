package ru.inedtest.dbtools.json.views;

public abstract class BooksView {

    public interface MainPageBooksView {}
    public interface SinglePageBookView extends MainPageBooksView, BookStyleView.MainBooksStyleView, AuthorsView.MainAuthorsView, CommentViews.MainCommentsView, UserView.UserMainInfo {}
    public interface FullView extends SinglePageBookView {}


}
