package com.example.weeksixtask.validation

class Validator {


   private var isEmail = false
   private var isPhoneNumber = false
   private var isName = false
   private var isGender = false

    /**
     * Checks Whether email is valid
     */

    fun isEmailValid(email:String): Boolean{

        return if(email.isEmpty()){
            false
        } else{

            var regex = "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$)".toRegex()
            isEmail = email.matches(regex)

            isEmail

        }
    }

    /**
     * Checks whether number is valid
     */

    fun isPhoneNumberValid(number: String): Boolean{
        return if(number.isEmpty()){
            false
        } else{

            var regex = "(^[0]\\d{10}\$)|(^[\\+]?[234]\\d{12}\$)".toRegex()

            isPhoneNumber = number.matches(regex)

            isPhoneNumber

        }
    }


   /**
    *  Checks Whether Name is Valid
    */

    fun isNameValid(name: String):Boolean{
       return if(name.isEmpty()){
           false
       } else{
           var regex = "[a-zA-Z]+".toRegex()


           isName = name.replace(" ", "").matches(regex)

           isName

       }

   }

    /**
     * Checks Whether Gender is valid
     */

    fun isGenderValid(gender:String):Boolean{

        return if (gender.isEmpty()){
            false
        } else{
            if (gender.equals("Male") || gender.equals("Female") || gender.equals("Unspecified")){

                isGender = true
                true
            } else{
                false
            }
        }
    }


    /**
     * Checks Whether all the Inputs are Valid
     */

    fun isAllValid(): Boolean{

        return isEmail && isGender && isName && isPhoneNumber
    }
}