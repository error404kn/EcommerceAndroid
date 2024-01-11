package com.example.itstepproject.util

import android.util.Patterns

fun validateEmail(email: String): RegisterValidation{
    if (email.isEmpty())
        return RegisterValidation.Failed("იმეილის ველი არ შეიძლება იყოს ცარიელი")

    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        return RegisterValidation.Failed("იმეილის ფორმატი არასწორია")

    return RegisterValidation.Success
}

fun validatePassword(password: String): RegisterValidation{
    if (password.isEmpty())
        return RegisterValidation.Failed("პაროლის ველი არ შეიძლება იყოს ცარიელი")

    if (password.length < 6)
        return RegisterValidation.Failed("პაროლი უნდა შეიცავდეს მინიმუმ 6 სიმბოლოს")

    return RegisterValidation.Success
}