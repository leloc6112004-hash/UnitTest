package com.ou.unittest.lab3;

public final class Age {
    public static final int MIN_AGE=18;
    public static final int MAX_AGE=65;

    public boolean isWorkingAge(int age){
        return age>=MIN_AGE && age<=MAX_AGE;
    }

}
