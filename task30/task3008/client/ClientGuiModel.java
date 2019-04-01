package com.javarush.task.task30.task3008.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ClientGuiModel {

    protected final Set<String> allUserNames = new HashSet<>();
    public String newMessage;
    public HashSet<String> getAllUserNames() {
        //return Collections.unmodifiableSet(allUserNames);
    }
}
