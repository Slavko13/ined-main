package ru.inedtest.dbtools.json.views;

public abstract class CommentViews {

    public interface MainCommentsView extends UserView.UserMainInfo {}
    public interface FullCommentsView extends MainCommentsView {}


}
