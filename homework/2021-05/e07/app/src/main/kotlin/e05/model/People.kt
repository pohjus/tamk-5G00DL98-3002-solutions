package model

import com.fasterxml.jackson.annotation.*;

// Jackson requires to have default constructor without arguments
@JsonIgnoreProperties(ignoreUnknown = true)
data class People(var results : MutableList<Person>? = null)