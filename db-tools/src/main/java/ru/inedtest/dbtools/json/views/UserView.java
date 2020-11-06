package ru.inedtest.dbtools.json.views;

public abstract class UserView {

    public interface UserMainInfo {}
    public interface UserFullInfo extends UserMainInfo {}
    public interface UserFullInfoWithCreds extends UserFullInfo {}

}
