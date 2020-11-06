package ru.inedtest.dbtools.json.views;

public abstract class BooksView {

    public interface MainPageBooksView {}
    public interface SinglePageBookView extends MainPageBooksView {}
    public interface FullView extends SinglePageBookView {}


}
