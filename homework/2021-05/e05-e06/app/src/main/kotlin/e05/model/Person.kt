package model

import com.fasterxml.jackson.annotation.*;

// Jackson requires to have default constructor without arguments

@JsonIgnoreProperties(ignoreUnknown = true)
data class Person(var name : String? = null, var height : String? = null, var mass : String? = null) {
    var bmi : Double? = null
        get() = this.mass!!.toDouble() / (this.height!!.toDouble() / 100.0 * this.height!!.toDouble() / 100.0)
}