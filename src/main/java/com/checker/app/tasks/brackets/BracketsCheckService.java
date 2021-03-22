package com.checker.app.tasks.brackets;

public interface BracketsCheckService {
    boolean isValid(String stringWithBrackets);
    boolean isValidWithStream(String stringWithBrackets);
}
