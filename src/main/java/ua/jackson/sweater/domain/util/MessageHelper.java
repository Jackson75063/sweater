package ua.jackson.sweater.domain.util;

import ua.jackson.sweater.domain.User;

public abstract class MessageHelper {

    public  static String getAuthorName(User author){

      return   author != null ? author.getUsername() : "<none>";

    }

}
